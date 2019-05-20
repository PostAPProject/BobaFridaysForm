/*
 * @author Daric Zhou, Jakin Chan, Jon Lee
 * @version May 2019
 * This class stores an order of a drink
 */
import java.util.ArrayList;

public class DrinkOrder extends T4Order {
		private ArrayList<String> toppings = new ArrayList<String>();
		private int sweetnessLevel, iceLevel;

		public DrinkOrder(String o, ArrayList<String> tops, double price, int sweetness, int ice) {
			super(o, price);
			toppings = tops;
			sweetnessLevel = sweetness;
			iceLevel = ice;
			for(@SuppressWarnings("unused") String topping : toppings) {
				price += 0.50;
			}
			setOrderPrice(price);
		}
		
		public ArrayList<String> getToppings() {
			return toppings;
		}
		//overrides superclass method by including sweetness and ice
		public String getOrderName() {
			return getOrderName() + "and" + sweetnessLevel + "% sweetness, " + iceLevel +  "% ice";
		}
		public void setOrderPrice(double newPrice) {
		super.orderPrice = newPrice;
		
		}
}
