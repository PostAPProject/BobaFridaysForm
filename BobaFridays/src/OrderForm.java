import java.util.*;
public class OrderForm {
	
	//builds a list of all orders and customers, in order to print receipt
	private ArrayList<T4Order> allOrders = new ArrayList<T4Order>();
	private ArrayList<Customer> allCustomers = new ArrayList<Customer>();
	private MenuItems T4Menu = new MenuItems();
	
	//accepts a name and assigns it to a new customer
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

	//accepts orders to add to the customer's receipt
	public void processCustomer(Customer c) {
		allCustomers.add(c);
		Scanner sc = new Scanner(System.in);
		System.out.println("What do you want to order? (Add condiments here as well, ie boba, grass jelly, etc) ");
		String order = sc.nextLine();
		while (!order.equals("quit")) {
			c.addOrder(orderItem(order));
			System.out.println("Print \"done\" if you want to exit, or your next order if you want to keep going");
			order = sc.next();
		}
		sc.close();
		System.out.println("Next Customer!");
	}
	
	//converts the order name into an order object and adds it to the customerís order list
	public T4Order orderItem(String order) {
		T4Order orderObject = new T4Order(order, T4Menu.getPrice(order));
		allOrders.add(orderObject);
		return orderObject;
	}
	
	//prints a list of all the orders, not divided by customer
	public String printAllOrders() {
		String answer= "";
		for (int i=0; i<allOrders.size(); i++) {
			answer+=(allOrders.get(i).getOrderName()+"\t"+allOrders.get(i).getPrice()+"\n");
		}
		return answer;
	}
	
	//prints big receipt separated by each customer
	public String printReceipt() {
		String answer= "";
		for (Customer c: allCustomers) {
			answer+=(c.getReceipt()+"\n"+"_____________\n");
		}
		return answer;
	}
}




