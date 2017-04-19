package by.scand.coffeeshop.view;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import by.scand.coffeeshop.domain.CoffeeShop;
import by.scand.coffeeshop.domain.DomainException;
import by.scand.coffeeshop.view.language.Localization;

@Controller
@SessionAttributes("order")
public class BuyController {
	@RequestMapping(value = "buy", method = RequestMethod.POST)
	public String home(Model model, HttpServletRequest request) {
		
		Localization localization = (Localization) request.getAttribute("localization");
		Map<Integer, Integer> items;
		String[] chosenSorts;
		chosenSorts = request.getParameterValues("sort");
		if (chosenSorts != null) {
			items = new HashMap<Integer, Integer>();
			for (String sort : chosenSorts) {
				Integer goodsId, goodsAmount;

				try {
					goodsAmount = Integer.parseUnsignedInt(request.getParameter("amount_for_id_" + sort));
					goodsId = Integer.parseUnsignedInt(sort);
				} catch (NumberFormatException e) {
					model.addAttribute("message", localization.getAttributes().get("messageIncorrectAmount"));
					return "message";
				}
				items.put(goodsId, goodsAmount);

			}
		} else {
			model.addAttribute("message", localization.getAttributes().get("messageNoSelectedSorts"));
			return "message";
		}
		ApplicationContext ctx = new ClassPathXmlApplicationContext("shop_spring.xml");
		CoffeeShop coffeeShop = (CoffeeShop) ctx.getBean("coffeeShop");
		coffeeShop.setLang(localization.getLanguage());
		try {
			model.addAttribute("order", coffeeShop.buyGoods(items));
		} catch (DomainException e) {
			model.addAttribute("message", localization.getAttributes().get("messageOrderProcessingError"));
			return "message";
		}

		return "order";
	}

}
