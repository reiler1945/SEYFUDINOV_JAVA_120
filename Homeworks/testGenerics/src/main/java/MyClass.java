import java.util.Collection;

public class MyClass <T> {
    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public MyClass(T value) {
        this.value = value;
    }
    Collection collection = null;
}
