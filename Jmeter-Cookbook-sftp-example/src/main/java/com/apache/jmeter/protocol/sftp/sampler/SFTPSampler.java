package com.apache.jmeter.protocol.sftp.sampler;


import com.jcraft.jsch.*;
import com.jcraft.jsch.Session;
import org.apache.jmeter.samplers.AbstractSampler;
import org.apache.jmeter.samplers.Entry;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.testbeans.TestBean;
import org.apache.jorphan.logging.LoggingManager;
import org.apache.log.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by shantonu on 8/1/16.
 * practice cookbook example
 */
public class SFTPSampler extends AbstractSampler implements TestBean {

    private static final Logger log = LoggingManager.getLoggerForClass();

    private String hostname = "";
    private int port = 22;
    private String username = "";
    private String password = "";
    private String passphrase = "";
    private int connectionTimeout = 5000;

    private String failureReason = "Unknown";
    private static final JSch jsch = new JSch();
    private Session session = null;
    private SFTPUserInfo userinfo = null;


    public static final String SFTP_COMMAND_GET = "get";
    public static final String SFTP_COMMAND_PUT = "put";
    public static final String SFTP_COMMAND_RM = "rm";
    public static final String SFTP_COMMAND_RMDIR = "rmdir";
    public static final String SFTP_COMMAND_LS = "ls";
    public static final String SFTP_COMMAND_RENAME = "ls";
    private String source;
    private String destination;
    private String action;
    private boolean printFile = true;

    public SFTPSampler() {
        super();
        setName("jcb@ Cookbook SFTP Sampler");
    }

    public SampleResult sample(Entry e) {
        SampleResult res = new SampleResult();
        res.setSampleLabel(getName() + ":(" + getUsername() + "@" + getHostname() + ":" + getPort() + ")");

        // Set up com.apache.jmeter.protocol.sftp.sampler return types
        res.setSamplerData(action + " " + source);

        res.setDataType(SampleResult.TEXT);
        res.setContentType("text/plain");

        String response;
        if (getSession() == null) {
            connect();
        }

        try {
            if (getSession() == null) {
                log.error("Failed to connect to server with credentials "
                        + getUsername() + "@" + getHostname() + ":" + getPort()
                        + " pw=" + getPassword());
                throw new NullPointerException("Failed to connect to server: " + getFailureReason());
            }

            response = doFileTransfer(getSession(), source, destination, res);
            res.setResponseData(response.getBytes());

            res.setSuccessful(true);

            res.setResponseMessageOK();
        } catch (JSchException e1) {
            res.setSuccessful(false);
            res.setResponseCode("JSchException");
            res.setResponseMessage(e1.getMessage());
        } catch (SftpException e1) {
            res.setSuccessful(false);
            res.setResponseCode("SftpException");
            res.setResponseMessage(e1.getMessage());
        } catch (IOException e1) {
            res.setSuccessful(false);
            res.setResponseCode("IOException");
            res.setResponseMessage(e1.getMessage());
        } catch (NullPointerException e1) {
            res.setSuccessful(false);
            res.setResponseCode("Connection Failed");
            res.setResponseMessage(e1.getMessage());
        } finally {
            // Try a disconnect/sesson = null here instead of in finalize.
            disconnect();
            setSession(null);
        }
        return res;
    }

    private String doFileTransfer(Session session, String source, String dest, SampleResult sampleResult)
            throws JSchException, SftpException, IOException {
        StringBuilder sb = new StringBuilder();
        ChannelSftp channel = (ChannelSftp) session.openChannel("sftp");

        sampleResult.sampleStart();
        channel.connect();

        if (SFTP_COMMAND_GET.equals(action)) {

            if (!printFile) {
                channel.get(source, dest);
            } else {
                BufferedReader br = new BufferedReader(new InputStreamReader(channel.get(source)));
                for (String line = br.readLine(); line != null; line = br.readLine()) {
                    sb.append(line);
                    sb.append("\n");
                }
            }

        } else if (SFTP_COMMAND_PUT.equals(action)) {
            channel.put(source, dest);
        } else if (SFTP_COMMAND_LS.equals(action)) {
            List<ChannelSftp.LsEntry> ls = channel.ls(source);
            for (ChannelSftp.LsEntry line : ls) {
                sb.append(line.getLongname());
                sb.append("\n");
            }
        } else if (SFTP_COMMAND_RM.equals(action)) {
            channel.rm(source);
        } else if (SFTP_COMMAND_RMDIR.equals(action)) {
            channel.rmdir(source);
        } else if (SFTP_COMMAND_RENAME.equals(action)) {
            channel.rename(source, dest);
        }

        sampleResult.sampleEnd();


        channel.disconnect();
        return sb.toString();
    }

    /////////////////// utility methods //////////////////
    public void connect() {
        try {
            failureReason = "Unknown";
            session = jsch.getSession(getUsername(), getHostname(), getPort());
            session.setUserInfo(userinfo);
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect(connectionTimeout);
        } catch (JSchException e) {
            failureReason = e.getMessage();
            session.disconnect();
            session = null;
            log.error("SSH connexion error", e);
        }
    }

    public void disconnect() {
        if (session != null) {
            session.disconnect();
        }
    }


    //////////// Accessors ////////////
    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public boolean getPrintFile() {
        return printFile;
    }

    public void setPrintFile(boolean printFile) {
        this.printFile = printFile;
    }

    public void setPassphrase(String passphrase) {
        this.passphrase = passphrase;
    }

    public String getPassphrase() {
        return passphrase;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String server) {
        this.hostname = server;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getConnectionTimeout() {
        return connectionTimeout;
    }

    public void setConnectionTimeout(int connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    protected Session getSession() {
        return session;
    }

    protected void setSession(Session session) {
        this.session = session;
    }

    protected String getFailureReason() {
        return failureReason;
    }

    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason;
    }

}
