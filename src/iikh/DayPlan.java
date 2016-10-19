package iikh;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class DayPlan extends Plans{
	Date dt;
	MealPlan mealList;
	Scanner inp = new Scanner(System.in);
	static ArrayList<String[]> dayPlans;
	public DayPlan() {
		dayPlans = new ArrayList<String[]>();
		Scanner scanIn = null;
		mealList = new MealPlan();
		int rowc = 0;
		String inputLine = "";
		String fileLocation = "PlansDatabase/DayPlans.csv";
		try {
			scanIn = new Scanner(new BufferedReader(new FileReader(fileLocation)));
			while(scanIn.hasNextLine()){
				inputLine = scanIn.nextLine();
				String[] inArray = inputLine.split(";");
				dayPlans.add(inArray);
				rowc ++;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public void start2(){
		PrintGen();
		System.out.println("1 - Add Day Plan");
		System.out.println("2 - Remove Day Plan");
		System.out.println("3 - List of Day Plans");
		int x = inp.nextInt();
		switch (x) {
		case -1:System.exit(0);
			break;
		case 0 :Plans.start();
			break;
		case 1 :AddDayPlan();
			break;
		case 2 :RemoveDayPlan();
			break;
		case 3 :ListDayPlan();
			break;
		default :System.out.println("Enter proper Number");
			break;
		}
	}
	
	public void AddDayPlan() {
		Scanner newScan = new Scanner(System.in);
		System.out.println("Enter Date :");
		System.out.printf("Day:");
		int dt = newScan.nextInt();
		System.out.printf("Month:");
		int mt = newScan.nextInt();
		System.out.printf("Year:");
		int yr = newScan.nextInt();
		Date date = new Date(dt,mt,yr);
		String newDate = date.toString();
		ListAvailMealPlans();
		System.out.println("Choose meals for the following:");
		System.out.println("Breakfast :");
		int br = newScan.nextInt();
		System.out.println("Lunch :");
		int lu = newScan.nextInt();
		System.out.println("Snacks :");
		int sn = newScan.nextInt();
		System.out.println("Dinner :");
		int di = newScan.nextInt();
		String[] newDay = {newDate,mealList.meals.get(br)[0],mealList.meals.get(lu)[0],mealList.meals.get(sn)[0],mealList.meals.get(di)[0]};
		dayPlans.add(newDay);
		RewriteCSV("PlansDatabase/DayPlans.csv", dayPlans);
		System.out.println("Added Day Plan of "+newDate+" Plan Database");
		ListDayPlan();
		
	}
	
	public void RemoveDayPlan() {
		PrintGen();
		PrintDayPlans();
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

	public void ListDayPlan() {
		PrintGen();
		PrintDayPlans();
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
	
	public void Remove(int i){
		System.out.println("Plan of " +dayPlans.get(i)[0]+" removed");
		dayPlans.remove(i);
		RewriteCSV("PlansDatabase/DayPlans.csv", dayPlans);
		RemoveDayPlan();
	}
	
	public void PrintDayPlans() {
		ListAvails(dayPlans);
	}
	public void ListAvailMealPlans() {
		System.out.println("Here is the list of Recipes available(choose among them) : ");
		ListAvails(mealList.meals);
	}
}
	
	
