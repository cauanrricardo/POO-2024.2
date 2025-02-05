import java.util.*;

class Pet {

    private int energyMax;
    private int cleanMax;
    private int energy;
    private int clean;
    private int age;
    private boolean alive;

    public Pet(int energyMax, int cleanMax) {
        this.energyMax = energyMax;
        this.cleanMax = cleanMax;
        this.energy = energyMax;
        this.clean = cleanMax;
        this.age = 0;
        this.alive = true;
    }

    public void setEnergy(int value) {
        if (value <= 0) {
            this.energy = 0;
            System.out.println("fail: pet morreu de fraqueza");
            this.alive = false;
        } else if (value > this.energyMax)
            this.energy = this.energyMax;
        else
            this.energy = value;
    }

    public void setClean(int value) {
        if (value <= 0) {
            this.clean = 0;
            System.out.println("fail: pet morreu de sujeira");
            this.alive = false;
        } else if (value > this.cleanMax)
            this.clean = this.cleanMax;
        else
            this.clean = value;
    }

    public void setAge(int value) {
        this.age = value;
    }

    public int getEnergyMax() {
        return energyMax;
    }

    public int getCleanMax() {
        return cleanMax;
    }

    public int getEnergy() {
        return energy;
    }

    public int getClean() {
        return clean;
    }

    public int getAge() {
        return age;
    }

    public boolean isAlive() {
        return !(this.clean == 0 || this.energy == 0);
    }

    @Override
    public String toString() {
        return "E:" + getEnergy() + "/" + energyMax + ", L:" + getClean() + "/" + cleanMax + ", I:" + age;

    }

    
}
class Game {
    private Pet pet;

  
    public Game(Pet pet) {
        this.pet = pet;
    }


    public void play() {
        if (!pet.isAlive()) {
            System.out.println("fail: pet esta morto");
            return;
        }
        pet.setEnergy(pet.getEnergy() - 2);
        pet.setClean(pet.getClean() - 3);
        pet.setAge(pet.getAge() + 1);
    }


    
    public void shower() {
        if (!pet.isAlive()) {
            System.out.println("fail: pet esta morto");
            return;
        }
        pet.setEnergy(pet.getEnergy() - 3);
        pet.setClean(pet.getCleanMax());
        pet.setAge(pet.getAge() + 2);
    }

    public void sleep() {
        if (!pet.isAlive()) {
            System.out.println("fail: pet esta morto");
            return;
        }
        if (pet.getEnergy() > pet.getEnergyMax() - 5) {
            System.out.println("fail: nao esta com sono");
            return;
        }
        int turnosDormidos = pet.getEnergyMax() - pet.getEnergy();  
        pet.setAge(pet.getAge() + turnosDormidos);
        pet.setEnergy(pet.getEnergyMax());
        
    }

    public void show() {
        System.out.println(pet);
    }
}

public class Shell {
    public static void main(String[] a) {
        Pet pet = new Pet(10, 10);
        Game game = new Game( pet);

        while (true) {
            var line = scanner.nextLine();
            System.out.println("$" + line);

            var par = line.split(" ");
            var cmd = par[0];

            if (cmd.equals("end")) {
                break;
            }
            if (cmd.equals("init")) {
                var energy = Integer.parseInt(par[1]);
                var clean = Integer.parseInt(par[2]);
                pet = new Pet(energy, clean);
                game = new Game(pet); // Substitui o jogo anterior
            }else if (cmd.equals("show")) {
                game.show();
             }
             else if (cmd.equals("play")) {
                game.play();
             }
             else if (cmd.equals("shower")) {
                 game.shower();
             }
             else if (cmd.equals("sleep")) {
                game.sleep();
             }
            else {
                System.out.println("fail: comando invalido");
            }
        }
    }

    private static Scanner scanner = new Scanner(System.in);
}
