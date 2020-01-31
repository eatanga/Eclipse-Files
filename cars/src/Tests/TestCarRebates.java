package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cars.Cars;
import cars.CarsLogic;

class TestCarRebates {
	Cars car = new Cars("Sedan");
	CarsLogic carsL = new CarsLogic();
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	public void testCalculateSalePrice() {
		car.setPrice(16000);
		double discountPrice = carsL.calculateSalePrice(car);
		assertEquals(12800, discountPrice);
	}

	@Test
	public void testCalculateDiscount() {
		car.setPrice(38000);
		double discountPrice = carsL.calculateDiscount(car);
		assertEquals(13300, discountPrice);
	}
	
}
