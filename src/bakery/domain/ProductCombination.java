package bakery.domain;

public class ProductCombination {

    private Integer productPackage, quantity;
    private Double orderTotalPrice;

    public ProductCombination(Integer productPackage, Integer quantity, Double orderTotalPrice) {
        this.productPackage = productPackage;
        this.quantity = quantity;
        this.orderTotalPrice = orderTotalPrice;
    }

    public Integer getProductPackage() {
        return productPackage;
    }

    public void setProductPackage(Integer productPackage) {
        this.productPackage = productPackage;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getOrderTotalPrice() {
        return orderTotalPrice;
    }

    public void setOrderTotalPrice(Double orderTotalPrice) {
        this.orderTotalPrice = orderTotalPrice;
    }
}
