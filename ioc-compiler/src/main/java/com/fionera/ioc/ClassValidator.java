package com.fionera.ioc;

import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;

/**
 * ClassValidator
 * Created by fionera on 17-8-14 in IocProcessor.
 */

final class ClassValidator {
    static boolean isPrivate(Element annotatedClass) {
        return annotatedClass.getModifiers().contains(Modifier.PRIVATE);
    }

    static String getClassName(TypeElement typeElement, String packageName) {
        return typeElement.getQualifiedName().toString().substring(packageName.length() + 1).replace('.',
                '$');
    }
}