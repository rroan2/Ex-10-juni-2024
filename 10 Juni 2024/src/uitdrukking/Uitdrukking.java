package uitdrukking;

public abstract class Uitdrukking {

	/**
	 * @pre | v != null
	 * @post | result >= 0
	 * @post | result == ((this instanceof OptellingUitdrukking ou )? (ou.getLinks().aantalVoorkomens(v) + ou.getRechts().aantalVoorkomens(v)): (this instanceof VariabeleUitdrukking vu ? (v.equals(vu.getVariabele()) ? 1: 0) : 0))
	 * Omdat dit een abtracte functie is moeten alle deelklassen deze functie implementeren (en overriden). Elke klasse moet strengere (of even strenge) pre en post condities hebben voor de functie.
	 */
	public abstract int aantalVoorkomens(String v);
	
	
}
