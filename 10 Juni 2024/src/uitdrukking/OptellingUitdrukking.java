package uitdrukking;

import java.util.Iterator;

/**
 * @invar | getLinks() != null
 * @invar | getRechts() != null
 */
public class OptellingUitdrukking extends Uitdrukking{

	/**
	 * @representationObject
	 * @peerObject
	 * @invar | links != null
	 */
	private Uitdrukking links;
	
	/**
	 * @representationObject
	 * @peerObject
	 * @invar | rechts != null
	 */
	private Uitdrukking rechts;
	
	/**
	 * @throws IllegalArgumentException | links == null || rechts == null
	 */
	public OptellingUitdrukking(Uitdrukking links, Uitdrukking rechts){
		if(links == null | rechts == null)
			throw new IllegalArgumentException();
		this.links = links;
		this.rechts = rechts;
	}
	
	public Uitdrukking getLinks() {
		return links;
	}
	
	public Uitdrukking getRechts() {
		return rechts;
	}
	
	/**
	 * @throws IllegalArgumentException | v == null
	 * @post | result >= 0
	 * @post | result == getLinks().aantalVoorkomens(v) + getRechts().aantalVoorkomens(v)
	 */
	public int aantalVoorkomens(VariabeleUitdrukking v) {
		return links.aantalVoorkomens(v) + rechts.aantalVoorkomens(v);
	}
	
	public Iterator<Uitdrukking> Itereren(){
		return new Iterator<>() {
			
			
			@Override
			public boolean hasNext() {
				return (links instanceof OptellingUitdrukking) & (rechts instanceof OptellingUitdrukking);
			}
			
			@Override
			public OptellingUitdrukking next() {
				if(links instanceof OptellingUitdrukking ul)
					return ul;
				return (OptellingUitdrukking) rechts;
					
			}
		};
	}
}
