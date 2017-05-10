package by.scand.coffeeshop.service.localization;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import by.scand.coffeeshop.dao.localization.LocalizationDao;
import by.scand.coffeeshop.exception.DaoException;
import by.scand.coffeeshop.exception.ServiceException;

/*
*	This class is using for UI localization.
*	To get all stored in DB attributes
*	we have to set language variable with necessary value, such as
*	"ru", "en", "fr" etc. and call method refreshAttributes()
*/
@Component
public class LocalizationServiceImpl implements LocalizationService {
	private String language;
	private Map<String, String> attributes;
	
	@Autowired
	private LocalizationDao localizationDao;

	@Override
	public String getLanguage() {
		return language;
	}

	@Override
	public void setLanguage(String language) {
		this.language = language;
	}

	@Override
	public Map<String, String> getAttributes() {

		return attributes;
	}

	@Override
	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
	}

	public void setLocalizationDao(LocalizationDao localDao) {
		this.localizationDao = localDao;

	}

	@Override
	public void refreshAttributes() throws ServiceException{
		try {
			localizationDao.getLocalization(this);
		} catch (DaoException e) {
			throw new ServiceException("Getting localization parameters error", e);
		}
	}

}
