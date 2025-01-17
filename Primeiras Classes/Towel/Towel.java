import java.util.Scanner;

class Towel {

    String color;
    String size;
    int wetness;

    public Towel(String color, String size) {
        this.color = color;
        this.size = size;
        this.wetness = 0;
    }

    public void dry(int amount) {
        wetness += amount;
        if (wetness > getMaxwetness()) {
            wetness = getMaxwetness(); 
        }
    }
    

    public void wringOut() {
        wetness = 0;
    }

    public int getMaxwetness() {
        switch (size) {

            case "P":
                return 10;
            case "M":
                return 20;
            case "G":
                return 30;
            default:
                return 0;
        }

    }

    public boolean isDry() {
        return wetness == 0;
    }

    public String toString() {
        return String.format("Cor: %s, Tamanho: %s, Umidade: %d", color, size, wetness);
    }

    public void show() {
        System.out.println(this);
    }

}

public class Shell {

    public static void main(String[] a) {
        // CRIE SUA TOALHA AQUI
        // Toalha toalha = new Toalha();
        Towel towel = null;

        while (true) {
            var line = scanner.nextLine();
            System.out.println("$" + line);

            var par = line.split(" ");
            var cmd = par[0];

            if (cmd.equals("end")) {
                break;
            } else if (cmd.equals("criar")) {
                // ATUALIZE SUA TOALHA USANDO O CONSTRUTOR
                var cor = par[1];
                var tamanho = par[2];
                towel = new Towel(cor, tamanho);
            } else if (cmd.equals("mostrar")) {
                // MOSTRE SUA TOALHA
                towel.show();
            } else if (cmd.equals("enxugar")) {
                // ENXUGUE
                int quantidade = Integer.parseInt(par[1]);
                towel.dry(quantidade);
            
                // Verifique se a toalha está encharcada
                if (towel.wetness == towel.getMaxwetness()) { //pq colocamos no metodo dry, se wetness > getMaxwetness -> wetness = getMaxwetness
                    System.out.println("toalha encharcada");
                }
            } else if (cmd.equals("seca")) {
                // OBTENHA SE ESTA SECA E IMPRIMA SIM OU NAO
                if (towel.isDry() == true) {
                    System.out.println("sim");
                } else {
                    System.out.println("nao");
                }
            } else if (cmd.equals("torcer")) {
                // CHAME O METODO TORCER
                towel.wringOut();
            } else {
                System.out.println("comando invalido");
            }
        }
    }

    private static Scanner scanner = new Scanner(System.in);
}
