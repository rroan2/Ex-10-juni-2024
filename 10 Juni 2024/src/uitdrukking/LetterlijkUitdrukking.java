package uitdrukking;


public class LetterlijkUitdrukking extends Uitdrukking {

	private int c;

	/**
	 * @post | c == getWaarde()
	 */
	public LetterlijkUitdrukking(int c){
		this.c = c;
	}
	
	public int getWaarde(){
		return c;
	}
	
	/**
	 * @throws IllegalArgumentException | v == null
	 * @post | result == 0
	 */
	public int aantalVoorkomens(VariabeleUitdrukking v) {
		if(v == null)
			throw new IllegalArgumentException();
		return 0;
	}
	
}
