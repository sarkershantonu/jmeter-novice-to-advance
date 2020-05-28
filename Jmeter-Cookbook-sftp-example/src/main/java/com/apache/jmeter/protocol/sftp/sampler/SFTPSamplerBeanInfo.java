package com.apache.jmeter.protocol.sftp.sampler;

import org.apache.jmeter.testbeans.BeanInfoSupport;
import org.apache.jmeter.testbeans.gui.FileEditor;
import org.apache.jorphan.logging.LoggingManager;
import org.apache.log.Logger;

import java.beans.PropertyDescriptor;

/**
 * Created by shantonu on 8/1/16.
 * practice cookbook example
 */
public class SFTPSamplerBeanInfo extends BeanInfoSupport {
    private static final Logger LOGGER = LoggingManager.getLoggerForClass();

    public SFTPSamplerBeanInfo() {


        super(SFTPSampler.class);
        try {
            PropertyDescriptor p;
            createPropertyGroup("Server", // $NON-NLS-1$
                    new String[]{
                            "hostname", // $NON-NLS-1$
                            "port", // $NON-NLS-1$
                            "connectionTimeout"
                    });

            p = property("hostname"); // $NON-NLS-1$
            p.setValue(NOT_UNDEFINED, Boolean.TRUE);
            p.setValue(DEFAULT, "");

            p = property("port"); // $NON-NLS-1$
            p.setValue(NOT_UNDEFINED, Boolean.TRUE);
            p.setValue(DEFAULT, new Integer(22));

            p = property("connectionTimeout");
            p.setValue(NOT_UNDEFINED, Boolean.TRUE);
            p.setValue(DEFAULT, new Integer(5000));

            createPropertyGroup("Login", // $NON-NLS-1$
                    new String[]{
                            "username", // $NON-NLS-1$
                            "password" // $NON-NLS-1$
                    });

            p = property("username"); // $NON-NLS-1$
            p.setValue(NOT_UNDEFINED, Boolean.TRUE);
            p.setValue(DEFAULT, "");

            p = property("password"); // $NON-NLS-1$
            p.setValue(NOT_UNDEFINED, Boolean.TRUE);
            p.setValue(DEFAULT, "");

            createPropertyGroup("Passphrase",
                    new String[]{
                            //"sshkeyfile", // $NON-NLS-1$
                            "passphrase" // $NON-NLS-1$
                    });


           /* p = property("sshkeyfile");
            p.setValue(NOT_UNDEFINED, Boolean.TRUE);
            p.setValue(DEFAULT, "");*/
            p.setPropertyEditorClass(FileEditor.class);

            p = property("passphrase");
            p.setValue(NOT_UNDEFINED, Boolean.TRUE);
            p.setValue(DEFAULT, "");


            createPropertyGroup("FileTransfer", new String[]{
                    "action", // $NON-NLS-1$
                    "source", // $NON-NLS-1$
                    "printFile",// $NON-NLS-1$
                    "destination" // $NON-NLS-1$

            });

            p = property("action"); // $NON-NLS-1$
            p.setValue(NOT_UNDEFINED, Boolean.TRUE);
            p.setValue(NOT_OTHER, Boolean.TRUE);
            p.setValue(DEFAULT, "get");
            p.setValue(TAGS, new String[]{
                    SFTPSampler.SFTP_COMMAND_GET,
                    SFTPSampler.SFTP_COMMAND_PUT,
                    SFTPSampler.SFTP_COMMAND_RM,
                    SFTPSampler.SFTP_COMMAND_RMDIR,
                    SFTPSampler.SFTP_COMMAND_LS
            });

            p = property("source"); // $NON-NLS-1$
            p.setValue(NOT_UNDEFINED, Boolean.TRUE);
            p.setValue(DEFAULT, "");

            p = property("printFile"); // $NON-NLS-1$
            p.setValue(NOT_UNDEFINED, Boolean.TRUE);
            p.setValue(DEFAULT, Boolean.TRUE);

            p = property("destination"); // $NON-NLS-1$
            p.setValue(NOT_UNDEFINED, Boolean.TRUE);
            p.setValue(DEFAULT, "");
        } catch (NoSuchMethodError e) {
            LOGGER.error("Error initializing component GraphGeneratorListener due to missing method, if your version is lower than 2.10, this" +
                    "is expected to fail, if not check project dependencies");
        }
    }
}
