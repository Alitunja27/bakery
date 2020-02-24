package bakery.domain;

public class CustomerOrder {
	
	private String productCode;
	private Integer productQuantity;

	public CustomerOrder(String productCode, Integer productQuantity) {
		this.productCode = productCode;
		this.productQuantity = productQuantity;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public Integer getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}
}
