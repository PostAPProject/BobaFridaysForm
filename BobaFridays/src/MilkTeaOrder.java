import java.util.ArrayList;

public class TeaOrder extends DrinkOrder {

		public TeaOrder(String o, ArrayList<String> t, double price, boolean isHot) {
			super(o, t, price);
			if(isHot) {
				price += 0.50;
			}	
		}
}
