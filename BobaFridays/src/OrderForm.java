import java.util.*;
public class OrderForm {
	
	//builds a list of all orders and all customers
	private ArrayList<T4Order> allOrders = new ArrayList<T4Order>();
	private ArrayList<Customer> allCustomers = new ArrayList<Customer>();
	private Menu menu;
	
	//@param: the menu to order from
	//constructs an order form
	public OrderForm(Menu m) {
		menu = m;
	}
	
	public void takeOrders() {
		Scanner console = new Scanner(System.in);
		System.out.println("Name: ");
		String name = console.nextLine().trim();
		while (!name.equals("quit")) {		
			processCustomer(new Customer(name));
			System.out.println("(print \"quit\" if you want to exit the program)+\n+Name: ");
			name = console.nextLine().trim();
		}
		console.close();
	}

	//accepts orders to add to the customer's receipt
	public void processCustomer(Customer c) {
		allCustomers.add(c);
		Scanner sc = new Scanner(System.in);
		boolean done = false;
		while (done==false) {
			System.out.println("Would you like food or drink? Type \"menu\" to see the menu, or \"remove\" to delete a previous order. ");
			String type = sc.nextLine().trim();
			if (type.toLowerCase().contains("remove")) { //remove a previous order
				System.out.println("For which customer would you like to remove an order? Enter their name here: ");
				String name = sc.nextLine().trim();
				for (int i = 0; i< allCustomers.size(); i++) {
					if (name.equalsIgnoreCase(allCustomers.get(i).getName())) { //check if that customer exists
						System.out.println("Enter the number of the order you would like to remove");
						allCustomers.get(i).removeOrder(sc.nextInt());
						i=allCustomers.size(); //exit the loop
					}
				}
			}
			//if customer needs to see a menu
			else if (type.toLowerCase().contains("menu")) {
				menu.printMenu("notTypo", type);
				System.out.println("Would you like food or drink?");
				type = sc.nextLine().trim();
			}
			if (type.equalsIgnoreCase("drink")) {
				System.out.println("What would you like to order?");
				c.addOrder(orderItem(sc.nextLine().trim(), true));
			}
			if (type.equalsIgnoreCase("food")) {
				System.out.println("What would you like to order?");
				c.addOrder(orderItem(sc.nextLine().trim(), false));
			}
			else {
				System.out.println("The type of order you requested does not exist");
			}
			System.out.println("Print \"done\" if you are finished ordering, or anything else to order more items");
			if (sc.nextLine().trim().equalsIgnoreCase("done")) {
				done = true;
			}
		}
		sc.close();
		System.out.println("Next Customer!");
	}
	
	//converts the order name into an order object and adds it to the customer's order list
	public T4Order orderItem(String order, boolean isDrink) {
		T4Order orderObject;
		Scanner s = new Scanner(System.in);
		if (isDrink) {
			ArrayList<String> toppings = new ArrayList<String>();
			String top = s.nextLine();
			Menu.printMenu("notTypo", "toppings");
			System.out.println("Enter a topping you want or \"done\" if you are finished adding toppings");
			while (!top.trim().equalsIgnoreCase("done")) {
				toppings.add(top);
				System.out.println("Enter another topping or \"done\" if you are finished adding toppings");
				top = s.nextLine();
			}
			System.out.println("Type \"yes\" if your drink is a type of tea");
			if (s.nextLine().trim().equalsIgnoreCase("yes")) {
				orderObject = new TeaOrder(order, menu.getPrice(order, toppings.size()), toppings);
			}
			else {
				orderObject = new DrinkOrder(order, menu.getPrice(order, toppings.size()), toppings);
			}
		}
		else {
			orderObject = new FoodOrder(order, menu.getPrice(order, 0));
		}
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