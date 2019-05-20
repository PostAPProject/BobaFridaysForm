//This class contains client code to run the OrderForm class
//@author Daric Zhou, Jakin Chan, Jon Lee
//@version May 19, 2019
public class BobaFridays {
	
	//accepts a name and assigns it to a new customer
	public static void main(String[] args) {
		Menu m = new Menu(); //defines which menu to order from
		OrderForm form = new OrderForm(m);
		form.takeOrders();
	}
}
