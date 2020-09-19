#!/bin/sh
JMETER_VERSION=apache-jmeter-5.3
PLUGINMGR_VERSION=1.3
CMDRUNNER_VERSION=2.2
export JMETER_HOME=/opt/$JMETER_VERSION
cd /opt
curl -O https://archive.apache.org/dist/jmeter/binaries/$JMETER_VERSION.tgz 
#cd /opt
tar -xvf $JMETER_VERSION.tgz 
rm /opt/$JMETER_VERSION.tgz 
rm -rf $JMETER_VERSION/docs $JMETER_VERSION/printable_docs 
cd $JMETER_HOME/lib 
curl -O http://search.maven.org/remotecontent?filepath=kg/apc/cmdrunner/$CMDRUNNER_VERSION/cmdrunner-$CMDRUNNER_VERSION.jar 
cd $JMETER_HOME/lib/ext 
curl -O http://search.maven.org/remotecontent?filepath=kg/apc/jmeter-plugins-manager/$PLUGINMGR_VERSION/jmeter-plugins-manager-$PLUGINMGR_VERSION.jar 
java -cp jmeter-plugins-manager-$PLUGINMGR_VERSION.jar org.jmeterplugins.repository.PluginManagerCMDInstaller
java  -jar ../cmdrunner-2.2.jar --tool org.jmeterplugins.repository.PluginManagerCMD install-all-except jpgc-hadoop,jpgc-oauth