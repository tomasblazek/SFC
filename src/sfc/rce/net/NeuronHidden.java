package sfc.rce.net;

import java.util.ArrayList;

public class NeuronHidden {
    private ArrayList<Integer> weightVector;
    private Double innerPotential;
    private Double radius;
    private String resultClass;

    public NeuronHidden(){
        innerPotential = 0.0;
    }

    public void setResultClass(String str){
        resultClass = str;
    }

    public String getResultClass(){
        return resultClass;
    }

    public void setWeights(ArrayList<Integer> in){
        weightVector = in;
    }

    public void setRadius(Double r){
        radius = r;
    }

    public Double getRadius(){
        return radius;
    }

    public void reduceRadius(Double ratio){
        radius = ratio * radius;
    }

    public Double calculateInnerPotential(ArrayList<Integer> inputVector){
        Double result = 0.0;
        Integer input;
        Integer weight;
        for ( int i = 0; i < inputVector.size(); i++){
            input = inputVector.get(i);
            weight = weightVector.get(i);
            result += Math.pow((input - weight), 2);
        }

        result = Math.sqrt(result);
        innerPotential = result;
        return result;
    }

    public Double getInnerPotential() {
        return innerPotential;
    }
}