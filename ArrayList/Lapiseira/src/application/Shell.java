package application;

import java.util.Scanner;

public class Shell {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Pencil pencil = new Pencil(0.5);

        while (true) {
            var line = scanner.nextLine();
            System.out.println("$" + line);

            var par = line.split(" ");
            var cmd = par[0];

            if (cmd.equals("end")) {
                break;
            } else if (cmd.equals("init")) {
                var thickness = Double.parseDouble(par[1]);
                pencil = new Pencil(thickness);
            } else if (cmd.equals("show")) {
                System.out.println(pencil);
            } else if (cmd.equals("insert")) {
                var thickness = Double.parseDouble(par[1]);
                var hardness = par[2];
                var size = Integer.parseInt(par[3]);
                pencil.insert(new Lead(thickness, hardness, size));
            } else if (cmd.equals("remove")) {
                pencil.remove();
            } else if (cmd.equals("write")) {
                pencil.writePage();
            } else if (cmd.equals("pull")) {
                pencil.pull();
            } else {
                System.out.println("fail: comando invalido");
            }
        }
    }
}
