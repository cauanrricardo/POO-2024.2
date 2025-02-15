package application;

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