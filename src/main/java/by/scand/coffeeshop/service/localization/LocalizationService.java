package by.scand.coffeeshop.service.localization;

import java.util.Map;

import by.scand.coffeeshop.exception.ServiceException;

public interface LocalizationService {

	String getLanguage();

	void setLanguage(String language);

	Map<String, String> getAttributes();

	void setAttributes(Map<String, String> attributes);

	void refreshAttributes() throws ServiceException;

}