package Hw4;

import Hw3.SLListSimple;

public class Leader {
    public static void main(String[] args) {   
        Leader test = new Leader();
        test.electLeader(9, 5);
    }

    public void electLeader(int n, int m){
        SLListSimple<Integer> list = new SLListSimple<>();
        for (int i = 1; i <= n; i++){
            list.addLast(i);
        }

        while (!list.isEmpty()) {
            for (int i = 1; i <= m - 1; i++){
                list.addLast(list.removeFirst());
            }
            list.removeFirst();
            System.out.println(list);
        }
    }
}