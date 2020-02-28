package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "purchase_details")
public class PurchaseDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "INV_ID")
	private int id;
	@Column(name = "CAR_NAME")
	private String purchName;
	@Column(name = "DATE")
	private LocalDate purchDate;
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="BUYER_ID")
	private Buyer buyer;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	@JoinTable
	  (
	      name="cars_on_list",
	      joinColumns={ @JoinColumn(name="INV_ID", referencedColumnName="INV_ID") },
	      inverseJoinColumns={ @JoinColumn(name="CAR_ID", referencedColumnName="ID", unique=true) }
	  )

	private List<CarList> carInventory;
	
	
	public PurchaseDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PurchaseDetails(int id, String purchName, LocalDate purchDate, Buyer buyer, List<CarList> carInventory) {
		super();
		this.id = id;
		this.purchName = purchName;
		this.purchDate = purchDate;
		this.buyer = buyer;
		this.carInventory = carInventory;
	}
	
	public PurchaseDetails( String purchName, LocalDate purchDate, Buyer buyer, List<CarList> carInventory) {
		super();
		this.purchName = purchName;
		this.purchDate = purchDate;
		this.buyer = buyer;
		this.carInventory = carInventory;
	}
	
	public PurchaseDetails( String purchName, LocalDate purchDate, Buyer buyer) {
		super();
		this.purchName = purchName;
		this.purchDate = purchDate;
		this.buyer = buyer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPurchName() {
		return purchName;
	}

	public void setPurchName(String purchName) {
		this.purchName = purchName;
	}

	public LocalDate getPurchDate() {
		return purchDate;
	}

	public void setPurchDate(LocalDate purchDate) {
		this.purchDate = purchDate;
	}

	public Buyer getBuyer() {
		return buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}

	public List<CarList> getCarInventory() {
		return carInventory;
	}

	public void setCarInventory(List<CarList> carInventory) {
		this.carInventory = carInventory;
	}

	@Override
	public String toString() {
		return "PurchaseDetails [id=" + id + ", purchName=" + purchName + ", purchDate=" + purchDate + ", buyer="
				+ buyer + ", carInventory=" + carInventory + "]";
	}
	
	
	
	

}
