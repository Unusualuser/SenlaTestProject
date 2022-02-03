package Task5;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
    Есть набор предметов, задаваемый заранее, предметы могут
    повторяться. Предмет имеет 2 параметра (обязательных, остальные
    добавлять на усмотрение): объем (целое значение) и ценность (целое
    значение). Предметы неделимы. Также задаётся сейф с
    обязательным параметром его объёма (целое значение).
    Нужно написать программу, которая наполняет сейф набором
    предметов таким образом, чтобы ценность этого набора была
    максимальной.
*/
public class Solution {
    public static void main(String[] args) {
        ArrayList<Item> items = new ArrayList<>();

        items.add(new Item("Item1",3, 5));
        items.add(new Item("Item2",10, 10));
        items.add(new Item("Item3",7, 8));
        items.add(new Item("Item4",5, 4));
        items.add(new Item("Item5",3, 2));


        Safe safe = new Safe(20);

        fillSafe(items, safe);

        safe.getItems().forEach(System.out::println);
    }

    public static void fillSafe(List<Item> items, Safe safe) {
        List<Item> suitableItems = excludeUnsuitableItems(items, safe.getTotalVolume());

        int itemsSize = suitableItems.size();
        int safeVolume = safe.getTotalVolume();

        Safe [][] safeMatrix = new Safe[itemsSize + 1][safeVolume + 1];

        for (int i = 0; i < itemsSize + 1; i++) {
            for (int j = 0; j < safeVolume + 1; j++) {
                safeMatrix[i][j] = new Safe(safeVolume);
            }
        }

        for (int i = 1; i < itemsSize + 1; i++) {
            for (int j = 1; j < safeVolume + 1; j++) {
                if (i == 1) {
                    if (suitableItems.get(0).getVolume() <= j) {
                        safeMatrix[i][j].addItem(suitableItems.get(0));
                    }
                }
                else {
                    if (suitableItems.get(i-1).getVolume() <= j) {
                        int currMaxValue = suitableItems.get(i-1).getValue() + safeMatrix[i-1][j - suitableItems.get(i-1).getVolume()].calcItemsValue();

                        if (safeMatrix[i-1][j].calcItemsValue() > currMaxValue)
                            safeMatrix[i][j] = safeMatrix[i-1][j];
                        else {
                            safeMatrix[i][j].addItem(suitableItems.get(i-1));
                            safeMatrix[i][j].addItems(safeMatrix[i-1][j - suitableItems.get(i-1).getVolume()].getItems());
                        }
                    }
                    else
                        safeMatrix[i][j] = safeMatrix[i-1][j];
                }
            }
        }

        safe.addItems(findBestSafe(safeMatrix).getItems());
    }

    public static List<Item> excludeUnsuitableItems(List<Item> items, int safeTotalVolume) {
        List<Item> suitableItems = new ArrayList<>(items);
        suitableItems = suitableItems.stream().filter(item -> item.getVolume() <= safeTotalVolume).collect(Collectors.toList());
        return suitableItems;
    }

    public static Safe findBestSafe(Safe [][] safeMatrix) {
        int indexMax = 0;
        for (int i = 0; i < safeMatrix.length; i++) {
            if (safeMatrix[i][safeMatrix[0].length-1].calcItemsValue() > safeMatrix[indexMax][safeMatrix[0].length-1].calcItemsValue())
                indexMax = i;
        }
        return safeMatrix[indexMax][safeMatrix[0].length-1];
    }
}
