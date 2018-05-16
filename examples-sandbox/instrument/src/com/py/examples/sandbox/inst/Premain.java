package com.py.examples.sandbox.inst;

import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;

/**
 * @author panyi on 18-5-16.
 */
public class Premain {
    public static void premain(String agentArgs, Instrumentation inst)
            throws ClassNotFoundException, UnmodifiableClassException {
        inst.addTransformer(new Transformer());
    }
}
