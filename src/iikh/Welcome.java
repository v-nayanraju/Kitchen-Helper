package iikh;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;

public class Welcome {
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		level0();		
	}
	
	static void level0(){
		System.out.println("WELCOME TO THE KITCHEN HELPER");
		System.out.println("1 - Recipe Database");
		System.out.println("2 - Plans");
		System.out.println("-1 - EXIT");
		int x;
		x = input.nextInt();
		switch (x) {
		case -1:System.exit(0);
			break;
		case 1:recipeDatabase();
			break;
		case 2 :planManager();
			break;
		default:System.out.println("Enter proper Number");
			break;
		}
	}
	
	static void recipeDatabase(){
		RecipeDatabase recipeList = new RecipeDatabase();
		recipeList.start();
	}
	static void planManager(){
		Plans plans = new Plans();
		Plans.start();
	}
	public static void PrintGen(){
		System.out.println("-1 - Exit");
		System.out.println("0 - Back ");
	}
	
	public void ListAvails(ArrayList<String[]> arrayList){
		for (int i = 0; i < arrayList.size(); i++) {
			System.out.printf((i==0)?"\t":i+".\t");
			for (int j = 0; j < arrayList.get(i).length; j++) {
				System.out.printf(arrayList.get(i)[j]+"\t");
			}
			System.out.printf("\n");
			if(i==0){
				System.out.printf("\t");
				for(int k = 0;k< arrayList.get(i).length; k++)
					System.out.printf("*********************");	
				System.out.printf("\n");
			}
		}
	}	
	public void RewriteCSV(String fileName, ArrayList<String[]> arrayList){
		try {
			FileWriter fileWriter = new FileWriter(fileName);
			for(String[] i:arrayList){
				for(String str : i){
					fileWriter.append(str);
					fileWriter.append(";");
				}
				fileWriter.append("\n");
			}
			fileWriter.flush();
			fileWriter.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
