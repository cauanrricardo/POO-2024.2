package application;

import java.util.Scanner;

public class Shell {
    public static void main(String[] args) {
        TrampoLine tr = new TrampoLine();
        while (true) {
            var line = scanner.nextLine();
            System.out.println("$" + line);

            var par = line.split(" ");
            var cmd = par[0];

            if (cmd.equals("end")) {
                break;
            } else if (cmd.equals("show")) {
                System.out.println(tr);
            } else if (cmd.equals("arrive")) {
                var name = par[1];
                var age = Integer.parseInt(par[2]);
                Kid kid = new Kid(name, age);
                tr.arrive(kid);
            } else if (cmd.equals("enter")) {
                tr.enter();
            } else if (cmd.equals("leave")) {
                tr.leave();
            } else if (cmd.equals("remove")) {
                var name = par[1];
                if (tr.removeKid(name) == null) {
                    System.out.println("fail: " + name + " nao esta no pula-pula");
                }
            } else {
                System.out.println("fail: comando invalido");
            }
        }
    }

    private static Scanner scanner = new Scanner(System.in);
}
