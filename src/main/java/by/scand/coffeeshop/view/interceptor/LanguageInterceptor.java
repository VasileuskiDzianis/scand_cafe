package by.scand.coffeeshop.view.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import by.scand.coffeeshop.service.localization.LocalizationService;

/*
 * This class is using as filter, which
 * check cookies end set language for all application.
 * 
*/

public class LanguageInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	private LocalizationService localizationService;

	
	public LanguageInterceptor() {
		
	}
	
	public void setLocalizationService(LocalizationService localizationService) {
		this.localizationService = localizationService;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		String language = "";

		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("language")) {// check existence
															// language's cookie
					language = cookie.getValue();

				}
			}
			if (!language.equals("")) { // if cookie was found, set it's
										// language
				localizationService.setLanguage(language);

			} else { // if our cookie wasn't found, set default language "en"
						// and add cookie
				localizationService.setLanguage("en");
				Cookie cookieLang = new Cookie("language", localizationService.getLanguage());
				cookieLang.setMaxAge(60 * 60 * 24 * 7);
				response.addCookie(cookieLang);

			}

		} else { // if no one cookie wasn't found, set default language "en" and
					// add cookie
			localizationService.setLanguage("en");
			Cookie cookieLang = new Cookie("language", localizationService.getLanguage());
			cookieLang.setMaxAge(60 * 60 * 24 * 7);
			response.addCookie(cookieLang);

		}

		localizationService.refreshAttributes();

		request.setAttribute("localization", localizationService);

		return true;
	}

}
