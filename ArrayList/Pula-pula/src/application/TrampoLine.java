package application;

import java.util.LinkedList;

class TrampoLine {

    private LinkedList<Kid> playing;
    private LinkedList<Kid> waiting;

    private Kid removeFromList(String name, LinkedList<Kid> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(name)) {
                return list.remove(i);
            }
        }
        return null;
    }

    public TrampoLine() {
        playing = new LinkedList<>();
        waiting = new LinkedList<>();
    }

    public void arrive(Kid kid) {
        waiting.addFirst(kid);
    }

    public void enter() {
        if (!waiting.isEmpty()) {// tem q ter crianca na fila de espera
            Kid first = waiting.removeLast(); // removendo o ultimo da lista de waiting
            playing.addFirst(first);// adicionando no primeiro playing
        }
    }

    public void leave() {
        if (!playing.isEmpty()) { // tem q ter gente na fila de playing
            Kid last = playing.removeLast(); // remover a ultima pessoa da fila playing
            waiting.addFirst(last); //adiciona em primeiro waiting
        }

    }

    public Kid removeKid(String name) {
        Kid kid = removeFromList(name, playing);
        if (kid == null) {
            kid = removeFromList(name, waiting);
        }
        return kid;
    }

    @Override
    public String toString() {
        String waitingStr;
        if (waiting.isEmpty()) {
            waitingStr = "[]";
        } else {
            waitingStr = waiting.toString();
        }

        String playingStr;
        if (playing.isEmpty()) {
            playingStr = "[]";
        } else {
            playingStr = playing.toString();
        }

        return waitingStr + " => " + playingStr;
    }

}
