import java.util.ArrayList;

public class DrinkOrder extends T4Order {
		private ArrayList<String> toppings = new ArrayList<String>();

		public DrinkOrder(String o, ArrayList<String> tops, double price) {
			super(o, price);
			toppings = tops;
			for(@SuppressWarnings("unused") String topping : toppings) {
				price += 0.50;
			}
		}
		public ArrayList<String> getToppings() {
			return toppings;
		}
		public String toString() {
			return getCustomerName() + ": " + getOrderName() + " with " + toppings + "\n Total cost: " + getPrice();
		}
		
	}
