package by.scand.coffeeshop.view.contoller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LanguageController {
	@RequestMapping(value = "language", method = RequestMethod.GET)
	public String home(Model model, HttpServletResponse response, @RequestParam("lang") String language) {
		if (language != null){
		Cookie cookieLang = new Cookie("language",language);
		cookieLang.setMaxAge(60*60*24*7);
		response.addCookie(cookieLang);
		}
					
		return "redirect:home";
	}
	
}
