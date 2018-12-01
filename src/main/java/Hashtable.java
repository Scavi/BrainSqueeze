public class Hashtable<K, V> {
    private final int capacity;
    private MapItem<K, V>[] table;
    private int count;

    public Hashtable(final int capacity) {
        this.capacity = capacity;
        this.table = new MapItem[capacity];
    }


    public boolean insert(final K key, final V value) {
        if (count >= capacity) {
            return false;
        } else if (key == null) {
            return false;
        }
        int pos = posOf(key);
        insert(pos, new MapItem<>(key, value));
        return true;
    }

    private void insert(final int pos, final MapItem<K, V> newItem) {
        if (table[pos] == null) {
            table[pos] = newItem;
        } else {
            MapItem<K, V> current = table[pos];
            while (current.next != null) {
                current = current.next;
            }
            current.next = newItem;
        }
        count++;
    }

    public boolean exists(final K key) {
        if (key == null) {
            return false;
        }
        int pos = posOf(key);
        boolean isExisting = false;
        if (table[pos] != null) {
            MapItem<K, V> current = table[pos];
            while (!isExisting && current != null) {
                isExisting = current.key.equals(key);
                current = current.next;
            }
        }
        return isExisting;
    }

    private int posOf(final K key) {
        // TODO um schlechten hashCode implementierungen vorzubeugen kann man ggf. den hashcode noch verändern
        // (shift, xor etc.) - führt hier aber vermutlich zu weeit

        int hash = key.hashCode();
        hash = hash < 0 ? hash >>> 16 : hash;
        return hash % this.capacity;
    }


    private class MapItem<K, V> {
        private final K key;
        private final V value;
        // TODO aktuell ist die Aufgabe nur eine hash map ohne resize durchzuführen.
        // Falls ihr ein resize braucht (sprich das table[] array verrößert werden muss was normalerweise bei 3/4 der
        // kapazität gemacht wird, dann ist es hilfreich sich den hashcode zu merken)
        private final int hashCode = 0;
        private MapItem<K, V> next;

        MapItem(final K key, final V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public MapItem<K, V> getNext() {
            return next;
        }
    }
}
