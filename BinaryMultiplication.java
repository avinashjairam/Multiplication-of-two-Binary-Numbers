
public class BinaryMultiplication{


	public static void main(String [] args){

	double num1 = 1011.01;
	double num2 = 110.1; 

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


}
