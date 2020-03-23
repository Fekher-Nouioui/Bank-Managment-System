package exceptions;

public class EntierNaturel {
	
	private int N;

	public EntierNaturel(int n) throws ConstException{	
		if(n < 0) 
			throw new ConstException("Entier n�gatif");
		else
			N = n;
	}
	public void somme(int x) throws SommeException{
		if((long)N + (long)x > Integer.MAX_VALUE) 
			throw new SommeException("La somme d�passe le maximum");
		else
			this.setN(this.getN()+x);
			
	}
	public void difference(int x) throws DifferenceException{
		if((long)N - (long)x < -Integer.MAX_VALUE) 
			throw new DifferenceException("La diff�rence d�passe le Maximum !");
		else
			this.setN(this.getN()-x);
	}
	public void produit(int x) throws ProduitException{
		if((long)(N) * (long)x > Integer.MAX_VALUE) 
			throw new ProduitException("Le produit d�passe le Maximum !");
		else
			this.setN(this.getN()*x);
	}
	public int getN() {
		return(N);
	}
	public void setN(int n) {
		this.N=n;
	}
}
