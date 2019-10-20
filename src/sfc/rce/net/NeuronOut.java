package sfc.rce.net;

import java.util.ArrayList;

public class NeuronOut {
    private ArrayList<NeuronHidden> inputNeurons = new ArrayList<NeuronHidden>();
    private String resultClass;

    public NeuronOut(String resultClass){
       this.resultClass = resultClass;
    }

    public void addInput(NeuronHidden n){
        inputNeurons.add(n);
    }

    public ArrayList<NeuronHidden> getInputNeurons(){
        return inputNeurons;
    }

    public String getResultClass(){
        return resultClass;
    }

}
