package app.core.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "company_address")
public class CompanyAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String city;
	private String country;
	@OneToOne(mappedBy = "address", cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	private Company company;

	public CompanyAddress() {
	}

	public CompanyAddress(int id, String city, String country) {
		super();
		this.id = id;
		this.city = city;
		this.country = country;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "CompanyAddress [id=" + id + ", city=" + city + ", country=" + country + "]";
	}

}
