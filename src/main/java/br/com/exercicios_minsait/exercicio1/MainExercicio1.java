package br.com.exercicios_minsait.exercicio1;

public class MainExercicio1 {
    public static void main(String[] args) {
        CacheLRU<Integer, String> cache = new CacheLRU<>(3);

        cache.put(1, "A");
        cache.put(2, "B");
        cache.put(3, "C");

        System.out.println(cache);

        cache.get(1);
        cache.put(4, "D");
        System.out.println(cache);

        cache.remove(1);
        System.out.println(cache);

        System.out.println("Tamanho: " + cache.size());
    }
}
