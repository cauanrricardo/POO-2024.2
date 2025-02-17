package application;

import java.util.*;
import java.util.stream.Collectors;

public class Shell {
    public static void main(String[] _args) {
        Pig pig = new Pig(0);
        while (true) {
            var line = scanner.nextLine();
            System.out.println("$" + line);

            var par = line.split(" ");
            var cmd = par[0];

            if (cmd.equals("end")) {
                break;
            } else if (cmd.equals("init")) {
                int maxVolume = Integer.parseInt(par[1]);
                pig = new Pig(maxVolume);
            } else if (cmd.equals("show")) {
                // Imprima o estado do porquinho
                System.out.println(pig.toString());
            } else if (cmd.equals("addCoin")) {
                // COM!
                var coin = par[1];
                // DEL!
                if (coin.equals("10")) {
                    pig.addCoin(Coin.C10);
                } else if (coin.equals("25")) {
                    pig.addCoin(Coin.C25);
                } else if (coin.equals("50")) {
                    pig.addCoin(Coin.C50);
                } else if (coin.equals("100")) {
                    pig.addCoin(Coin.C100);
                } else {
                    System.out.println("fail: invalid coin");
                }
            } else if (cmd.equals("addItem")) {
                var item = par[1];
                var volume = Integer.parseInt(par[2]);
                pig.addItem(new Item(item, volume));
            } else if (cmd.equals("break")) {
                pig.breakPig();
            } else if (cmd.equals("extractCoins")) {
                // Obtenha as moedas usando o método extractCoins
                // Imprima as moedas obtidas
                var coins = pig.extractCoins().stream().map(coin -> "" + coin.toString())
                        .collect(Collectors.joining(", "));
                System.out.println("[" + coins + "]");
            } else if (cmd.equals("extractItems")) {
                // Obtenha os itens usando o método extractItems
                // Imprima os itens obtidos
                var items = pig.extractItems().stream().map(item -> "" + item.toString())
                        .collect(Collectors.joining(", "));
                System.out.println("[" + items + "]");
            } else {
                System.out.println("fail: invalid command");
            }
        }
    }

    public static Scanner scanner = new Scanner(System.in);
}
