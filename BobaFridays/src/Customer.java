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
	
	public void removeOrder(T4Order t) {
		customerOrders.remove(t);
	}
	
	public void removeOrder(int i) {
		customerOrders.remove(i);
	}
	
	public String getName() {
		return name;
	}
	
	public T4Order getOrder(int index) {
		return customerOrders.get(index);
	}
	
	public ArrayList<T4Order> getAllOrders() {
		return customerOrders;
	}
	
	public String getReceipt() {
		String answer = name+": \n";
		for (T4Order t: customerOrders) {
			answer+=t.getOrderName()+"\t"+t.getPrice()+"\n";
		}
		return answer;
	}
}
