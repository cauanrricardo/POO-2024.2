package Time;

import java.util.Scanner;

class Time {
    private int hour = 0;
    private int minute = 0;
    private int second = 0;


  //construtor
    public Time(int hour, int minute, int second){
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        
    } 
//SETTERS
    public void setHour(int hour){
        if(hour >= 0 && hour < 24){
           this.hour = hour;
        }
        else {
            System.out.println("fail: hora invalida");
        }
        
    }

    public void setMinute(int minute){
        if(minute >= 0 && minute < 60){
            this.minute =  minute;
        }
        else {
              System.out.println("fail: minuto invalido");
        }
    }


    public void setSecond(int second){
        if(second >= 0 && second < 60){
            this.second = second;
        }
        else{
            System.out.println("fail: segundo invalido");
        }
        
    }

//GETTERS
    public int getHour(){
        return hour;
    } 

    public int getMinute(){
        return minute;
    } 

    public int getSecond(){
        return second;
    } 

    //avança o tempo em um segundo
    public void nextSecond(){
        second++;
        if(this.second == 60){
            minute++;
            second = 0;
        }
        if(this.minute == 60){
            hour++;
            minute = 0;
        }
        if(this.hour == 24){
            hour = 0;
        }
       
    } 

    public String toString() {
        return String.format("%02d", hour) + ":" + 
               String.format("%02d", minute) + ":" + 
               String.format("%02d", second);
    }
}


class Solver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Time time = new Time(0, 0, 0);
        while (true) {
            String line = scanner.nextLine();
            System.out.println("$" + line);

            String[] ui = line.split(" ");
            String cmd = ui[0];

            if (cmd.equals("end")) {
                break;
            } else if (cmd.equals("set")) {
                time.setHour(Integer.parseInt(ui[1]));
                time.setMinute(Integer.parseInt(ui[2]));
                time.setSecond(Integer.parseInt(ui[3]));
            } else if (cmd.equals("show")) {
                System.out.println(time);
            } else if (cmd.equals("next")) {
                time.nextSecond();
            } else {
                System.out.println("fail: comando inválido");
            }
        }

        scanner.close();
    }
}