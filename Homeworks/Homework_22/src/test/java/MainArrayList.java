public class MainArrayList {
    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>();
        arrayList.add("Привет", "Как дела", "Отлично");
        System.out.println(arrayList);
        arrayList.add("Ok");
        System.out.println(arrayList);
        System.out.println("Есть ли `Ok`? " + arrayList.contains("Ok"));
        arrayList.remove("Ok");
        System.out.println(arrayList);
        arrayList.removeAt(2);
        System.out.println(arrayList);
        arrayList.removeAt(0);
        System.out.println(arrayList);
    }
}
