package application;

import java.util.Scanner;
import java.util.Locale;


class Solver{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MediaNotas m = new MediaNotas();

        while(true) {
            String line = scanner.nextLine();
            String ui[] = line.split(" ");
            System.out.println("$" + line);
            if(ui[0].equals("end")) {
                break; 
            } else if(ui[0].equals("addNota")) {
                m.addNota( Double.parseDouble( ui[1]) );
            } else if(ui[0].equals("removeNota")) {
                m.removeNota( Integer.parseInt( ui[1]) ); 
            } else if(ui[0].equals("maiorNota")) {
                System.out.println( m.maiorNota() );
            } else if(ui[0].equals("menorNota")) {
                System.out.println( m.menorNota() );
            } else if(ui[0].equals("media")) {
                System.out.printf( Locale.US, "%.2f\n",  m.media() );
            }else if(ui[0].equals("parametriza")) {
                m.parametriza(); 
            }else if(ui[0].equals("show")) {
                System.out.println( m );
            }else{
                System.out.println("fail: comando invalido");
            }
        }
        scanner.close();
    }
}
