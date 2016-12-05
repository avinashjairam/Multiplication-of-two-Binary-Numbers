import java.util.*;

class BinaryNumber{

	ArrayList<Integer>number;

	BinaryNumber(int [] number){
//		this.number = Arrays.copyOf(number, number.length);
	}




}

public class BinaryMultiplication{

	int numberOfDecimalPlaces=0;

	ArrayList<BinaryNumber> binaryNumbers = new ArrayList<BinaryNumber>();
	ArrayList<Integer> additionNumbers = new ArrayList<Integer>();
	ArrayList<ArrayList<Integer>> listOfLists = new ArrayList<ArrayList<Integer>>();
	ArrayList<Integer>additionResult = new ArrayList<Integer>();

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


	public static void main(String [] args){
		
		int [] num1 = new int [] {1,0,1,1,0,1};
		int [] num2 = new int [] {1,1,0,1};
		
	//	totalBits = num1.length * num2.length;

		BinaryMultiplication obj = new BinaryMultiplication(num1,num2);
		obj.multiply();
		obj.addition();
	}	

	public String addTwoBits(int x, int y){
		String returnValue="";
		if(x == 0 && y == 0){
			
			returnValue ="0";
		}
		else if( x == 1 && y == 0){
			returnValue = "1";
		}
		else if(x == 0 && y == 1){
			returnValue =  "1";
		}
		else if(x == 1 && y ==1){
			returnValue = "10";
		}
//		System.out.println(returnValue.charAt(0));

		return returnValue;
	}

	public void addition(){
//		for(int i =0; i < listOfLists.size(); i++){
//			System.out.println(listOfLists.get(i));
//		}

		addTwoBinaryNumbers(listOfLists.get(0),listOfLists.get(2));
	}

	public void addTwoBinaryNumbers(ArrayList<Integer>num1, ArrayList<Integer>num2){
		ArrayList<String> sum = new ArrayList<String>();
		String result="";
		ArrayList<Integer>carry = new ArrayList<Integer>();
	
		for(int i =0; i<num1.size(); i++){
			result=addTwoBits(num1.get(i),num2.get(i));
			if(result.length() == 2){
				result = result.charAt(1);
				carry.add(Integer.parseInt(result.charAt(0)));				
			}
			else{
				sum.add(result);
			}

		}
	
		System.out.print("sum is " +sum);	
		
	}


	public void paddedZeros(ArrayList<Integer>list, int x, int y){
		int numZerosToAdd = (x+y) - list.size() -1; 

		for(int i =0; i < numZerosToAdd; i++){
			list.add(0);
		}
	}		


	public void multiply(){
		for (int i=num1.length-1; i >=0;i--){
	//		additionNumbers.clear();
			resetAdditionNumbers();
			addZeros(num1.length -1 -i);
			
			for(int j=num2.length-1; j >= 0; j--){
				additionNumbers.add(num1[i]*num2[j]);
			//	System.out.print(num1[i]  * num2[j] + " ");
			}
//		
			System.out.println(additionNumbers);
			paddedZeros(additionNumbers,num1.length,num2.length);
			Collections.reverse(additionNumbers);
			this.listOfLists.add(additionNumbers);
			System.out.println(additionNumbers);
			System.out.println();
			//System.out.println(listOfLists);
		}
		System.out.println("list of lists " + listOfLists);

	
	}



	public void resetAdditionNumbers(){
		additionNumbers = null;
		additionNumbers = new ArrayList<Integer>();
	

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




}
