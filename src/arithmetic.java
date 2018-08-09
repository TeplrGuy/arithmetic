
import java.util.Scanner;


/**
 * Simple arithmetic operations - ask user the answer of adding/subtracting two numbers
 * - Record time and print out top 5 answers by the time they were answered
 * 
 * - Not really efficient but will be improving
 */

/**
 * @author Gilbert A
 *
 */


 class Questions{
	 private int firstNumber;
	 private int secondNumber;
	 private int answer;
	 private long time;
	 private int number;
	
	
	 public Questions() {
		
	}
	public int getFirstNumber() {
		return firstNumber;
	}
	public void setFirstNumber(int firstNumber) {
		this.firstNumber = firstNumber;
	}
	public int getSecondNumber() {
		return secondNumber;
	}
	public void setSecondNumber(int secondNumber) {
		this.secondNumber = secondNumber;
	}
	public int getAnswer() {
		return answer;
	}
	public void setAnswer(int answer) {
		this.answer = answer;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public int getNumber() {
		return number;
	}
	public void setNumbert(int number) {
		this.number = number;
	}
	 
	 
	
	 
	
}
public class arithmetic {

	
	private static int n = 10;
    private static int count;
	private static  int userInput() {
		Scanner in = new Scanner(System.in);
		int input;

		System.out.print("Entr your answer: ");
		 input = in.nextInt();
		 return input;
	}
	
	private static int getInt() {
		
		int min = 1;
		int max = 9;
		int x = (int)(Math.random() * max) + min;
		 if (x < min || x >= max) { return x; }  
		return x;
		
	}
	
	private static int getAnswer(int firstNumber, int secondNumber) {
		if (count % 2 == 0){
			return (firstNumber + secondNumber);
		}else {
			return (firstNumber - secondNumber);
		}
	}
	
	private static boolean checkAnswer(int firstNumber, int secondNumber, int userInput) {
		if (count % 2 == 0){
			return getAnswer(firstNumber, secondNumber) == userInput;
		}else {
			return getAnswer(firstNumber, secondNumber) == userInput;
		}
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		long startTime, endTime;
		
		
		Questions[] questions = new Questions[n];
		
		for(int i=0; i< n;i++)
		    questions[i] = new Questions();
		
		while (true) {
			int firstNumber = getInt();
			int secondNumber = getInt();
			int answer;
			
			count = count +1;
			if (count == n) {
			
				break;
			}
			
	   
			if (count % 2 == 0){
				System.out.println(+count+": What is the answer for "+firstNumber +"+"+secondNumber);
				 startTime = System.nanoTime();
				if (checkAnswer(firstNumber, secondNumber, userInput())) {
					System.out.println("Your answer is correct");
				}else {
					System.out.println("Your answer is wrong");
				}
				endTime   = System.nanoTime();
				long totalTime = endTime - startTime;
				totalTime = totalTime/1000000000;
				System.out.println("Total time before answering: " + totalTime);
				
				
				
					
					questions[count].setFirstNumber(firstNumber);
					questions[count].setSecondNumber(secondNumber);
					questions[count].setTime(totalTime);
					questions[count].setNumbert(count);;
				
				
			}else {
			 startTime = System.nanoTime();
				System.out.println(+count+": What is the answer for "+firstNumber +"-"+secondNumber);
				if (checkAnswer(firstNumber, secondNumber, userInput())) {
					System.out.println("Your answer is correct");
				}else {
					System.out.println("Your answer is wrong");
				}
				endTime   = System.nanoTime();
				long totalTime = endTime - startTime;
				totalTime = totalTime/1000000000;
				System.out.println("Total time before answering: " + totalTime);
				
				questions[count].setFirstNumber(firstNumber);
				questions[count].setSecondNumber(secondNumber);
				questions[count].setTime(totalTime);
				questions[count].setNumbert(count);;
			}
		
			System.out.println("\n");
			
		}
		
		long[] array1 = new long[n];
		long largest[] = new long[5];
		int[] maxIndex = new int[5];
		long max = 0;
		int  index;
		 
		
		for(int i = 0; i < n; i++) 
			array1[i] = questions[i].getTime();
		

		 System.out.println("Top 5 Questions");
		 for (int j = 0; j < 5; j++) {
	        max = array1[0];
	        index = 0;
	        for (int i = 0; i < array1.length; i++) {
	            if (max < array1[i]) {
	                max = array1[i];
	                index = i;
	                maxIndex[j] = i;
	            }
	            
	            
	        }
	        
	        largest[j] = max;
	        array1[index] = Long.MIN_VALUE;
	        
	    }
		 for (int j = 0; j < 5; j++) {
			 if (questions[maxIndex[j]].getNumber() % 2 == 0){
	        	 System.out.println("Question "+questions[maxIndex[j]].getNumber()+": " + questions[maxIndex[j]].getFirstNumber()+"+"+questions[maxIndex[j]].getSecondNumber());
	        	 System.out.println("Longest time: " + largest[j] + " seconds");
	        }else {
	        	 System.out.println("Question "+questions[maxIndex[j]].getNumber()+": " + questions[maxIndex[j]].getFirstNumber()+"-"+questions[maxIndex[j]].getSecondNumber());
	        	 System.out.println("Longest time: " + largest[j] + " seconds");
	        }
		 }
		
		
	}

	
}
