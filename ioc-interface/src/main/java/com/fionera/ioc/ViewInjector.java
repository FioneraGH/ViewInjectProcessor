package com.fionera.ioc;

/**
 * ViewInjector
 * Created by fionera on 17-8-14 in IocProcessor.
 */

public interface ViewInjector<T> {
    void inject(T t, Object source);
}
