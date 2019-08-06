package ru.itis.spring;

public class CustomTextPrefixPostfixUtilsImpl implements PrefixUtils {
    private String prefix;
    private String postfix;
    private MessageRenderer renderer;

    public CustomTextPrefixPostfixUtilsImpl(MessageRenderer renderer) {
        this.renderer = renderer;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setPostfix(String postfix) {
        this.postfix = postfix;
    }

    @Override
    public void render(String message) {
        System.out.println(prefix);
        renderer.render(message);
        System.out.println(postfix);
    }
}
