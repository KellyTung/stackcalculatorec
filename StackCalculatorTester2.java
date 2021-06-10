import java.util.ArrayList;
import java.util.List;

public class StackCalculatorTester2 
{
	public static void main(String[] args) 
	{
		StackCalculatorTester2 test = new StackCalculatorTester2();
		test.run();
	}
	
	public void run() 
	{
		ExprUtils utils = new ExprUtils();
		StackCalculator stackIt = new StackCalculator();
		String expr;
		
		System.out.println("\n\n");
		
		expr = "5 + 3 * 5";
		double answer = stackIt.evaluateExpression(utils.tokenizeExpression(expr));
		System.out.printf("%s = %.4f%n%n", expr, answer);
		
		expr = "2.1 + 7 * (5 - 2)";
		answer = stackIt.evaluateExpression(utils.tokenizeExpression(expr));
		System.out.printf("%s = %.4f%n%n", expr, answer);
		
		expr = "3.456 * 22 / (.65 - 23)";
		answer = stackIt.evaluateExpression(utils.tokenizeExpression(expr));
		System.out.printf("%s = %.4f%n%n", expr, answer);
		
		expr = "54 + 0.12 * 3 - 4 / 4.6 - (2 ^ 4 - 3) + 1";
		answer = stackIt.evaluateExpression(utils.tokenizeExpression(expr));
		System.out.printf("%s = %.4f%n%n", expr, answer);
		
		expr = "4 * (3 + 8) - 18 / (7 * 3)";
		answer = stackIt.evaluateExpression(utils.tokenizeExpression(expr));
		System.out.printf("%s = %.4f%n%n", expr, answer);
		
		expr = "27 - ((3 - 6 * 2) + 37 - 3 ^ 5 + 1) - 3";
		answer = stackIt.evaluateExpression(utils.tokenizeExpression(expr));
		System.out.printf("%s = %.4f%n%n", expr, answer);
		
		expr = "(2 * 7 - 1) - ((4 - 16 % (2 + 5) / 6) + 43 - 4 ^ 3 + 1) - 3";
		answer = stackIt.evaluateExpression(utils.tokenizeExpression(expr));
		System.out.printf("%s = %.4f%n%n", expr, answer);
		
		System.out.println("\n\n");
	}
}

/*
C:\Java\StackCalculator> java StackCalculatorTester2



5 + 3 * 5 = 20.0000

2.1 + 7 * (5 - 2) = 23.1000

3.456 * 22 / (.65 - 23) = -3.4019

54 + 0.12 * 3 - 4 / 4.6 - (2 ^ 4 - 3) + 1 = 41.4904

4 * (3 + 8) - 18 / (7 * 3) = 43.1429

27 - ((3 - 6 * 2) + 37 - 3 ^ 5 + 1) - 3 = 238.0000

(2 * 7 - 1) - ((4 - 16 % (2 + 5) / 6) + 43 - 4 ^ 3 + 1) - 3 = 26.3333




C:\Java\StackCalculator>
*/