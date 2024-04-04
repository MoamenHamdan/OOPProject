package Moamen_Lorence;

import java.io.Serializable;

public class Country  implements Serializable {
	protected int CountryNumber;

	public Country() {
		super();
	}

	public Country(int CountryNumber) {
		super();
		this.CountryNumber = CountryNumber;
	}

	public int getCountryNumber() {
		return CountryNumber;
	}

	public void setCountryNumber(int CountryNumber) {
		this.CountryNumber = CountryNumber;
	}
	


}

