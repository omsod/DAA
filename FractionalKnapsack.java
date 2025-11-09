import java.util.*;

class Item {
    int weight, value;
    Item(int v, int w) {
        value = v; 
        weight = w; 
    }
}

public class FractionalKnapsack {
    static double getMaxValue(Item[] items, int capacity) {
        Arrays.sort(items, (a, b) -> Double.compare((double)b.value / b.weight, (double)a.value / a.weight));
        double totalValue = 0.0;
        for (Item i : items) {
            if (capacity >= i.weight) {
                capacity -= i.weight;
                totalValue += i.value;
            } else {
                totalValue += i.value * ((double) capacity / i.weight);
                break;
            }
        }
        return totalValue;
    }

    public static void main(String[] args) {
        Item[] items = { new Item(60, 10), new Item(100, 20), new Item(120, 30) };
        int capacity = 50;
        System.out.println("Maximum value in Knapsack = " + getMaxValue(items, capacity));
    }
}
