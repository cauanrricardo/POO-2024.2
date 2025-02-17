package application;

class Item {

    private String label;
    private int volume;

    public Item(String label, int volume) {
        this.label = label;
        this.volume = volume;
    }

    public String getLabel() {
        return label;
    }

    public int getVolume() {
        return volume;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return String.format("%s:%d", this.label, this.volume);
    }

}
