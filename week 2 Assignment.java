//Author: Ce Lan 

package assignment;

public class Assignment {
	
	public static void main(String[] args) {
		Assignment assignment = new Assignment();
		System.out.println("printPerfectNumbers(3): ");
		assignment.printPerfectNumbers(3);
		System.out.println("printPerfectNumbers(33875): ");
		assignment.printPerfectNumbers(33875);
		System.out.println("printIsoscelesTriangle(10): " );
		assignment.printIsoscelesTriangle(10);
		System.out.println("addDigits(12947):  " + assignment.addDigits(12947));
		System.out.println("employeeSalary(40):  " + assignment.employeeSalary(40));
	}
	//1. Write a java function to calculate the salary of an employee based on the following rules.
	//i. function takes input of number of hours an employee worked and returns the salary.
	//ii.  The first 36 hours worked are paid at a rate of 15.0, then the next 5 hours are paid at a rate of 15 * 1.5. Hours after that up to a max of 48 are paid at a rate of 15 * 2.
	public double employeeSalary(double hours){
		if (hours<= 36)
			return 15.0*hours;
		else{
			if (hours<41)
				return 36*15.0+(hours-36)*15*1.5;
			else  //not handling hours > 48!
				return 36*15.0+5*15*1.5+(hours-41)*15*2.0;
		}
	}
	
//	2. Write a java function that adds all the digits of an integer until it is single digit.
//	i. function takes an integer as input and returns its sum of digits.
//	ii. for example input = 37, sum = 3+7 = 10, sum = 1+0 = 1. result = 1.
	public int addDigits(int input) {
		
		if (input<10)
			return input;
		else {
			int res=0;
			for (;input>0;) {
				int remainder=input%10;
				res+=remainder;
				input/=10;
			}
			return addDigits(res);
		}
	}
//	3. Write a java function to print all perfect number between 1 and n.
//	i. Perfect number is a positive integer which is equal to the sum of its proper positive divisors.
//	ii. For example: 6 is the first perfect number, Proper divisors of 6 are 1, 2, 3. Sum of its proper divisors = 1 + 2 + 3 = 6.
//	
	public void printPerfectNumbers( int n){
		
		if (n<6) {
			System.out.println("No perfect number less or eauql to " + n);
			return ;
		}
			
		System.out.println(6);
		for (int i=7; i<n;i++) {
			if (isPerfect(i))
				System.out.println(i);
		}
	}
	public boolean isPerfect(int a) {
		int res=0;
		int sq=(int)Math.sqrt(a);
		for ( int i=2;i<=sq;i++) {
			if (a%i==0) {
				res+=i;
				if (a/i!=i)
					res+=a/i;
				}
		}
		return res+1==a;
	}
	
	
//	6. Write a Java program that generates an isosceles right angled triangle made of asterisks. 
//	i. function should take input of one equal side as integer. Other than the edges the inner part of the triangle should be empty.
//	ii. For example input is 6. the function should print—
//	
//   *
//   **
//   * *
//   *  *
//   *   *
//   ******



	public void printIsoscelesTriangle( int n){
		System.out.println("*");//first line
		if (n==1)
			return;
		for (int i=2;i<n;i++) {
			StringBuffer space= new StringBuffer();
			for (int j=0;j<i-2;j++)
				space.append(" ");
			System.out.println("*"+space.toString()+"*");
		}
		StringBuffer space= new StringBuffer();
		for (int i=0;i<n;i++)
			space.append("*");
		System.out.println(space.toString());
}
}
