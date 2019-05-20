/*
 * @author Daric Zhou, Jakin Chan, Jon Lee
 * @version May 2019
 * This superclass stores an order of a drink or food
 */
public class T4Order {
	private String customerName;
	private String order;
	protected double orderPrice;
	
	public T4Order(String o, double price) {
		order = o;
		setOrderPrice(price);
	}
	
	public String getCustomerName() {
		return customerName;
	}
	public String getOrderName() {
		return order;
	}
	public double getPrice() {
		return orderPrice * 1.0875;
	}

	public void setOrderPrice(double orderPrice) {
		this.orderPrice = orderPrice;
	}
}
