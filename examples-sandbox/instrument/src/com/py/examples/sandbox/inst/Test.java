package com.py.examples.sandbox.inst;

import com.sun.tools.attach.AgentInitializationException;
import com.sun.tools.attach.AgentLoadException;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;

import java.io.IOException;

/**
 * @author panyi on 18-5-17.
 */
public class Test {
    public static void main(String[] args) throws AttachNotSupportedException,
            IOException, AgentLoadException, AgentInitializationException {
        VirtualMachine vm = VirtualMachine.attach("57824");
        vm.loadAgent("D:\\workspace\\GIT\\examples\\examples-sandbox\\instrument\\dist\\instrument1.jar");
    }
}
