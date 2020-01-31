package cars;

public class CarsLogic {
	public double calculateDiscount(Cars car) {
		return car.calculateDiscount(car);
	}
	public double calculateSalePrice(Cars car) {
		return car.calculateSalePrice(car);
	}
	public boolean isEligible(Cars car) {
		if(car.getAge()<3) {
		return true;
	}else {
		return false;
	}
	}
}
