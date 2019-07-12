package com.py.at2;

import com.sun.tools.attach.AgentInitializationException;
import com.sun.tools.attach.AgentLoadException;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;

import java.io.IOException;

/**
 * @author panyi on 18-5-17.
 */
public class AttachAPI {
    public static void main(String[] args) throws AttachNotSupportedException, IOException, AgentLoadException, AgentInitializationException {
        // the following strings must be provided by us
        String processId = "41656";
        String jarFileName = "D:\\workspace\\GIT\\examples\\examples-sandbox\\agentmain2\\agentmain2.jar";
        VirtualMachine virtualMachine = VirtualMachine.attach(processId);
        try {
            virtualMachine.loadAgent(jarFileName, "D:\\workspace\\GIT\\examples\\examples-sandbox\\agentmain2\\DemoPrint.class");
        } finally {
            //virtualMachine.detach();
        }
    }
}
