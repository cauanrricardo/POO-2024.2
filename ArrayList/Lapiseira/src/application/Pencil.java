package application;

import java.util.ArrayList;
import java.util.List;

class Pencil {

    private double thickness;
    private Lead tip = null;
    List<Lead> barrel = new ArrayList<>();

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
            System.out.println("fail: calibre incompatível");
            return false;
        }
        barrel.add(grafite);
        return true;

    }

    public Lead remove() {
        if (!hasGrafite()) {
            System.out.println("fail: nao existe grafite");
            return null;
        }
        Lead removed = tip;
        tip = null;
        return removed;
    }

    public void writePage() {
        if (!hasGrafite()) {
            System.out.println("fail: nao existe grafite no bico");
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

    public boolean pull() {
        if (hasGrafite()) {
            System.out.println("fail: ja existe grafite no bico");
            return false;
        }
        if (barrel.isEmpty()) {
            System.out.println("fail: tambor vazio");
            return false;
        }
        tip = barrel.remove(0); // retira o primeiro grafite do tambor e coloca no bico
        return true; // retornando true
    }

    @Override
    public String toString() {
        String bicoStr = (tip == null) ? "[]" : tip.toString();
        String tamborStr = "<";
        for (int i = 0; i < barrel.size(); i++) {
            if (i > 0) {
                tamborStr += "";
            }
            tamborStr += barrel.get(i).toString();
        }
        tamborStr += ">";

        return "calibre: " + thickness + ", bico: " + bicoStr + ", tambor: " + tamborStr;
    }

}