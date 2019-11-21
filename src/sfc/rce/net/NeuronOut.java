/**
 *  Project RCE neural network for SFC subject
 *  Author: xblaze31
 */

package sfc.rce.net;

import java.util.ArrayList;

/**
 * Class represents output neuron and its properties.
 */
public class NeuronOut {
    private ArrayList<NeuronHidden> inputNeurons = new ArrayList<NeuronHidden>();
    private String resultClass;

    public NeuronOut(String resultClass){
       this.resultClass = resultClass;
    }

    /**
     * Add input to output neuron.
     * @param n Input neuron
     */
    public void addInput(NeuronHidden n){
        inputNeurons.add(n);
    }

    /**
     * Get input neurons.
     * @return Input neurons
     */
    public ArrayList<NeuronHidden> getInputNeurons(){
        return inputNeurons;
    }

    /**
     * Get result class.
     * @return Result class
     */
    public String getResultClass(){
        return resultClass;
    }

}
