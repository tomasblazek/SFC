/**
 *  Project RCE neural network for SFC subject
 *  Author: xblaze31
 */

package sfc.rce.io;

import sfc.rce.net.Dataset;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Handle inputs.
 */
public class Reader {

    /**
     * User input handler.
     *
     * @return Vector for neural network for classification
     * @throws NoSuchElementException
     */
    public static ArrayList<Double> getUserInput() throws NoSuchElementException {
        Scanner input = new Scanner(System.in);
        String line = "'missing input'";
        String[] messages = {"Set left weight:\n",
                             "Set left distance:\n",
                             "Set right weight:\n",
                             "Set right distance:\n"};

        ArrayList<Double> inVector = new ArrayList<Double>();

        for (int i = 0; i < messages.length; i++){
            try {
                System.out.print(messages[i]);
                line = input.nextLine();
                inVector.add(Double.parseDouble(line));
            } catch (NumberFormatException e){
                System.err.println("Error: Invalid value of " + line + "! Should be number.\n");
                i--;
            }
        }

        return inVector;
    }

    /**
     * Read content of file.
     *
     * @param fileName File name
     * @return  String with file content
     * @throws IOException
     */
    public static String readString(String fileName) throws IOException {
        String data = "";
        data = new String(Files.readAllBytes(Paths.get(fileName)));
        return data;
    }

    /**
     * Parse string to Dataset format. String should be in format of numbers separated by colons. Example: 1,2,3,1
     *
     * @param data Data string
     * @return Return object of Dataset
     * @throws NumberFormatException
     */
    public static Dataset stringToDataset(String data) throws NumberFormatException{
        Dataset dataset = new Dataset();
        String[] lines;
        String[] elements;
        lines = data.split("\n");
        for (String line : lines){
            elements = line.split(",");
            if (elements.length < 2){
                return dataset;
            }
            dataset.resultVector.add(elements[0]);
            ArrayList<Double> trainingVector = new ArrayList<Double>();
            for (int i = 1; i < elements.length; i++){
                Double e = Double.parseDouble(elements[i]);
                trainingVector.add(e);
            }
            dataset.trainingSet.add(trainingVector);
        }

        return dataset;
    }

}
