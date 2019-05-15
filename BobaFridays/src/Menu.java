import java.util.ArrayList;

//This is not even close to done. Imma change the strings to objects later.
public class MenuItems{
public class MenuItems{
 		private static String[] drinks = {"Earl Grey Milk Tea", "Jasmine Milk Tea", "Roasted Oolong Milk Tea", "Thai Milk Tea", "Soy Milk Tea", "Almond Milk Tea", "Peal Milk Tea", "Jasmine Milk Tea", "Grass Milk Tea", "Milk Tea with Coffee Jelly", "Milk Tea with Pearl and Coffee Jelly", "Wintermelon Milk Tea", "Potted Milk Tea", "Peppermint Milk Tea", "Classical Rose Milk Tea",
 							"Matcha Wish Fresh Milk", "Grass Jelly With Fresh Milk", "Taro Pearl Milk Tea", "Caramel Milk Tea", "Ballet Chocolate Milk", "French Pudding Milk Tea", "Red Bean Milk Tea", "Sesame Green Milk Tea", "Mango Milk Tea", "Coffee Milk Tea", "Okinawwa Milk Tea", "Caramel Ice Milk", "Panda Milk Tea", "Lychee Milk Tea", "Green Tea Topped with Cream",
 							"Jadeite Royal Tea Topped with Cream", "Oolong Tea Topped with Cream", "Chocolate Milk Topped With Cream", "Mango Royal Tea Topped With Cream", "Honey Peach Smoothie", "Lemon Smoothie", "Lychee Smoothie", "Passion Fruit Milkshake", "Chocolate Smoothie", "Strawberry Smoothie", "Red Bean Milkshake", "Avacado Smoothie", "Taro Smoothie", 
 							"Apple Smoothie", "Mango Smoothie", "Pineapple Smoothie", "Jadeite Royal Tea", "Passion Fruit Royal Tea", "Grapefruit Royal Tea", "Mango Royal Tea", "Osmanthus Royal Tea", "Royal Tea", "Elegant Rose Royal Tea", "Apple Royal Tea", "Pineapple Royal Tea", "Earl Grey Tea", "Jasmine Green Tea", "Roasted Oolong Tea", "Yogurt Green Tea", 
 							"Lychee Black Tea", "Honey Green Tea", "Apple Black Tea", "Apple Green Tea", "Osmanthus Oolong Tea", "Lemon Bomb", "Winter Melon", "Winter Melon Lemon", "Honey Aloe", "Honey Grass Jelly", "Kumquat Lemon", "Ginger Tea", "Ginger Milk Tea", "Longan Red Date Tea", "Elegant Rose Aloe", "Green Tea with Ice Cream"};
		private static String[] food = {"French Fries", "Egg Puff", "Fried Flour Bun With Condensed Milk", "Fried Tofu", "Popcorn Chicken", "Fried Popstickers", "Fried Calamari", "Lobster Ball", "Fried Onion Ring", "Sweet Potato Fries", "Fried Cheeese Sticks", "Tea, Egg", "Sample Platter", "Fried Mushrooms", "Fried Spring Roll"};
		private static String[] toppings = {"Pearl", "Agar Pearl", "Aloe", "Coconut Jelly", "Rainbow Jelly", "Coffee Jelly", "Grass Jelly", "Pudding", "Red Bean", "Top Cream"};

	public static void printMenu(String userInput, String orderType){
			String[] options;
			ArrayList<String> possibleInputs = new ArrayList<String>();
			
			if(orderType.equals("drinks")){
				options = drinks;
			}else if(orderType.equals("food")){
				options = food;
			}else if(orderType.equals("toppings")){
				options = toppings;
			}else {
				options = drinks;
			}

			if(userInput.equals("notTypo")){
				for(int i = 0; i < options.length; i++){
					System.out.print(options[i] + "     ");
					if(i % 5 == 0){
						System.out.println();
					}
				}
				System.out.println();
			}else{
				int minPercentage = (int) (userInput.length() * 0.25);
				//int counter = 0;
				int longestStreak = 0;
				int streak = 0;

				for(int i = 0; i < options.length; i++){
					for(int j = 0; j < options[i].length(); j++){
						for(int k = 0; k < userInput.length(); k++){
							if(userInput.charAt(k) == options[i].charAt(j)){
								if(k >= 1 && j >= 1){
									if(userInput.charAt(k-1) == options[i].charAt(j-1)){
										streak++;
										System.out.print(userInput.charAt(k) + "" + streak + " ");
										if(streak > longestStreak){
											longestStreak = streak;
										}
									}else{
										System.out.print("*");
										streak = 0;
									}
								}
							}
						}
					}
					if(longestStreak >= minPercentage){
						possibleInputs.add(options[i]);
						System.out.println(streak + " " + options[i]);
					}
					longestStreak = 0;
				}
				System.out.println("Num possible: " + possibleInputs.size());
				
				for(int i = 0; i < possibleInputs.size(); i++){
					System.out.print(possibleInputs.get(i) + "     ");
					if(i % 5 == 0){
						System.out.println();
					}
				}
			}
		}
		
		public double getPrice(String order) {
			return 0.0;
		}
}
