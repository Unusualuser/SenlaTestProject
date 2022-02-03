package Task4;

/*
    Создайте программу, которая будет получать число и печатать
    его в следующем формате (формы цифр можно придумать свои,
    главное, чтобы они читались на экране).
    (*) Дополнительно: сделайте так, чтобы наибольшая цифра состояла
    не из ‘*’, а из соответствующих маленьких (обычных) цифр.
*/

public class Solution {

    public static void main(String[] args) {
        printNumber(1234567890);
    }

    public static void printNumber(int number) {
        String stringNumber = Integer.toString(number);
        char max = getMax(stringNumber);

        for (int i = 0; i < FormatNumber.ZERO.length; i++) {
            for (int j = 0; j < stringNumber.length(); j++) {
                String toPrint = "";
                char currChar = stringNumber.charAt(j);

                switch (currChar) {
                    case '0':
                        toPrint = FormatNumber.ZERO[i];
                        break;
                    case '1':
                        toPrint = FormatNumber.ONE[i];
                        break;
                    case '2':
                        toPrint = FormatNumber.TWO[i];
                        break;
                    case '3':
                        toPrint = FormatNumber.THREE[i];
                        break;
                    case '4':
                        toPrint = FormatNumber.FOUR[i];
                        break;
                    case '5':
                        toPrint = FormatNumber.FIVE[i];
                        break;
                    case '6':
                        toPrint = FormatNumber.SIX[i];
                        break;
                    case '7':
                        toPrint = FormatNumber.SEVEN[i];
                        break;
                    case '8':
                        toPrint = FormatNumber.EIGHT[i];
                        break;
                    case '9':
                        toPrint = FormatNumber.NINE[i];
                }

                if (currChar == max)
                    toPrint = toPrint.replaceAll("\\$", Character.toString(currChar));

                System.out.print(toPrint);
            }
            System.out.println();
        }
    }

    public static char getMax(String stringNumber) {
        char max = '0';

        for (int i = 0; i < stringNumber.length(); i++) {
            char currChar = stringNumber.charAt(i);

            if (currChar > max)
                max = currChar;
        }

        return max;
    }
}
