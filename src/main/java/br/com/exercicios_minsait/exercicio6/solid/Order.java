package br.com.exercicios_minsait.exercicio6.solid;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {
    private final List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    // Não permitir alteração da lista
    public List<Item> getItems() {
        return Collections.unmodifiableList(items);
    }
}
