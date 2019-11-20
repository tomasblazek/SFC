/**
 *  Project RCE neural network for SFC subject
 *  Author: xblaze31
 */

package sfc.rce.net;

import java.util.ArrayList;

/**
 * Store dataset structures
 */
public class Dataset {
    public ArrayList<ArrayList<Double>> trainingSet = new ArrayList<ArrayList<Double>>();
    public ArrayList<String> resultVector = new ArrayList<String>();

    @Override
    public String toString() {
        String data = "Traning set\n";
        data += trainingSet.toString();
        data += "\nResult vector:\n";
        data += resultVector + "\n";
        return data;
    }
}
