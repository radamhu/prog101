public class Java03 {   
	public static void main(String[] args) {
  
	//
	int A;
	int V;
	System.out.println(""); 
	System.out.println("Kocka A, V"); 
	System.out.println("Kérem a kocka él hosszát (cm) a = "); 
	java.util.Scanner sc = new java.util.Scanner(System.in);//új sc nevû példányt létrehozása a Scanner osztályból
	System.out.print(" a = "); int a = sc.nextInt();// új sc példányunk várja egy integert NextInt
	
	System.out.println(""); // soremelés
	A = 6*a*a; V = a*a*a; //felszín, térfogat
	System.out.print("	A="+A+" cm2");
	System.out.print("	V="+V+" cm3");
	System.out.println(""); // soremelés
	
	System.out.print("  A kilépéshez nyomjon Entert");
	System.console().readLine(); // kifejezetten a dos ablak-nál egy ENTER-t vár
	}    
}