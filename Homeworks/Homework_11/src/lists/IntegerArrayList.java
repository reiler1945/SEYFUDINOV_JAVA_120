package lists;

public class IntegerArrayList {

    private int[] array;
    private int currentLength = 0; //актуальная длина списка

    //добавим элемент в список
    public void add(int element) {
        // если длины массива не хватает, увеличим в 1.5 раза
        if (currentLength == array.length) {
            int[] array_new = new int[(int)(array.length * 1.5)];
            for (int i = 0; i < array.length; i++) {
                array_new[i] = array[i];
            }
            array = array_new;
        }
        array[currentLength] = element;
        currentLength++;
        System.out.println("added element = " + element + " by index = " + (currentLength - 1));
    }

    //элемент по индексу
    public int get(int index) {
        if ((index < currentLength) && (index >= 0)) {
            return array[index];
        }
        return -1;
    }

    //удалим элемент по индексу
    public void removeByIndex(int index) {
        if ((index >= currentLength) && (index < 0)) {
            System.out.println("index = " + index + " is out of the list diapason");
        } else {
            int temp;
            for (int i = index; i < currentLength - 1; i++) {
                temp = array[i + 1];
                array[i] = temp;
            }
            currentLength--;
            System.out.println("removed element by index = " + index);
        }
    }

    //удалим элемент по значению
    public void removeByValue(int value) {
        int index = indexOf(value);
        if (index == -1) {
            System.out.println("There are no elements with value = " + value);
        } else {
            while (index != -1) {
                removeByIndex(index);
                index = indexOf(value);
            }
        }
    }

    //индекс элемента по значению
    public int indexOf(int value) {
        for (int i = 0; i < currentLength; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    //отобразим array list
    public void print() {
        String result = "[";
        for (int i = 0; i < currentLength; i++) {
            result = result + array[i] + ",";
        }
        result = result + "]";
        System.out.println(result);
    }

    //конструктор
    IntegerArrayList() {
        this.array = new int[10];
    }

}
