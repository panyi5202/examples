package com.py.at;

import java.lang.instrument.Instrumentation;

/**
 * @author panyi on 18-5-17.
 */
public class LoadedAgent {
    @SuppressWarnings("rawtypes")
    public static void agentmain(String args, Instrumentation inst) {
        Class[] classes = inst.getAllLoadedClasses();
        for (Class cls : classes) {
            System.out.println(cls.getName());
        }
    }
}
