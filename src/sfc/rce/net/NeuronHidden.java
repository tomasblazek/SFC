package sfc.rce.net;

import java.util.ArrayList;

public class NeuronHidden {
    private ArrayList<Double> weightVector;

    private Double radius;
    private String resultClass;

    public NeuronHidden(){
    }

    public void setResultClass(String str){
        resultClass = str;
    }

    public String getResultClass(){
        return resultClass;
    }

    public void setWeights(ArrayList<Double> in){
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