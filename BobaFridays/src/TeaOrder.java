/*
 * @author Daric Zhou
 * @version May 2019
 * This class stores an order of milk tea or regular tea
 */
import java.util.ArrayList;

public class TeaOrder extends DrinkOrder {

		public TeaOrder(String o, ArrayList<String> t, double price, int sweetness, int ice, boolean isHot) {
			super(o, t, price, sweetness, ice);
			if(isHot) {
				price += 0.50;
			}	
			super.setOrderPrice(price);
		}
}
