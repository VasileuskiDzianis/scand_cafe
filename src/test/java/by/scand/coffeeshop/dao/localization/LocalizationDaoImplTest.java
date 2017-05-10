package by.scand.coffeeshop.dao.localization;

import static org.junit.Assert.*;

import org.junit.Test;

import by.scand.coffeeshop.dao.localization.LocalizationDaoImpl;
import by.scand.coffeeshop.exception.ServiceException;
import by.scand.coffeeshop.service.localization.LocalizationServiceImpl;

public class LocalizationDaoImplTest extends LocalizationDaoImpl {

	@Test
	public void testGetLocalization() throws ServiceException {
		LocalizationServiceImpl local = new LocalizationServiceImpl();
		local.setLocalizationDao(new LocalizationDaoImpl());
		
		local.setLanguage("en");
		local.refreshAttributes();
		
		assertEquals("home",local.getAttributes().get("homeButton"));
		
		local.setLanguage("ru");
		local.refreshAttributes();
		
		assertEquals("домой",local.getAttributes().get("homeButton"));
		
	}

}
