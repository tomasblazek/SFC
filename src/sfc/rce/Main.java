package sfc.rce;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Ola amigo");

        ArrayList<Integer> inputVector;
        ArrayList<ArrayList<Integer>> trainingSet = new ArrayList<ArrayList<Integer>>();

        for (int a = 0; a < 3; a++){
            inputVector = new ArrayList<Integer>();
            for (int i = 0; i < 5; i++) {
                inputVector.add(a);
            }
            trainingSet.add(inputVector);
        }
        System.out.println(trainingSet);





    }
}
