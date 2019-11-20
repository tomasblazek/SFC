/**
 *  Project RCE neural network for SFC subject
 *  Author: xblaze31
 */

package sfc.rce.net;

import java.util.ArrayList;

/**
 * Class represents hidden neuron and its properties.
 */
public class NeuronHidden {
    private ArrayList<Double> weightVector;

    private Double radius;
    private String resultClass;

    public NeuronHidden(){
    }

    /**
     * Set result class.
     * @param str Result class
     */
    public void setResultClass(String str){
        resultClass = str;
    }

    /**
     * Get result class.
     * @return Result class
     */
    public String getResultClass(){
        return resultClass;
    }

    /**
     * Set weights of neuron inputs.
     * @param in Input weights
     */
    public void setWeights(ArrayList<Double> in){
        weightVector = in;
    }

    /**
     * Set neuron radius.
     * @param r Radius
     */
    public void setRadius(Double r){
        radius = r;
    }

    /**
     * Get neuron radius.
     * @return Radius
     */
    public Double getRadius(){
        return radius;
    }

    /**
     * Process reduce of neuron radius by given ratio.
     * @param ratio Reduce ratio
     */
    public void reduceRadius(Double ratio){
        radius = ratio * radius;
    }

    /**
     * Calculate inner potential of neuron.
     * @param inputVector Input vector
     * @return Inner potential
     */
    public Double calculateInnerPotential(ArrayList<Double> inputVector){
        Double result = 0.0;
        Double input;
        Double weight;
        for ( int i = 0; i < inputVector.size(); i++){
            input = inputVector.get(i);
            weight = weightVector.get(i);
            result += Math.pow((input - weight), 2);
        }

        result = Math.sqrt(result);
        return result;
    }

}