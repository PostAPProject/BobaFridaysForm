package teaFiveThree;
import java.util.*;
public class OrderForm {

	Private ArrayList<T4Order> allOrders = new ArrayList<T4Order>();
	Private ArrayList<Customer> allCustomers = new ArrayList<Customer>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Name: ");
		String name= sc.nextLine();
		while (!name.equals("quit")) {		
			Customer c = new Customer(name);
			c.processCommand();
			System.out.println("(print \"quit\" if you want to exit the program)+\n+Name: ");
		}

	}

	public void orderDrink(String name, String order){

	}
	//order the drink and add it to the customer’s order list

	public static void processCommand() {
		boolean keepGoing = true;
		while (keepGoing) {
			System.out.println("What do you want to order? (Add condiments here as well, ie boba, grass jelly, etc) ");
			String order = sc.next();
			T4 order = new orderDrink(name, order);
			c.add(order)
			System.out.println("Print \"done\" if you want to exit, or your next order if you want to keep going");
		}
		System.out.println("Next Customer!");
	}
	
}




