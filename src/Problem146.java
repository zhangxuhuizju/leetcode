import java.util.*;

public class Problem146 {
    class LRUCache extends LinkedHashMap<Integer, Integer>{
        int max;

        public LRUCache(int capacity) {
            super(capacity, 0.75f, true);
            this.max = capacity;
        }

        public int get(int key) {
           return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
           super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return this.size() > max;
        }
    }
}
