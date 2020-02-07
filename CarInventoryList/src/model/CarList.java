package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cars")
public class CarList {
	//attributes and instance variables
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY )
	@Column(name="ID")
		private int id;
	@Column(name="COMPANY")
		private String company;
	@Column(name="CAR")
		private String car;

	public CarList() {
		super();
		// TODO Auto-generated constructor stub
	}
	//getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCar() {
		return car;
	}

	public void setCar(String car) {
		this.car = car;
	}
	//Helper methods
	public CarList(String company, String car) {
		super();
		this.company = company;
		this.car = car;
	}
	
	public String displayCarInfo() {
		return company + ":" + car;
	}
	
}
