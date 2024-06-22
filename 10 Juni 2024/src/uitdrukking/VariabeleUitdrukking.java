package uitdrukking;

public class VariabeleUitdrukking extends Uitdrukking {

	/**
	 * @representationObject
	 */
	private String v;
	
	/**
	 * @throws IllegalArgumentException | v == null
	 * @post | v == getVariabele()
	 */
	public VariabeleUitdrukking(String v){
		if(v == null)
			throw new IllegalArgumentException();
		this.v = v;
	}
	
	public String getVariabele() {
		return v;
	}
	
	/**
	 * @throws IllegalArgumentException | v == null
	 * @post | result == (v.equals(getVariabele()) ? 1 : 0)
	 */
	public int aantalVoorkomens(String v) {
		if(v == null)
			throw new IllegalArgumentException();
		return v.equals(this.v) ? 1 : 0;
	}

	
}
