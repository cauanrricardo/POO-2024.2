import java.util.*;

class Carro {

    public int pass;
    public int passMax;
    public int gas;
    public int gasMax;
    public int km;

    public Carro() {
        this.pass = 0;
        this.passMax = 2;
        this.gas = 0;
        this.gasMax = 100;
        this.km = 0;
    }

    public void enter() {
        if (pass < passMax) {//verifica se o n° de passageiros e menor que o n° de passageiros totais
            pass++;
        } else {
            System.out.println("fail: limite de pessoas atingido");
        }

    }

    public void leave() {
        if (pass > 0) {//verifica se ha passageiros no carro
            pass--;
        } else {
            System.out.println("fail: nao ha ninguem no carro");
        }
    }

    public void drive(int distance) {
        if (this.pass == 0) {
            System.out.println("fail: nao ha ninguem no carro");
            return;
        }
        if (this.gas == 0) {
            System.out.println("fail: tanque vazio");
            return;
        }
        // 1 gas = 1 km; - pq o carro so consegue andar ate o n° de gasolina atual(gas)
        if (distance < gas) {//se a distancia for menor que a distancia total (gas)
            this.gas -= distance;//vai diminuir a gasolina
            this.km += distance;//vai aumentar o km
        } else {//se a distancia for maior que o gas
            System.out.println("fail: tanque vazio apos andar " + this.gas + " km");
            this.km += gas;
            this.gas = 0;
        }

    }

    public void fuel(int increment) {
        if (increment <= 0)
            return; // ignora valores inválidos
        gas += increment;
        if (gas > gasMax) {
            gas = gasMax;
        }
    }

    public String toString() {
        return "pass: " + pass + ", gas: " + gas + ", km: " + km;
    }

}

public class Shell {

    public static void main(String[] a) {
        // CRIE SEU CARRO AQUI
        Carro carro = new Carro();
        while (true) {
            var line = scanner.nextLine();
            System.out.println("$" + line);

            var par = line.split(" ");
            var cmd = par[0];

            if (cmd.equals("end")) {
                break;
            } else if (cmd.equals("show")) {
                // MOSTRE OS ATRIBUTOS DO CARRO
                System.out.println(carro);
            } else if (cmd.equals("enter")) {
                // TENTE EMBARCAR UMA PESSOA
                carro.enter();
            } else if (cmd.equals("leave")) {
                // TENTE DESEMBARCAR UMA PESSOA
                carro.leave();
            } else if (cmd.equals("fuel")) {
                // AUMENTE A QUANTIDADE DE COMBUSTIVEL
                int increment = Integer.parseInt(par[1]);
                carro.fuel(increment);
            } else if (cmd.equals("drive")) {
                // TENTE DIRIGIR UMA CERTA DISTANCIA
                int distance = Integer.parseInt(par[1]);
                carro.drive(distance);
            } else {
                System.out.println("fail: comando invalido");
            }
        }
    }

    private static Scanner scanner = new Scanner(System.in);
}
