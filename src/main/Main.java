package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class Main {
	
	public static void checkWithoutPolymorphismExample() {
		System.out.println("---checkWithoutPolymorphismExample---");
		
		BinaryOperator binaryOperator = new BinaryOperator(6, 5);
		AdditionOperator operatorAdd = new AdditionOperator(6, 5);
		SubtractionOperator operatorSub = new SubtractionOperator(6, 5);
		
		System.out.println("Binary: "+binaryOperator.operate());
		System.out.println("Addition: "+operatorAdd.operate());
		System.out.println("Subtraction: "+operatorSub.operate());
	}
	
	public static void checkPolymorphismExample() {
		System.out.println("---checkPolymorphismExample---");
		
		BinaryOperator binaryOperator = new BinaryOperator(6, 5);
		//See: AdditionOperator is assigned to BinaryOperator
		BinaryOperator operatorAdd = new AdditionOperator(6, 5);
		//See: SubtractionOperator is assigned to BinaryOperator
		BinaryOperator operatorSub = new SubtractionOperator(6, 5);
		
		System.out.println("Binary: "+binaryOperator.operate());
		System.out.println("Addition: "+operatorAdd.operate());
		System.out.println("Subtraction: "+operatorSub.operate());
	}
	
	public static boolean isSameResult(BinaryOperator op1, BinaryOperator op2) {
		return op1.operate() ==  op2.operate();
	}
	
	public static void checkPolymorphismUseCase1() {
		System.out.println("---checkPolymorphismUseCase1---");
		
		AdditionOperator op1 = new AdditionOperator(6, 5);
		SubtractionOperator op2 = new SubtractionOperator(6, 5);
		SubtractionOperator op3 = new SubtractionOperator(12, 1);
		
    	//passing the AdditionOperator, SubtractionOperator to method
		System.out.println(isSameResult(op1, op2));
    	//passing the AdditionOperator, SubtractionOperator to method
		System.out.println(isSameResult(op1, op3));
	}
	
	public static void checkPolymorphismUseCase2() {
		System.out.println("---checkPolymorphismUseCase2---");
		
		//List of BinaryOperator
		ArrayList<BinaryOperator> operators = new ArrayList<>();
		//Adding child: AdditionOperator to list of BinaryOperator
		operators.add(new AdditionOperator(6, 5));
		//Adding child: SubtractionOperator to list of BinaryOperator
		operators.add(new SubtractionOperator(6, 5));
		//Adding child: SubtractionOperator to list of BinaryOperator
		operators.add(new SubtractionOperator(10, 2));

		for(BinaryOperator op: operators) {
			System.out.println(op.operate());
		}
	}
	
	public static void checkPolymorphismTypeSafetyCasting() {
		System.out.println("---checkPolymorphismTypeSafetyCasting---");
		
		//Polymorphism
		BinaryOperator binOp = new AdditionOperator(6, 5);

		//type safety check
		if(binOp instanceof AdditionOperator) {
			//safely casting
			AdditionOperator additionOp = (AdditionOperator) binOp;
			System.out.println(additionOp.getGreater());
		}
		//type safety check
		if(binOp instanceof SubtractionOperator) {
			//safely casting
			SubtractionOperator subtractionOp = (SubtractionOperator) binOp;
			System.out.println(subtractionOp.isBothOperandEqual());
		}
	}
	
	public static void checkPolymorphismPossibleCases() {
		//uncomment to see Compilation errors
		/*
		AdditionOperator additionOp = new AdditionOperator(6,5); 
		//--> Possible (Normal object declaration)
		
		BinaryOperator binOp = new AdditionOperator(6,5); 
		//--> Possible (Child can be initialized to parent, Polymorphism)
		
		String string = new AdditionOperator(6,5); 
		//--> Compilation Error (String is not a parent)
		
		AdditionOperator additionOp1 = new BinaryOperator(6,5); 
		//--> Compilation Error (Parent cannot be assigned to child)
		
		AdditionOperator additionOp2 = new SubtractionOperator(6,5); 
		//--> Compilation Error (Child cannot be assigned to another child)
		
		AdditionOperator castedAdditionOp = (AdditionOperator) binOp;
		//--> Possible (binOp was an object of AdditionOperator)
		
		SubtractionOperator castedSubtractionOp = (SubtractionOperator) binOp;
		//--> Runtime Error (binOp was not an object of SubtractionOperator)
		 */
	}
	
	public static void checkPolymorphismReallifeExamples() {
		System.out.println("---checkPolymorphismReallifeExamples---");
		
		//ArrayList is assigned to List, Polymorphism
		List<String> list = new ArrayList<>();
		
		//LinkedList is assigned to Queue, Polymorphism
		Queue<String> queue = new LinkedList<>();
		
		//HashMap is assigned to Map, Polymorphism
		Map<String, Integer> hashMap = new HashMap<>();
		
		//TreeMap is assigned to Map, Polymorphism
		Map<String, Integer> treeMap = new TreeMap<>();
	}
	
	public static void main(String[] args) {
		checkWithoutPolymorphismExample();
		
		checkPolymorphismExample();
		
		checkPolymorphismUseCase1();
		
		checkPolymorphismUseCase2();
		
		checkPolymorphismTypeSafetyCasting();
		
		checkPolymorphismPossibleCases();
		
		checkPolymorphismReallifeExamples();
	}
}
