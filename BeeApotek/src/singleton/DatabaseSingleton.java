package singleton;

import java.util.ArrayList;

import models.Medicine;

public class DatabaseSingleton {
	public static volatile ArrayList<Medicine> instance = null;
	public static ArrayList<Medicine> getInstance(){
		if(instance == null) {
			synchronized(DatabaseSingleton.class) {
				if(instance == null) {
					instance = new ArrayList<Medicine>();
				}
			}
		}
		return instance;
	}
	public static void showDatabaseData() {
		for(int i = 0; i < instance.size(); i++) {
			System.out.println("Name: " + instance.get(i).getName());
			System.out.println("Id: " + instance.get(i).getId());
			System.out.println("Quantity: " + instance.get(i).getQuantity());
			System.out.println("Category: " + instance.get(i).getCategory());
			System.out.println("Type: " + instance.get(i).getType());
			System.out.println("Price: " + instance.get(i).getPrice()+"$");
			System.out.println("Price in Rupiah: Rp " + instance.get(i).getPrice() * 15+"k");
		}
	}
}
