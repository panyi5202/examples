package com.py.at2;


import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.lang.instrument.ClassDefinition;
import java.lang.instrument.Instrumentation;

/**
 * @author panyi on 18-5-17.
 */
public class AgentMain2 {
    public static void agentmain(String arg, Instrumentation inst)
            throws Exception {

        System.out.println("Hello, " + arg);

        Class<?> runningProcess = Class.forName("com.py.at2.DemoPrint");

        //Get current path
        System.out.println(ClassLoader.getSystemResource("") );

        File f = new File(arg);
        byte[] reporterClassFile = new byte[(int) f.length()];
        DataInputStream in = new DataInputStream(new FileInputStream(f));
        in.readFully(reporterClassFile);
        in.close();

        // Apply the redefinition
        inst.redefineClasses(new ClassDefinition(runningProcess, reporterClassFile));

        System.out.println("Agent Main Done");
    }

}
