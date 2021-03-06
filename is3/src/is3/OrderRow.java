package is3;

public class OrderRow {
	private String number;
	private String amount;

	private Order order;
	private Product product;

	public OrderRow(String number, String amount) {
		this.setNumber(number);
		this.setAmount(amount);
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getNumber() {
		return this.number;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getAmount() {
		return this.amount;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Product getProduct() {
		return this.product;
	}

	public void removeProduct() {
		this.product = null;
	}
}
