
import java.util.Random;

public class LinearSearch {

//create a random array
    public int[] generate(int length) {
        int[] array = new int[length];
        Random rd = new Random();
        for (int i = 0; i < length; i++) {
            array[i] = rd.nextInt(length);
        }
        return array;
    }

//display created array
    public void displayArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    int linearSearch(int[] array, int value) {
        int index = -1;
        int i;
        for (i = 0; i < array.length; i++) {
            if (value == array[i]) {
                index = i;
                break;
            }
        }
        return index;
    }

}
