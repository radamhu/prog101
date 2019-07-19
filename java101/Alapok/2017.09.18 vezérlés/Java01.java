public class Java01{//run.bat Java01
public static void	main(String[]args){
	
	int r=10;
	double k,t;
	
	System.out.println();
	System.out.println("  kör  ");
	System.out.println("  r= "+r+" cm");
	k=r*2*Math.PI; t=r*r*Math.PI;
	System.out.println("  kerület "+k+" cm");
	System.out.println("  terület "+t+" cm");
	
	double a;
	System.out.println();
	System.out.println("  négyzet  ");
	a=r*Math.sqrt(2);
	System.out.println("  a= "+a+" cm");
	k=4*a; t=a*a;
	System.out.println("  kerület "+k+" cm");
	System.out.println("  terület "+t+" cm");
	System.out.println();

	
	System.out.print("Kilépéshez nyomjon entert!");
	System.console().readLine();
	
	}
}