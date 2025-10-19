public class Perceptron {
    private double[] pesos;
    private double learningRate;
    private double bias;
    private int epocas;
    private double[][] entradas;
    private int[] saidas;

    public Perceptron(int epocas, double learningRate, double[][]  entradas, int[] saidas) {
        this.bias = Math.random();
        this.epocas = epocas;
        this.entradas = entradas;
        this.saidas = saidas;
        this.learningRate = learningRate;
        setPesos();
    }

    //função degrau de ativação
    private int ativacao(double soma) {
        return soma >= 0 ? 1 : 0;
    }

    //define os pesos iniciais com valores aleatórios entre 0 e 1
    private void setPesos() {
        pesos = new double[this.entradas[0].length];
        for (int i = 0; i < pesos.length; i++) {
            pesos[i] = Math.random();
        }
    }

    //para cada época faz uma predição e atualiza os pesos e o bias
    public void treinamento() {
        for (int epoca = 0; epoca < epocas; epoca++) {
            for(int i = 0; i < entradas.length; i++) {
                double soma = 0.d;
                for(int j = 0; j < entradas[i].length; j++) {
                    soma += pesos[j] * entradas[i][j];
                }
                soma += bias;
                int y_pred =  ativacao(soma);
                int erro = saidas[i] - y_pred;

                //atualização dos pesos -> peso(j) = peso(j) + (taxa de aprendizagem * erro da predição * entrada da predição)
                for(int j = 0; j < pesos.length; j++) {
                    pesos[j] += learningRate * erro *  entradas[i][j];
                }

                //atualização do bias -> bias + (taxa de aprendizagem * erro da predição)
                bias += learningRate * erro;
            }
        }
    }

    //faz uma predição binária -> f(somatório de (pesos * entrada) + bias)
    public int predicao(double[] entrada) throws Exception {
        if (entrada.length != pesos.length) {
            throw new Exception("entrada deve ter o número de elementos dos pesos");
        }
        double soma = 0.d;
        for(int j = 0; j < entrada.length; j++) {
            soma += pesos[j] * entrada[j];
        }
        soma += bias;
        return ativacao(soma);
    }
}
