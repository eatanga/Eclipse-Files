/*
 * Author : Emmanuel Atanga
 * Date: 02/12/2020
 *  This is a POJO called Dollar Converter, that converts from dollars to international currencies
 *  calculates the interest rate.
 *  this is to be used to demonstrate a JSP web application using servlets.
 */
package model;

public class DollarConverter {
	
	private double dollars;
	private double pesos;
	private double euros;
	private double pounds;
	private double franc;
	private double yen;
	public double interest;
	
	public DollarConverter() {
		super();
	}
	
	public DollarConverter(double dollars) {
		super();
		this.dollars = dollars;
		setAmount(dollars);
		setInterest(dollars);
	}
	public void setDollars(double dollars) {
		this.dollars = dollars;
		setAmount(dollars);
		setInterest(dollars);
	}

	private void setPesos(double pesos) {
		this.pesos = pesos;
	}

	private void setEuros(double euros) {
		this.euros = euros;
	}

	private void setPounds(double pounds) {
		this.pounds = pounds;
	}

	private void setFranc(double franc) {
		this.franc = franc;
	}

	private void setYen(double yen) {
		this.yen = yen;
	}
	
	
	
	public double getDollars() {
		return dollars;
	}

	public double getPesos() {
		return pesos;
	}

	public double getEuros() {
		return euros;
	}

	public double getPounds() {
		return pounds;
	}

	public double getFranc() {
		return franc;
	}

	public double getYen() {
		return yen;
	}
//To calculate interest
	public void setInterest(double dollars) {
		final double INT_RATE =0.425;
		this.interest = dollars * INT_RATE;
		setAmount(dollars);
		}
	

	public double getInterest() {
		return this.interest;
	}
// converts to froreign currency
	public void setAmount(double dollars) {
		final double PESOS = 61.16;
		final double EUROS = 0.92;
		final double POUNDS = 0.77;
		final double FRANC = 0.98;
		final double YEN = 109.96;
		
		setPesos(dollars * PESOS);
		setEuros(dollars * EUROS);
		setPounds(dollars * POUNDS);
		setFranc(dollars * FRANC);
		setYen(dollars * YEN);
	}


	@Override
	public String toString() {
		return "DollarConverter [" + dollars +" dollars is equivalent to: " + pesos + " pesos |  " + euros + " euros |  " + pounds + " pounds |  " 
				+ franc + " franc |  " +  yen + " yen  " + "]";
	}
	
}
