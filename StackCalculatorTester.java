import java.util.ArrayList;
import java.util.List;

public class StackCalculatorTester 
{
	public static void main(String[] args) 
	{
		StackCalculatorTester test = new StackCalculatorTester();
		test.run();
	}
	
	public void run() 
	{
		ExprUtils utils = new ExprUtils();
		StackCalculator stackIt = new StackCalculator();
		String expr;
		
		System.out.println("\n\n");
		
		expr = "2 + 3 * 5";
		double answer = stackIt.evaluateExpression(utils.tokenizeExpression(expr));
		System.out.printf("%s = %.4f%n%n", expr, answer);
		
		expr = "2.1 + 3 * (5 - 4)";
		answer = stackIt.evaluateExpression(utils.tokenizeExpression(expr));
		System.out.printf("%s = %.4f%n%n", expr, answer);
		
		expr = "3.456 * 23 / (.5 - 23)";
		answer = stackIt.evaluateExpression(utils.tokenizeExpression(expr));
		System.out.printf("%s = %.4f%n%n", expr, answer);
		
		expr = "54 + 0.12 * 3 - 4 / 5.6 - (2 ^ 3 - 4) + 1";
		answer = stackIt.evaluateExpression(utils.tokenizeExpression(expr));
		System.out.printf("%s = %.4f%n%n", expr, answer);
		
		expr = "4 * (3 + 2) - 18 / (6 * 3)";
		answer = stackIt.evaluateExpression(utils.tokenizeExpression(expr));
		System.out.printf("%s = %.4f%n%n", expr, answer);
		
		expr = "27 - ((3 - 6 * 2) + 34 - 3 ^ 2 + 1) - 3";
		answer = stackIt.evaluateExpression(utils.tokenizeExpression(expr));
		System.out.printf("%s = %.4f%n%n", expr, answer);
		
		expr = "(2 * 7 - 1) - ((3 - 16 % (2 + 3) / 6) + 34 - 3 ^ 2 + 1) - 3";
		answer = stackIt.evaluateExpression(utils.tokenizeExpression(expr));
		System.out.printf("%s = %.4f%n%n", expr, answer);
		
		System.out.println("\n\n");
	}
}

/*
C:\Java\StackCalculator> java StackCalculatorTester



2 + 3 * 5 = 17.0000

2.1 + 3 * (5 - 4) = 5.1000

3.456 * 23 / (.5 - 23) = -3.5328

54 + 0.12 * 3 - 4 / 5.6 - (2 ^ 3 - 4) + 1 = 50.6457

4 * (3 + 2) - 18 / (6 * 3) = 19.0000

27 - ((3 - 6 * 2) + 34 - 3 ^ 2 + 1) - 3 = 7.0000

(2 * 7 - 1) - ((3 - 16 % (2 + 3) / 6) + 34 - 3 ^ 2 + 1) - 3 = -18.8333




C:\Java\StackCalculator>
*/