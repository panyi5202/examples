package com.py.examples.sandbox.inst;

import com.py.examples.sandbox.inst.target.TransClass;

import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;

/**
 * @author panyi on 18-5-16.
 */
public class AgentMain {
    public static void agentmain(String agentArgs, Instrumentation inst) throws UnmodifiableClassException {
        inst.addTransformer(new Transformer(), true);
        inst.retransformClasses(TransClass.class);
        System.out.println("Agent Main Done");
    }
}
