package iikh;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class WeekPlan extends Plans{
	Date date;
	MealPlan mealList;
	Scanner inp = new Scanner(System.in);
	static ArrayList<String[]> weekPlan;
	String week[]= {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
	public WeekPlan() {
		mealList = new MealPlan();
		weekPlan = new ArrayList<String[]>();
	}
	
	public void start2(){
		PrintGen();
		System.out.println("1 - Make Week Plan");
		int x = inp.nextInt();
		switch (x) {
		case -1:System.exit(0);
			break;
		case 0 :Plans.start();
			break;
		case 1 :MakeWeekPlan();
			break;
		default :System.out.println("Enter proper Number");
			break;
		}
	}
	
	public void MakeWeekPlan() {
		Scanner newScan = new Scanner(System.in);
		System.out.println("Enter start Date :");
		System.out.printf("Day:");
		int dt = newScan.nextInt();
		System.out.printf("Month:");
		int mt = newScan.nextInt();
		System.out.printf("Year:");
		int yr = newScan.nextInt();
		date = new Date(dt,mt,yr);
		String newDate = date.toString();
		String[] header = {"WeekDay","Breakfast","Lunch","Snacks","Dinner"};
		weekPlan.add(header);
		for(String str:week){
			ListAvailMealPlans();
			System.out.println("Choose meals for the "+str+" :");
			System.out.println("Breakfast :");
			int br = newScan.nextInt();
			System.out.println("Lunch :");
			int lu = newScan.nextInt();
			System.out.println("Snacks :");
			int sn = newScan.nextInt();
			System.out.println("Dinner :");
			int di = newScan.nextInt();
			String[] newDay = {str,mealList.meals.get(br)[0],mealList.meals.get(lu)[0],mealList.meals.get(sn)[0],mealList.meals.get(di)[0]};
			weekPlan.add(newDay);
		}
		GenerateCSV();
		System.out.println("Added Day Plan of "+newDate+" Plan Database");
		PrintWeekPlan();
	}
	
	public void PrintWeekPlan() {
		ListAvails(weekPlan);
	}
	
	public void ListAvailMealPlans() {
		System.out.println("Here is the list of Recipes available(choose among them) : ");
		ListAvails(mealList.meals);
	}
	
	public void GenerateCSV() {
			String fileName = "PlansDatabase/"+date.getDate() +"_"+date.getMonth()+"_"+date.getYear()+".csv";
			RewriteCSV(fileName, weekPlan);
	}
	
	

}
