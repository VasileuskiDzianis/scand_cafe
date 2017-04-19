package by.scand.coffeeshop.view.language;

import java.util.Map;

import by.scand.coffeeshop.dao.DaoException;
import by.scand.coffeeshop.dao.LocalizationDao;

/*
*	This class is using for UI localization.
*	To get all stored in DB attributes
*	we have to set language variable with necessary value, such as
*	"ru", "en", "fr" etc. and call method refreshAttributes()
*/

public class Localization {
	private String language;
	private Map<String, String> attributes;
	private LocalizationDao localizationDao;

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Map<String, String> getAttributes() {

		return attributes;
	}

	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
	}

	public void setLocalizationDao(LocalizationDao localDao) {
		this.localizationDao = localDao;

	}

	public void refreshAttributes() {
		try {
			localizationDao.getLocalization(this);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}

}
