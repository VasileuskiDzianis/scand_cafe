package by.scand.coffeeshop.dao.localization;

import by.scand.coffeeshop.exception.DaoException;
import by.scand.coffeeshop.service.localization.LocalizationService;

public interface LocalizationDao {

	void getLocalization(LocalizationService localizationServiceImpl) throws DaoException;

}