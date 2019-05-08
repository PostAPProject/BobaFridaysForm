import java.util.ArrayList;

public class DrinkOrder extends T4Order {
		private String customerName;
		private String order;
		private ArrayList<String> toppings;
		private double orderPrice;

		public DrinkOrder(String name, String o, ArrayList<String> t, double price) {
			super(name, o, price);
			toppings = t;
		}
		public ArrayList<String> getToppings() {
			return toppings;
		}
		public String toString() {
			return customerName + ": " + order + " with " + toppings + "\n Total cost: " + orderPrice;
		}
		
	}