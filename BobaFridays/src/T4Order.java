
public class T4Order {
	private String customerName;
	private String order;
	private double orderPrice;

	public T4Order(String name, String o, double price) {
		customerName = name;
		order = o;
		orderPrice = price;
	}
	
	public T4Order(String o, double price) {
		order = o;
		orderPrice = price;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	public String toString() {
		return customerName + ": " + order + "\n Total cost: " + orderPrice;
	}
	public String getOrderName() {
		return order;
	}
	public double getPrice() {
		return orderPrice * 1.0875;
	}
}

