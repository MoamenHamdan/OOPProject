package Moamen_Lorence;

import java.io.Serializable;
import java.util.Scanner;

public class Construction extends AnestheticLand implements Serializable{
	private int numberOfLevels;
	private String typeOfSoil;
	
	


	public Construction(int numberOfLevels, String typeOfSoil, String nameOfPerson, int idOfLand, double area,
		double priceOfOneMeter, int CountryNumber) {
		super(nameOfPerson, idOfLand, area, priceOfOneMeter, CountryNumber);
		this.numberOfLevels = numberOfLevels;
		this.typeOfSoil = typeOfSoil;
	}

	public Construction(int numberOfLevels, String typeOfSoil) {
		this.numberOfLevels = numberOfLevels;
		this.typeOfSoil = typeOfSoil;
	}

	public Construction() {
		this(0, null);
	}

	public int getNumberOfLevels() {
		return numberOfLevels;
	}

	public void setNumberOfLevels(int numberOfLevels) {
		this.numberOfLevels = numberOfLevels;
	}

	public String getTypeOfSoil() {
		return typeOfSoil;
	}

	public void setTypeOfSoil(String typeOfSoil) {
		this.typeOfSoil = typeOfSoil;
	}

	public void Display() {
		super.Display();
		System.out.println("The number of levels : " + numberOfLevels);
		System.out.println("The type of the soil : " + typeOfSoil);
	}

	

	public void ReadDetailsOfConstructionLand() {
		Scanner scan = new Scanner(System.in);
		super.ReadAnestheticLandInformation();
		System.out.println("Please provide the total *NUMBER OF LEVELS* or storeys associated with the  building : ");
		setNumberOfLevels(scan.nextInt());
		scan.nextLine();
		System.out.println("Please specify the nature or *CATEGORY OF SOIL* present or desired, as applicable or instructed : ");
		setTypeOfSoil(scan.nextLine());
	}

	public double priceOfLand() {
		return PriceOfOneMeter * area * (1 + 0.1 * numberOfLevels);

	}


}

