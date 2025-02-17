package application;

enum Coin {
    C10(0.10, 1, "C10"),
    C25(0.25, 2, "C25"),
    C50(0.50, 3, "C50"),
    C100(1.0, 4, "C100");

    private double value;
    private int volume;
    private String label;

    private Coin(double value, int volume, String label) {
        this.value = value;
        this.volume = volume;
        this.label = label;
    }

    public double getValue() {
        return value;
    }

    public int getVolume() {
        return volume;
    }

    public String getlabel() {
        return label;
    }

    @Override
    public String toString() {
        return String.format("%.2f:%d", this.value, this.volume);
    }
}