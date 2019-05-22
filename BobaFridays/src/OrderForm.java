//This class contains methods which take in and store a series of boba orders by multiple customers
//@author Daric Zhou, Jakin Chan, Jon Lee
//@version May 19, 2019
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
			System.out.println("(Print \"quit\" if you want to exit the program)\nName: ");
			name = console.nextLine().trim();
		}
		System.out.println("Orders:\n" + printFullReceipt());
		System.out.println("Overall total: $" + getTotalPrice());
		console.close();
	}

	//accepts orders to add to the customer's receipt
	@SuppressWarnings("static-access")
	public void processCustomer(Customer c) {
		allCustomers.add(c);
		Scanner sc = new Scanner(System.in);
		boolean done = false;
		while (!done) {
			System.out.println("Would you like food or drink? Type \"menu\" to see the menu, or \"remove\" to delete a previous order. ");
			String type = sc.nextLine().trim();
			if (type.toLowerCase().contains("remove")) { //remove a previous order
				System.out.println("For which customer would you like to remove an order? Enter their name here: ");
				String name = sc.nextLine().trim();
				for (int i = 0; i< allCustomers.size(); i++) {
					if (name.equalsIgnoreCase(allCustomers.get(i).getName())) { //check if that customer exists
						System.out.println("Enter the number of the order you would like to remove (ex: 1 for the 1st order): ");
						int index = Integer.parseInt(sc.nextLine().trim())-1; //-1 to convert to zero based indexing
						if (index < allCustomers.get(i).getAllOrders().size() && index >= 0) {
							System.out.println("Order has been removed.");
							allCustomers.get(i).removeOrder(index); 
							i = allCustomers.size(); //exit the loop
						}
						else {
							System.out.println((index+1)+" is not a valid number of order for Customer "+allCustomers.get(i).getName());
							i = allCustomers.size(); //exit the loop
						}
					}
				}
			}
			else {
				//if customer needs to see a menu
				if (type.toLowerCase().contains("menu")) {
					System.out.println("Which menu would you like to see, food or drinks?");
					type = sc.nextLine().trim();
					menu.printMenu("notTypo", type);
				}
				if (type.toLowerCase().contains("drink")) {
					System.out.println("What would you like to order?");
					String drink = sc.nextLine();
					while(!menu.checkTypo(drink.trim())){
						menu.printMenu(drink, "drinks");
						drink = sc.nextLine();
					}
					c.addOrder(orderItem(drink.trim(), true));
					System.out.println("Order completed. ");
				}
				else if (type.toLowerCase().contains("food")) {
					System.out.println("What would you like to order?");
					String food = sc.nextLine();
					while(!menu.checkTypo(food.trim())){
						menu.printMenu(food, "food");
						food = sc.nextLine();
					}
					c.addOrder(orderItem(food.trim(), false));
					System.out.println("Order completed. ");
				}
				else {
					System.out.println("The requested type of order does not exist.");
				}
			}
			System.out.println("Print \"done\" if you are finished, or \"not\" to order more items.");
			if (sc.nextLine().trim().equalsIgnoreCase("done")) {
				done = true;
				System.out.println("Receipt:\n\n" + printReceipt(c) + "\n");
			}
		}
		System.out.println("Next Customer!");
	}
	
	//converts the order name into an order object and adds it to the customer's order list
	@SuppressWarnings("static-access")
	public T4Order orderItem(String order, boolean isDrink) {
		
		T4Order orderObject;
		Scanner s = new Scanner(System.in);
		
		if (isDrink) {
			ArrayList<String> toppings = new ArrayList<String>();
			Menu.printMenu("notTypo", "toppings");
			System.out.println("Enter a topping you want or \"done\" if you are finished adding toppings");
			String top = s.nextLine();
			while (!top.trim().equalsIgnoreCase("done")) {
				toppings.add(top);
				System.out.println("Enter another topping or \"done\" if you are finished adding toppings");
				top = s.nextLine();
				while(!menu.checkTypo(top) && !top.trim().equalsIgnoreCase("done")){
					menu.printMenu(top, "toppings");
					top = s.nextLine();
				}
			}
			int sweetness = 100;
			System.out.println("Enter the sweetness level you want (no percent sign) or press \"Enter\" for 100%");
			String sweetLevel = s.nextLine().trim();
			if (!sweetLevel.equals("")) {
				sweetness = Integer.parseInt(sweetLevel);
			}
			int ice = 100;
			System.out.println("Enter the ice level you want (no percent sign) or press \"Enter\" for 100%");
			String iceLevel = s.nextLine().trim();
			
			if (!iceLevel.equals("")) {
				ice = Integer.parseInt(iceLevel);
			}
			System.out.println("Type \"yes\" if your drink is a type of tea.");
			
			if (s.nextLine().trim().equalsIgnoreCase("yes")) {
				boolean isHot = false;
				System.out.println("Type \"yes\" if you want hot tea.");
				if (s.nextLine().trim().equalsIgnoreCase("yes")) {
					isHot = true;
				}
				orderObject = new TeaOrder(order, toppings, menu.getPrice(order, toppings.size()), sweetness, ice, isHot);
			}
			else {
				orderObject = new DrinkOrder(order, toppings, menu.getPrice(order, toppings.size()), sweetness, ice);
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
			answer+=(allOrders.get(i).getOrderName()+": $"+allOrders.get(i).getPrice()+"\n");
		}
		return answer;
	}
	
	//prints big receipt separated by each customer
	public String printReceipt(Customer c) {
		String answer = (c.getReceipt()+"\n"+"_____________\n");
		return answer;
	}
	
	public String printFullReceipt() {
		String answer = "";
		for (int i = 0 ; i < allCustomers.size(); i++) {
			answer+=printReceipt(allCustomers.get(i));
		}
		return answer;
	}
	
	public double getTotalPrice() {
		double totalPrice = 0.0;
		for(int i = 0; i<allOrders.size(); i++) {
			totalPrice += allOrders.get(i).getPrice();
		}
		return totalPrice;
	}
	
}
