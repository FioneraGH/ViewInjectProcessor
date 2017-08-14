package com.fionera.ioc;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.util.Elements;

/**
 * ProxyInfo
 * Created by fionera on 17-8-14 in IocProcessor.
 */

class ProxyInfo {
    private static final String PROXY = "ViewInjector";

    private TypeElement typeElement;
    private String packageName;
    private String proxyClassName;

    Map<Integer, VariableElement> injectVariables = new HashMap<>();

    ProxyInfo(Elements elementUtils, TypeElement typeElement) {
        this.typeElement = typeElement;
        PackageElement packageElement = elementUtils.getPackageOf(typeElement);
        String packageName = packageElement.getQualifiedName().toString();
        String className = ClassValidator.getClassName(typeElement, packageName);
        this.packageName = packageName;
        this.proxyClassName = className + "$$" + PROXY;
    }

    String generateJavaCode() {
        StringBuilder builder = new StringBuilder();
        builder.append("// Generated code. Do not modify the file!\n");
        builder.append(String.format(Locale.CHINA, "package %s;\n\n", packageName));

        builder.append("import com.fionera.ioc.*;\n\n");

        builder.append(
                String.format(Locale.CHINA, "public class %s implements %s<%s> {\n", proxyClassName,
                        ProxyInfo.PROXY, typeElement.getQualifiedName()));
        generateMethods(builder);
        builder.append("}\n");
        return builder.toString();
    }

    private void generateMethods(StringBuilder builder) {
        builder.append("  @Override\n");
        builder.append(
                String.format(Locale.CHINA, "  public void inject(%s host, Object source) {\n",
                        typeElement.getQualifiedName()));

        for (int id : injectVariables.keySet()) {
            VariableElement element = injectVariables.get(id);
            String name = element.getSimpleName().toString();
            String type = element.asType().toString();
            builder.append("    if (source instanceof android.app.Activity) {\n");
            builder.append(String.format(Locale.CHINA,
                    "      host.%s = (%s)(((android.app.Activity)source).findViewById(%s));\n",
                    name, type, id));
            builder.append("    } else {\n");
            builder.append(String.format(Locale.CHINA,
                    "      host.%s = (%s)(((android.view.View)source).findViewById(%s));\n", name,
                    type, id));
            builder.append("    }\n");
        }
        builder.append("  }\n");
    }

    String getProxyClassFullName() {
        return packageName + "." + proxyClassName;
    }

    TypeElement getTypeElement() {
        return typeElement;
    }
}
