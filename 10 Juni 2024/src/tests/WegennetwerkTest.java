package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import wegennetwerk.Kruispunt;
import wegennetwerk.Weg;

class WegennetwerkTest {

	@Test
	void test() {
		Weg weg1 = new Weg();
		Kruispunt kruispunt1 = new Kruispunt();	
		Kruispunt kruispunt2 = new Kruispunt();
		weg1.stelInAlsEindkruispunt(kruispunt1);
		assertEquals(weg1.getEindkruispunt(), kruispunt1);
		weg1.stelInAlsStartkruispunt(kruispunt2);
		assertEquals(weg1.getStartkruispunt(), kruispunt2);
		
		assert(kruispunt1.getAankomstwegen().contains(weg1));
		assert(kruispunt2.getVertrekwegen().contains(weg1));
		
		kruispunt1.ontkoppelWegVanEindkruispunt(weg1);
		assert(!kruispunt1.getAankomstwegen().contains(weg1));
		kruispunt2.ontkoppelWegVanStartkruispunt(weg1);
		assert(!kruispunt2.getAankomstwegen().contains(weg1));
	}

}
