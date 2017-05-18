package by.scand.coffeeshop.controller;

import java.util.HashMap;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import by.scand.coffeeshop.domain.BuyForm;
import by.scand.coffeeshop.domain.Items;
import by.scand.coffeeshop.service.order.OrderService;

@Controller
@SessionAttributes("order")
public class BuyController {

	private static final Logger LOGGER = LoggerFactory.getLogger(BuyController.class);

	@Autowired
	private OrderService orderService;
	@Autowired
	private MessageSource messageSource;

	@RequestMapping(value = "buy", method = RequestMethod.POST)
	public String buy(Model model, Locale locale, @ModelAttribute BuyForm items) {
		int numberOfSelectedItems = 0;
		Map<Integer, Integer> buyItems = new HashMap<Integer, Integer>(); // K - product id; V - amount

		for (Items item : items.getItems()) {

			if ((item.getId() != 0) && (item.getAmount() != null)) {
				buyItems.put(item.getId(), item.getAmount());
				numberOfSelectedItems++;
			}

		}

		if (numberOfSelectedItems == 0) {
			model.addAttribute("message", messageSource.getMessage("message.NoSelectedSorts", null, locale));
			
			return "message";
		}

		model.addAttribute("order", orderService.buyGoods(buyItems, locale.getLanguage()));

		return "order";
	}

	private static boolean validateAmount(String amount) {

		String regEx = "\\d{1,2}"; // 1-2 decimal digits
		Pattern pattern = Pattern.compile(regEx);
		Matcher m = pattern.matcher(amount.trim());

		return m.matches();
	}

}
