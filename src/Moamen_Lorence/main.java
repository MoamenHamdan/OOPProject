package Moamen_Lorence;

import java.util.Scanner;
import java.io.*;

public class main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.println("\t\t\t\t\t\t\t\t\t\t Welcome !");
			System.out.print(
					"Can you please provide us with more information or context about the province you are referring to?  ");
			String name = scanner.nextLine().trim();
			if (name.isEmpty()) {
				throw new IllegalArgumentException("Province name cannot be empty");
			}
			System.out.println("");

			System.out.print("What is the highest numerical value in " + name + " : ");
			int MAX = scanner.nextInt();
			if (MAX <= 0) {
				throw new IllegalArgumentException("Maximum number of lands must be positive");
			}
			System.out.println("");

			Province province = new Province(MAX, name);

			System.out.print("Please specify the exact number of lands that you wish to include: ");
			int number = scanner.nextInt();
			if (number <= 0 || number > MAX) {
				throw new IllegalArgumentException("Number of lands must be positive and not exceed " + MAX);
			}
			System.out.println("\n---------------------------------------------------------------------------------");
			for (int i = 0; i < number; i++) {
				System.out.print(
						"\nKindly indicate your preferred option by entering a corresponding number - press 1 to select agriculture or press 2 to choose construction:");

				int choose = scanner.nextInt();
				System.out.println("\n---------------------------------------------------------------------------------");
				System.out.println("\n---------------------------------------------------------------------------------");

				if (choose == 1) {
					Agriculture agriculture = new Agriculture();
					System.out.println(
							"\nPlease provide the necessary details and data pertaining to the agricultural sector or domain, as required or requested ");
					agriculture.ReadAnestheticLandInformation();

					if (province.AddAnestheticLand(agriculture))
						System.out.println(
								"\nThe addition has been successfully completed  as per the requirements provided !");

					else
						System.out.println(
								"\nThe land that you are attempting to add has already been included or registered previously, as per the available records or database!");

				}

				else if (choose == 2) {
					System.out.println(
							"\nPlease provide the necessary details and data related to the construction sector or domain, as required or requested");
					Construction construction = new Construction();
					construction.ReadAnestheticLandInformation();

					if (province.AddAnestheticLand(construction))
						System.out.println(
								"\nThe addition has been successfully completed  as per the requirements provided !");

					else
						System.out.println(
								"\nThe land that you are attempting to add has already been included or registered previously, as per the available records or database!");

				}

				else {
					System.out.println(
							"\nInvalid choice. Please enter 1 for agriculture or 2 for construction.");
					i--;
				}
			}
			System.out.println("\n---------------------------------------------------------------------------------");
			System.out.println("\nThe complete list of registered lands is as follows. ");
			province.displayAllLands();
			System.out.println("\n---------------------------------------------------------------------------------");
			if (province.isFull() == true) {
				System.out.println("\n" + name + " is FULL");

			} else {
				System.out.println("\n" + name + " is NOT full you can add later land if you need ");
			}

			if (province.isEmpty() == true) {
				System.out.println("\n " + name + " is EMPTY");
			} else {
				System.out.println("\n" + name + " is NOT EMPTY any more  ");
			}
			System.out.println("\n---------------------------------------------------------------------------------");
			System.out.print(
					"\nPlease indicate the precise number of lands that you wish to remove or delete from the current quantity : ");
			int remove = scanner.nextInt();

			for (int i = 0; i < remove; i++) {
				System.out.print("\nEnter the id of the land you want to delete : ");
				int id = scanner.nextInt();

				if (province.DeleteAnestheticLand(id)) {
					System.out.println("The Land of id " + id + " is deleted.");

				} else {
					System.out.println("The Land of id " + id + " doesn't exist.");
				}
			}
			System.out.println("\n---------------------------------------------------------------------------------");
			System.out.println("\nThe number after deleting is : " + province.getNumberOfAnestheticLands());
			System.out.println("\n---------------------------------------------------------------------------------");
			System.out.println("\nThe total count  of agricultural lands within this province is as follows "
					+ province.FindNumberOfAgricultureLands());
			System.out.println("The total count  of construction lands within this province is as follows "
					+ province.FindNumberOfConstructionLands());
			System.out.println("\n---------------------------------------------------------------------------------");
			System.out.print(
					"\nPlease specify the exact number of lands for which you wish to modify or update the information, as required or instructed. ");
			int update = scanner.nextInt();

			for (int i = 0; i < update; i++) {
				System.out.print("Enter the id of the land you want to update: ");
				int id = scanner.nextInt();
				if (province.UpdateLandInformation(id))
					System.out.println("The Land of id " + id + " is updated.");
				else
					System.out.println("The Land of id " + id + " doesn't exist.");
			}

			System.out.println("\nAll lands in " + province.getName() + " after updates:");
			province.displayAllLands();

			System.out.println("\n---------------------------------------------------------------------------------");
			System.out.print(
					"Please input or provide the unique identification associated with the first land that you wish to *MERGE*  with another land : ");
			int FID = scanner.nextInt();
			System.out.print(
					"Please input or provide the unique identification associated with the second land that you wish to *MERGE*  with another land : ");
			int SID = scanner.nextInt();
			if (province.MergeTwoLands(FID, SID))
				System.out.println(
						"The merging of the lands has been completed successfully and as per the specified instructions.");
			else
				System.out.println(
						"The merging  of the lands could not be completed due to an error or issue, please review the instructions and try again.");

			System.out.println("\nAll lands in " + province.getName() + " after merging:");
			province.displayAllLands();

			System.out.println("\n---------------------------------------------------------------------------------");
			System.out.print("Enter the id of the land you want to split: ");
			int oldID = scanner.nextInt();
			System.out.print("Enter the id of the new land that will appear: ");
			int newID = scanner.nextInt();
			System.out.print("Enter the percentage that you want to be splitted from the land: ");
			double per = scanner.nextDouble();
			if (province.SplitLand(oldID, newID, per)) {
				System.out.println("Land of id " + oldID + " split successfully.");
				System.out.println("All lands in " + name + " after split:");
				province.displayAllLands();
				System.out.println();
			} else {
				System.out.println("Unable to split land of id " + oldID + ".");
			}
			System.out.println("\n---------------------------------------------------------------------------------");
			System.out.println("Please enter the name of the agricuture file : ");
			String agriculture = scanner.next();
			System.out.println("Please enter the name of the construction file : ");
			String construction = scanner.next();
			province.SaveData(agriculture, construction);
			System.out.println("\n---------------------------------------------------------------------------------");
			province.TakeAgricultureinfoFromFile(agriculture);
			System.out.println("Please enter the id of the agriculture land: ");
			int moamen = scanner.nextInt();
			System.out.println(province.PriceOfAgricultureLandsById(agriculture, moamen));
			System.out.println("\n---------------------------------------------------------------------------------");
			province.TakeConstructioninfoFromFile(construction);
			System.out.println("Please enter the id of the  construction land: ");
			int lorence = scanner.nextInt();
			System.out.println(province.PriceOfConstructionLandsById(construction, lorence));
			System.out.println("\n---------------------------------------------------------------------------------");
			province.PriceOfAgricultureLandsById(agriculture, moamen);
			province.PriceOfConstructionLandsById(construction, lorence);
			System.out.println("\n---------------------------------------------------------------------------------");
			System.out.println("Enter the ID for Second Method to find the price ");
			int id=scanner.nextInt();
			province.SecondMethodToFindPriceOfLandsById(id);
		} catch (Exception e) {
			System.err.println("An error occurred: " + e.getMessage());
			e.printStackTrace();
		} finally {
			scanner.close();
		}
	}
}
