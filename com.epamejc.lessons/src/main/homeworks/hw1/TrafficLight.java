package main.homeworks.hw1;

import static main.homeworks.hw1.enums.Messages.*;

class TrafficLight {

    private static Double getNumberFromInput(String line) {

        Double d = null;

        try {
            if (Double.parseDouble(line) > 0) {
                return Double.parseDouble(line);
            } else {
                System.out.println(ENTER_NUMBER_COMMAND.toString());
            }
        } catch (NumberFormatException e) {
            System.out.println(ENTER_NUMBER_COMMAND.toString());
        }
        return d;
    }

    static void getColor(String line) {

        Double minutes = getNumberFromInput(line);

        if (minutes != null) {
            double div = minutes % 10;

            if (div >= 0 && div < 3) {
                System.out.println(GREEN_LIGHT_MESSAGE.toString());
            } else if (div >= 3 && div < 5) {
                System.out.println(YELLOW_LIGHT_MESSAGE.toString());
            } else {
                System.out.println(RED_LIGHT_MESSAGE.toString());
            }
        }
    }

}
