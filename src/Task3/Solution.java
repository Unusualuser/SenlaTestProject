package Task3;

/*
    Создайте программу, которая будет:
     -подсчитывать количество гласных в словах
     -выводить слова отсортированным списком по количеству
      гласных (сначала те, у которых больше гласных)
     -делать первую гласную букву в слове заглавной

    Предложение вводится пользователем вручную русскими буквами.
    Разделитель пробел (“ ”).
*/

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    private static final String VOWELS_PATTERN = "[аеёиоуыэюяАЕЁИОУЫЭЮЯ]";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sentence = scanner.nextLine();

        ArrayList<String> words = new ArrayList<>(Arrays.asList(sentence.split(" ")));

        words.sort(((o1, o2) -> countVowels(o2) - countVowels(o1)));

        for (int i = 0; i < words.size(); i++) {
            words.set(i, upFirstVowel(words.get(i)));
        }

        System.out.print(words.get(0));
        for (int i = 1; i < words.size(); i++) {
            System.out.printf(" %s", words.get(i));
        }
    }

    public static int countVowels(String str) {
        int counter = 0;

        Pattern pattern = Pattern.compile(VOWELS_PATTERN);
        Matcher matcher = pattern.matcher(str);

        while (matcher.find())
            counter++;

        return counter;
    }

    public static String upFirstVowel(String str) {
        for (int i = 0; i < str.length(); i++) {
            String currLetter = Character.toString(str.charAt(i));

            if (VOWELS_PATTERN.contains(currLetter))
                return str.replaceFirst(currLetter, currLetter.toUpperCase());
        }

        return str;
    }
}
