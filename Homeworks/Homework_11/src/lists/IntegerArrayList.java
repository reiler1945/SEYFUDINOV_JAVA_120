package lists;

public class IntegerArrayList {

    int[] array;
    int currentLength = 0; //актуальная длина списка

    //добавим элемент в список
    void add(int element) {
        if (currentLength == 10) {
            System.out.println("Can't add element " + element + ". The list is full");
        } else {
            array[currentLength] = element;
            currentLength++;
            System.out.println("added element = " + element + " by index = " + (currentLength - 1));
        }
    }

    //элемент по индексу
    int get(int index) {
        if ((index < currentLength) && (index >= 0)) {
            return array[index];
        }
        return -1;
    }

    //удалим элемент по индексу
    void removeByIndex(int index) {
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
    void removeByValue(int value) {
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
    int indexOf(int value) {
        for (int i = 0; i < currentLength; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    //отобразим array list
    void print() {
        String result = "[";
        for (int i = 0; i < currentLength; i++) {
            result = result + array[i] + ",";
        }
        result = result + "]";
        System.out.println(result);
    }

}
