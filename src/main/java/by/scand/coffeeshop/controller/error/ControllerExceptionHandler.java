package by.scand.coffeeshop.controller.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.Locale;

/**
 * Component that will handle all exceptions
 */
@ControllerAdvice
public class ControllerExceptionHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(ControllerExceptionHandler.class);
	@Autowired
	private MessageSource messageSource;

	@ExceptionHandler
	public String handle(Exception e, Model model, Locale locale) {

		LOGGER.error("Exception occur, ", e);

		model.addAttribute("message", messageSource.getMessage("message.internalServerError", null, locale));

		return "message";
	}
}