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
	
	ArrayList<Integer>sum = new ArrayList<Integer>();

	int [] num1;
	int [] num2;

	int count1 =0;
	int count2=0;
	

	String num1AsString, num2AsString;

	public static void main(String [] args){
		
	//	int [] num1 = new int [] {1,0,1,1,0,1};
	//	int [] num2 = new int [] {1,1,0,1};
	
//		int [] num1 = new int [] {1,1,1,1};
//		int [] num2 = new int [] {1,1,1,1};

	
		int [] num1 = new int [] {1,1};
		int [] num2 = new int [] {1,1};

	//	totalBits = num1.length * num2.length;

		BinaryMultiplication obj = new BinaryMultiplication(num1,num2);
		obj.multiply();
		obj.addition();
		System.out.println("regular mulitiplication #steps " + obj.count1);
/*
		ArrayList<Integer>number1 = new ArrayList<Integer>();
		ArrayList<Integer>number2 = new ArrayList<Integer>();

		for(int i = 0; i <num1.length; i++){
			number1.add(num1[i]);
		}

		for(int j=0; j <num2.length; j++){
			number2.add(num2[j]);
		}

//		System.out.println("Divide and Conquer result: ");
		System.out.println("Divide and Conquer result: " + Integer.toBinaryString(obj.divideAndConquer(number1,number2)));
		System.out.println("divide and conquer #steps: " + obj.count2); */

	}

	public int divideAndConquer(ArrayList<Integer>num1, ArrayList<Integer>num2){
		count2++;
		 makeEqual(num1,num2);

		int size = num1.size();
		if(size == 0){
			return 0;
		}

		System.out.println (num1 + " " + num2);
		if(size == 1){
			System.out.println(" base case multiplication " + num1.get(0) * num2.get(0));
			return num1.get(0) * num2.get(0);

		}

		int firstPartOfNumber = size/2;
		int secondPartOfNumber = size - firstPartOfNumber;

		ArrayList<Integer> Xh = new ArrayList<Integer>();
		ArrayList<Integer> Xl = new ArrayList<Integer>();
		ArrayList<Integer> Yh = new ArrayList<Integer>();
		ArrayList<Integer> Yl = new ArrayList<Integer>();

	

		for(int i =0; i < firstPartOfNumber; i++){
			Xh.add(num1.get(i));
			Yh.add(num2.get(i));
		}

		for(int i =secondPartOfNumber; i < size; i++){
			Xl.add(num1.get(i));
			Yl.add(num2.get(i));
		}

		System.out.println(Xh);

		int a = divideAndConquer(Xh,Yh);
		int d = divideAndConquer(Xl,Yl);

		ArrayList<Integer> localSum1 = new ArrayList<Integer>();
		addTwoBinaryNumbers(Xh,Xl);
		copyArrayList(sum,localSum1);

		ArrayList<Integer> localSum2 = new ArrayList<Integer>();
		addTwoBinaryNumbers(Yh,Yl);
		copyArrayList(sum,localSum2);

		System.out.println("local sum1 = " + localSum1 + " local sum2 = " + localSum2);
	
		int e = divideAndConquer(localSum1,localSum2);

	
//		int e=0;
		System.out.println("a = " + a + " d = " + d + " e = " + e);
//		System.out.println("steps " + count1);
	 	
	
		return  a *(1<<(2*secondPartOfNumber)) +(e - a - d) *  (1 <<secondPartOfNumber) + d;

		//return 0;

	}

	public void copyArrayList(ArrayList<Integer>source, ArrayList<Integer>destination){

		for(int i=0;i<source.size();i++){
			destination.add(source.get(i));
		}
	}

	public void makeEqual(ArrayList<Integer>num1, ArrayList<Integer>num2){
		

		if(num1.size() == num2.size()){
			return;
		}
		else if(num1.size() > num2.size() ){
			for(int i = num2.size(); i <num1.size(); i++){
				num2.add(0, 0);
			}
		}
				
		else{
			for(int i = num1.size(); i <num2.size(); i++){
				num1.add(0, 0);
			}		
		}
	}


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


	

	public String addTwoBits(int x, int y){
		count1++;
		count2++;
		String returnValue="";
		System.out.println("x is " + x + " y is " +y);	
		if(x == 0 && y == 0){
			returnValue ="0";
		}
		else if(x == 1 && y == 0){
			returnValue = "1";
		}
		else if(x == 0 && y == 1){
			returnValue =  "1";
		}
		else if(x == 1 && y ==1){
			returnValue = "10";
		}
		else if(x == 1 && y == 10){
			returnValue = "11";
		}
		else if(x == 10 && y == 1){
			returnValue = "11";
		}
//		System.out.println("return value is " + returnValue);

		return returnValue;
	}

	public void addition(){
//		for(int i =0; i < listOfLists.size(); i++){
//			System.out.println(listOfLists.get(i));
//		}

//		int [] sum;

		 addTwoBinaryNumbers(listOfLists.get(0),listOfLists.get(1));
		count1++;
		count1++;
	//	ArrayList<Integer> partialSum = Arrays.asList(sum); 
		for(int i =2; i < listOfLists.size(); i++){
			addTwoBinaryNumbers(listOfLists.get(i),sum);
			count1++;
		}
	}

	public void addTwoBinaryNumbers(ArrayList<Integer>num1, ArrayList<Integer>num2){
		count1++;
		sum=null;
		 sum = new ArrayList<Integer>();
		String result="";
		ArrayList<Integer>carry = new ArrayList<Integer>();

//		System.out.println("\nNow working on " + num1 + " " + num2);
//		System.out.println();
	
		for(int i =num1.size()-1; i>=0; i--){
			result=addTwoBits(num1.get(i),num2.get(i));
//			System.out.println("Initial Result is " + result);
			
			if(carry.size() != 0){
//				System.out.println("Carry loaded: " + carry.get(carry.size()-1) + " result is " + result);
				result=addTwoBits(Integer.parseInt(result),carry.get(carry.size()-1));
//				System.out.println("result after carry " + result);
				carry.remove(carry.size()-1);
			

			}

//			System.out.println("i = " + i + " result is " + result + " carry is " + carry + " result length is " + result.length());


			if(result.length() == 2){
				carry.add(Integer.parseInt(result.substring(0,1)));
				result = Character.toString(result.charAt(1));
//				System.out.println(carry);			
				sum.add(Integer.parseInt(result));
				
			}
			else{
				sum.add(Integer.parseInt(result));
			}

			result="";

			if(i==0 && carry.size()!=0){
				for(int j = 0; j < carry.size(); j++){
					sum.add(carry.get(j));
				}

			}

		}
		Collections.reverse(sum);	
//		System.out.print("sum is " +sum + " carry is " + carry);	
		System.out.println("sum is " + sum);		
		/*int [] sum1 =  new int [sum.size()];
		sum1 = sum.toArray(sum1);

		return sum1;*/
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
				count1++;	
		//	System.out.print(num1[i]  * num2[j] + " ");
			}
//		
//			System.out.println(additionNumbers);
			paddedZeros(additionNumbers,num1.length,num2.length);
			Collections.reverse(additionNumbers);
			this.listOfLists.add(additionNumbers);
//			System.out.println(additionNumbers);
//			System.out.println();
			//System.out.println(listOfLists);
		}
//		System.out.println("list of lists " + listOfLists);

	
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
