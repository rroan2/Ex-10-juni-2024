package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import uitdrukking.LetterlijkUitdrukking;
import uitdrukking.OptellingUitdrukking;
import uitdrukking.VariabeleUitdrukking;

class UitdrukkingTest {

	@Test
	void test() {
		LetterlijkUitdrukking let = new LetterlijkUitdrukking(2);
		assertEquals(2, let.getWaarde());
		VariabeleUitdrukking var = new VariabeleUitdrukking("x");
		assertEquals("x", var.getVariabele());
		assertEquals(0, let.aantalVoorkomens("x"));
		assertEquals(1, var.aantalVoorkomens("x"));
		
		OptellingUitdrukking o1 = new OptellingUitdrukking(var, let);
		assertEquals(o1.getLinks(), var);
		OptellingUitdrukking o2 = new OptellingUitdrukking(o1, o1);
		assertEquals(o2.getRechts(), o1);
		OptellingUitdrukking o3 = new OptellingUitdrukking(o2, var);
		assertEquals(3, o3.aantalVoorkomens("x"));
	}

}
