public class Java01{//run.bat Java01
public static void	main(String[]args){
	
	int r=10;
	double k,t;
	
	System.out.println();
	System.out.println("  k�r  ");
	System.out.println("  r= "+r+" cm");
	k=r*2*Math.PI; t=r*r*Math.PI;
	System.out.println("  ker�let "+k+" cm");
	System.out.println("  ter�let "+t+" cm");
	
	double a;
	System.out.println();
	System.out.println("  n�gyzet  ");
	a=r*Math.sqrt(2);
	System.out.println("  a= "+a+" cm");
	k=4*a; t=a*a;
	System.out.println("  ker�let "+k+" cm");
	System.out.println("  ter�let "+t+" cm");
	System.out.println();

	
	System.out.print("Kil�p�shez nyomjon entert!");
	System.console().readLine();
	
	}
}