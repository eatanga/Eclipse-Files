import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import controller.PurchaseDetailsHelper;
import model.Buyer;
import model.CarList;
import model.PurchaseDetails;

public class BuyerTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*Buyer emile = new Buyer("Emile");

		BuyerHelper bh = new BuyerHelper();

		bh.insertBuyer(emile);

		List<Buyer> allBuyers = bh.showAllBuyers();
		for (Buyer a : allBuyers) {
			System.out.println(a.toString());
		}
	
		PurchaseDetailsHelper pdh = new PurchaseDetailsHelper();
		PurchaseDetails emileList = new PurchaseDetails("Emile's Inventory", LocalDate.now(), emile);

		pdh.insertNewPurchaseDetails(emileList);
		
		List<PurchaseDetails> allInventory = pdh.getLists();
		for (PurchaseDetails a : allInventory) {
			System.out.println(a.toString());
		}
		 */
		Buyer john = new Buyer("John");
		
		PurchaseDetailsHelper pdh = new PurchaseDetailsHelper();
		
		CarList sentra = new CarList("Hyndai", "Sentra");
		CarList malibu = new CarList("Chevy", "Malibu");
		
		List<CarList> johnsCars = new ArrayList<CarList>();
		johnsCars.add(sentra);
		johnsCars.add(malibu);
		
		PurchaseDetails johnsInventory = new PurchaseDetails("John's car inventory", LocalDate.now(), john);
		johnsInventory.setCarInventory(johnsCars);
		
		pdh.insertNewPurchaseDetails(johnsInventory);
		
		
		List<PurchaseDetails> allInventory = pdh.getInventory();
		for(PurchaseDetails a: allInventory) {
			System.out.println(a.toString());
		}
		

	}

}
