/*
 *@author Jakin Chan, Daric Zhou, Jon Lee
 *@version 18 May 2019
 *This class contains the entire database of the T4 menu
 */

import java.util.ArrayList;

public class Menu{
 		private static String[] drinks = {"Earl Grey Milk Tea", "Jasmine Milk Tea", "Roasted Oolong Milk Tea", "Thai Milk Tea", "Soy Milk Tea", "Almond Milk Tea", "Peal Milk Tea", "Jasmine Milk Tea", "Grass Milk Tea", "Milk Tea with Coffee Jelly", "Milk Tea with Pearl and Coffee Jelly", "Wintermelon Milk Tea", "Potted Milk Tea", "Peppermint Milk Tea", "Classical Rose Milk Tea",
 							"Matcha Wish Fresh Milk", "Grass Jelly With Fresh Milk", "Taro Pearl Milk Tea", "Caramel Milk Tea", "Ballet Chocolate Milk", "French Pudding Milk Tea", "Red Bean Milk Tea", "Sesame Green Milk Tea", "Mango Milk Tea", "Coffee Milk Tea", "Okinawa Milk Tea", "Caramel Ice Milk", "Panda Milk Tea", "Lychee Milk Tea", "Green Tea Topped with Cream",
 							"Jadeite Royal Tea Topped with Cream", "Oolong Tea Topped with Cream", "Chocolate Milk Topped With Cream", "Mango Royal Tea Topped With Cream", "Honey Peach Smoothie", "Lemon Smoothie", "Lychee Smoothie", "Passion Fruit Milkshake", "Chocolate Smoothie", "Strawberry Smoothie", "Red Bean Milkshake", "Avacado Smoothie", "Taro Smoothie", 
 							"Apple Smoothie", "Mango Smoothie", "Pineapple Smoothie", "Jadeite Royal Tea", "Passion Fruit Royal Tea", "Grapefruit Royal Tea", "Mango Royal Tea", "Osmanthus Royal Tea", "Royal Tea", "Elegant Rose Royal Tea", "Apple Royal Tea", "Pineapple Royal Tea", "Earl Grey Tea", "Jasmine Green Tea", "Roasted Oolong Tea", "Yogurt Green Tea", 
 							"Lychee Black Tea", "Honey Green Tea", "Apple Black Tea", "Apple Green Tea", "Osmanthus Oolong Tea", "Lemon Bomb", "Winter Melon", "Winter Melon Lemon", "Honey Aloe", "Honey Grass Jelly", "Kumquat Lemon", "Ginger Tea", "Ginger Milk Tea", "Longan Red Date Tea", "Elegant Rose Aloe", "Green Tea with Ice Cream"};
		private static String[] food = {"French Fries", "Egg Puff", "Fried Flour Bun With Condensed Milk", "Fried Tofu", "Popcorn Chicken", "Fried Pot Stickers", "Fried Calamari", "Lobster Ball", "Fried Onion Ring", "Sweet Potato Fries", "Fried Cheese Sticks", "Tea Egg", "Sample Platter", "Fried Mushrooms", "Fried Spring Roll"};
		private static String[] toppings = {"Pearl", "Agar Pearl", "Aloe", "Coconut Jelly", "Rainbow Jelly", "Coffee Jelly", "Grass Jelly", "Pudding", "Red Bean", "Top Cream"};
		//prints out the menu of T4items based on the type: food, drink, or topping
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
					String items = options[i] + "                                        ";
					System.out.println(items.substring(0, 40) + getPrice(options[i]));
				}
				System.out.println();
			}else{
				int minPercentage = (int) (userInput.length() * 0.75);
				int longestStreak = 0;
				int streak = 0;

				for(int i = 0; i < options.length; i++){
					for(int j = 0; j < options[i].length(); j++){
						for(int k = 0; k < userInput.length(); k++){
							if(((k < userInput.length()) && (j < options[i].length())) && ((userInput.toLowerCase().charAt(k) == options[i].toLowerCase().charAt(j) || ((userInput.charAt(k) == ' ') && (options[i].charAt(j) == ' '))))){
								while((k < userInput.length() && j < options[i].length()) && ((userInput.toLowerCase().charAt(k) == options[i].toLowerCase().charAt(j) || ((userInput.charAt(k) == ' ') && (options[i].charAt(j) == ' '))))){
									streak++;
									k++;
									j++;
								}
								if(streak > longestStreak){
									longestStreak = streak;
								}
							}else{
								streak = 0;
							}
						}
					}
					if(longestStreak >= minPercentage){
						possibleInputs.add(options[i]);
					}
					longestStreak = 0;
				}
				System.out.println("Sorry, we don't have " + userInput + ", do you mean:");
				
				for(int i = 0; i < possibleInputs.size(); i++){
					String items = possibleInputs.get(i) + "                                   ";
					System.out.println(items.substring(0, 40) + getPrice(possibleInputs.get(i)));
				}
			}
		}
		//checks if the userInput is misspelled 
		public static boolean checkTypo(String userInput){
			userInput = userInput.toLowerCase();
			
			for(int i = 0; i < drinks.length; i++){
				if(userInput.equalsIgnoreCase(drinks[i])){
					return true;
				}	
			}
		
			for(int i = 0; i < food.length; i++){
				if(userInput.equalsIgnoreCase(food[i])){
					return true;
				}
			}
		
			for(int i = 0; i < toppings.length; i++){
				if(userInput.equalsIgnoreCase(toppings[i])){
					return true;
				}
			}	
			return false;
		}

		public static double getPrice(String order, int numToppings) {
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
						finalPrice = 3.70;
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
					case "honey grass jelly":
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
					case "fried cheese sticks":
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
						break;
					case "Pearl":
						finalPrice = 0.50;
						break;
					case "Agar Pearl":
						finalPrice = 0.05;
						break;
					case "Aloe":
						finalPrice = 0.50;
						break;
					case "Coconut Jelly":
						finalPrice = 0.50;
						break;
					case "Rainbow Jelly":
						finalPrice = 0.50;
						break;
					case "Coffee Jelly":
						finalPrice = 0.50;
						break;
					case "Grass Jelly":
						finalPrice = 0.50;
						break;
					case "Pudding":
						finalPrice = 0.50;
						break;
					case "Red Bean":
						finalPrice = 0.50;
						break;
					case "Top Cream":
						finalPrice = 0.50;
				}
			}
			
			if(numToppings != 0 ) {
				finalPrice += 0.5 * numToppings;
			}
			return finalPrice;
		}
	
		public static double getPrice(String order) {
			order = order.toLowerCase();
			
			if(order.contains("smoothie") || order.contains("milkshake")) {
				return 4.25;
			}else if((order.contains("royal tea") && !order.contains("with cream")) || order.equals("oolong tea")) {
				if(order.equals("jadeite royal tea")) {
					return 3.05;
				}else {
					return 3.55;
				}
			}else if(order.contains("with cream")) {
				if(order.contains("green tea") || order.contains("chocolate milk")) {
					return 4.05;
				}else {
					return 3.80;
				}
			}else if(order.contains("milk")) {
				switch(order){
					case "earl grey milk tea":
						return 3.15;
					case "jasmine milk tea":
						return 3.15;
					case "roasted oolong milk tea":
						return 3.15;
					case "thai milk tea":
						return 3.15;
					case "royal fresh milk tea":
						return 3.15;
					case "soy milk tea":
						return 3.40;
					case "almond miilk tea":
						return 3.60;
					case "ginger milk tea":
						return 3.80;
					case "classical rose milk tea":
						return 3.70;
					case "taro pearl milk tea":
						return 3.75;
					case "caramel milk tea":
						return 3.70;
					case "mango milk tea":
						return 3.70;
					case "okinawa milk tea":
						return 3.85;
					case "caramel ice milk":
						return 3.85;
					case "panda milk tea":
						return 3.80;
					case "lychee milk tea":
						return 3.70;
					case "fried flour bun with condensed milk":
						return 3.50;
					default:
						return 3.65;
				}
			}else if(order.contains("tea")) {
				switch(order){
					case "earl grey tea":
						return 3.05;
					case "jasmine green tea":
						return 3.05;
					case "roasted oolong tea":
						return 3.05;
					case "ginger tea":
						return 3.70;
					case "longan red date tea":
						return 3.70;
					case "green tea with ice cream":
						return 3.70;
					case "tea egg":   //I don't want to deal with the 3 pcs ones (3.25)
						return 1.35;
					default:
						return 3.55;
				}
			}else {
				switch(order) {
					case "winter melon":
						return 3.55;
					case "winter melon lemon":
						return 3.70;
					case "honey grass jelly":
						return 3.65;
					case "honey aloe":
						return 3.65;
					case "kumquat lemon":
						return 3.55;
					case "elegant rose aloe":
						return 3.70;
					case "french fries":
						return 3.15;
					case "egg puff":
						return 5.45;
					case "fried tofu":
						return 3.75;
					case "basil popcorn chicken":
						return 5.15;
					case "fried pot stickers":
						return 4.25;
					case "fried calamari":
						return 5.75;
					case "lobster ball":
						return 4.99;
					case "fried onion ring":
						return 3.50;
					case "sweet potato fries":
						return 3.50;
					case "fried cheese sticks":
						return 3.75;
					case "sample platter":
						return 6.95;
					case "fried mushrooms":
						return 4.50;
					case "fried spring roll":
						return 3.25;
					case "lemon bomb":
						return 3.75;
					case "Pearl":
						return 0.50;
					case "Agar Pearl":
						return 0.50;
					case "Aloe":
						return 0.50;
					case "Coconut Jelly":
						return 0.50;
					case "Rainbow Jelly":
						return 0.50;
					case "Coffee Jelly":
						return 0.50;
					case "Grass Jelly":
						return 0.50;
					case "Pudding":
						return 0.50;
					case "Red Bean":
						return 0.50;
					case "Top Cream":
						return 0.50;
				}
			}
			return 0.50;
		}
}
