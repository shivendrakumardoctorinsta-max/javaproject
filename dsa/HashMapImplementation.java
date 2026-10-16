package dsa;
import java.util.ArrayList;
import java.util.LinkedList;

public class HashMapImplementation {

    static class HashMap<K, V> {

        // ✅ Static Node to avoid reference to outer class
        private static class Node<K, V> {
            K key;
            V value;

            Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n; // number of key-value pairs
        private int N; // number of buckets
        private LinkedList<Node<K, V>>[] buckets;

        @SuppressWarnings("unchecked")
        public HashMap() {
            this.N = 4;
            this.buckets = new LinkedList[N];
            for (int i = 0; i < N; i++) {
                buckets[i] = new LinkedList<>();
            }
        }

        // ✅ Improved hash function (better distribution)
        private int hashFunction(K key) {
            int h = key.hashCode();
            return Math.abs(h ^ (h >>> 16)) % N;
        }

        // ✅ Use equals(), not ==
        private int searchInLL(K key, int bi) {
            LinkedList<Node<K, V>> ll = buckets[bi];
            int index = 0;

            for (Node<K, V> node : ll) {
                if (node.key.equals(key)) {
                    return index;
                }
                index++;
            }
            return -1;
        }

        // ✅ Correct rehash implementation
        @SuppressWarnings("unchecked")
        private void rehash() {
            LinkedList<Node<K, V>>[] oldBuckets = buckets;

            N = N * 2;                 // update bucket size
            buckets = new LinkedList[N];
            for (int i = 0; i < N; i++) {
                buckets[i] = new LinkedList<>();
            }

            n = 0; // reset count before reinserting

            for (LinkedList<Node<K, V>> ll : oldBuckets) {
                for (Node<K, V> node : ll) {
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V value) {
            if (key == null) {
                throw new IllegalArgumentException("Null keys not allowed");
            }

            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di == -1) {
                buckets[bi].add(new Node<>(key, value));
                n++;
            } else {
                buckets[bi].get(di).value = value;
            }

            double lambda = (double) n / N;
            if (lambda > 0.75) { // standard load factor
                rehash();
            }
        }

        public V get(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di == -1) {
                return null;
            }
            return buckets[bi].get(di).value;
        }

        public V remove(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di == -1) {
                return null;
            }

            Node<K, V> node = buckets[bi].remove(di);
            n--;
            return node.value;
        }

        public boolean containsKey(K key) {
            int bi = hashFunction(key);
            return searchInLL(key, bi) != -1;
        }

        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();

            for (LinkedList<Node<K, V>> ll : buckets) {
                for (Node<K, V> node : ll) {
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public int size() {
            return n;
        }

        public boolean isEmpty() {
            return n == 0;
        }

        public void clear() {
            for (LinkedList<Node<K, V>> ll : buckets) {
                ll.clear();
            }
            n = 0;
        }
    }

    // ✅ Testing
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        map.put("India", 190);
        map.put("China", 200);
        map.put("USA", 150);

        for (String key : map.keySet()) {
            System.out.println(key + " -> " + map.get(key));
        }

        System.out.println("Size: " + map.size());
    }
}
