//This is not even close to done. Imma change the strings to objects later.
public class menuItems{
 		private String[] drinks = {};
		private String[] food = {"French Fries", "Egg Puff", "Fried Flour Bun Wiith Condensed Milk", "Fried Tofu", "Popcorn Chicken", "Fried Popstickers", "Fried Calamari", "Lobster Ball", "Fried Onion Ring", "Sweet Potato Fries", "Fried Cheeese Sticks", "Tea, Egg", "Sample Platter", "Fried Mushrooms", "Fried Spring Roll"};
		private String[] toppings = {"Pearl", "Agar Pearl", "Aloe", "Coconut Jelly", "Rainbow Jelly", "Coffee Jelly", "Grass Jelly", "Pudding", "Red Bean", "Top Cream"};

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
			String[] options;
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
