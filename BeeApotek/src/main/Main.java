package main;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

import adapters.Rupiah;
import adapters.RupiahAdapter;
import models.Medicine;
import factories.ColdFactory;
import factories.CoughFactory;
import factories.FluFactory;
import factories.HeadacheFactory;
import factories.MedicineFactory;
import singleton.DatabaseSingleton;

public class Main {
	Scanner scan = new Scanner(System.in);
	ArrayList<Medicine> database = DatabaseSingleton.getInstance();
	MedicineFactory coldFactory = new ColdFactory(); 
	MedicineFactory fluFactory = new FluFactory();
	MedicineFactory coughFactory = new CoughFactory();
	MedicineFactory headacheFactory = new HeadacheFactory();
	RupiahAdapter rupiahAdapter;
	public void menu() {
		System.out.println("BeeApotek");
		System.out.println("=========");
		System.out.println("1. Add a medicine");
		System.out.println("2. View all medicine");
		System.out.println("3. Delete a medicine");
		System.out.println("4. Update medicine");
		System.out.println("5. Exit");
		System.out.print("Choose option: ");
	}

	public Main() {
		
		
		Integer input = 0;
		menu();
		input = scan.nextInt();
		scan.nextLine();
		switch(input) {
		case 1:
			addMedicine();
			break;
		case 2: 
			showMedicine();
			break;
		case 3:
			deleteMedicine();
			break;
		case 4:
			updateMedicine();
			break;
		case 5:
			System.exit(0);
			break;
		}
		
	}
	
	public void addMedicine() {
		String name;
		do {
			System.out.print("Enter Medicine name[5-15 characters]: ");
			name = scan.next();
			scan.nextLine();
		}
		while(name.length() < 5 || name.length() > 15);
		String id;
		String regex = "^[A-Za-z]{2}[0-9]{2}$"; 
		do {
			System.out.println("Enter Medicine ID [2 Alphabets followed by 2 Numbers]: ");
			id = scan.next();
			scan.nextLine();
		}while(!Pattern.matches(regex, id));
		int quantity;
		do {
			System.out.println("Enter Medicine Quantity [1-100]: ");
			quantity = scan.nextInt();
			scan.nextLine();
		}while(quantity < 0 || quantity > 100);
	    String category;
	    do {
	    	System.out.println("Enter Medicine Category [Cold | Cough | Flu | Headache] [non-case sensitive]: ");
			category = scan.next();
			scan.nextLine();
	    }while(!category.equalsIgnoreCase("Cold")&&!category.equalsIgnoreCase("Cough")&&!category.equalsIgnoreCase("Flu")&&!category.equalsIgnoreCase("Headache"));
		String type;
		do {
			System.out.print("Enter Medicine Type [Syrup | Tablet | Pill] [non-case sensitive]: ");
			type = scan.next();
			scan.nextLine();
		}
		while(!type.equalsIgnoreCase("Syrup") && !type.equalsIgnoreCase("Tablet")&& !type.equalsIgnoreCase("Pill"));
		int price;
		do {
			System.out.println("Enter medicine price(must be between 5-50): ");
			price = scan.nextInt();
			scan.nextLine();
		}while(price < 5 || price > 50);
		
		if(category.equalsIgnoreCase("Cold")) {
			rupiahAdapter = new RupiahAdapter(new Rupiah());
			Medicine medicine = coldFactory.createMedicine(name,id,quantity,category,type,price);
			int calculateRupiah = rupiahAdapter.calculateRupiahPrice(medicine);
			System.out.println(category + " " + type +" Medicine with the price of Rp " + calculateRupiah +"k have been added to the system.");
		
			database.add(medicine);
		}
		else if(category.equalsIgnoreCase("Flu")){
			Medicine medicine = fluFactory.createMedicine(name,id,quantity,category,type,price);
			rupiahAdapter = new RupiahAdapter(new Rupiah());
			int calculateRupiah = rupiahAdapter.calculateRupiahPrice(medicine);
			System.out.println(category + " " + type +" Medicine with the price of Rp " + calculateRupiah +"k have been added to the system.");
			
			database.add(medicine);
		}
		else if(category.equalsIgnoreCase("Cough")) {
			Medicine medicine = coughFactory.createMedicine(name,id,quantity,category,type,price);
			rupiahAdapter = new RupiahAdapter(new Rupiah());
			int calculateRupiah = rupiahAdapter.calculateRupiahPrice(medicine);
			System.out.println(category + " " + type +" Medicine with the price of Rp " + calculateRupiah +"k have been added to the system.");
			
			database.add(medicine);
		}
		else{
			Medicine medicine = headacheFactory.createMedicine(name,id,quantity,category,type,price);
			rupiahAdapter = new RupiahAdapter(new Rupiah());
			int calculateRupiah = rupiahAdapter.calculateRupiahPrice(medicine);
			System.out.println(category + " " + type +" Medicine with the price of Rp " + calculateRupiah +"k have been added to the system.");
			
			database.add(medicine);
		}
		System.out.println("Press Enter to Continue... ");
		scan.nextLine();
		main(null);
		
	}
	
	public void showMedicine() {
		
		System.out.println("View Medicine List");
		System.out.println("==================");
		DatabaseSingleton.showDatabaseData();
		System.out.println("Press Enter to Continue... ");
		scan.nextLine();
		main(null);
	}
	
	public void deleteMedicine() {
		String deletedmedicine;
		System.out.println("Delete medicine");
		System.out.println("===============");
		System.out.println("Medicine Available: ");
		DatabaseSingleton.showDatabaseData();
		
		for(int i = 0; i < database.size(); i++) {
			do {
				System.out.print("Please input the medicine name that want to be deleted: ");
				deletedmedicine = scan.nextLine();
				
			}
			while(!database.get(i).getName().equals(deletedmedicine));
			database.remove(i);
			System.out.println("medicine has been deleted!");
			break;
		}
		System.out.println("Press Enter to Continue... ");
		scan.nextLine();
		main(null);
	}
	
	public void updateMedicine() {
	    System.out.println("Update medicine");
	    System.out.println("==========");
	    DatabaseSingleton.showDatabaseData();
	   

	    boolean medicineFound = false;
	    String name = null;

	    do {
	        System.out.print("Please choose the medicine name to be edited: ");
	        name = scan.nextLine();

	        for (Medicine medicine : database) {
	            if (medicine.getName().equalsIgnoreCase(name)) {
	                medicineFound = true;

	                int newQuantity;
	                do {
	                    System.out.print("Enter new medicine quantity [1-100]: ");
	                    newQuantity = scan.nextInt();
	                } while (newQuantity < 0 || newQuantity > 100);
	                medicine.setQuantity(newQuantity);
	                int newPrice;
	        		do {
	        			System.out.println("Enter new medicine price(must be between 5-50): ");
	        			newPrice = scan.nextInt();
	        			scan.nextLine();
	        		}while(newPrice < 5 || newPrice > 50);
	        		medicine.setPrice(newPrice);
	                System.out.println("Medicine have been updated successfully!");
	                scan.nextLine();
	                break;
	            }
	        }

	        if (!medicineFound) {
	            System.out.println("medicine with the name '" + name + "' not found. Please try again.");
	        }

	    } while (!medicineFound);

	    DatabaseSingleton.showDatabaseData();
	    System.out.println("Press Enter to Continue... ");
		scan.nextLine();
	    main(null);
	}

	public static void main(String[] args) {
		new Main();
	}

}
