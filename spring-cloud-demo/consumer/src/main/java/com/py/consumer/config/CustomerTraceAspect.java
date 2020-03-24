package com.py.consumer.config;

import brave.Tracer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author Roy
 */
//@Aspect
public class CustomerTraceAspect {
    /*private final Tracer tracer;

    public CustomerTraceAspect(Tracer tracer) {
        this.tracer = tracer;
    }

    @Pointcut("@within(org.springframework.web.bind.annotation.RestController) || @within(org.springframework.stereotype.Controller)")
    private void traceHandlerInterceptorPointcut() {
    }

    @Around("traceHandlerInterceptorPointcut()")
    public Object wrapWithCorrelationId(ProceedingJoinPoint pjp)
            throws Throwable {
        boolean filter = filterNoRequestMappingMethod(pjp);
        ObjectMapper mapper = new ObjectMapper();
        if (filter) {
            // 通过 DefaultTracer 生成 Span 信息
            this.tracer.addTag("params", tagValue);
        }
        Object callable = pjp.proceed();
        if (filter) {
            this.tracer.addTag("result", mapper.writeValueAsString(callable));
        }
        return callable;
    }*/
}
