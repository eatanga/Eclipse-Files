
import java.util.List;
import java.util.Scanner;

import controller.CarListHelper;
import model.CarList;




public class DisplayInventory {
	static Scanner in = new Scanner(System.in);
	static CarListHelper cli = new CarListHelper();
	
	//method to add new car to inventory
	public static void addCar() {
		// TODO Auto-generated method stub
		System.out.print("Please Enter a Car Company: ");
		String company = in.nextLine();
		System.out.print("Please enter a car name: ");
		String car = in.nextLine();
		
		CarList toAdd = new CarList(company, car);
		cli.addCar(toAdd);
	}
	//method to delete car from inventory
	public static void deleteCar() {
		// TODO Auto-generated method stub
		System.out.print("Enter the Company to delete: ");
		String company = in.nextLine();
		System.out.print("Enter the car to delete: ");
		String car = in.nextLine();
		
		CarList toDelete = new CarList(company, car);
		cli.deleteCar(toDelete);
	}
	// method to edit car or company entry
	public static void editCarEntry() {
		// TODO Auto-generated method stub
		System.out.println("How would you like to find your car? ");
		System.out.println("1 : Search by Car Company");
		System.out.println("2 : Search by Car name");
		int searchBy = in.nextInt();
		in.nextLine();
		List<CarList> foundCar = null;
		if (searchBy == 1) {
			System.out.print("Please enter the company name: ");
			String companyName = in.nextLine();
			foundCar = cli.searchForCarByCompany(companyName);
			
		} else {
			System.out.print("Please enter the Car name: ");
			String carName = in.nextLine();
			foundCar = cli.searchForCarByCar(carName);

		}

		if (!foundCar.isEmpty()) {
			System.out.println("Results found!");
			for (CarList l : foundCar) {
				System.out.println(l.getId() + " : " + l.toString());
			}
			System.out.print("Which ID do you wish to edit? ");
			int idToEdit = in.nextInt();

			CarList toEdit = cli.searchForCarById(idToEdit);
			System.out.println("Retrieved " + toEdit.getCar() + " from " + toEdit.getCompany());
			System.out.println("1 : Do you wish to update the company name?");
			System.out.println("2 :Do you wish to update car name?");
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				System.out.print("New Company name: ");
				String newCompany = in.nextLine();
				toEdit.setCompany(newCompany);
			} else if (update == 2) {
				System.out.print("New Car name: ");
				String newCar = in.nextLine();
				toEdit.setCar(newCar);
			}

			cli.updateCar(toEdit);

		} else {
			System.out.println("---- No results found");
		}

	}

	//default no arg constructor used to load menu
	public static void main(String[] args) {
		// TODO Auto-generated method stub
				openMenu();
	}
	//method to display menu
		public static void openMenu() {
			boolean doOver = true;
			System.out.println("--- Welcome to our awesome shopping list! ---");
			while (doOver) {
				System.out.println("*  Select an Option:");
				System.out.println("*  1 -- Add an Car");
				System.out.println("*  2 -- Delete a Car");
				System.out.println("*  3 -- view Inventory");
				System.out.println("*  4 -- Edit Car Entry");
				System.out.println("*  5 -- Exit");
				System.out.print("*  Your selection: ");
				int choice = in.nextInt();
				in.nextLine();

				if (choice == 1) {
					addCar();
				} else if (choice == 2) {
					deleteCar();
				} else if (choice == 3) {
					viewInventory();
				} else if (choice == 4) {
					editCarEntry();
				} else {
					cli.clearUp();
					System.out.println("   Thanks for Logging in!   ");
					doOver = false;
				}
			}

	}
		//method to view complete inventory
		public static void viewInventory() {
			List<CarList> inventory = cli.viewInventory();
			for(CarList singleCar : inventory){
			System.out.println(singleCar.displayCarInfo());
			}
		}
}
