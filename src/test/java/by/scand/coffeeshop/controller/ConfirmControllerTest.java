package by.scand.coffeeshop.controller;

import static org.junit.Assert.*;

import org.junit.Test;

import by.scand.coffeeshop.controller.ConfirmController;

public class ConfirmControllerTest {

	@Test
	public void testValidateAddress() {
		
		assertEquals(false, ConfirmController.validateAddress(""));
		assertEquals(false, ConfirmController.validateAddress(" г.Минск"));
		assertEquals(false, ConfirmController.validateAddress("г.Минск, ул.Центральная+"));
		assertEquals(true, ConfirmController.validateAddress(" г.Минск, ул.Центральная"));
		assertEquals(false, ConfirmController.validateAddress("#г.Минск, ул.Центральная"));
		assertEquals(false, ConfirmController.validateAddress("      г.Минск    "));
		assertEquals(true, ConfirmController.validateAddress("      г.Минск, ул. Гая    "));
	}
}
