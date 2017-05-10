package by.scand.coffeeshop.view.contoller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import by.scand.coffeeshop.exception.ServiceException;
import by.scand.coffeeshop.service.localization.LocalizationService;
import by.scand.coffeeshop.service.shop.ShopService;

@Controller
@SessionAttributes("order")
public class BuyController {

	private ShopService shopService;

	@Autowired
	public BuyController(ShopService shopService) {
		this.shopService = shopService;
	}

	private static final Logger logger = LoggerFactory.getLogger(BuyController.class);

	@RequestMapping(value = "buy", method = RequestMethod.POST)
	public String home(Model model, @RequestParam MultiValueMap<String, String> requestParameters,
			@RequestAttribute(name = "localization") LocalizationService localizationService) {

		Map<Integer, Integer> buyItems;
		List<String> chosenSorts;
		chosenSorts = requestParameters.get("sort");
		if (chosenSorts != null) {
			buyItems = new HashMap<Integer, Integer>();
			Integer goodsId, goodsAmount;
			for (String sort : chosenSorts) {
				try {
					goodsAmount = Integer.parseUnsignedInt(requestParameters.get("amount_for_id_" + sort).get(0));
					goodsId = Integer.parseUnsignedInt(sort);
				} catch (NumberFormatException e) {
					logger.error("Error user input incorrect number", e);
					model.addAttribute("message", localizationService.getAttributes().get("messageIncorrectAmount"));
					return "message";
				}
				buyItems.put(goodsId, goodsAmount);
			}
		} else {
			model.addAttribute("message", localizationService.getAttributes().get("messageNoSelectedSorts"));
			return "message";
		}
		shopService.setLang(localizationService.getLanguage());
		try {
			model.addAttribute("order", shopService.buyGoods(buyItems));
		} catch (ServiceException e) {
			logger.error("Error with buying goods", e);
			model.addAttribute("message", localizationService.getAttributes().get("messageOrderProcessingError"));
			return "message";
		}
		return "order";
	}

}
