package wegennetwerk;

import java.util.HashSet;
import java.util.Set;
import logicalcollections.LogicalSet;

public class Kruispunt {

	/**
	 * @invar | vertrekwegen != null
	 * @invar | vertrekwegen.stream().allMatch(w -> w == null || w.startkruispunt == this)
	 */
	Set<Weg> vertrekwegen = new HashSet<Weg>();
	
	/**
	 * @invar | aankomstwegen != null
	 * @invar | aankomstwegen.stream().allMatch(w -> w == null || w.eindkruispunt == this)
	 */
	Set<Weg> aankomstwegen = new HashSet<Weg>();
	
	
	/**
	 * @creates | result
	 * @inspects | this
	 */
	public Set<Weg> getVertrekwegen(){
		return Set.copyOf(vertrekwegen);
	}
	
	/**
	 * @creates | result
	 * @inspects | this
	 */
	public Set<Weg> getAankomstwegen(){
		return Set.copyOf(aankomstwegen);
	}
	
	/**
	 * @post | getVertrekwegen().stream().allMatch(w -> w == null)
	 * @post | getAankomstwegen().stream().allMatch(w -> w == null)
	 */
	public Kruispunt() {}
	
	/**
	 * @throws IllegalArgumentException | weg == null || !getVertrekwegen().contains(weg)
	 * @post | weg.getStartkruispunt() == null
	 * @post | old(getVertrekwegen()).equals(LogicalSet.plus(getVertrekwegen(), weg))
	 * @mutates_properties | getVertrekwegen(), weg.getStartkruispunt()
	 */
	public void ontkoppelWegVanStartkruispunt(Weg weg) {
		if(weg == null | !vertrekwegen.contains(weg))
			throw new IllegalArgumentException();
		vertrekwegen.remove(weg);
		weg.startkruispunt = null;
	}
	
	/**
	 * @throws IllegalArgumentException | weg == null || !getAankomstwegen().contains(weg)
	 * @post | weg.getEindkruispunt() == null
	 * @post | old(getAankomstwegen()).equals(LogicalSet.plus(getAankomstwegen(), weg))
	 * @mutates_properties | getAankomstwegen(), weg.getEindkruispunt()
	 */
	public void ontkoppelWegVanEindkruispunt(Weg weg) {
		if(weg == null | !aankomstwegen.contains(weg))
			throw new IllegalArgumentException();
		aankomstwegen.remove(weg);
		weg.eindkruispunt = null;
	}
}
