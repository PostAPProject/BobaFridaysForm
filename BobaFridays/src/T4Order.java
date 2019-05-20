/*
 * @author Daric Zhou, Jakin Chan, Jon Lee
 * @version May 2019
 * This superclass stores an order of a drink or food
 */
public class T4Order {
	private String order;
	protected double orderPrice;
	
	public T4Order(String o, double price) {
		order = o;
		setOrderPrice(price);
	}
	public String getOrderName() {
		return order;
	}
	public double getPrice() {
		return round2(orderPrice * 1.0875);
	}

	public void setOrderPrice(double orderPrice) {
		this.orderPrice = orderPrice;
	}
	
	//Takes a double, returns it rounded to the hundreths place
	public static double round2(double num) {
		
		if(num == 0) {
			return 0;
		}
		
		int sign = (int) (num / Math.abs(num));
		int answer = Math.abs((int)(num*1000));
		if(answer%10>=5) {
			return sign*((int)((answer+10)/10))/100.0;
		}else{
			return sign*(answer/10)/100.0;
		}
		
	}
	
}
