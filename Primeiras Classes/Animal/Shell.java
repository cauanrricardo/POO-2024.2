import java.util.Scanner;

class Animal{

    public String species;
    public String sound;
    public  int age;

    public Animal(String species, String sound){
    this.species = species;
    this.sound = sound;
    this.age= 0;
    }

    public String makeSound(){
        if(age == 0){
            return "---";
        }
        if(age == 4){
            return "RIP";
        }
        return this.sound;
    }

    public void ageBy(int increment){
        age += increment;
         if(age >= 4){
            System.out.printf("warning: %s morreu%n", species);
            age = 4;
         }
    }
    public String toString(){
        return String.format("%s:%d:%s", species, age, sound);
    }

}
public class Shell {

    public static void main(String[] _args) {
         Animal animal = new Animal("", "");

        while (true) { //vai ser um loop infinito, ate achar um break;
            var line = scanner.nextLine();//line e o nome da variavel e le a linha digitada pelo usuario
            System.out.println("$" + line);//imprimi o $ + line

            //Processamentos de comandos
            var par = line.split(" ");//split = divide a linha separada por espaços
            var cmd = par[0];//pega o primeiro elemento da line

            if (cmd.equals("end")  ) { //se for end o comando termina
                break;
            }
            else if (cmd.equals("init") ) {
                // INICIE O ANIMAL UTILIZANDO O CONSTRUTOR
                 var species = par[1
                 ];
                 var sound = par[2];
                 animal = new Animal(species, sound);
            } 
            else if (cmd.equals("show")) {
                // MOSTRE O ANIMAL
                System.out.println(animal);
            } 
            else if (cmd.equals("noise")) {
                // OBTER O BARULHO DO ANIMAL E IMPRIMA
                System.out.println(animal.makeSound());
            } 
            else if (cmd.equals("grow") ) {
                // AUMENTE A IDADE DO ANIMAL
                 var increment = Integer.parseInt(par[1]);//comverte de String para int
                 animal.ageBy(increment);
            }  
            else {
                System.out.println("fail: comando invalido\n");
            }
        }
    }

    static Scanner scanner = new Scanner(System.in);
}
