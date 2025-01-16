import java.util.*;
class Calculator {

    public int battery;
    public int batteryMax;
    public float display;

    public Calculator(int batteryMax) {
        this.batteryMax = batteryMax;
    }

    public void charge(int value) {
        if (value + battery <= batteryMax) {
            battery += value;
        } else {
            battery = batteryMax;
        }
    }

    public void sum(int a, int b) {
        if (battery == 0) {
            System.out.println("fail: bateria insuficiente");
            return;
        }
        display = a + b;
        battery--;

    }

    public void division(int num, int den) {
        if (battery == 0) {
            System.out.println("fail: bateria insuficiente");
            return;
        }
        if (den == 0) {
            System.out.println("fail: divisao por zero");
            battery--;
            return;
        }
        display = (float) num / den;
        battery--;
    }

    public String toString() {
        return String.format("display = %.2f, battery = %d", this.display, this.battery);
    }
}

public class Shell {

    public static void main(String[] args) {
        Calculator calculator = new Calculator(0);
        
        while (true) {
            var line = scanner.nextLine();
            System.out.println("$" + line);

            var par = line.split(" ");
            var cmd = par[0];

            if (cmd.equals("end")) {
                break;
            }
            else if (cmd.equals("init")) {
                // CHAME O CONSTRUTOR
                 int batteryMax = Integer.parseInt(par[1]);
                 calculator = new Calculator(batteryMax);
            } 
            else if (cmd.equals("show")) {
                // MOSTRAR
                System.out.println(calculator);
            } 
            else if (cmd.equals("charge")) {
                // RECARREGAR A BATERIA
                int value = Integer.parseInt(par[1]);
                calculator.charge(value);
            } 
            else if (cmd.equals("sum")) {
                // SOMAR
                 int a = Integer.parseInt(par[1]);
                 int b = Integer.parseInt(par[2]);
                 calculator.sum(a, b);
            } 
            else if (cmd.equals("div")) {
                // DIVIDIR
                 int num = Integer.parseInt(par[1]);
                 int den = Integer.parseInt(par[2]);
                 calculator.division(num, den);
            } 
            else {
                System.out.println("fail: comando invalido");
            }
        }
    }

    private static Scanner scanner = new Scanner(System.in);
}
