package by.scand.coffeeshop.view.contoller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.scand.coffeeshop.exception.ServiceException;
import by.scand.coffeeshop.service.discount.DiscountService;
import by.scand.coffeeshop.service.localization.LocalizationService;
import by.scand.coffeeshop.service.shop.ShopService;

@Controller
public class CatalogController {
	private ShopService shopService;
	private DiscountService discountService;

	@Autowired
	public CatalogController(ShopService shopService, DiscountService discountService) {
		this.shopService = shopService;
		this.discountService = discountService;
	}

	private static final Logger logger = LoggerFactory.getLogger(CatalogController.class);

	@RequestMapping(value = { "/", "home" }, method = RequestMethod.GET)
	public String home(Model model, 
			@RequestAttribute(name = "localization") LocalizationService localizationService) {

		shopService.setLang(localizationService.getLanguage());

		try {
			model.addAttribute("catalog", shopService.getCatalog());
		} catch (ServiceException e) {
			if (localizationService.getAttributes() != null) {
				logger.error("Error showCatalog()", e);
				model.addAttribute("message", localizationService.getAttributes().get("messageOrderProcessingError"));
				return "message";
			} else {
				logger.error("Error showCatalog()", e);
				model.addAttribute("message", "Fatal error. Try later... Фатальная ошибка. Зайдите позже.");
				return "message";
			}

		}
		try {
			model.addAttribute("nCupFree", discountService.getNumberOfFreeCup());
		} catch (ServiceException e) {
			logger.error("Error getting business rules parameters", e);
			model.addAttribute("message", "Fatal error. Try later...Фатальная ошибка. Зайдите позже.");
			return "message";
		}

		return "catalog";
	}

}
