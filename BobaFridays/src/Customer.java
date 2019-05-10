import java.util.ArrayList;

public class Customer {
	private String name = "";
	private ArrayList<T4Order> customerOrders = new ArrayList<T4Order>();
	
	public Customer(String name) {
		this.name = name;
	}
	
	public void addOrder(T4Order order) {
		customerOrders.add(order);
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<T4Order> getOrders() {
		return customerOrders;
	}
}
