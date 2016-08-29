package pl.sylwia.calculator.calculation.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import pl.sylwia.calculator.calculation.Register;

@Component
public class Divide implements Register {

	@Override
	public BigDecimal calculate(BigDecimal number1, BigDecimal number2) {
		if (number2.equals(BigDecimal.ZERO)) {
			throw new UnsupportedOperationException("Dzielenie przez zero");
		}
		return number1.divide(number2, BigDecimal.ROUND_HALF_UP);
	}

}
