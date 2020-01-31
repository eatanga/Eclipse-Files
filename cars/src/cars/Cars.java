//Emmanuel Atanga

package cars;

public class Cars {
	private String name;
	private double price;
	private int age;

	// default no argument constructors
	public Cars() {
		// TODO Auto-generated constructor stub
	}
	//parameterized constructor
	public Cars(String name) {
		this.name = name;
	}
	// methods to calculate rebate discounts
	 public double calculateDiscount(Cars car) {
		 double discount = 0;
		 if(car.getPrice()<=20000) {
			 discount = car.getPrice() * 0.2;
		 }else {
			 if(car.getPrice()<=40000 && car.getPrice()>=21000) {
				 discount = car.getPrice() * 0.35;
			 }else {
				 if(car.getPrice()>=41000) {
					 discount = car.getPrice() * 0.4;
				 }
			 }
		 }
		return discount;
	 }
	 
	 public double calculateSalePrice(Cars car) {
		 double salePrice;
		 salePrice = car.getPrice() - calculateDiscount(car);
		 return salePrice;
	 }

	
	 //getters and setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int year) {
		this.age = year;
	}
	 

	 
}
