package exceptions;

public class TestEntierNaturel {

	public static void main(String[] args) {
		
		EntierNaturel n=null;
		try {
			n= new EntierNaturel(100);
		}catch (ConstException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			n.somme(5);
			n.produit(6);
			n.difference(7);
			System.out.println("La valeur de n : " + n.getN());
			
		}catch(SommeException e) {
			System.out.println(e.getMessage());
		}
		catch(DifferenceException e) {
			System.out.println(e.getMessage());
		}
		catch(ProduitException e) {
			System.out.println(e.getMessage());
		}
	}

}
