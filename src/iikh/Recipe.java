package iikh;

import java.util.ArrayList;

public class Recipe {
	private static String name;
	private static ArrayList<String> ingredients = new ArrayList<String>();
	
	public Recipe(){
		name = null;
		ingredients = null;
	}
	public Recipe(String n, ArrayList<String> i) {
		name = n;
		ingredients = i;		
	}
	public static String getName() {
		return name;
	}
	public static ArrayList<String> getIngredients() {
		return ingredients;
	}
}
