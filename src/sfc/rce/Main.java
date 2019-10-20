package sfc.rce;

import sfc.rce.net.Net;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Ola amigo");

        ArrayList<Double> inputVector;
        ArrayList<ArrayList<Double>> trainingSet = new ArrayList<ArrayList<Double>>();

//        for (int a = 0; a < 4; a++){
//            inputVector = new ArrayList<Integer>();
//            for (int i = 0; i < 5; i++) {
//                inputVector.add(a);
//            }
//            trainingSet.add(inputVector);
//        }

        inputVector = new ArrayList<Double>();
        inputVector.add(2.0);
        inputVector.add(0.0);
        inputVector.add(1.0);
        trainingSet.add(inputVector);
        inputVector = new ArrayList<Double>();
        inputVector.add(0.0);
        inputVector.add(1.0);
        inputVector.add(2.0);
        trainingSet.add(inputVector);
        inputVector = new ArrayList<Double>();
        inputVector.add(2.0);
        inputVector.add(1.0);
        inputVector.add(1.0);
        trainingSet.add(inputVector);
        inputVector = new ArrayList<Double>();
        inputVector.add(0.0);
        inputVector.add(3.0);
        inputVector.add(2.0);
        trainingSet.add(inputVector);

        Net net = new Net(3.0);
        net.trainNet(trainingSet);

        System.out.println(trainingSet);

        ArrayList<ArrayList<Double>> testingSet = new ArrayList<ArrayList<Double>>();
        inputVector = new ArrayList<Double>();
        inputVector.add(0.0);
        inputVector.add(1.0);
        testingSet.add(inputVector);

    }
}
