package bakery.domain;

public class ProductDetail {

    private String productName, productCode;
    private Integer productPack;
    private Double productPrice;

    public ProductDetail(String productName, String productCode, Integer productPack, Double productPrice) {
        this.productName = productName;
        this.productCode = productCode;
        this.productPack = productPack;
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public Integer getProductPack() {
        return productPack;
    }

    public void setProductPack(Integer productPack) {
        this.productPack = productPack;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }
}
