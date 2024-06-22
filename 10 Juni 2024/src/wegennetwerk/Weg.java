package wegennetwerk;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import logicalcollections.LogicalSet;

/**
 * @invar | getStartkruispunt() == null || getStartkruispunt().getVertrekwegen().contains(this)
 * @invar | getEindkruispunt() == null || getEindkruispunt().getAankomstwegen().contains(this)
 */
public class Weg {
	
	/**
	 * @invar | startkruispunt == null || startkruispunt.vertrekwegen.contains(this)
	 * @peerObject
	 * @representationObject
	 */
	Kruispunt startkruispunt;
	
	/**
	 * @invar | eindkruispunt == null || eindkruispunt.aankomstwegen.contains(this)
	 * @peerObject
	 * @representationObject
	 */
	Kruispunt eindkruispunt;
	
	/**
	 * @post | getStartkruispunt() == null
	 * @post | getStartkruispunt() == null
	 */
	public Weg() {}
	
	public Kruispunt getStartkruispunt() {
		return startkruispunt;
	}
	
	public Kruispunt getEindkruispunt() {
		return eindkruispunt;
	}
	
	
	/**
	 * @throws IllegalStateException | getStartkruispunt() != null
	 * @throws IllegalArgumentException | kruispunt == null
	 * @throws IllegalArgumentException | kruispunt.getVertrekwegen().contains(this)
	 * @post | getStartkruispunt() == kruispunt
	 * @post | kruispunt.getVertrekwegen().equals(LogicalSet.plus(old(kruispunt.getVertrekwegen()), this))
	 * @mutates_properties | getEindkruispunt(), getEindkruispunt().getAankomstwegen()
	 */
	public void stelInAlsStartkruispunt(Kruispunt kruispunt) {
		if(startkruispunt != null)
			throw new IllegalStateException();
		if(kruispunt == null)
			throw new IllegalArgumentException();
		if(kruispunt.vertrekwegen.contains(this))
			throw new IllegalArgumentException();
		kruispunt.vertrekwegen.add(this);
		startkruispunt = kruispunt;
		
	}
	
	/**
	 * @throws IllegalStateException | getEindkruispunt() != null
	 * @throws IllegalArgumentException | kruispunt == null
	 * @throws IllegalArgumentException | kruispunt.getAankomstwegen().contains(this)
	 * @post | getEindkruispunt() == kruispunt
	 * @post | kruispunt.getAankomstwegen().equals(LogicalSet.plus(old(kruispunt.getAankomstwegen()), this))
	 * @mutates_properties | getStartkruispunt(), getStartkruispunt().getVertrekwegen()
	 */
	public void stelInAlsEindkruispunt(Kruispunt kruispunt) {
		if(eindkruispunt != null)
			throw new IllegalStateException();
		if(kruispunt == null)
			throw new IllegalArgumentException();
		if(kruispunt.aankomstwegen.contains(this))
			throw new IllegalArgumentException();
		kruispunt.aankomstwegen.add(this);
		eindkruispunt = kruispunt;
		
	}
	
	public List<Weg> tweedeOrdeWegen() {
		return eindkruispunt.getVertrekwegen().stream()
				.filter(w -> w.eindkruispunt != null)
				.map(w -> w.eindkruispunt)
				.flatMap(k -> k.vertrekwegen.stream()).collect(Collectors.toList());
	}
}
