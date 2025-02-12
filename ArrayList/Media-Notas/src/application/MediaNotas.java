package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

class MediaNotas {

    private List<Double> notas = new ArrayList<>();

    public void addNota(double nota) {
        notas.add(nota);

    }

    public void removeNota(int index) {
        if (index >= 0 && index <= notas.size()) {
            notas.remove(index);
        } else {
            System.out.println(" falha: indice invalido");
        }

    }

    private void mudaNota(int index, double valor) {
        notas.set(index, valor);
    }

    public double maiorNota() {
        if (notas.isEmpty()) {
            System.out.println("falha: quantidade de notas insuficiente");
            return -1;
        } else {
            double maior = Double.MIN_VALUE;

            for (Double nota : notas) {
                if (nota > maior) {
                    maior = nota;
                }

            }
            return maior;
        }

    }

    public double menorNota() {
        if (notas.isEmpty()) {
            System.out.println("falha: quantidade de notas insuficiente");
            return -1;
        } else {
            double menor = Double.MAX_VALUE;
            for (Double nota : notas) {
                if (nota < menor) {
                    menor = nota;
                }
            }
            return menor;
        }

    }

    public double media() {
        double soma = 0;
        for (Double nota : notas) {
            soma += nota;
        }
        double media = soma / notas.size();
        return media;

    }

    public void parametriza() {
        int index = 0;
        Double maior = maiorNota();

        for (Double nota : notas) {
            double m = 0.0;
            m = (nota / maior) * 10;
            mudaNota(index, m);
            index++;
        }
    }

    public String toString() {
        String resultado = "[";
        for (int i = 0; i < notas.size(); i++) {
            resultado += String.format(Locale.US, "%.2f", notas.get(i)); // Formata para duas casas decimais
            if (i < notas.size() - 1) { // Se não for o último elemento, adiciona vírgula e espaço
                resultado += ", ";
            }
        }
        resultado += "]";
        return resultado;
    }

}
