package ru.itis.spring;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class CustomTextPrefixUtilsImpl implements PrefixUtils {
    private String prefix;
    private MessageRenderer renderer;

    public CustomTextPrefixUtilsImpl(MessageRenderer renderer) {
        this.renderer = renderer;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setPostfix(String postfix) {
        throw new NotImplementedException();
    }

    @Override
    public void render(String message) {
        System.out.println(prefix);
        renderer.render(message);
    }
}
