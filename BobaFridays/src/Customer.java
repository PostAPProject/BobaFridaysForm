import java.util.ArrayList;

public class Customer {
	private ArrayList<T4Order> customerOrders = new ArrayList<T4Order>();

			public class menuItems{
		private String[] drinks = {};
		private String[] food = {};
		private String[] toppings = {};
		private ArrayList<String> drinksList = new ArrayList<String>();
		private ArrayList<String> foodList = new ArrayList<String>();
		private ArrayList<String> toppingsList = new ArrayList<String>();

		public menuItems(){
			for(int i = 0; i < drinks.length; i++){
				drinksList.add(drinks(i));
			}

			for(int i = 0; i < food.length; i++){
				foodList.add(food(i));
			}

			for(int i = 0; i < toppings.length; i++){
				toppingsList.add(toppings(i));
			}
		}

		public void menu(String userInput, String orderType){
			ArrayList<String> options;
			if(orderType.equals(“drinks”)){
				options = drinks;
			}else if(orderType.equals(“food”)){
				options = food;
			}else{
				options = toppings;
			}

			if(userInput.equals(“notTypo”)){
				for(int i = 0; i < options.size(); i++){
					System.out.print(options(i));
					if(i % 5 = 0){
						System.out.println();
					}
				}
				System.out.println();
			}else{
				int minPercentage = userInput.length() * 0.75;
				ArrayList<String> possibleInputs = new ArrayList<String>;
				counter  = 0;

				for(int i = 0; i < options.length; i++){
					for(int j = 0; j < options(i).length(); j++){
						for(int k = 0; k < userInput.length(); k++){
							if(userInput.charAt(k) == options(i).charAt(j)){
								counter++;
							}
						}
					}
					if(counter >= minPercentage){
						possibleInputs.add(options(i));
					}
					counter = 0;
				}

				for(int i = 0; i < possibleInputs.length; i++){

				}
			}
		}
		public double getPrice(String order) {

		}
	}

}
