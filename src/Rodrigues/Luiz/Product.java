package Rodrigues.Luiz;

public class Product {

    private Integer id;
    private final String name;
    private final String unit;
    private final Double quantity;
    private final Double moneyspent;

    public Product(String name, String unit, Double quantity, Double moneyspent) {
        this.name = name;
        this.unit = unit;
        this.quantity = quantity;
        this.moneyspent = moneyspent;
    }

    public Product(Integer id, String name, String unit, Double quantity, Double moneyspent) {
        this.id = id;
        this.name = name;
        this.unit = unit;
        this.quantity = quantity;
        this.moneyspent = moneyspent;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }

    public Double getQuantity() {
        return quantity;
    }

    public Double getMoneyspent() {
        return moneyspent;
    }

    @Override
    public String toString() {
        return String.format(" %d | %s | %s | %.2f | %.2f ", this.id, this.name, this.unit, this.quantity, this.moneyspent);
    }
}
