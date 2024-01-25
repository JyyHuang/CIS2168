package Hw1;

import java.util.Arrays;

public class Squash {
    public static void main(String[] args) {
        int[] list = {0,0,0,0,1,1,0,0,0,7,7,7,1,1,0};
        System.out.println("Before: " + Arrays.toString(list));
        squash(list);
        System.out.println("After: " + Arrays.toString(list));
    }

    public static void squash(int[] arr){
        if (arr.length == 0){
            return;
        }

        int j = 0;
        int current = arr[j];
        for (int i = 1; i < arr.length; i++){
            if (arr[i] != current){
                j++;
                arr[j] = arr[i];
                current = arr[j];
            }
        }

        for (int i = j + 1; i < arr.length; i++){
            arr[i] = -1;
        }
    }
}
