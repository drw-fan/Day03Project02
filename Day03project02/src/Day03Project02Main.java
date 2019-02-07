import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day03Project02Main {
	public static void main (String[] args) {

		int[][] claimMatrix = new int[3000][3000];
		
		
		String claimString="";  //  #1 @ 509,796: 18x15
		String realClaimString="";
		int indexEndNumber=0, indexOfComma=0, indexOfColon=0, indexOfx=0;
		int startCol=0, startRow=0, numCols=0, numRows=0, idNum=0;
		String colString="", rowString="", numColString="", numRowString="";
		int totalInMultiClaims=0;
		
		

		try {
			File myFile = new File("claims.txt");
			Scanner inputFile = new Scanner(myFile);

			while (inputFile.hasNext()) {
				claimString = (inputFile.nextLine());
				
				
				indexEndNumber = claimString.indexOf('@');
				indexOfComma = claimString.indexOf(',');
				indexOfColon = claimString.indexOf(':');
				indexOfx = claimString.indexOf('x');
				
				idNum = Integer.parseInt(claimString.substring(1, indexEndNumber-1));
				startCol = Integer.parseInt(claimString.substring(indexEndNumber+2, indexOfComma));
				startRow = Integer.parseInt(claimString.substring(indexOfComma+1, indexOfColon));
				numCols = Integer.parseInt(claimString.substring(indexOfColon+2, indexOfx));
				numRows = Integer.parseInt(claimString.substring(indexOfx+1));

				for (int i = startRow; i <(startRow+numRows); i++) {
					for (int j =startCol; j < (startCol + numCols); j++) {
						if (claimMatrix[i][j] == 0)
							claimMatrix[i][j] = idNum;
						else claimMatrix[i][j] = -1;
					}
				}
			}

			inputFile.close();
		}

		catch (FileNotFoundException e) {
			System.out.println("File IO error!");
		}
		
		try {
			File myFile = new File("claims.txt");
			Scanner inputFile = new Scanner(myFile);

			while (inputFile.hasNext()) {
				claimString = (inputFile.nextLine());
				
				indexEndNumber = claimString.indexOf('@');
				indexOfComma = claimString.indexOf(',');
				indexOfColon = claimString.indexOf(':');
				indexOfx = claimString.indexOf('x');
				
				idNum = Integer.parseInt(claimString.substring(1, indexEndNumber-1));
				startCol = Integer.parseInt(claimString.substring(indexEndNumber+2, indexOfComma));
				startRow = Integer.parseInt(claimString.substring(indexOfComma+1, indexOfColon));
				numCols = Integer.parseInt(claimString.substring(indexOfColon+2, indexOfx));
				numRows = Integer.parseInt(claimString.substring(indexOfx+1));
				
				realClaimString = claimString;
				
				for (int i = startRow; i <(startRow+numRows); i++) {
					for (int j =startCol; j < (startCol + numCols); j++) {
						if (claimMatrix[i][j] == -1) {
							realClaimString = "";
							break;
						}
					}
				}
				
				if (realClaimString != "")
					break;
			}

			inputFile.close();
		}

		catch (FileNotFoundException e) {
			System.out.println("File IO error!");		}

		
		System.out.println("Only claim that doesn't overlap = " + realClaimString);
	}
}
