package Moamen_Lorence;

import java.io.Serializable;
import java.util.Scanner;

    abstract public class AnestheticLand extends Country implements LandPrice ,Serializable {
	protected String NameOfPerson;
	protected int idOfLand;
	protected double area, PriceOfOneMeter;
	

	public AnestheticLand() {
		this(null, 0, 0, 0, 0);
	}

	public AnestheticLand(String NameOfPerson, int idOfLand, double area, double PriceOfOneMeter, int CountryNumber) {
		super(CountryNumber);
		this.NameOfPerson = NameOfPerson;
		this.idOfLand = idOfLand;
		this.area = area;
		this.PriceOfOneMeter = PriceOfOneMeter;
	}

	
	public AnestheticLand(AnestheticLand land) {
		super(land.CountryNumber);
		area=land.area;
		idOfLand=land.idOfLand;
		NameOfPerson=land.NameOfPerson;
		
	}

	public String getNameOfPerson() {
		return NameOfPerson;
	}

	public void setNameOfPerson(String NameOfPerson) {
		this.NameOfPerson = NameOfPerson;
	}

	public int getIdOfLand() {
		return idOfLand;
	}

	public void setIdOfLand(int idOfLand) {
		this.idOfLand = idOfLand;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public double getPriceOfOneMeter() {
		return PriceOfOneMeter;
	}

	public void setPriceOfOneMeter(double priceOfOneMeter) {
		PriceOfOneMeter = priceOfOneMeter;
	}

	public void Display() {
		System.out.println("The name of the person is :" + NameOfPerson);
		System.out.println("The id of the land :" + idOfLand);
		System.out.println("The area of the land :" + area);
		System.out.println("The price of one meter :" + PriceOfOneMeter);
	}

	
	
	public void ReadAnestheticLandInformation() {
		Scanner scan = new Scanner(System.in);
		System.out.print("\nKindly input or provide the *FIRST NAME* of the individual in question, as needed or instructed :");
		setNameOfPerson(scan.next());
		System.out.print("\nPlease enter the unique identification or the *ID* associated with the land, as specified or required : ");
		 setIdOfLand(scan.nextInt());
		System.out.print("\nPlease input or provide the total size or *AREA* of the land : ");
		 setArea(scan.nextDouble());
		System.out.print("\nPlease specify the *PRICE* attributed to a single unit of measurement for the length of the land in $ : ");
		 setPriceOfOneMeter(scan.nextDouble());
	}




	

}
