package pl.sylwia.calculator.domain;

import org.springframework.format.annotation.NumberFormat;

public class Form {

	@NumberFormat
	private String number1;
	@NumberFormat
	private String number2;

	public String getNumber1() {
		return number1;
	}

	public void setNumber1(String number1) {
		this.number1 = number1;
	}

	public String getNumber2() {
		return number2;
	}

	public void setNumber2(String number2) {
		this.number2 = number2;
	}

}
