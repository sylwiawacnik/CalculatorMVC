package pl.sylwia.calculator.controller;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.sylwia.calculator.domain.Form;
import pl.sylwia.calculator.service.CalculateService;

@Controller
@Transactional
public class HomeController {

	@Autowired
	private CalculateService calculateService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("form", new Form());
		model.addAttribute("history", calculateService.showCalculationHistory());
		return "home";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String calculate(Model model, @Valid Form form, BindingResult bindingResult, HttpServletRequest request) {
		if (bindingResult.hasErrors())
			return "home";

		BigDecimal calculate = calculateService.calculate(form, request);
		model.addAttribute("calculate", calculate);
		model.addAttribute("history", calculateService.showCalculationHistory());

		return "home";
	}

	@RequestMapping(value = "/clean", method = RequestMethod.POST)
	public String clean(Model model) {
		calculateService.clean();
		return "redirect:/";

	}
}
