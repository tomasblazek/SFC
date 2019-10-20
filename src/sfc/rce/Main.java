package sfc.rce;

import sfc.rce.io.Reader;
import sfc.rce.net.Dataset;
import sfc.rce.net.Net;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
	    String fileName = "T:\\VUT\\VUT\\2MIT\\SFC\\projekt\\SFC\\dataset\\test.txt";

        String data= null;
        try {
            data = Reader.readString(fileName);
        } catch (IOException e) {
            System.err.println("Error: Reading file " + fileName + " failed!\n");
            System.exit(1);
        }

        Dataset dataset = null;
        try {
            dataset = Reader.stringToDataset(data);
            if (dataset == null){
                System.err.println("Error: Reading file " + fileName + " failed!\n");
                System.exit(1);
            }
        } catch (NumberFormatException e) {
            System.err.println("Error: While parsing dataset from file \"" + fileName + "\" bad format!\n");
            System.exit(1);
        }

        Net net = new Net(3.0);
        net.trainNet(dataset.trainingSet, dataset.resultVector);
        System.out.println(data);
    }
}
