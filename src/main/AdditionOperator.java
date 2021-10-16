package main;

public class AdditionOperator extends BinaryOperator {

	public AdditionOperator(int operator1, int operator2) {
		//constructor, initializing the parent BinaryOperators
		super(operator1, operator2);
	}

	@Override
	public int operate() {
		return operand1 + operand2;
	}
	
	public int getGreater() {
		return Math.max(operand1, operand2);
	}
}
