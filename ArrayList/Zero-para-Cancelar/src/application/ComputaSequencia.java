package application;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Locale;

class ComputaSequencia {

    private List<Integer> valores = new ArrayList<>();

    public void cadastra(int valor) {
        if (valor != 0) {
            valores.add(valor);
        } else {
            valores.remove(valores.size() - 1);
        }
    }

    public int computa() {
        int soma = 0;
        for (int valor : valores) {
            soma += valor;
        }
        return soma;
    }

    public String toString() {
        return "valores = " + valores.toString();
    }

}
