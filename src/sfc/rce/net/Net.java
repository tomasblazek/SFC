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


    public ArrayList<String> runNetMultiple(ArrayList<ArrayList<Double>> inputVectors){
        ArrayList<String> results = new ArrayList<String>();

        for (ArrayList<Double> inputVector : inputVectors) {
            results.add(runNetSingle(inputVector));
        }
        return results;
    }

    public String runNetSingle(ArrayList<Double> inputVector){
        for (NeuronOut neuronOut : neuronsOut){
            for (NeuronHidden neuronInput : neuronOut.getInputNeurons()){
                Double innerPotential = neuronInput.calculateInnerPotential(inputVector);
                if (innerPotential <= neuronInput.getRadius()) {
                    return neuronOut.getResultClass();
                }
            }
        }

        return null;
    }

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

    public void trainNet(ArrayList<ArrayList<Double>> in, ArrayList<String> results){
        Boolean modif = false;
        Boolean hit = false; // Indicator of hit
        Integer k = 0; // Index of neuron in net hidden layer
        Integer p = 0; // Index of input vector

        for (ArrayList<Double> inputVector : in) {
            hit = false;
            k = 0;


            String resultClass = results.get(p);

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
                            neuronHidden.reduceRadius(0.8);
                            modif = true;
                        }
                    }
                }

                if (k.equals(countOfNeuronsHidden) && !hit){
                    addHiddenNeuron(inputVector, resultClass);
                    modif = true;
                }

            }
            p++;
        }

        if (modif){
            trainNet(in, results);
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
