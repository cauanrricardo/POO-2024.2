package application;

import java.util.Scanner;

class Shell {
    public static void main(String[] _args) {
        Market market = null;
        while (true) {
            var line = scanner.nextLine();
            System.out.println("$" + line);

            var par = line.split(" ");
            var cmd = par[0];

            if (cmd.equals("end")) {
                break;
            } else if (cmd.equals("init")) {
                var qtd_caixas = Integer.parseInt(par[1]);
                market = new Market(qtd_caixas);
            } else if (cmd.equals("show")) {
                System.out.println(market);
            } else if (cmd.equals("arrive")) {
                var nome = par[1];
                market.arrive(new Person(nome));
            } else if (cmd.equals("call")) {
                var indice = Integer.parseInt(par[1]);
                market.call(indice);
            } else if (cmd.equals("finish")) {
                var indice = Integer.parseInt(par[1]);
                market.finish(indice);
            } else {
                System.out.println("fail: comando invalido");

            }
        }
    }

    static Scanner scanner = new Scanner(System.in);

}
