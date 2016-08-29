package pl.sylwia.calculator.calculation.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import pl.sylwia.calculator.calculation.Register;
@Component
public class Multiply implements Register{

	@Override
	public BigDecimal calculate(BigDecimal number1, BigDecimal number2) {
		return number1.multiply(number2);
	}

}
