public class Program {   
	public static void main(String[] args) {
	  
	//
	
	System.out.println(); // soremelés
	System.out.print("Alap műveletek (a, b<>0)");
	System.out.println(); // soremelés
	
	java.util.Scanner sc = new java.util.Scanner(System.in);//új sc nevű példányt létrehozása a Scanner osztályból
	System.out.print("	a = "); int a = sc.nextInt();// új sc példányunk várja egy integert NextInt
	System.out.print("	b = "); int b = sc.nextInt();// új sc példányunk várja egy integert NextInt
	System.out.println(); // soremelés
	System.out.print("	a + b = "+(a+b));
	System.out.println(); // soremelés
	System.out.print("	a - b = "+(a-b));
	System.out.println(); // soremelés
	System.out.print("	a * b = "+(a*b));
	System.out.println(); // soremelés
	System.out.print("	a / b = "+(a/b));
	System.out.println(); // soremelés
	
	System.out.println(); // soremelés
	System.out.print("A kilépéshez nyomjon Entert");
	System.console().readLine();
	}   
 }