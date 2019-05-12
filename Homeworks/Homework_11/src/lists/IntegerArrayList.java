package lists;

public class IntegerArrayList {

    int[] array;
    int currentLength = 0;

    void add(int element) {
        if (currentLength == 10) {
            System.out.println("Can't add element. The list is full");
        } else {
            array[currentLength] = element;
            currentLength++;
        }
    }

    int get(int index) {
        if ((index < currentLength) && (index >= 0)) {
            return array[index];
        }
        return -1;
    }

    void removeByIndex(int index) {
        //TODO
        currentLength--;
    }

    void removeByValue(int value) {
        //TODO
        currentLength--;
    }

    int indexOf(int value) {
        for (int i = 0; i < currentLength; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
