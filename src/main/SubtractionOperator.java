package main;

public class SubtractionOperator extends BinaryOperator {
	public SubtractionOperator(int operator1, int operator2) {
		//constructor, initializing the parent BinaryOperator
		super(operator1, operator2);
	}

	@Override
	public int operate() {
		return operand1 - operand2;
	}
	
	public boolean isBothOperandEqual() {
		return operand1 == operand2;
	}
}
