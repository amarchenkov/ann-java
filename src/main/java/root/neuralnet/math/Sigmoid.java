package root.neuralnet.math;

public class Sigmoid implements IActivationFunction {
    private double a = 0.0;

    public Sigmoid(double a) {
        this.a = a;
    }

    @Override
    public Double calc(Double x) {
        return 1.0 / (1.0 + Math.exp(-a * x));
    }

}
