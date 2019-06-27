public class TestMyClass {
    public static void main(String[] args) {
        MyClass<String> my1 = new MyClass<String>("Привет");
        Printable printable = (print) -> System.out.println(print);
        printable.print(my1.getValue());
        MyClass<Integer> my2 = new MyClass<Integer>(100);
        printable.print(my2.getValue());
    }
}
