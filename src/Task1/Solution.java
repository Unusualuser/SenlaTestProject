package Task1;

/*
    Напишите программу, которая возвращает сумму цифр, присутствующих в данной строке.
    Если цифр нет, то возвращаемая сумма должна быть равна 0
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(sum("SENLA123456789"));
        System.out.println(sum("SENLA"));
    }

    public static int sum(String str) {
        int sum = 0;

        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);

            if (Character.isDigit(currentChar))
                sum += Character.getNumericValue(currentChar);
        }

        return sum;
    }
}
