package br.com.exercicios_minsait.exercicio6.codigolegado;

import java.util.ArrayList;
import java.util.List;

public class OrderLegado {
    private List<ItemLegado> items;

    public OrderLegado() {
        items = new ArrayList<>();
    }

    public void addItem(ItemLegado item) {
        items.add(item);
    }

    public double calculateTotal() {
        double total = 0;
        for (ItemLegado item : items) {
            total += item.getPrice();
        }
        return total;
    }
}
