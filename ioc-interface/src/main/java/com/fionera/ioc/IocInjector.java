package com.fionera.ioc;

import android.app.Activity;

/**
 * IocInjector
 * Created by fionera on 17-8-14 in IocProcessor.
 */

public class IocInjector {

    public static void inject(Activity activity){
        inject(activity,activity);
    }

    private static void inject(Object host, Object source){
        try {
            Class<?> clazz = host.getClass();
            Class<?> proxyClazz = Class.forName(clazz.getName() + "$$ViewInjector");
            ViewInjector viewInjector = (ViewInjector) proxyClazz.newInstance();
            viewInjector.inject(host, source);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}
