package sfc.rce;

import sfc.rce.io.Printer;
import sfc.rce.io.Reader;
import sfc.rce.net.Dataset;
import sfc.rce.net.Net;

import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Main {

    private static void argParse(String[] args){
        for (int i = 0; i < args.length; i++){
            if (i + 1 == args.length){
                System.err.print("Error: Missing value for " + args[i] + "\n");
                System.exit(1);
            }

            try {
                switch (args[i]) {
                    case "-t":
                        Arguments.trainingFile = args[i + 1];
                        break;
                    case "-v":
                        Arguments.validationFile = args[i + 1];
                        break;
                    case "-R":
                        Arguments.maxRadius = Double.parseDouble(args[i + 1]);
                        break;
                    case "-r":
                        Arguments.decreaseRation = Double.parseDouble(args[i + 1]);
                        break;
                }
                i++;
            }
             catch (NumberFormatException e) {
                System.err.println("Error: Invalid value of " + args[i] + "! Should be floating point number.\n");
                System.exit(1);
            }
        }
    }

    public static void main(String[] args) {
        String data = null;
        Dataset dataset = null;

        argParse(args);

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

                if (result == null){
                    result = "Unknown";
                }
                System.out.print("Result: " + result + "\n\n");
            }
        }
    }
}
