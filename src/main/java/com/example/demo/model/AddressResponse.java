package com.example.demo.model;

public class AddressResponse {

	private String country;
	private String city;
	private String zipcode;
	private String streetName;
	private String streetAddress;
	
	public AddressResponse() {
		super();
	}

	public AddressResponse(String country, String city, String zipcode, String streetName, String streetAddress) {
		super();
		this.country = country;
		this.city = city;
		this.zipcode = zipcode;
		this.streetName = streetName;
		this.streetAddress = streetAddress;
	}

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getZipcode() {
    return zipcode;
  }

  public void setZipcode(String zipcode) {
    this.zipcode = zipcode;
  }

  public String getStreetName() {
    return streetName;
  }

  public void setStreetName(String streetName) {
    this.streetName = streetName;
  }

  public String getStreetAddress() {
    return streetAddress;
  }

  public void setStreetAddress(String streetAddress) {
    this.streetAddress = streetAddress;
  }
	
	
}
