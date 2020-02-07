import java.util.List;
import java.util.Scanner;

import controller.CarListHelper;
import model.CarList;



public class DisplayInventory {
	static Scanner in = new Scanner(System.in);
	static CarListHelper cli = new CarListHelper();
	private static void addNewCar() {
		// TODO Auto-generated method stub
		System.out.print("Please Enter a Car Company: ");
		String company = in.nextLine();
		System.out.print("Please enter a car name: ");
		String car = in.nextLine();
		
		CarList toAdd = new CarList(company, car);
		cli.addNewCar(toAdd);
	}

	private static void deleteCar() {
		// TODO Auto-generated method stub
		System.out.print("Enter the store to delete: ");
		String company = in.nextLine();
		System.out.print("Enter the item to delete: ");
		String car = in.nextLine();
		
		CarList toDelete = new CarList(company, car);
		cli.deleteCar(toDelete);
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
				openMenu();
	}
		public static void openMenu() {
			boolean doOver = true;
			System.out.println("--- Welcome to our awesome shopping list! ---");
			while (doOver) {
				System.out.println("*  Select an Option:");
				System.out.println("*  1 -- Add an Car");
				System.out.println("*  2 -- Delete a Car");
				System.out.println("*  3 -- view Inventory");
				System.out.println("*  4 -- Exit");
				System.out.print("*  Your selection: ");
				int choice = in.nextInt();
				in.nextLine();

				if (choice == 1) {
					addNewCar();
				} else if (choice == 2) {
					deleteCar();
				} else if (choice == 3) {
					viewInventory();	
				} else {
					cli.clearUp();
					System.out.println("   Thanks for Logging in!   ");
					doOver = false;
				}
			}

	}

		private static void viewInventory() {
			List<CarList> inventory = cli.showInventory();
			for(CarList singleItem : inventory){
			System.out.println(singleItem.displayCarInfo());
			}
		}
}
