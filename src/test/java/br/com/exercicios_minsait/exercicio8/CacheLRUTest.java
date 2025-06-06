package br.com.exercicios_minsait.exercicio8;

import br.com.exercicios_minsait.exercicio1.CacheLRU;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class CacheLRUTest {

    @Test
    public void testPutAndGet() {
        CacheLRU<Integer, String> cache = new CacheLRU<>(3);
        cache.put(1, "um");
        cache.put(2, "dois");
        cache.put(3, "três");

        Assertions.assertEquals("um", cache.get(1));
        Assertions.assertEquals("dois", cache.get(2));
        Assertions.assertEquals("três", cache.get(3));

        System.out.println("\nTeste: testPutAndGet");
        System.out.println(cache);
        System.out.println("Fim do teste");
    }

    /**
     * Teste para verificar o comportamento dos elementos incluídos na cache, verificando a ordem (quando acessados novamente) e a inclusão posterior
     */
    @Test
    public void testEvictionLeastRecentlyUsed() {
        CacheLRU<Integer, String> cache = new CacheLRU<>(3);
        cache.put(1, "um");
        cache.put(2, "dois");
        cache.put(3, "três");

        System.out.println("\nTeste: testEvictionLeastRecentlyUsed");
        System.out.println(cache);

        // Acessa 1 e 2 para torná-los mais recentes
        cache.get(1);
        cache.get(2);

        System.out.println("\nApos tornar 1 e 2 mais recentes: ");
        System.out.println(cache);

        // Adiciona um novo, deve remover o 3 (menos usado)
        cache.put(4, "quatro");

        System.out.println("\nApos incluir um novo elemento: ");
        System.out.println(cache);

        Assertions.assertNotNull(cache.get(1));
        Assertions.assertNotNull(cache.get(2));
        Assertions.assertNotNull(cache.get(4));
        Assertions.assertNull(cache.get(3)); // foi removido

        System.out.println("Fim do teste");
    }

    @Test
    public void testRemove() {
        CacheLRU<Integer, String> cache = new CacheLRU<>(2);
        cache.put(1, "um");
        cache.put(2, "dois");

        System.out.println("\nTeste: testRemove");
        System.out.println(cache);

        cache.remove(1);
        System.out.println("\nApos remover o elemento 1: ");
        System.out.println(cache);

        Assertions.assertNull(cache.get(1));
        Assertions.assertEquals("dois", cache.get(2));

        System.out.println("Fim do teste");
    }

    @Test
    public void testSize() {
        CacheLRU<Integer, String> cache = new CacheLRU<>(2);
        cache.put(1, "um");
        cache.put(2, "dois");
        Assertions.assertEquals(2, cache.size());

        System.out.println("\nTeste: testSize");
        System.out.println("Tamanho Inicial: " + cache.size());
        System.out.println(cache);

        cache.put(3, "três");
        Assertions.assertEquals(2, cache.size()); // ainda deve ser 2

        System.out.println("\nInclusão de um novo elemento: ");
        System.out.println(cache);
        System.out.println("Fim do teste");
    }
}
