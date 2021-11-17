package junit_tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Product;

public class TestProduct {

	@Test
	public void test_product_1() {
		Product p = new Product();

		assertNull(p.getModel());

		assertTrue(p.getFinish() == null);
		assertFalse(p.getFinish() != null);

		assertTrue(p.getStorage() == 0);
		assertEquals(0, p.getStorage());

		assertFalse(p.hasCellularConnectivity());
		assertFalse(p.hasCellularConnectivity() == true);
		assertTrue(p.hasCellularConnectivity() == false);
		assertTrue(p.hasCellularConnectivity() != true);
		assertTrue(!(p.hasCellularConnectivity() == true));
		assertTrue(!p.hasCellularConnectivity());

		assertEquals(0.0, p.getOriginalPrice(), 0.1);
		//assertTrue(0.0 == p.getOriginalPrice());
		assertEquals(0.0, p.getDiscountValue(), 0.1);
		assertEquals(0.0, p.getPrice(), 0.1);

		assertEquals("null null 0GB(cellular connectivity: false): $(0.00 - 0.00)", p.toString());
	}

	@Test
	public void test_product_2() {
		Product p = new Product(new String("iPad Pro 12.9"), 1709.00);

		assertNotNull(p.getModel());
		assertEquals("iPad Pro 12.9", p.getModel());
		assertTrue(p.getModel().equals("iPad Pro 12.9"));
		//assertTrue(p.getModel() == "iPad Pro 12.9");

		assertTrue(p.getFinish() == null);
		assertFalse(p.getFinish() != null);

		assertTrue(p.getStorage() == 0);
		assertEquals(0, p.getStorage());

		assertFalse(p.hasCellularConnectivity());
		assertFalse(p.hasCellularConnectivity() == true);
		assertTrue(p.hasCellularConnectivity() == false);
		assertTrue(p.hasCellularConnectivity() != true);
		assertTrue(!(p.hasCellularConnectivity() == true));
		assertTrue(!p.hasCellularConnectivity());

		assertEquals(1709.00, p.getOriginalPrice(), 0.1);
		//assertTrue(0.0 == p.getOriginalPrice());
		assertEquals(0.0, p.getDiscountValue(), 0.1);
		assertEquals(1709.00, p.getPrice(), 0.1);

		assertEquals("iPad Pro 12.9 null 0GB(cellular connectivity: false): $(1709.00 - 0.00)", p.toString());


	}
	
	@Test
	public void test_product_3() {
		
		Product p = new Product(new String("iPad Pro 12.9"), 1709.00);

		assertNotNull(p.getModel());
		assertEquals("iPad Pro 12.9", p.getModel());
		assertTrue(p.getModel().equals("iPad Pro 12.9"));
		//assertTrue(p.getModel() == "iPad Pro 12.9");

		p.setFinish("Space Grey");
		assertFalse(p.getFinish() == null);
		assertTrue(p.getFinish() != null);
		assertEquals("Space Grey", p.getFinish());
		assertTrue(p.getFinish().equals("Space Grey"));

		p.setStorage(1000);
		assertTrue(p.getStorage() == 1000);
		assertEquals(1000, p.getStorage());

		p.setHasCellularConnectivity(true);
		assertFalse(!p.hasCellularConnectivity());
		assertFalse(p.hasCellularConnectivity() == false);
		assertTrue(p.hasCellularConnectivity() == true);
		assertTrue(p.hasCellularConnectivity() != false);
		assertTrue(!(p.hasCellularConnectivity() == false));
		assertTrue(!(!p.hasCellularConnectivity()));

		assertEquals(1709.00, p.getOriginalPrice(), 0.1);
		//assertTrue(0.0 == p.getOriginalPrice());
		p.setDiscountValue(220.00);
		assertEquals(220.00, p.getDiscountValue(), 0.1);
		assertEquals(1489.00, p.getPrice(), 0.1);

		assertEquals("iPad Pro 12.9 Space Grey 1000GB(cellular connectivity: true): $(1709.00 - 220.00)", p.toString());


	}

}
