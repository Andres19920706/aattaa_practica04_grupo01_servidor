package aattaa.practica04.servidorHttp;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Servidor para comprobar la petición  POST
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, HttpServletRequest request,Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		String resultado;
		
		if(request.getParameter("nombre")!=null){
			System.out.println(request.getParameter("nombre"));
			resultado = "OK";
		}else{
			System.out.println("Peticion incompleta");
			resultado = "ERROR";
		}
		
		model.addAttribute("resultado", resultado );
		return "home";
	}
	
}
