package com.apache.jmeter.protocol.sftp.sampler;

import com.jcraft.jsch.UserInfo;

import java.io.Serializable;

/**
 * Created by shantonu on 8/1/16.
 * practice cookbook example
 */
public class SFTPUserInfo implements UserInfo, Serializable {
    private SFTPSampler owner;

    public SFTPUserInfo(SFTPSampler owner) {
        this.owner = owner;
    }

    public String getPassphrase() {
        return owner.getPassphrase();
    }

    public String getPassword() {
        return owner.getPassword();
    }

    public boolean promptPassword(String message) {
        return true;
    }

    public boolean promptPassphrase(String message) {
        return true;
    }

    public boolean promptYesNo(String message) {
        return true;
    }

    public void showMessage(String message) {
        return;
    }

}
