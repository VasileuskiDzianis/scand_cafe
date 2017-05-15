package by.scand.coffeeshop.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	public String buy(Model model, Locale locale, @RequestParam Map<String, String> orderParameters,
			@RequestParam(name="chosenIds", required=false) List<Integer> chosenIds) {
		Map<Integer, Integer> buyItems; // K - product id; V - amount
		if (chosenIds == null) {
			model.addAttribute("message", messageSource.getMessage("label.messageNoSelectedSorts", null, locale));
			return "message";
		}
		buyItems = new HashMap<Integer, Integer>();
		Integer goodsId, goodsAmount;
		for (Integer id : chosenIds) {
			if (!validateAmount(orderParameters.get("amount_for_id_" + id))) {
				model.addAttribute("message", messageSource.getMessage("label.messageIncorrectAmount", null, locale));
				return "message";
			}
			goodsAmount = Integer.parseUnsignedInt(orderParameters.get("amount_for_id_" + id));
			goodsId = id;
			buyItems.put(goodsId, goodsAmount);
		}

		model.addAttribute("order", shopService.buyGoods(buyItems, locale.getLanguage()));
		return "order";
	}

	private static boolean validateAmount(String amount) {
		String regEx = "\\d{1,2}"; // 1-2 decimal digits
		Pattern pattern = Pattern.compile(regEx);
		Matcher m = pattern.matcher(amount.trim());
		return m.matches();
	}

}
