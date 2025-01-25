import java.util.*;

final class Time {

    private int hour;
    private int minute;
    private int second;

    public Time(int hour, int minute, int second) {
        setHour(hour);
        setMinute(minute);
        setSecond(second);
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    public void setHour(int hour) {
        if (hour >= 0 && hour <= 23) {
            this.hour = hour;
        } else {
            System.out.println("fail: hora invalida");
        }
    }

    public void setMinute(int minute) {
        if (minute >= 0 && minute <= 59) {
            this.minute = minute;
        } else {
            System.out.println("fail: minuto invalido");
        }
    }

    public void setSecond(int second) {
        if (second >= 0 && second <= 59) {
            this.second = second;
        } else {
            System.out.println("fail: segundo invalido");
        }
    }

    public void nextsecond() {
        second++;
        if (this.second == 60) {
            this.minute++;
            this.second = 0;
        }
        if (this.minute == 60) {
            this.hour++;
            this.minute = 0;
        }
        if (this.hour == 24) {
            this.hour = 0;
        }
    }

    @Override//
    public String toString() {
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }

}

public class Shell {
    public static void main(String[] a) {
        Time time = new Time(0, 0, 0);

        while (true) {
            var line = scanner.nextLine();
            System.out.println("$" + line);

            var par = line.split(" ");
            var cmd = par[0];

            if (cmd.equals("end")) {
                break;
            } else if (cmd.equals("show")) {
                // MOSTRE O RELÓGIO AQUI
                System.out.println(time);
            } else if (cmd.equals("init")) {
                // INICIE O RELÓGIO AQUI utilizando o construtor
                int hour = Integer.parseInt(par[1]);
                int minute = Integer.parseInt(par[2]);
                int second = Integer.parseInt(par[3]);
                 time = new Time(hour, minute, second);
            } else if (cmd.equals("set")) {
                // CHAME OS MÉTODOS SET AQUI
                 int hour = Integer.parseInt(par[1]);
                 int minute = Integer.parseInt(par[2]);
                 int second = Integer.parseInt(par[3]);
                 time.setHour(hour);
                 time.setMinute(minute);
                 time.setSecond(second);

            } else if (cmd.equals("next")) {
                // CHAME O MÉTODO nextSecond AQUI
                time.nextsecond();
            } else {
                System.out.println("fail: comando invalido");
            }
        }
    }

    private static Scanner scanner = new Scanner(System.in);
}
