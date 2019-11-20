/**
 *  Project RCE neural network for SFC subject
 *  Author: xblaze31
 */

package sfc.rce.io;

import sfc.rce.net.Dataset;

import java.util.ArrayList;

/**
 * Handle outputs.
 */
public class Printer {

    /**
     * Print help for user.
     */
    public static void printHelp() {
        System.out.print("Application for SFC implementing RCE neural network by Tomáš Blažek (xblaze31)\n");
        System.out.print("Usage: sfc-rce.jar [-t <training_set>][-v <training_set>][-R <max_radius>][-r <decrease_ratio>]\n\n");
        System.out.print("Options:\n");
        System.out.print("-t\tDefine training set of neural network\n");
        System.out.print("-v\tDefine validation set of neural network\n");
        System.out.print("-R\tSet max radius value of neuron RCE neural network\n");
        System.out.print("-r\tSet decrease ratio of radius. Should be from interval (0,1)\n");
    }

    /**
     * Print result of classification.
     * @param result String with result
     */
    public static void printResult(String result){
        if (result == null){
            result = "Unknown";
        }

        System.out.print("__________________________\n");
        System.out.print("     Result: " + result + "\n");
        System.out.print("__________________________\n\n");
    }

    /**
     * Print multiple results of classification and overall statistics.
     *
     * @param results Arraylist of results
     * @param dataset Validation Dataset
     */
    public static void printResults(ArrayList<String> results, Dataset dataset){
        int correct = 0;
        int incorrect = 0;
        int unknown = 0;
        for (int i = 0; i < results.size(); i++){
            int index = i + 1;
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
