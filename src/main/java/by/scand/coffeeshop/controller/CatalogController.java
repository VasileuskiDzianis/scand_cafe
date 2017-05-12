package by.scand.coffeeshop.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.scand.coffeeshop.exception.ServiceException;
import by.scand.coffeeshop.service.discount.DiscountService;
import by.scand.coffeeshop.service.shop.ShopService;

@Controller
public class CatalogController {
	@Autowired
	private ShopService shopService;
	@Autowired
	private DiscountService discountService;
	@Autowired
	private MessageSource messageSource;

	private static final Logger LOGGER = LoggerFactory.getLogger(CatalogController.class);

	@RequestMapping(value = { "/", "home" }, method = RequestMethod.GET)
	public String home(Model model, Locale locale) {

		//shopService.setLanguage(locale.getLanguage());

		try {
			model.addAttribute("catalog", shopService.getCatalog(locale.getLanguage()));
		} catch (ServiceException e) {
				LOGGER.error("Error showCatalog()", e);
				model.addAttribute("message", messageSource.getMessage("message.internalServerError", null, locale));
				return "message";
			}
		try {
			model.addAttribute("nCupFree", discountService.getNumberOfFreeCup());
		} catch (ServiceException e) {
			LOGGER.error("Error getting business rules parameters", e);
			model.addAttribute("message", messageSource.getMessage("message.internalServerError", null, locale));
			return "message";
		}

		return "catalog";
	}

}
