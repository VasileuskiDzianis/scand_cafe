package by.scand.coffeeshop.view.language;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LanguageHandler extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("shop_spring.xml");

		Localization localization = (Localization) ctx.getBean("localization");

		String language = "";

		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("language")) {// check existence
															// language's cookie
					language = cookie.getValue(); 

				}
			}
			if (!language.equals("")) { //if cookie was found, set it's language
				localization.setLanguage(language);

			} else { //if cookie wasn't found, set default language "en" and add cookie
				localization.setLanguage("en");
				Cookie cookieLang = new Cookie("language",localization.getLanguage());
				cookieLang.setMaxAge(60*60*24*7);
				response.addCookie(cookieLang);
				
			}

		} else {
			localization.setLanguage("en");
			Cookie cookieLang = new Cookie("language",localization.getLanguage());
			cookieLang.setMaxAge(60*60*24*7);
			response.addCookie(cookieLang);
			
		}

		

		localization.refreshAttributes();

		request.setAttribute("localization", localization);

		return true;
	}

}
