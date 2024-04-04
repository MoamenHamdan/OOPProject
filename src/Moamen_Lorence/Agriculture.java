package Moamen_Lorence;

import java.util.Scanner;
import java.io.Serializable;

public class Agriculture extends AnestheticLand implements Serializable {
	public String cropToBeSeeded;


	public Agriculture() {
		this(null);
	}

	public Agriculture(String NameOfPerson, int idOfLand, double area, double PriceOfOneMeter, int CountryNumber) {
		super(NameOfPerson, idOfLand, area, PriceOfOneMeter, CountryNumber);
		this.cropToBeSeeded = cropToBeSeeded;
	}

	
	public Agriculture(String cropToBeSeeded) {
		
		this.cropToBeSeeded=cropToBeSeeded;

	}

	public String getCropToBeSeeded() {
		return cropToBeSeeded;
	}

	public void setCropToBeSeeded(String cropToBeSeeded) {
		this.cropToBeSeeded = cropToBeSeeded;
	}

	public void Display() {
		System.out.println("The crop  to be seeded :" + cropToBeSeeded);
	}

	

	public void ReadDetailsOfAgricultureLand() {
		Scanner scan = new Scanner(System.in);
		super.ReadAnestheticLandInformation();
		System.out.print("Please enter the *TYPE OF CROP* that you intend to plant  on the land , as needed or instructed : ");
		 setCropToBeSeeded(scan.next());
	}

	
	public double priceOfLand() {
		return super.area*super.PriceOfOneMeter;
	}

}
