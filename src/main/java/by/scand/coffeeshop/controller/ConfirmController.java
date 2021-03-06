package by.scand.coffeeshop.controller;

import java.util.Locale;
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
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.support.SessionStatus;

import by.scand.coffeeshop.domain.Buyer;
import by.scand.coffeeshop.domain.Order;
import by.scand.coffeeshop.service.order.OrderService;

@Controller
public class ConfirmController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ConfirmController.class);
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private MessageSource messageSource;

	@RequestMapping(value = { "confirm" }, method = RequestMethod.POST)
	public String home(Model model, Locale locale, @SessionAttribute Order order, @ModelAttribute Buyer buyer,
			SessionStatus status) {

		if (!validateAddress(buyer.getAddress())) {
			LOGGER.error("Error user input incorrect address");
			model.addAttribute("message", messageSource.getMessage("message.FieldAddressEmpty", null, locale));
			
			return "message";
		}

		orderService.confirmOrder(buyer, order);

		model.addAttribute("message", messageSource.getMessage("message.OrderAccepted", null, locale));
		status.setComplete();
		
		return "message";
	}

	private static boolean validateAddress(String address) {
		
		String regEx = "[a-zA-zа-яА-я0-9 ,.№-]{10,90}"; //minimum 10 characters address begins from letter
		Pattern pattern = Pattern.compile(regEx);
		Matcher m = pattern.matcher(address.trim());
		
		return m.matches();
	}
}