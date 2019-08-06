import java.util.HashMap;

public class MainLinkedList {
    public static void main(String[] args) {
        List<String> linkedList = new LinkedList<>();
        linkedList.add("Привет", "Как дела", "Отлично", "Ok");
        System.out.println(linkedList);
        linkedList.removeAt(3);
        System.out.println(linkedList);
        System.out.println("Есть ли элемент ''Как дела'' = " + linkedList.contains("Как дела"));
        linkedList.remove("Отлично");
        System.out.println(linkedList);
        System.out.println(linkedList.get(1));
    }
}
