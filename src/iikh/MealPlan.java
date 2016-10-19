package iikh;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class MealPlan extends Plans{
	Scanner inp = new Scanner(System.in);
	static ArrayList<String[]> meals;
	public MealPlan() {
		meals = new ArrayList<String[]>();
		Scanner scanIn = null;
		int rowc = 0;
		String inputLine = "";
		String fileLocation = "PlansDatabase/Meals.csv";
		try {
			scanIn = new Scanner(new BufferedReader(new FileReader(fileLocation)));
			while(scanIn.hasNextLine()){
				inputLine = scanIn.nextLine();
				String[] inArray = inputLine.split(";");
				meals.add(inArray);
				rowc ++;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public void start2(){
		PrintGen();
		System.out.println("1 - Add Meal Plan");
		System.out.println("2 - Remove Meal Plan");
		System.out.println("3 - Edit Meal Plan");
		System.out.println("4 - List of Meal Plans");
		int x = inp.nextInt();
		switch (x) {
		case -1:System.exit(0);
			break;
		case 0 :Plans.start();
			break;
		case 1 :AddMealPlan();
			break;
		case 2 :RemoveMealPlan();
			break;
		case 3 :EditMealPlan();
			break;
		case 4 :ListMealPlan();
			break;
		default :System.out.println("Enter proper Number");
			break;
		}
	}
	
	public void AddMealPlan(){
		Scanner newScan = new Scanner(System.in);
		System.out.printf("Enter the name:");
		String name = newScan.nextLine();
		ArrayList<Integer> recs = new ArrayList<Integer>();
		ListAvailRecipes();
		System.out.println("Enter the numbers of recipes required one by one(enter -1 to end):");
		int rec = newScan.nextInt();
		while(rec!=(-1)){
			recs.add(rec);
			rec = newScan.nextInt();
		}
		String recList = recipes.recipes.get(recs.get(0))[0];
		for (int i = 1; i < recs.size(); i++) {
			recList +=","+recipes.recipes.get(recs.get(i))[0];
		}
		String[] newMeal = new String[2];
		newMeal[0] = name;
		newMeal[1] = recList;
		meals.add(newMeal);
		RewriteCSV("PlansDatabase/Meals.csv", meals);
		System.out.println("Added "+name+" to the Meal Plan Database");
		ListMealPlan();
	}
	
	public void RemoveMealPlan() {
		PrintGen();
		PrintMeals();
		int x = inp.nextInt();
		switch (x) {
		case -1:System.exit(0);
			break;
		case 0 :start2();
			break;
		default:Remove(x);
			break;
		}
	}
		
	public void EditMealPlan() {
		PrintGen();
		PrintMeals();
		int x = inp.nextInt();
		switch (x) {
		case -1:System.exit(0);
			break;
		case 0 :start2();
			break;
		default:Edit(x);
			break;
		}
	}
	
	public void ListMealPlan() {
		PrintGen();
		PrintMeals();
		int x = inp.nextInt();
		switch (x) {
		case -1:System.exit(0);
			break;
		case 0 :start2();
			break;
		default:System.out.println("Enter proper Number");
			break;
		}
	}
	
	public void PrintMeals(){
		ListAvails(meals);
		}
	
	public void Remove(int i){
		System.out.println("Meal Plan of " +meals.get(i)[0]+" removed");
		meals.remove(i);
		RewriteCSV("PlansDatabase/Meals.csv", meals);
		RemoveMealPlan();
	}
	
	public void Edit(int i) {
		System.out.println("Present Meal:");
		AccessMeal(i);
		Scanner editScan = new Scanner(System.in);
		ListAvailRecipes();
		ArrayList<Integer> recs = new ArrayList<Integer>();
		System.out.println("Enter the edited number of Recipes list one by one(Enter -1 if done):");
		int rec = editScan.nextInt();
		while(rec!=-1){
			recs.add(rec);
			rec = editScan.nextInt();
		}
		String recList = recipes.recipes.get(recs.get(0))[0];
		for (int j = 1; j < recs.size(); j++) {
			recList +=","+recipes.recipes.get(recs.get(j))[0];
		}	
		meals.get(i)[1] = recList;
		RewriteCSV("PlansDatabase/Meals.csv", meals);
		System.out.println("Meal Plan of "+meals.get(i)[0]+" edited");
		EditMealPlan();
	}
	
	public void AccessMeal(int i) {
		System.out.println("Name\t:"+meals.get(i)[0]);
		System.out.println("Recipes\t:"+ meals.get(i)[1]);
	}
	public void ListAvailRecipes(){
		System.out.println("Here is the list of Recipes available(choose among them) : ");
		ListAvails(recipes.recipes);
	}
}
