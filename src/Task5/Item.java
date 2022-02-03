package Task5;

public class Item {
    private final String name;
    private final int value;
    private final int volume;

    public Item(String name, int value, int volume) {
        this.name = name;
        this.value = value;
        this.volume = volume;
    }

    public int getValue() {
        return value;
    }

    public int getVolume() {
        return volume;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name=" + name +
                ", value=" + value +
                ", volume=" + volume +
                '}';
    }
}
