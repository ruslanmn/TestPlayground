package ru.crazy.playground.aop.impl;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import ru.crazy.playground.aop.Profiler;
import ru.crazy.playground.mbean.ProfilerToggle;

import javax.management.ObjectName;
import java.lang.management.ManagementFactory;
import java.lang.reflect.Proxy;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class ProfilerAnnotationBeanPostProcessor implements BeanPostProcessor {

    private ProfilerToggle toggle = new ProfilerToggle();
    private Set<String> beansToProcess = new HashSet<>();

    @SneakyThrows
    public ProfilerAnnotationBeanPostProcessor() {
        var mBeanServer = ManagementFactory.getPlatformMBeanServer();
        mBeanServer.registerMBean(toggle, new ObjectName("profiler", "name", "ProfilerToggle"));
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().isAnnotationPresent(Profiler.class)) {
            beansToProcess.add(beanName);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return beansToProcess.contains(beanName) ?
            Proxy.newProxyInstance(bean.getClass().getClassLoader(),
                    bean.getClass().getInterfaces(),
                    (proxy, method, args) -> {
                if (toggle.isEnabled()) {
                    var start = System.nanoTime();
                    var res = method.invoke(bean, args);
                    var end = System.nanoTime();
                    log.info("{} executed for {} seconds", method.getName(), TimeUnit.NANOSECONDS.toSeconds(end - start));
                    return res;
                } else {
                    return method.invoke(bean, args);
                }
            }) : bean;
    }
}
