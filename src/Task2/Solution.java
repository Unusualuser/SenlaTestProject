package Task2;

/*
    Создайте программу, которая будет вычислять и выводить на экран простые множители,
    из которых состоит целое число, введенное пользователем.
    Если введенное число не целое, то нужно сообщать пользователю об ошибке.
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try {
            int userNumber = readIntFromConsole();

            if (userNumber > 1) {
                List<Integer> primeFactors = getPrimeFactors(userNumber);

                System.out.print(primeFactors.get(0));
                for (int i = 1; i < primeFactors.size(); i++) {
                    System.out.printf(" %d", primeFactors.get(i));
                }
            }
            else
                System.out.println("Данное число не подходит для разложения");
        }
        catch (NumberFormatException e) {
            System.out.println("Ошибка, вы ввели не целое число");
        }
    }

    public static int readIntFromConsole() throws NumberFormatException {
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextInt())
            return scanner.nextInt();
        else
            throw new NumberFormatException();
    }

    public static List<Integer> getPrimeFactors(int number) {
        ArrayList<Integer> primeFactors = new ArrayList<>();
        int multiplier = 2;

        while (number != 1) {
            if (number % multiplier == 0) {
                primeFactors.add(multiplier);
                number /= multiplier;
            } else if (multiplier == 2) {
                multiplier++;
            } else {
                multiplier += 2;
            }
        }

        return primeFactors;
    }

}
