package by.scand.coffeeshop.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import by.scand.coffeeshop.domain.Buyer;
import by.scand.coffeeshop.domain.CoffeeShop;
import by.scand.coffeeshop.domain.DomainException;
import by.scand.coffeeshop.domain.Order;
import by.scand.coffeeshop.view.language.Localization;

@Controller
public class ConfirmController {
	private static final Logger logger = LoggerFactory.getLogger(ConfirmController.class);
	@RequestMapping(value = {"confirm"}, method = RequestMethod.POST)
	public String home(Model model, HttpSession session, HttpServletRequest request,
			@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,
			@RequestParam("patronymic") String patronymic,
			@RequestParam("address") String address) {
		
		Localization localization = (Localization) request.getAttribute("localization");
		
		Buyer buyer;
		
		if ((!address.trim().equals(""))&(address.length()>=10)){ //address field can't be empty an less than 10
			buyer = new Buyer(firstName,lastName,patronymic,address);
		} else{
			logger.error("Error user input incorrect address");
			model.addAttribute("message", localization.getAttributes().get("messageFieldAddressEmpty"));
			return "message";
		}
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("shop_spring.xml");
		CoffeeShop coffeeShop = (CoffeeShop)ctx.getBean("coffeeShop");
		coffeeShop.setLang("en");
		Order order = (Order)session.getAttribute("order");
		
		
				
		
		try {
			if (coffeeShop.confirmOrder(buyer, order)){
			model.addAttribute("message", localization.getAttributes().get("messageOrderAccepted"));
			} else model.addAttribute("message", localization.getAttributes().get("messageOrderProcessingError"));
		} catch (DomainException e) {
			logger.error("Error with adding order to DB", e);
			model.addAttribute("message", localization.getAttributes().get("messageOrderProcessingError"));
		}
		
		session.removeAttribute("order");
		return "message";
	}
	
}
