public class Java03 {   
	public static void main(String[] args) {
  
	//
	int A;
	int V;
	System.out.println(""); 
	System.out.println("Kocka A, V"); 
	System.out.println("K�rem a kocka �l hossz�t (cm) a = "); 
	java.util.Scanner sc = new java.util.Scanner(System.in);//�j sc nev� p�ld�nyt l�trehoz�sa a Scanner oszt�lyb�l
	System.out.print(" a = "); int a = sc.nextInt();// �j sc p�ld�nyunk v�rja egy integert NextInt
	
	System.out.println(""); // soremel�s
	A = 6*a*a; V = a*a*a; //felsz�n, t�rfogat
	System.out.print("	A="+A+" cm2");
	System.out.print("	V="+V+" cm3");
	System.out.println(""); // soremel�s
	
	System.out.print("  A kil�p�shez nyomjon Entert");
	System.console().readLine(); // kifejezetten a dos ablak-n�l egy ENTER-t v�r
	}    
}