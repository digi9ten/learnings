import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache {

    private final int capacity;

    private final LinkedList<String> listOfValues;

    private final HashMap<String, String> map;

    private LRUCache(int capacity) {
        if (0 >= capacity || Integer.MAX_VALUE <= capacity) {
            throw new IllegalArgumentException("Bad Capacity given");
        }
        this.capacity = capacity;

        listOfValues = new LinkedList<>();

        map = new HashMap<>();
    }

    private String get(String key) {
        String currentValue = map.get(key);
        if (null != currentValue) {
            listOfValues.remove(currentValue);
            listOfValues.push(currentValue);
        }
        return currentValue;
    }

    private String[] getAll() {
        return listOfValues.toArray(new String[0]);
    }

    private void set(String key, String incoming) {
        if (map.containsKey(key)) {
            listOfValues.remove(map.get(key));
        }

        map.put(key, incoming);
        listOfValues.push(incoming);

        if (capacity < listOfValues.size()) {
            map.remove(listOfValues.removeLast());
        }
    }

    private static LRUCache prepCache(LRUCache cache) {
        cache.set("1", "red");
        cache.set("2", "green");
        cache.set("3", "blue");
        cache.set("4", "brown");
        cache.set("5", "orange");
        cache.set("6", "turquoise");
        return cache;
    }

    public static void main(String[] args) {
        LRUCache cache = prepCache(new LRUCache(5));
        Util.printThese("Current LRU Cache elements (Should be turquoise, orange, brown, blue, green)", cache.getAll());

        cache = prepCache(new LRUCache(5));
        cache.get("3");
        Util.printThese("Current LRU Cache elements (Should be blue, turquoise, orange, brown, green)", cache.getAll());

        cache = prepCache(new LRUCache(5));
        cache.get("3");
        cache.get("2");
        cache.get("2");
        Util.printThese("Current LRU Cache elements (Should be green, blue, turquoise, orange, brown)", cache.getAll());

        cache = prepCache(new LRUCache(5));
        cache.set("5", "magenta");
        Util.printThese("Current LRU Cache elements (Should be magenta, turquoise, brown, blue, green)", cache.getAll());
    }
}
