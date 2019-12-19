package main.homeworks.homework1;
import java.io.*;

//Создать "светофор", который выводит сигнал-цвет. Вы вводите время от 0-3 минуты - зеленый,
//4-5 минуты - желтый, 6-10 красный. Вводим цифру 0 до n, получаем результат. Работу программы
//сделать непрерывной, выход можно обработать.

public class Traffic_Lights {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        do {
            System.out.println("Type a number from 0 to n");
            String inp = reader.readLine();
            if (inp.equals("exit")) break;
            else {
                double num = -1;
                try {
                    num = Math.floor(Double.parseDouble(inp));
                } catch (NumberFormatException e)
                {
                    System.out.println("use numbers, or word exit.");
                }
                if (num >= 0 && num <= 3) System.out.println("green");
                else if (num >= 4 && num <= 5) System.out.println("yellow");
                else if (num >= 6 && num <= 10) System.out.println("red");
                else System.out.println("wrong input");
            }
        } while (true);
    }
}

