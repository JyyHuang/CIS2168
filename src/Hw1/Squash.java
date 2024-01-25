package Hw1;

import java.util.ArrayList;

public class Squash {
    public static void main(String[] args) {
        
    }

    public static int[] squash(int[] list){
        int l = 0;
        int r = 1;
        int i = 0;
        int duplicateCount = 0;
        int[] result = new int[list.length];
        while (list[r] != -1 || r < list.length);{
            if (list[l] == (list[r])){
                l++;
                r++;
                duplicateCount++;
            }
            else{
                result[i] = list[l];
                i++;
            }
        }

        for ()
    }
}
