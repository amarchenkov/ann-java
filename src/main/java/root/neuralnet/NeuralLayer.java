package root.neuralnet;

import root.neuralnet.math.IActivationFunction;

import java.util.List;

public abstract class NeuralLayer {
    protected int numberOfNeuronsInLayer;
    private List<Neuron> neuron;
    protected IActivationFunction activationFnction;
    protected NeuralLayer previousLayer;
    protected NeuralLayer nextLayer;
    protected List<Double> input;
    protected List<Double> output;
    protected int numberOfInputs;

    protected void init() {
        for (int i = 0; i < numberOfNeuronsInLayer; i++) {
            try {
                neuron.get(i).setActivationFunction(activationFnction);
                neuron.get(i).init();
            } catch (IndexOutOfBoundsException iobe) {
                neuron.add(new Neuron(numberOfInputs, activationFnction));
                neuron.get(i).init();
            }
        }
    }

    protected void calc() {
        for (int i = 0; i < numberOfNeuronsInLayer; i++) {
            neuron.get(i).setInputs(this.input);
            neuron.get(i).calc();
            try {
                output.set(i, neuron.get(i).getOutput());
            } catch (IndexOutOfBoundsException iobe) {
                output.add(neuron.get(i).getOutput());
            }
        }
    }
}
