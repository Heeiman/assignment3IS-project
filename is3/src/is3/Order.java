package is3;

import java.util.HashMap;

public class Order {
	private String orderId;
	private String delDate;
	private Customer customer;
	private HashMap<String, OrderRow> ordRowList = new HashMap<String, OrderRow>();

	public Order(String orderId, String delDate) {
		this.setOrderId(orderId);
		this.setDelDate(delDate);
		this.setOrdRowList(new HashMap<String, OrderRow>());
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderId() {
		return this.orderId;
	}

	public void setDelDate(String delDate) {
		this.delDate = delDate;
	}

	public String getDelDate() {
		return delDate;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setOrdRowList(HashMap<String, OrderRow> ordRowList) {
		this.ordRowList = ordRowList;
	}

	public HashMap<String, OrderRow> getOrdRowList() {
		return this.ordRowList;
	}

	public void addOrderRow(OrderRow aRow) {
		this.ordRowList.put(aRow.getNumber(), aRow);
	}
	
	public OrderRow findOrderRow(String number) {
		for (OrderRow aRow : this.ordRowList.values()) {
			if (aRow.getNumber().equals(number)) {
				return aRow;
			}
		}
		return null;
	}

	public void removeOrderRow(String number) {
		ordRowList.remove(number);
	}
	public void printOrderRows () {
		ordRowList.forEach((key, value) -> System.out.println(key + ":" + value.getAmount()));
}
	public void getOrderValue () {
		ordRowList.forEach((key, value) -> value.getAmount().toString());
}
}
