public class Java04 {   
	public static void main(String[] args) {
  
	//
	
	System.out.println(); // soremel�s
	System.out.print("Alap m�veletek (a, b<>0)");
	System.out.println(); // soremel�s
	
	java.util.Scanner sc = new java.util.Scanner(System.in);//�j sc nev� p�ld�nyt l�trehoz�sa a Scanner oszt�lyb�l
	System.out.print("	a = "); int a = sc.nextInt();// �j sc p�ld�nyunk v�rja egy integert NextInt
	System.out.print("	b = "); int b = sc.nextInt();// �j sc p�ld�nyunk v�rja egy integert NextInt
	System.out.println(); // soremel�s
	System.out.print("	a + b = "+(a+b));
	System.out.println(); // soremel�s
	System.out.print("	a - b = "+(a-b));
	System.out.println(); // soremel�s
	System.out.print("	a * b = "+(a*b));
	System.out.println(); // soremel�s
	System.out.print("	a / b = "+(a/b));
	System.out.println(); // soremel�s
	
	System.out.println(); // soremel�s
	System.out.print("A kil�p�shez nyomjon Entert");
	System.console().readLine();
	}    
 }