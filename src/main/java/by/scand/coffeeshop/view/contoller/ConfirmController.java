package by.scand.coffeeshop.view.contoller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.support.SessionStatus;

import by.scand.coffeeshop.domain.Buyer;
import by.scand.coffeeshop.domain.Order;
import by.scand.coffeeshop.exception.ServiceException;
import by.scand.coffeeshop.service.localization.LocalizationService;
import by.scand.coffeeshop.service.shop.ShopService;

@Controller
public class ConfirmController {
	private ShopService shopService;
	
	@Autowired
	public ConfirmController(ShopService shopService) {
		this.shopService = shopService;
	}
	
	private static final Logger logger = LoggerFactory.getLogger(ConfirmController.class);
	@RequestMapping(value = {"confirm"}, method = RequestMethod.POST)
	public String home(Model model,
			@RequestAttribute(name="localization") LocalizationService localizationService,
			@SessionAttribute Order order,
			@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,
			@RequestParam("patronymic") String patronymic,
			@RequestParam("address") String address,
			SessionStatus status) {
		
		Buyer buyer;
		
		if (validateAddress(address)){
			buyer = new Buyer(firstName,lastName,patronymic,address);
		} else{
			logger.error("Error user input incorrect address");
			model.addAttribute("message", localizationService.getAttributes().get("messageFieldAddressEmpty"));
			return "message";
		}
		
		shopService.setLang("en");
		
		try {
			if (shopService.confirmOrder(buyer, order)){
			model.addAttribute("message", localizationService.getAttributes().get("messageOrderAccepted"));
			} else model.addAttribute("message", localizationService.getAttributes().get("messageOrderProcessingError"));
		} catch (ServiceException e) {
			logger.error("Error with adding order to DB", e);
			model.addAttribute("message", localizationService.getAttributes().get("messageOrderProcessingError"));
		}
		
		status.setComplete();
		return "message";
	}
	
	protected static boolean validateAddress(String address){
		String regexC = "[a-zA-zа-яА-я0-9 ,.№-]{10,30}"; //minimum 10 characters, address begins from letter
		Pattern pattern = Pattern.compile(regexC);
		Matcher m = pattern.matcher(address.trim());
		return m.matches();
	}
	
}
