package sfc.rce;

import sfc.rce.io.Reader;
import sfc.rce.net.Dataset;
import sfc.rce.net.Net;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	    String fileNameTrainingSet = "T:\\VUT\\VUT\\2MIT\\SFC\\projekt\\SFC\\dataset\\balance-scale2.data";
        String fileNameTestingSet = "T:\\VUT\\VUT\\2MIT\\SFC\\projekt\\SFC\\dataset\\balance-scale2-testing.data";

        String data= null;
        try {
            data = Reader.readString(fileNameTrainingSet);
        } catch (IOException e) {
            System.err.println("Error: Reading file " + fileNameTrainingSet + " failed!\n");
            System.exit(1);
        }

        Dataset dataset = null;
        try {
            dataset = Reader.stringToDataset(data);
            if (dataset == null){
                System.err.println("Error: Reading file " + fileNameTrainingSet + " failed!\n");
                System.exit(1);
            }
        } catch (NumberFormatException e) {
            System.err.println("Error: While parsing dataset from file \"" + fileNameTrainingSet + "\" bad format!\n");
            System.exit(1);
        }

        Net net = new Net(3.0);
        net.trainNet(dataset.trainingSet, dataset.resultVector);

        try {
            data = Reader.readString(fileNameTestingSet);
        } catch (IOException e) {
            System.err.println("Error: Reading file " + fileNameTestingSet + " failed!\n");
            System.exit(1);
        }

        try {
            dataset = Reader.stringToDataset(data);
            if (dataset == null){
                System.err.println("Error: Reading file " + fileNameTestingSet + " failed!\n");
                System.exit(1);
            }
        } catch (NumberFormatException e) {
            System.err.println("Error: While parsing dataset from file \"" + fileNameTestingSet + "\" bad format!\n");
            System.exit(1);
        }

        ArrayList<String> results =  net.runNetMultiple(dataset.trainingSet);

        for (int i = 0; i < results.size(); i++){
            if (!results.get(i).equals(dataset.resultVector.get(i))) {
                System.out.print("" + i + ") ");
                System.out.print(results.get(i));
                System.out.print(" should be:");
                System.out.println(dataset.resultVector.get(i));
            } else {
                System.out.print("" + i + ") ");
                System.out.print(results.get(i));
                System.out.print(" is correct\n");
            }
        }
    }
}
