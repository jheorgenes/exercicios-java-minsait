package br.com.exercicios_minsait.exercicio6.codigolegado;

public class ItemLegado {
    private final String name;
    private final double price;

    public ItemLegado(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
