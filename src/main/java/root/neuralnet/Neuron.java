package root.neuralnet;

import root.neuralnet.math.IActivationFunction;
import root.neuralnet.math.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class Neuron {
    protected List<Double> weight;
    private List<Double> input;
    private Double output;
    private Double outputBeforeActivation;
    private int numberOfInputs;
    protected Double bias;
    private IActivationFunction activationFunction;

    public Neuron(int numberOfInputs, IActivationFunction activationFunction) {
        this.numberOfInputs = numberOfInputs;
        this.activationFunction = activationFunction;
        this.weight = new ArrayList<>(numberOfInputs + 1);
        this.input = new ArrayList<>(numberOfInputs);
    }

    public void init() {
        for (int i = 0; i <= numberOfInputs; i++) {
            double newWeight = RandomNumberGenerator.generateNext();
            this.weight.add(i, newWeight);

        }
    }

    public void calc() {
        outputBeforeActivation = 0.0;
        if (numberOfInputs > 0) {
            if (input != null && weight != null) {
                for (int i = 0; i <= numberOfInputs; i++) {
                    outputBeforeActivation += (i == numberOfInputs ? bias : input.get(i)) * weight.get(i);
                }
            }
        }
        output = activationFunction.calc(outputBeforeActivation);
    }

    public void setActivationFunction(IActivationFunction activationFnction) {
        this.activationFunction = activationFnction;
    }

    public void setInputs(List<Double> input) {
        this.input = input;
    }

    public Double getOutput() {
        return output;
    }
}
