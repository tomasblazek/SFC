package sfc.rce.net;

import java.util.ArrayList;

public class Net {
    private ArrayList<NeuronHidden> neuronsHidden = new ArrayList<NeuronHidden>();
    private ArrayList<NeuronOut> neuronsOut = new ArrayList<NeuronOut>();
    private Double rMax;

    private Integer countOfNeuronsHidden = 0;
    private Integer countofNeuronsOut = 0;

    public Net(Double maxRadius){
        rMax = maxRadius;
    }


//    public String runNet(ArrayList<>)
//
//
//    public String runNet(){
//
//    }


    private void addHiddenNeuron (ArrayList<Double> inputVector, String resultClass){
        countOfNeuronsHidden++;
        NeuronHidden neuronHidden = new NeuronHidden();
        neuronHidden.setWeights(inputVector);
        neuronHidden.setResultClass(resultClass);
        neuronHidden.setRadius(rMax);
        neuronsHidden.add(neuronHidden);

        NeuronOut neuronOut = getNeuronOut(resultClass);
        if (neuronOut == null) {
            neuronOut = new NeuronOut(resultClass);
            countofNeuronsOut++;
            neuronsOut.add(neuronOut);
        }
        neuronOut.addInput(neuronHidden);
    }

    public void trainNet(ArrayList<ArrayList<Double>> in){
        Boolean modif = false;
        Boolean hit = false; // Indicator of hit
        Integer k = 0; // Index of neuron in net hidden layer


        for (ArrayList<Double> inputVector : in) {
            hit = false;
            k = 0;

            String resultClass = (inputVector.get(inputVector.size() - 1)).toString();

            if ((k + 1) > countOfNeuronsHidden) {
                addHiddenNeuron(inputVector, resultClass);
                modif = true;
            } else {
                for (; k < countOfNeuronsHidden; k++){
                    NeuronHidden neuronHidden = neuronsHidden.get(k);
                    Double innerPotential = neuronHidden.calculateInnerPotential(inputVector);
                    if (innerPotential <= neuronHidden.getRadius()){
                        if (neuronHidden.getResultClass().equals(resultClass)){
                            hit = true;
                        } else {
                            neuronHidden.reduceRadius(0.5);
                            modif = true;
                        }
                    }
                }

                if (k.equals(countOfNeuronsHidden) && !hit){
                    addHiddenNeuron(inputVector, resultClass);
                    modif = true;
                }

            }
        }

        if (modif){
            trainNet(in);
        }

    }

    private NeuronOut getNeuronOut(String classResult){
        for (NeuronOut neuron : neuronsOut) {
            if (neuron.getResultClass().equals(classResult)) {
                return neuron;
            }
        }
        return null;
    }

    public ArrayList<NeuronHidden> getNeuronsHidden() {
        return neuronsHidden;
    }

    public ArrayList<NeuronOut> getNeuronsOut() {
        return neuronsOut;
    }

}
