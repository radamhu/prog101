package tanulok;

public class Tanulok {

    private static ArrayList<Tanulo> lista = new ArrayList<>();
    
    public static void main(String[] args) {
        lista.add(new Tanulo("Kis J�nos", 2000, 3.22));
        lista.add(new Tanulo("Nagy L�szl�", 2002, 2.11));
        lista.add(new Tanulo("Kov�cs �va", 1998, 4.33));
        
        Collections.sort(lista);
        
        for (Tanulo t : lista)
            System.out.println(t);
    }
    
}
