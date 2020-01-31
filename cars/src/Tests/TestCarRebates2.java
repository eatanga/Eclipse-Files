package Tests;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;

import cars.Cars;
import cars.CarsLogic;

public class TestCarRebates2 {
CarsLogic carsL = new CarsLogic();
Cars car = new Cars();
	@Before
	public void setUp() throws Exception {
	}

	public void testIsEligible() {
		car.setAge(8);
		assertTrue(carsL.isEligible(car));
	}
}
