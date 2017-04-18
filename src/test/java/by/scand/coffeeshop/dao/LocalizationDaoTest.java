package by.scand.coffeeshop.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import by.scand.coffeeshop.view.language.Localization;

public class LocalizationDaoTest extends LocalizationDao {

	@Test
	public void testGetLocalization() {
		Localization local = new Localization();
		local.setLocalizationDao(new LocalizationDao());
		
		local.setLanguage("en");
		local.refreshAttributes();
		
		assertEquals("home",local.getAttributes().get("homeButton"));
		
		local.setLanguage("ru");
		local.refreshAttributes();
		
		assertEquals("домой",local.getAttributes().get("homeButton"));
		
	}

}
