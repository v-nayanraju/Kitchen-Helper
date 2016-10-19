package iikh;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class RecipeDatabase extends Welcome{
	Scanner inp = new Scanner(System.in);
	static ArrayList<String[]> recipes;	
	public RecipeDatabase() {
		recipes = new ArrayList<String[]>();
		Scanner scanIn = null;
		int rowc = 0;
		String inputLine = "";
		String fileLocation = "Recipes.csv";
		try {
			scanIn = new Scanner(new BufferedReader(new FileReader(fileLocation)));
			while(scanIn.hasNextLine()){
				inputLine = scanIn.nextLine();
				String[] inArray = inputLine.split(";");
				recipes.add(inArray);
				rowc ++;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void start(){
		PrintGen();
		System.out.println("1 - Add Recipe");
		System.out.println("2 - Remove Recipe");
		System.out.println("3 - Edit Recipe");
		System.out.println("4 - List of recipes");
		
		int x = inp.nextInt();
		switch (x) {
		case -1:System.exit(0);
			break;
		case 0 :Welcome.level0();
			break;
		case 1 :AddRecipe();
			break;
		case 2 :RemoveRecipe();
			break;
		case 3 :EditRecipe();
			break;
		case 4 :ListRecipe();
			break;
		default:System.out.println("Enter proper Number");
			break;
		}		
	}
	
	public void AddRecipe(){
		Scanner newScan = new Scanner(System.in);
		System.out.printf("Enter the name:");
		String name = newScan.nextLine();
		ArrayList<String> ingredients = new ArrayList<String>();
		System.out.println("Enter the list of ingredientsone by one(enter -1 to end):");
		String ing = newScan.nextLine();
		while(!ing.equals("-1")){
			ingredients.add(ing);
			ing = newScan.nextLine();
		}
		String ingList = ingredients.get(0);
		for (int i = 1; i < ingredients.size(); i++) {
			ingList +=","+ingredients.get(i);
		}
		String[] newRec = new String[2];
		newRec[0] = name;
		newRec[1] = ingList;
		recipes.add(newRec);
		RewriteCSV("Recipes.csv", recipes);
		System.out.println("Added "+name+" to the Recipe Database");
		ListRecipe();
	}
	
	public void RemoveRecipe() {
		PrintGen();
		ListAvails(recipes);
		int x = inp.nextInt();
		switch (x) {
		case -1:System.exit(0);
			break;
		case 0 :start();
			break;
		default:Remove(x);
			break;
		}
	}
	
	public void EditRecipe() {
		PrintGen();
		ListAvails(recipes);
		int x = inp.nextInt();
		switch (x) {
		case -1:System.exit(0);
			break;
		case 0 :start();
			break;
		default:Edit(x);
			break;
		}
	}
	
	public void ListRecipe() {
		PrintGen();
		ListAvails(recipes);
		int x = inp.nextInt();
		switch (x) {
		case -1:System.exit(0);
			break;
		case 0 :start();
			break;
		default:System.out.println("Enter proper Number");
			break;
		}
	}
	
	public void AccessRecipe(int i) {
		System.out.println("Name\t:"+recipes.get(i)[0]);
		System.out.println("Ingredients\t:"+ recipes.get(i)[1]);
	}
	
	public void Edit(int i) {
		System.out.println("Present Recipe:");
		AccessRecipe(i);
		Scanner editScan = new Scanner(System.in);
		ArrayList<String> ingredients = new ArrayList<String>();
		System.out.println("Enter the edited Ingredient list one by one(Enter -1 if done):");
		String ing = editScan.nextLine();
		while(!ing.equals("-1")){
			ingredients.add(ing);
			ing = editScan.nextLine();
		}
		String ingList = ingredients.get(0);
		for (int j = 1; j < ingredients.size(); j++) {
			ingList +=","+ingredients.get(j);
		}	
		recipes.get(i)[1] = ingList;
		RewriteCSV("Recipes.csv", recipes);
		System.out.println("Recipe of "+recipes.get(i)[0]+" edited");
		EditRecipe();
	}
	
	public void Remove(int i) {
		System.out.println("Recipe of " +recipes.get(i)[0]+" removed");
		recipes.remove(i);
		RewriteCSV("Recipes.csv", recipes);
		RemoveRecipe();
	}
}
