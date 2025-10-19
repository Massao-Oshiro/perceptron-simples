public class Main {
    public static void main(String[] args) {
        double[][] entradas = {
                {0, 0},
                {1, 0},
                {0, 1},
                {1, 1},
        };
        int[] saidas = {0, 1, 1, 1};

        Perceptron perceptron = new Perceptron(100, 0.1, entradas, saidas);
        perceptron.treinamento();
        try {
            System.out.println(perceptron.predicao(new double[]{0, 0}));
            System.out.println(perceptron.predicao(new double[]{1, 1}));
            System.out.println(perceptron.predicao(new double[]{0, 1}));
            System.out.println(perceptron.predicao(new double[]{1, 0}));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        perceptron.mostrarPesosBias();
    }
}