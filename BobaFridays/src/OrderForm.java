
import java.util.*;
public class OrderForm {

	private ArrayList<T4Order> allOrders = new ArrayList<T4Order>();
	private ArrayList<Customer> allCustomers = new ArrayList<Customer>();

	public void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Name: ");
		String name= sc.nextLine();
		while (!name.equals("quit")) {		
			processCustomer(new Customer(name));
			System.out.println("(print \"quit\" if you want to exit the program)+\n+Name: ");
		}
		sc.close();
	}

	public void processCustomer(Customer c) {
		allCustomers.add(c);
		Scanner sc = new Scanner(System.in);
		System.out.println("What do you want to order? (Add condiments here as well, ie boba, grass jelly, etc) ");
		String order = sc.nextLine();
		while (!order.equals("quit")) {
			c.addOrder(orderDrink(order));
			System.out.println("Print \"done\" if you want to exit, or your next order if you want to keep going");
			order = sc.next();
		}
		sc.close();
		System.out.println("Next Customer!");
	}
	
	//orders the drink and add it to the customer’s order list
	public T4Order orderDrink(String order) {
		T4Order orderObject = new T4Order(order);
		allOrders.add(orderObject);
		return orderObject;
	}
}




