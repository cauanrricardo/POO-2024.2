package application;

import java.util.*;

class Pig {

    private ArrayList<Coin> coins;
    private ArrayList<Item> items;
    private boolean broken = false;
    private int volumeMax;

    public Pig(int volumeMax) {
        this.volumeMax = volumeMax;
        coins = new ArrayList<>();
        items = new ArrayList<>();
    }

    public boolean addCoin(Coin coin) {
        if (broken == true) {
            System.out.println("fail: the pig is broken");
            return false;
        }
        if (coin.getVolume() + getVolume() >= volumeMax) {
            System.out.println("fail: the pig is full");
            return false;
        }
        coins.add(coin);
        return true;
    }

    public boolean addItem(Item item) {
        if (broken) {
            System.out.println("fail: the pig is broken");
            return false;
        }
        if (item.getVolume() + getVolume() >= volumeMax) {
            System.out.println("fail: the pig is full");
            return false;
        }
        items.add(item);
        return true;
    }

    public boolean breakPig() {
        if (broken) {
            System.out.println("fail: the pig is alredy broken");
            return false;
        }
        broken = true;
        return true;

    }

    public ArrayList<Coin> extractCoins() {
        if (!broken) {
            System.out.println("fail: you must break the pig first");
            return new ArrayList<>();
        }
        ArrayList<Coin> extractCoins = new ArrayList<>(coins); // criei um arraylist do tipo Coin chamado extractCoins
                                                               // que vai receber uma "copia" da lista de coins
        coins.clear(); // apago a lista de coins
        return extractCoins; // e retorno o extractCoins e uma copia da lista de coins
    }

    public ArrayList<Item> extractItems() {
        if (!broken) {
            System.out.println("fail: you must break the pig first");
            return new ArrayList<>();
        }
        ArrayList<Item> extracItems = new ArrayList<>(items);
        items.clear();
        return extracItems;
    }

    public int getVolume() {
        if (broken) {
            return 0;
        }
        int volume = 0;
        for (Item item : items) {
            volume += item.getVolume();
        }
        for (Coin coin : coins) {
            volume += coin.getVolume();
        }
        return volume;
    }

    public double getValue() {
        double value = 0;
        for (Coin coin : coins) {
            value += coin.getValue();
        }
        return value;
    }

    @Override
    public String toString() {
        String state = broken ? "broken" : "intact";
        String coinsList = coins.toString();
        String itemsList = items.toString();
        double value = getValue();
        int volume = getVolume();
        return String.format("state=%s : coins=%s : items=%s : value=%.2f : volume=%d/%d",
                state, coinsList, itemsList, value, volume, volumeMax);
    }

}