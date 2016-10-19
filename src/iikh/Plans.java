package iikh;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Plans extends Welcome{
	static Scanner inp = new Scanner(System.in);
	RecipeDatabase recipes;
	public Plans() {
		recipes = new RecipeDatabase();
	}
	public static void start(){
		PrintGen();
		System.out.println("1 - Meal Plan");
		System.out.println("2 - Day Plan");
		System.out.println("3 - Week Plan");
		
		int x = inp.nextInt();
		switch (x) {
		case -1:System.exit(0);
			break;
		case 0 :Welcome.level0();
			break;
		case 1 :MealPlan();
			break;
		case 2 :DayPlan();
			break;
		case 3 :WeekPlan();
			break;
		default :System.out.println("Enter proper Number");
			break;
		}
	}
	
	public static void MealPlan(){
		MealPlan meal = new MealPlan();
		meal.start2();
	}
	public static void DayPlan(){
		DayPlan day = new DayPlan();
		day.start2();
	}
	public static void WeekPlan(){
		WeekPlan week = new WeekPlan();
		week.start2();
	}
}
