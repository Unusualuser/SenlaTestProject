package Task5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Safe {
    private final int totalVolume;
    private final ArrayList<Item> items;

    public Safe(int totalVolume) {
        this.totalVolume = totalVolume;
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void addItems(List<Item> items) {
        this.items.addAll(items);
    }

    public List<Item> getItems() {
        return Collections.unmodifiableList(items);
    }

    public int calcItemsValue() {
        int value = 0;

        for (Item item : this.items) {
            value += item.getValue();
        }

        return value;
    }

    public int getTotalVolume() {
        return totalVolume;
    }

    @Override
    public String toString() {
        return "Safe{" +
                "totalVolume=" + totalVolume +
                ", items=" + items +
                '}';
    }
}
