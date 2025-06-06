package br.com.exercicios_minsait.exercicio6.solid;

public class DiscountOrderTotalCalculator implements OrderTotalCalculator {
    private final double discountRate;

    public DiscountOrderTotalCalculator(double discountRate) {
        this.discountRate = discountRate;
    }

    @Override
    public double calculate(Order order) {
        double total = order.getItems().stream()
                .mapToDouble(Item::getPrice)
                .sum();
        return total * (1 - discountRate);
    }
}
