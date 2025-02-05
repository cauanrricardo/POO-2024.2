import java.util.*;

class Pessoa {

    private int age;
    private String name;

    public Pessoa(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%s:%d", name, age);
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

}

class Motorcycle {

    private Pessoa person; // penas define um espaço (referência) que pode apontar para um objeto do tipo
                           // // Person - agregação
    private int power;
    private int time;

    public Motorcycle(int power) {
        this.power = power;
        this.person = null;
        this.time = 0;
    }

    public Pessoa getPessoa() {
        return person;
    }

    public int getPower() {
        return power;
    }

    public int getTime() {
        return time;
    }

    public boolean insertPerson(Pessoa person) {
        if (this.person != null) {// tem pesssoa na moto
            System.out.println("fail: busy motorcycle");
            return false;
        } else {
            this.person = person;
            return true;
        }
    }

    public Pessoa remove() {
        if (this.person == null) {
            System.out.println("fail: empty motorcycle");
            return null;
        } else {
            Pessoa pessoaRemove; // criei uma variavel local como se fosse um "auxiliar" Person, para armazenar
                                 // temporarioamente os dados do this.person.
            pessoaRemove = this.person; // pessoaRemove vai receber os dados do atributo person, temporariamente
            this.person = null;// coloquei pra esse referencia receber nulo, ou seja esta vazia a moto
            // System.out.println(pessoaRemove.getName() + ":" + pessoaRemove.getAge());
            return pessoaRemove;// e retorno a pessoaRemove;
        }
    }

    public void buyTime(int time) {
        this.time += time;
    }

    public void drive(int time) {
        if (this.time <= 0) {
            System.out.println("fail: buy time first");
            return;
        }
        if (this.person == null) {
            System.out.println("fail: empty motorcycle");
            return;
        }
        if (this.person.getAge() > 10) {// acessar a classe Person com o atributo age, pelo metodo get, pois o atributo
            // é privado
            System.out.println("fail: too old to drive");
            return;
        }
        if (time > this.time) {
            System.out.println("fail: time finished after " + this.time + " minutes");
            this.time = 0;
            return;
        }
        this.time -= time;
    }

    public void honk() {
        String buzina = "P";
        for (int i = 0; i < power; i++) {
            buzina += "e";
        }
        buzina += "m";
        System.out.println(buzina);
    }

    @Override
    public String toString() {
        if (person == null) {
            return String.format("power:%d, time:%d, person:(empty)", getPower(), this.time);
        } else {
            return String.format("power:%d, time:%d, person:(%s)", getPower(), this.time, this.person.toString());
        }
    }

}

public class Shell {

    public static void main(String[] args) {
        Motorcycle moto = new Motorcycle(1);

        while (true) {
            var line = scanner.nextLine();
            System.out.println("$" + line);

            var par = line.split(" ");
            var cmd = par[0];

            if (cmd.equals("end")) {
                break;
            } else if (cmd.equals("init")) { // inicilaizar o construtor
                // // CRIE SUA MOTO AQUI
                var power = Integer.parseInt(par[1]);
                moto = new Motorcycle(power);
            } else if (cmd.equals("show")) {
                System.out.println(moto);
            } else if (cmd.equals("enter")) {
                // // CRIE UM OBJETO PESSOA AQUI
                // // DEPOIS INSIRA NA MOTO
                var name = par[1];
                var age = Integer.parseInt(par[2]);
                Pessoa pessoa = new Pessoa(name, age);
                moto.insertPerson(pessoa);
            } else if (cmd.equals("leave")) {
                // // RETIRE A PESSOA DA MOTO
                // // MOSTRE A PESSOA RETIRADA AQUI
                Pessoa pessoa = moto.remove();
                if (pessoa != null) {// caso exista uma pessoa
                    System.out.println(pessoa);
                }
            } else if (cmd.equals("buy")) {
                // // COMPRE TEMPO
                var time = Integer.parseInt(par[1]);
                moto.buyTime(time);
            } else if (cmd.equals("drive")) {
                // // DIRIJA A MOTO
                var time = Integer.parseInt(par[1]);
                moto.drive(time);
            } else if (cmd.equals("honk")) {
                // // BUZINE
                moto.honk();
            } else {
                System.out.println("fail: comando invalido");
            }
        }
    }

    static Scanner scanner = new Scanner(System.in);
}
