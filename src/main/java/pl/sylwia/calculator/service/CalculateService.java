package pl.sylwia.calculator.service;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.sylwia.calculator.calculation.impl.Add;
import pl.sylwia.calculator.calculation.impl.Divide;
import pl.sylwia.calculator.calculation.impl.Multiply;
import pl.sylwia.calculator.calculation.impl.Subtract;
import pl.sylwia.calculator.dao.CalculationHistoryDao;
import pl.sylwia.calculator.domain.CalculationHistory;
import pl.sylwia.calculator.domain.Form;

@Service
public class CalculateService {

	@Autowired
	private Add add;
	@Autowired
	private Divide divide;
	@Autowired
	private Subtract subtract;
	@Autowired
	private Multiply multiply;
	@Autowired
	private CalculationHistoryDao calculationHistoryDao;

	public BigDecimal calculate(Form form, HttpServletRequest request) {

		BigDecimal number1 = new BigDecimal(form.getNumber1());
		BigDecimal number2 = new BigDecimal(form.getNumber2());
		BigDecimal calculate;
		String operation;

		if (request.getParameter("add") != null) {
			calculate = add.calculate(number1, number2);
			operation = "+";
		} else if (request.getParameter("subtract") != null) {
			calculate = subtract.calculate(number1, number2);
			operation = "-";
		} else if (request.getParameter("multiply") != null) {
			calculate = multiply.calculate(number1, number2);
			operation = "*";
		} else {
			calculate = divide.calculate(number1, number2);
			operation = "/";
		}

		CalculationHistory calculationHistory = new CalculationHistory();
		calculationHistory.setNumber1(number1);
		calculationHistory.setNumber2(number2);
		calculationHistory.setResult(calculate);
		calculationHistory.setOperation(operation);

		calculationHistoryDao.save(calculationHistory);

		return calculate;
	}

	public List<CalculationHistory> showCalculationHistory() {
		return calculationHistoryDao.getAllHistory();
	}

	public void clean() {
		calculationHistoryDao.cleanAll();
	}

}
