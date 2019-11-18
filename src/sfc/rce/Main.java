package sfc.rce;

import sfc.rce.io.Printer;
import sfc.rce.io.Reader;
import sfc.rce.net.Dataset;
import sfc.rce.net.Net;

import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Main {

    public static void main(String[] args) {
        String data = null;
        Dataset dataset = null;

        Arguments.argParse(args);

        Net net = new Net(Arguments.maxRadius);

        if (!Arguments.trainingFile.equals("")){
            try {
                data = Reader.readString(Arguments.trainingFile);
                dataset = Reader.stringToDataset(data);
                if (dataset == null) {
                    System.err.println("Error: Reading file " + Arguments.trainingFile + " failed!\n");
                    System.exit(1);
                }
            } catch (NumberFormatException e) {
                System.err.println("Error: While parsing dataset from file \"" + Arguments.trainingFile + "\" bad format!\n");
                System.exit(1);
            } catch (IOException e) {
                System.err.println("Error: Reading file " + Arguments.trainingFile + " failed!\n");
                System.exit(1);
            }

            net.trainNet(dataset.trainingSet, dataset.resultVector); // Train net
        }

        if (!Arguments.validationFile.equals("")) {
            try {
                data = Reader.readString(Arguments.validationFile);
                dataset = Reader.stringToDataset(data);
                if (dataset == null) {
                    System.err.println("Error: Reading file " + Arguments.validationFile + " failed!\n");
                    System.exit(1);
                }
            } catch (NumberFormatException e) {
                System.err.println("Error: While parsing dataset from file \"" + Arguments.validationFile + "\" bad format!\n");
                System.exit(1);
            } catch (IOException e) {
                System.err.println("Error: Reading file " + Arguments.validationFile + " failed!\n");
                System.exit(1);
            }

            ArrayList<String> results = net.runNetMultiple(dataset.trainingSet);
            Printer.printResults(results, dataset);
        } else {
            while (true) {
                String result = null;
                try {
                    result = net.runNetSingle(Reader.getUserInput());
                } catch (NoSuchElementException e){
                    System.exit(0);
                }

                Printer.printResult(result);
            }
        }
    }
}
