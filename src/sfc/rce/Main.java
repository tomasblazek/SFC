package sfc.rce;

import sfc.rce.net.Net;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Ola amigo");

        ArrayList<Integer> inputVector;
        ArrayList<ArrayList<Integer>> trainingSet = new ArrayList<ArrayList<Integer>>();

//        for (int a = 0; a < 4; a++){
//            inputVector = new ArrayList<Integer>();
//            for (int i = 0; i < 5; i++) {
//                inputVector.add(a);
//            }
//            trainingSet.add(inputVector);
//        }

        inputVector = new ArrayList<Integer>();
        inputVector.add(2);
        inputVector.add(0);
        inputVector.add(1);
        trainingSet.add(inputVector);
        inputVector = new ArrayList<Integer>();
        inputVector.add(0);
        inputVector.add(1);
        inputVector.add(2);
        trainingSet.add(inputVector);
        inputVector = new ArrayList<Integer>();
        inputVector.add(2);
        inputVector.add(1);
        inputVector.add(1);
        trainingSet.add(inputVector);
        inputVector = new ArrayList<Integer>();
        inputVector.add(0);
        inputVector.add(3);
        inputVector.add(2);
        trainingSet.add(inputVector);

        Net net = new Net(3.0);
        net.trainNet(trainingSet);

        System.out.println(trainingSet);
    }
}
