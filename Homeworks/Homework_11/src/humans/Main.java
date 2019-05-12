package humans;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Human[] humans = new Human[10];
        // введем список людей
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < humans.length; i++) {
            humans[i] = new Human();
            System.out.println("Введите имя, возраст человека № " + (i + 1));
            System.out.print("Имя:");
            humans[i].name = scanner.next();
            System.out.print("Возраст:");
            humans[i].age = scanner.nextInt();
        }
        // отобразим список людей
        for (int i = 0; i < humans.length; i++) {
            System.out.println("Вы ввели: человек № " + (i + 1) + "; name = " + humans[i].name + "; возраст = " + humans[i].age);
        }
        // найдем часто встречающийся возраст
        int[] ages = new int[10];
        for (int i = 0; i < humans.length; i++) {
            ages[i] = humans[i].age;
        }
        // сортируем массив возрастов
        ages = mergeSort(ages);
        // непосредственно ищем целевой результат
        int j = 1;
        int previous = ages[0];
        String mostCommonAges = "" + ages[0]; // здесь будем запоминать возрасты наиболее часто встречающиеся
        int mostCommonAgesCount = 1; // здесь будем запоминать частоту встречи возраста
        for (int i = 1; i < ages.length; i++) {
            if (ages[i] == previous) {
                j++;
                if (mostCommonAgesCount < j) {
                    mostCommonAgesCount = j;
                    mostCommonAges = "" + ages[i];
                } else if (mostCommonAgesCount == j) {
                    mostCommonAges = mostCommonAges + ", " + ages[i];
                }
            } else {
                j = 1;
            }
            previous = ages[i];
        }
        // покажем искомый результат
        if (mostCommonAgesCount > 1) {
            System.out.println("Наиболее часто встречающийся возраст = " + mostCommonAges + "; " + mostCommonAgesCount + " раз(а)");
        } else {
            System.out.println("Каждый возраст встречается по одному разу");
        }
    }
    /*сортировка слиянием*/
    public static int[] mergeSort(int[] a) {
        // если массив нулевой или единичной длины
        if (a.length <= 1) {
            return a;
        } else {
            // делим массив на 2 части
            int[] left = new int[a.length / 2];
            int[] right = new int[a.length - left.length];
            for (int i = 0; i < a.length; i++) {
                if (i < left.length) {
                    left[i] = a[i];
                }
                else {
                    right[i - left.length] = a[i];
                }
            }
            // сортируем полученные части
            left = mergeSort(left);
            right = mergeSort(right);
            // производим слияние 2-х отсортированных массивов в третий
            int[] result = new int[left.length + right.length];
            int k = 0;
            int m = 0;
            for (int i = 0; i < (left.length + right.length); i++) {
                // если не вышли за границу одного из массивов
                if ((k < left.length) && (m < right.length)) {
                    if (left[k] < right[m]) {
                        result[i] = left[k];
                        k++;
                    } else {
                        result[i] = right[m];
                        m++;
                    }
                } else {
                    // если вышли за границу right
                    if (k < left.length) {
                        result[i] = left[k];
                        k++;
                    } else {
                        result[i] = right[m];
                        m++;
                    }
                }
            }
            return result;
        }
    }
}
