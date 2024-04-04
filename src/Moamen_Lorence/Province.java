package Moamen_Lorence;

import java.io.*;
import java.util.Arrays;
import java.io.Serializable;
public class Province  implements Serializable {
	private String name;
	private int numberOfAnestheticLands;
	private AnestheticLand[] Land;
	private static int agricultureCount;
	private static int constructionCount;

	public Province(int size, String n) {
		name = n;
		Land = new AnestheticLand[size];
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumberOfAnestheticLands() {
		return numberOfAnestheticLands;
	}

	public void setNumberOfAnestheticLands(int numberOfAnestheticLands) {
		this.numberOfAnestheticLands = numberOfAnestheticLands;
	}

	public AnestheticLand[] getL() {
		return Land;
	}

	public void setL(AnestheticLand[] Land) {
		this.Land = Land;
	}

	public boolean isFull() {
		for (int i = 0; i < Land.length; i++) {
			if (Land[i] == null)
				return false;
		}
		return true;
	}

	public boolean isEmpty() {
		for (int i = 0; i < Land.length; i++) {
			if (Land[i] != null)
				return false;
		}
		return true;
	}

	public boolean AddAnestheticLand(AnestheticLand land) {
		if (numberOfAnestheticLands < Land.length) {
			for (int i = 0; i < numberOfAnestheticLands; i++) {
				if (Land[i].idOfLand == land.idOfLand) {
					return false;
				}
			}
			Land[numberOfAnestheticLands] = land;
			numberOfAnestheticLands++;
			return true;
		}
		return false;
	}

	public boolean DeleteAnestheticLand(int idOfLand) {
		if (searchLandById(idOfLand) >= -1) {
			for (int i = searchLandById(idOfLand); i < numberOfAnestheticLands - 1; i++) {
				Land[i] = Land[i + 1];
			}
			Land[numberOfAnestheticLands - 1] = null;
			numberOfAnestheticLands--;
			return true;
		}
		return false;
	}

	public int searchLandById(int idofland) {
		for (int i = 0; i < numberOfAnestheticLands; i++) {
			if (Land[i].idOfLand == idofland) {
				return i;
			}
		}
		return -1;
	}

	public void displayAllLands() {
		for (int i = 0; i < numberOfAnestheticLands; i++) {
			Land[i].Display();
			System.out.println();
		}
	}

	public int FindNumberOfAgricultureLands() {
//		int a = 0;
		for (int i = 0; i < numberOfAnestheticLands; i++) {
			if (Land[i] instanceof Agriculture) {
				agricultureCount++;
			}
		}
		return agricultureCount;
	}

	public int FindNumberOfConstructionLands() {
//		int c = 0;
		for (int i = 0; i < numberOfAnestheticLands; i++) {
			if (Land[i] instanceof Construction) {
				constructionCount++;
			}
		}
		return constructionCount;
	}

	public boolean UpdateLandInformation(int idofland) {
		if (searchLandById(idofland) > -1) {
			int i = searchLandById(idofland);
			Land[i].ReadAnestheticLandInformation();
			;
			return true;
		} else
			return false;
	}

	public boolean MergeTwoLands(int idOfLandOne, int idOfLandTwo) {
		int moamen, lorence;
		moamen = searchLandById(idOfLandOne);
		lorence = searchLandById(idOfLandTwo);
		if (moamen == -1 || lorence == -1) {
			return false;
		}
		Land[moamen].setArea(Land[moamen].getArea() + Land[lorence].getArea());
		Land[moamen].setPriceOfOneMeter(Land[moamen].getPriceOfOneMeter() + Land[lorence].getPriceOfOneMeter());
		return DeleteAnestheticLand(idOfLandTwo);
	}

	public boolean SplitLand(int oldID, int newID, double presentage) {
		int moamen = searchLandById(oldID);
		if (moamen > -1 && searchLandById(newID) == -1) {
			if (Land[moamen] instanceof Agriculture) {
				Agriculture lorence = new Agriculture();
				lorence.setIdOfLand(newID);
				lorence.setArea(Land[moamen].getArea() * presentage / 100);
				lorence.setPriceOfOneMeter(Land[moamen].getPriceOfOneMeter());
				lorence.setNameOfPerson(Land[moamen].getNameOfPerson());
				lorence.CountryNumber = Land[moamen].CountryNumber;
				lorence.setCropToBeSeeded(((Agriculture) Land[moamen]).getCropToBeSeeded());
				Land[moamen].setArea(Land[moamen].getArea() - lorence.getArea());
				return AddAnestheticLand(lorence);
			} else if (Land[moamen] instanceof Construction) {
				Construction lorence = new Construction();
				lorence.setIdOfLand(newID);
				lorence.setArea(Land[moamen].getArea() * presentage / 100);
				lorence.setPriceOfOneMeter(Land[moamen].getPriceOfOneMeter());
				lorence.setNameOfPerson(Land[moamen].getNameOfPerson());
				lorence.CountryNumber = Land[moamen].CountryNumber;
				lorence.setNumberOfLevels(((Construction) Land[moamen]).getNumberOfLevels());
				lorence.setTypeOfSoil(((Construction) Land[moamen]).getTypeOfSoil());
				Land[moamen].setArea(Land[moamen].getArea() - lorence.getArea());
				return AddAnestheticLand(lorence);
			}
		}
		return false;
	}
	public void SaveData(String agriculture,String construction)throws IOException {
	  
		File fileAgriculture =new File(agriculture);
		File fileConstruction =new File(construction);
		fileAgriculture.createNewFile();
		fileAgriculture.createNewFile();
				ObjectOutputStream A = new ObjectOutputStream(new FileOutputStream(fileAgriculture));
				
		for(int i=0;i<numberOfAnestheticLands;i++) {
			if(Land[i] instanceof Agriculture) {
		        A.writeObject(Land[i]);
			}
		}
		        A.close();
		             
		     ObjectOutputStream C = new ObjectOutputStream(new FileOutputStream(fileConstruction));
		for(int i=0;i<numberOfAnestheticLands;i++) {
			if(Land[i] instanceof Construction) {
		        C.writeObject(Land[i]);
			}
		}
		        C.close();

		     } 

		public AnestheticLand[] TakeAgricultureinfoFromFile(String file)throws IOException, ClassNotFoundException{
			 Agriculture[] A=new Agriculture[FindNumberOfAgricultureLands()];
			FileInputStream FILE = new FileInputStream(file);
		        ObjectInputStream OBJ = new ObjectInputStream(FILE);
		        for(int i=0;i<FindNumberOfAgricultureLands();i++) {
		        	 A[i]=(Agriculture)OBJ.readObject();
		        }
		        OBJ.close();
		        FILE.close();
			return A;
		}
		
		public AnestheticLand[] TakeConstructioninfoFromFile(String file)throws ClassNotFoundException, IOException{
			Construction[] C=new Construction[FindNumberOfConstructionLands()];
			FileInputStream FILE = new FileInputStream(file);
		        ObjectInputStream OBJ = new ObjectInputStream(FILE);
		        for(int i=0;i<FindNumberOfConstructionLands();i++) {
		        	 C[i]=(Construction)OBJ.readObject();
		        }
		        OBJ.close();
		        FILE.close();
			return C;
		}
		public double PriceOfAgricultureLandsById(String file,int id)throws ClassNotFoundException, IOException{
			AnestheticLand[] A=new AnestheticLand[FindNumberOfAgricultureLands()];
			A=TakeAgricultureinfoFromFile(file);
			boolean aalam=false;
			int index=0;
			for(int i=0;i<FindNumberOfAgricultureLands();i++) {
				
				if(A[i].idOfLand==id) {
					aalam=true;
					index=i;
					break;
				}
			}
			if(aalam) {
				return A[index].PriceOfOneMeter*A[index].area;
			}
			return 0;
		}
		public double PriceOfConstructionLandsById(String file,int id)throws ClassNotFoundException, IOException{
			AnestheticLand[] A=new AnestheticLand[FindNumberOfConstructionLands()];
			A=TakeConstructioninfoFromFile(file);
			boolean aalam=false;
			int index=0;
			for(int i=0;i<FindNumberOfConstructionLands();i++) {
				
				if(A[i].idOfLand==id) {
					aalam=true;
					index=i;
					break;
				}
			}
			if(aalam) {
				return A[index].PriceOfOneMeter*A[index].area;
			}
			return 0;
		}
		public double SecondMethodToFindPriceOfLandsById(int id){
			int index=searchLandById(id);
			if(index>-1) {
				return 	(Land[index].getPriceOfOneMeter())*(Land[index].getArea());
			}
			return 0;
		}
	
	

	

}
