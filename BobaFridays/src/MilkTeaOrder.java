import java.util.ArrayList;

public class TeaOrder extends DrinkOrder {
		private String customerName;
		private String order;
		private ArrayList<String> toppings;
		private double orderPrice;
		private boolean isHot;

		public TeaOrder(String name, String o) {
			super(name, o, t, price);
			this.isHot = isHot;
			if(isHot) {
				orderPrice += 0.50;
			}
			for(String topping : toppings) {
				orderPrice += 0.50;
			}
			
		}
