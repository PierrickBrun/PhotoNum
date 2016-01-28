package util;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class PrintableMenu {
	ArrayList<String> menuContent;
	String menuTitle;
	String menuFooter = "";
	Scanner scan = new Scanner(System.in);

	public PrintableMenu(String title){
		menuTitle = title;
		menuContent = new ArrayList<>();
	}
	
	public PrintableMenu(String title, String footer){
		menuTitle = title;
		menuFooter = footer;
		menuContent = new ArrayList<>();
	}
	
	public void setFooter(String footer){
		menuFooter = footer;
	}
	
	

	public void addItem(String item){
		menuContent.add(item);
	}

	public void removeItem(int itemId){
		menuContent.remove(itemId);
	}

	public int launch(){
		String scannedValue = "";
		int selectedMenuItem = -1;
		do{
			if(selectedMenuItem == 0){
				System.out.println("Aucun élément du menu de correspond à votre selection.");
			}
			System.out.println(menuTitle+": \n"
					+ "_____________\n");
			for (int i = 0; i < menuContent.size(); i++) {
				System.out.println((i+1)+". "+menuContent.get(i));
			}
			System.out.println(menuFooter);
			System.out.println("_____________\n"
					+ "Choisissez une option");
			scannedValue = scan.nextLine();
			selectedMenuItem = checkInt(menuContent.size(), scannedValue);
		}while(!(checkInt(menuContent.size(), scannedValue) > 0));
		return selectedMenuItem;
	}

	private int checkInt(int arraySize, String suposedlyAnInteger){
		int checkemdubs;
		try {
			checkemdubs = Integer.parseInt(suposedlyAnInteger);
		} catch (NumberFormatException e) {
			checkemdubs = 0;
		}
		if(checkemdubs <= arraySize && checkemdubs > 0){
			return checkemdubs;
		}
		return 0;

	}
	
	public boolean isLastItem(int i){
		if(i == menuContent.size()){
			return true;
		}
		return false;
	}
}
