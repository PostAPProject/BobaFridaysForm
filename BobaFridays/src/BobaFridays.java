import java.util.Scanner;

public class BobaFridays {
	
	//accepts a name and assigns it to a new customer
	public static void main(String[] args) {
		MenuItems m = new MenuItems(); //defines which menu to order from
		OrderForm form = new OrderForm(m);
		form.takeOrders();
	}	
}
