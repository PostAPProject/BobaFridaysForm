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
					String items = options[i] + "                    ";
					System.out.println(items.substring(0, 25) + getPrice(options[i], null));
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
							/*
							if(userInput.charAt(k) == options[i].charAt(j) || ((userInput.charAt(k) == ' ') && (options[i].charAt(j) == ' '))){
								while(userInput.charAt(k) == options[i].charAt(j) || ((userInput.charAt(k) == ' ') && (options[i].charAt(j) == ' '))){
									streak++;
									k++;
									j++;
								}
								if(streak > longestStreak){
									streak = longestStreak;
								}
							}else{
								streak = 0;
							}
							*/
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
					String items = possibleInputs.get(i) + "                    ";
					System.out.println(items.substring(0, 25) + possibleInputs.get(i), null));
				}
			}
		}
		
		public double getPrice(String order, String toppings) {
			double finalPrice = 0;
			order = order.toLowerCase();
			
			if(order.contains("smoothie") || order.contains("milkshake")) {
				finalPrice = 4.25;
			}else if((order.contains("royal tea") && !order.contains("with cream")) || order.equals("oolong tea")) {
				if(order.equals("jadeite royal tea")) {
					finalPrice = 3.05;
				}else {
					finalPrice = 3.55;
				}
			}else if(order.contains("with cream")) {
				if(order.contains("green tea") || order.contains("chocolate milk")) {
					finalPrice = 4.05;
				}else {
					finalPrice = 3.80;
				}
			}else if(order.contains("milk")) {
				switch(order){
					case "earl grey milk tea":
						finalPrice = 3.15;
						break;
					case "jasmine milk tea":
						finalPrice = 3.15;
						break;
					case "roasted oolong milk tea":
						finalPrice = 3.15;
						break;
					case "thai milk tea":
						finalPrice = 3.15;
						break;
					case "royal fresh milk tea":
						finalPrice = 3.15;
						break;
					case "soy milk tea":
						finalPrice = 3.40;
						break;
					case "almond miilk tea":
						finalPrice = 3.60;
						break;
					case "ginger milk tea":
						finalPrice = 3.80;
						break;
					case "classical rose milk tea":
						finalPrice = 3.70;
						break;
					case "taro pearl milk tea":
						finalPrice = 3.75;
						break;
					case "caramel milk tea":
						finalPrice = 3.70;
						break;
					case "mango milk tea":
						finanlPrice = 3.70;
						break;
					case "okinawa milk tea":
						finalPrice = 3.85;
						break;
					case "caramel ice milk":
						finalPrice = 3.85;
						break;
					case "panda milk tea":
						finalPrice = 3.80;
						break;
					case "lychee milk tea":
						finalPrice = 3.70;
						break;
					case "fried flour bun with condensed milk":
						finalPrice = 3.50;
						break;
					default:
						finalPrice = 3.65;
				}
			}else if(order.contains("tea")) {
				switch(order){
					case "earl grey tea":
						finalPrice = 3.05;
						break;
					case "jasmine green tea":
						finalPrice = 3.05;
						break;
					case "roasted oolong tea":
						finalPrice = 3.05;
						break;
					case "ginger tea":
						finalPrice = 3.70;
						break;
					case "longan red date tea":
						finalPrice = 3.70;
						break;
					case "green tea with ice cream":
						finalPrice = 3.70;
						break;
					case "tea egg":   //I don't want to deal with the 3 pcs ones (3.25)
						finalPrice = 1.35;
						break;
					default:
						finalPrice = 3.55;
				}
			}else {
				switch(order) {
					case "winter melon":
						finalPrice = 3.55;
						break;
					case "winter melon lemon":
						finalPrice = 3.70;
						break;
					case "henry grass jelly":
						finalPrice = 3.65;
						break;
					case "honey aloe":
						finalPrice = 3.65;
						break;
					case "kumquat lemon":
						finalPrice = 3.55;
						break;
					case "elegant rose aloe":
						finalPrice = 3.70;
						break;
					case "french fries":
						finalPrice = 3.15;
						break;
					case "egg puff":
						finalPrice = 5.45;
						break;
					case "fried tofu":
						finalPrice = 3.75;
						break;
					case "basil popcorn chicken":
						finalPrice = 5.15;
						break;
					case "fried pot stickers":
						finalPrice = 4.25;
						break;
					case "fried calamari":
						finalPrice = 5.75;
						break;
					case "lobster ball":
						finalPrice = 4.99;
						break;
					case "fried onion ring":
						finalPrice = 3.50;
						break;
					case "sweet potato fries":
						finalPrice = 3.50;
						break;
					case "fried cheese stick":
						finalPrice = 3.75;
						break;
					case "sample platter":
						finalPrice = 6.95;
						break;
					case "fried mushrooms":
						finalPrice = 4.50;
						break;
					case "fried spring roll":
						finalPrice = 3.25;
						break;
					case "lemon bomb":
						finalPrice = 3.75;
				}
			}
			
			if(toppings != null) {
				finalPrice += 0.5;
			}
			return finalPrice;
		}
}
