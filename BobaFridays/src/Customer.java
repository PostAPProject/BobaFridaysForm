//This class contains methods which allow a customer to make and store multiple orders
//@author Daric Zhou, Jakin Chan, Jon Lee
//@version May 19, 2019
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
		double totalPrice = 0.0;
		
		for(T4Order t: customerOrders) {
			totalPrice += t.getPrice();
		}
		for (T4Order t: customerOrders) {
			answer+=t.getOrderName()+": $"+t.getPrice()+"\n";
		}
		answer += "Total price: $" + totalPrice;
		return answer;
	}
	
}
