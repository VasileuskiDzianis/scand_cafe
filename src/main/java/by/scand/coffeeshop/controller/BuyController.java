package by.scand.coffeeshop.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import by.scand.coffeeshop.exception.ServiceException;
import by.scand.coffeeshop.service.shop.ShopService;

@Controller
@SessionAttributes("order")
public class BuyController {
	@Autowired
	private ShopService shopService;
	@Autowired
	private MessageSource messageSource;

	private static final Logger LOGGER = LoggerFactory.getLogger(BuyController.class);

	@RequestMapping(value = "buy", method = RequestMethod.POST)
	public String buy(Model model, Locale locale, 
			@RequestParam Map<String, String> orderParameters,
			@RequestParam("chosenIds") List<Integer> chosenIds) {
		Map<Integer, Integer> buyItems; //K - product id; V - amount
		if (chosenIds != null) {
			buyItems = new HashMap<Integer, Integer>();
			Integer goodsId, goodsAmount;
			for (Integer id : chosenIds) {
				try {
					goodsAmount = Integer.parseUnsignedInt(orderParameters.get("amount_for_id_" + id));
					goodsId = id;
				} catch (NumberFormatException e) {
					LOGGER.error("Error user input incorrect number", e);
					model.addAttribute("message",
							messageSource.getMessage("label.messageIncorrectAmount", null, locale));
					return "message";
				}
				buyItems.put(goodsId, goodsAmount);
			}
		} else {
			model.addAttribute("message", messageSource.getMessage("label.messageNoSelectedSorts", null, locale));
			return "message";
		}
		try {
			model.addAttribute("order", shopService.buyGoods(buyItems, locale.getLanguage()));
		} catch (ServiceException e) {
			LOGGER.error("Error with buying goods", e);
			model.addAttribute("message", messageSource.getMessage("label.messageOrderProcessingError", null, locale));
			return "message";
		}
		return "order";
	}

}
