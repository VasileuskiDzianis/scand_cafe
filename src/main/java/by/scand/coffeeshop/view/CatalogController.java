package by.scand.coffeeshop.view;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.scand.coffeeshop.domain.BusinessRules;
import by.scand.coffeeshop.domain.BusinessRulesImpl;
import by.scand.coffeeshop.domain.CoffeeShop;
import by.scand.coffeeshop.domain.DomainException;
import by.scand.coffeeshop.view.language.Localization;

@Controller
public class CatalogController {
	private static final Logger logger = LoggerFactory.getLogger(CatalogController.class);
	@RequestMapping(value = {"/","home"}, method = RequestMethod.GET)
	public String home(Model model, HttpServletRequest request) {
		
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("shop_spring.xml");
		CoffeeShop coffeeShop = (CoffeeShop)ctx.getBean("coffeeShop");
		
		Localization localization = (Localization)request.getAttribute("localization");
		
		coffeeShop.setLang(localization.getLanguage());
		BusinessRulesImpl businessRules = (BusinessRulesImpl)ctx.getBean("businessRules");
		try {
			businessRules.refreshRules();
		} catch (DomainException e) {
			logger.error("Error refreshRules()", e);
			model.addAttribute("message", "Fatal error. Try later... Фатальная ошибка. Зайдите позже.");
			return "message";
		}
		
		try {
			model.addAttribute("catalog", coffeeShop.showCatalog() );
		} catch (DomainException e) {
			if (localization.getAttributes() != null){
			logger.error("Error showCatalog()", e);	
			model.addAttribute("message", localization.getAttributes().get("messageOrderProcessingError"));
			return "message";
			} else {
				logger.error("Error showCatalog()", e);	
				model.addAttribute("message", "Fatal error. Try later... Фатальная ошибка. Зайдите позже.");
				return "message";
			}
			
		}
		try {
			model.addAttribute("nCupFree", businessRules.getEachNCupFree());
		} catch (DomainException e) {
			logger.error("Error getting business rules parameters", e);	
			model.addAttribute("message", "Fatal error. Try later...Фатальная ошибка. Зайдите позже.");
			return "message";
		}
			
		return "catalog";
	}
	
}
