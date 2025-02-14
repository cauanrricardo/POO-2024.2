package application;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Market {

        private List<Person> counters = new ArrayList<>();
        private List<Person> queue = new LinkedList<>();

        public Market(int counterCont) {

                this.counters = new ArrayList<>();
                for (int i = 0; i < counterCont; i++) {
                        counters.add(null); // vai adicionar null em cada posicao
                }
                this.queue = new LinkedList<>();
        }

        private boolean validaIndex(int index) {
                return index >= 0 && index < counters.size();
        }

        public void arrive(Person person) {
                queue.add(person);
        }

        public boolean call(int index) {
                if (queue.isEmpty()) {
                        System.out.println("fail: sem clientes");
                        return false;
                }
                if (counters.get(index) != null) {
                        System.out.println("fail: caixa ocupado");
                        return false;
                }
                Person client = queue.remove(0); // removi o primeiro cliente da fila
                counters.set(index, client);// usei o set pra colocar o cleinte no caixa especifico
                return true;

        }

        public Person finish(int index) {
                if (!validaIndex(index)) {
                        System.out.println("fail: caixa inexistente");
                        return null;
                }
                if (counters.get(index) == null) {
                        System.out.println("fail: caixa vazio");
                        return null;
                }
                Person client = counters.get(index); // pegar o cliente no caixa;
                counters.set(index, null); // vai liberar o caixa
                return client; // retornando cliente

        }

        @Override
        public String toString() {
                String show = "Caixas: [";
                for (int i = 0; i < counters.size(); i++) {
                        if (i > 0) {
                                show += ", ";
                        }
                        if (counters.get(i) == null) {
                                show += "-----";
                        } else {
                                show += counters.get(i).getName();
                        }
                }
                show += "]\nEspera: " + queue;
                return show;

        }

}
