import java.util.Scanner;

class Lead {

    private double thickness;
    private String hardness;
    private int size;

    public Lead(double thickness, String hardness, int size) {
        this.thickness = thickness;
        this.hardness = hardness;
        this.size = size;
    }

    public String getHardness() {
        return hardness;
    }

    public int getSize() {
        return size;
    }

    public double getThickness() {
        return thickness;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int usagePerSheet() {
        switch (hardness) {
            case "HB":
                return 1;
            case "2B":
                return 2;
            case "4B":
                return 4;
            case "6B":
                return 6;

            default:
                return 0;
        }

    }

    @Override
    public String toString() {
        return "[" + thickness + ":" + hardness + ":" + size + "]";
    }

}

class Pencil {

    private double thickness;
    private Lead tip = null;

    public Pencil(double thickness) {
        this.thickness = thickness;
    }

    public boolean hasGrafite() {
        return tip != null;
    }

    public boolean insert(Lead grafite) {
        if (hasGrafite()) {
            System.out.println("fail: ja existe grafite");
            return false;
        }
        if (grafite.getThickness() != thickness) {
            System.out.println("fail: calibre incompativel");
            return false;
        }
        tip = grafite;
        return true;

    }

    public Lead remove() {
        if (!hasGrafite()) {
            System.out.println("fail: nao existe grafite");
        }
        Lead removed = tip;
        tip = null;
        return removed;
    }

    public void writePage() {
        if (!hasGrafite()) {
            System.out.println("fail: nao existe grafite");
            return;
        }
        if (tip.getSize() <= 10) { 
            System.out.println("fail: tamanho insuficiente");
            return;
        }
        if (tip.getSize() - tip.usagePerSheet() < 10) {
            System.out.println("fail: folha incompleta");
            tip.setSize(10); 
            return;
        }

        tip.setSize(tip.getSize() - tip.usagePerSheet()); 
    }

    @Override
    public String toString() {
        if (tip == null)
            return "calibre: " + thickness + ", grafite: " + null;
        else
            return "calibre: " + thickness + ", grafite: " + tip.toString();
    }

}

public class Shell {
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
            } else {
                System.out.println("fail: comando invalido");
            }
        }
    }

    static Scanner scanner = new Scanner(System.in);
}
