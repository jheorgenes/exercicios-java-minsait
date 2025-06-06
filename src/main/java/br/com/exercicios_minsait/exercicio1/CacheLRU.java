package br.com.exercicios_minsait.exercicio1;

import java.util.LinkedHashMap;
import java.util.Map;

public class CacheLRU<K, V> {

    private final int capacidadeMaxima;
    private final LinkedHashMap<K, V> cache;

    public CacheLRU(int capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
        this.cache = new LinkedHashMap<K, V>(capacidadeMaxima, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > CacheLRU.this.capacidadeMaxima;
            }
        };
    }

    public void put(K key, V value) {
        cache.put(key, value);
    }

    public V get(K key) {
        return cache.getOrDefault(key, null);
    }

    public void remove(K key) {
        cache.remove(key);
    }

    public int size() {
        return cache.size();
    }

    @Override
    public String toString() {
        return cache.toString();
    }
}
