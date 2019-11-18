package sfc.rce.io;

import sfc.rce.net.Dataset;

import java.util.ArrayList;

public class Printer {
    public static void printResults(ArrayList<String> results, Dataset dataset){
        int correct = 0;
        int incorrect = 0;
        int unknown = 0;
        for (int i = 0; i < results.size(); i++){
            Integer index = i + 1;
            if (results.get(i) == null){
                System.out.print("" + index + ") Unknown");
                System.out.print(" should be:");
                System.out.println(dataset.resultVector.get(i));
                unknown++;
            } else if (!results.get(i).equals(dataset.resultVector.get(i))) {
                System.out.print("" + index + ") ");
                System.out.print(results.get(i));
                System.out.print(" should be:");
                System.out.println(dataset.resultVector.get(i));
                incorrect++;
            } else {
                System.out.print("" + index + ") ");
                System.out.print(results.get(i));
                System.out.print(" is correct\n");
                correct++;
            }
        }

        System.out.println("________________________________");
        System.out.println("Total: \t\t" + results.size() + "\nCorrect: \t" + correct + "\nIncorrect: \t" + incorrect
                            + "\nUnknown: \t" + unknown);    }
}
