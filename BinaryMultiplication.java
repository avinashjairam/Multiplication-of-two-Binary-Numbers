import java.util.*;

class BinaryNumber{

	ArrayList<Integer>number

	BinaryNumber(int [] number){
		this.number = Arrays.copyOf(number, number.length);
	}




}

public class BinaryMultiplication{

	int numberOfDecimalPlaces=0;

	ArrayList<BinaryNumber> binaryNumbers = new ArrayList<BinaryNumber>();
	ArrayList<Integer> additionNumbers = new ArrayList<Integer>();

	int [] num1;
	int [] num2;

	String num1AsString, num2AsString;
	
	
	public BinaryMultiplication(int [] num1, int [] num2){


		//We are multiplying the larger number by the smaller number 
		if(num1.length < num2.length){
			this.num1 = Arrays.copyOf(num1, num1.length);
			this.num2 = Arrays.copyOf(num2, num2.length);
		}
		else{
			this.num1 = Arrays.copyOf(num2, num2.length);
			this.num2 = Arrays.copyOf(num1, num1.length);
		}

	}

	public void multiply(){
		for (int i=num1.length-1; i >=0;i--){
			additionNumbers.clear();

			addZeros(num1.length -1 -i);
			
			for(int j=num2.length-1; j >= 0; j--){
				additionNumbers.add(num1[i]*num2[j]);
			//	System.out.print(num1[i]  * num2[j] + " ");
			}
//			System.out.println(additionNumbers);
			Collections.reverse(additionNumbers);
			this.listOfLists.add(additionNumbers);
			System.out.println(additionNumbers);
			System.out.println();
			//System.out.println(listOfLists);
		}
		System.out.println(listOfLists);

	
	}

	//The addZeros() method add the appropriate number of zeros to the addition sequence 
	public void addZeros(int k){
		if(k!=0){
			for(int i=0;i<k;i++){
				additionNumbers.add(0);
			}
		}

//		System.out.println("with zeros " + additionNumbers);
	}

	public void printArray(int [] array){
		for(int i =0; i < array.length; i++){
			System.out.print(array[i] + " ");
		}
		System.out.println();

	}

	public void printListOfLists(){
/*		System.out.print(listOfLists.size());
		
		for(ArrayList<Integer> list : listOfLists){
			for(Integer x : list){
				System.out.println(x);
			}
		}
*/
		
		for(int i=0;i<listOfLists.size();i++){
		//	for(int j=0; j <listOfLists.get(i).size(); j++){
		//		System.out.print(listOfLists.get(i).get(j) + " ");
		//	}
			System.out.println(listOfLists.get(i));
		}

		//System.out.println(listOfLists.size());
	}


	public int getNumberOfDecimalPlaces(){

		

		return 0;
	}

	public static void main(String [] args){
		
		int [] num1 = new int [] {1,0,1,1,0,1};
		int [] num2 = new int [] {1,1,0,1};

		BinaryMultiplication obj = new BinaryMultiplication(num1,num2);
		obj.multiply();
		//obj.printListOfLists();
	}	

	/*double num1 = 1011.01;
	double num2 = 110.1; 

	int numberOfDecimalPlaces;

	boolean decimalOperation = false;

	String smallerNumber,largerNumber;;
		
	int num1Length, num2Length,totalLength;


	int [][] values; 

	String num1AsString = Double.toString(num1);
	String num2AsString = Double.toString(num2);

	num1Length = num1AsString.length();
	num2Length = num2AsString.length();
	totalLength = num1Length + num2Length;

	

	if(num1AsString.contains(".") || num2AsString.contains(".")){
		decimalOperation = true;
	}

	if(num1Length < num2Length){
		smallerNumber = num1AsString;
		largerNumber = num2AsString;
	}
	else{
		smallerNumber = num2AsString;
		largerNumber = num1AsString;
	}

	values = new int [smallerNumber.length()][totalLength];

	initializeArray(values,smallerNumber.length(),totalLength);

	System.out.println (num1 + " length is " + num1Length);
	System.out.println (num2 + " length is " + num2Length);


	multiply(smallerNumber, largerNumber, values, decimalOperation);

	}

	public static void initializeArray(int [][] values, int numRows , int numColumns){
		for (int i =0; i < numRows; i++){
			for (int j=0; j < numColumns; j++){
				values[i][j]=0;
				System.out.print(values[i][j]);
			}
			System.out.println();
		}
	}

	public static double multiply(String smallerNumber, String largerNumber, int [][] values, boolean decimalOperation){

		if(decimalOperation){
			for(int i = smallerNumber.length()-1; i >= 0; i--){
				if(smallerNumber.charAt(i) == '.' ){
					continue;
				}
			//	System.out.print(smallerNumber.charAt(i));

				for (int j = largerNumber.length()-1; j >= 0; j--){
					if(largerNumber.charAt(i) != '.' ){
						System.out.print("i=" + smallerNumber.charAt(i) + "*" + "j=" + largerNumber.charAt(j) + " ");
					}
			
		//			System.out.print( largerNumber.charAt(i));
				}
				System.out.println("end");
			}
		}

		return 0;
	}
*/

}
