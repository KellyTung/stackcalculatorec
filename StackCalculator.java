import java.util.List;		// used by expression evaluator
import java.util.ArrayList;

/**
 * This is a program that uses stacks to calculate expressions.
 * It uses the ExprUtils class to tokenize the expression and check
 * if a character is a valid operator. It also uses the ArrayStack
 * to construct the stack and place items in it. The program uses
 * multiple methods to check the precedence of objects and effecively
 * go through the stack. It uses the algorithim that was previously
 * addressed in class.
 * EC: For the extra credit part, it utilizes the Variable class in
 * order to assign and store variables. The program is modified so that
 * it accomodates the '=' sign as well.
 *
 *	@author	Kelly Tung
 *	@since 4/7/2021
 */
public class StackCalculator
{
	/** An instance of the ExprUtils class. It will be used for checking
	 * if a "token" is a value or operator. */
	private ExprUtils utils;	// expression utilities

	/** An instance of the ArrayStack class. It stores the numbers in the
	 * expression by adding it to the stack. */
	private ArrayStack<Double> valueStack;		// value stack

	/** An instance of the ArrayStack class. It stores the operators in the
	 * expression by adding it to the stack. */
	private ArrayStack<String> operatorStack;	// operator stack

	/** An arraylist of variables that stores the name and value of them. */
	private ArrayList<Variable> variables;  // arraylist of variables

	/** The constructor initializes the class variables */
	public StackCalculator()
	{
		utils = new ExprUtils();
		valueStack = new ArrayStack<Double>();
		operatorStack = new ArrayStack<String>();
		variables = new ArrayList<Variable>();
	}

	/** main method */
	public static void main(String[] args) 
	{
		StackCalculator sc = new StackCalculator();
		sc.run();
	}

	/**
	 * This method prints out the introduction and conclusion
	 * to the program. It calls runCalc() to ask the user the expression.
	 */
	public void run() 
	{
		System.out.println("\n\n\nWelcome to StackCalculator!!!\n");
		initializeVariables();
		runCalc();
		System.out.println("\nThanks for using StackCalculator! Goodbye.\n\n\n");
	}

	/**
	 * This method initializes 2 variables: e and pi.
	 * It uses the Math class in order to get the value for both of them and it
	 * creates instances of the Variable class to store the information.
	 */
	public void initializeVariables()
	{
		Variable var1 = new Variable();
		var1.setName("e");
		var1.setValue(Math.E);
		variables.add(var1);

		Variable var2 = new Variable();
		var2.setName("pi");
		var2.setValue(Math.PI);
		variables.add(var2);
	}

	/**
	 * Prompts the user for expressions, runs the expression evaluator,
	 * and displays the answer. It uses a while loop to continue asking
	 * the user what expression it wants to answer. If the user types "h",
	 * then the prgogram displays the help menu. If the user types "q",
	 * then the program quits. If the user types "I", it shows the variables.
	 * If the user types an expression with an "=" (and is valid), it assigns
	 * the expression value to a variable by using the instance variable of ExprUtils.
	 * It calls evaluateExpression() method to get the answer.
	 */
	public void runCalc() 
	{
		Prompt p = new Prompt();
		String input = "";
		while (true)
		{
			input = p.getString("->");
			if (input.equals("h"))
			{
				printHelp();
				System.out.println();
			}
			else if (input.equals("q"))
			{
				System.out.println("\nThanks for using StackCalculator! Goodbye.\n\n\n");
				System.exit(0);
			}
			else if (input.equals("I"))
			{
				System.out.println();
				printVariables();
				System.out.println();
			}
			else
			{
				List<String> tokens = utils.tokenizeExpression(input);
				if (tokens.contains("="))
				{
					int index = tokens.indexOf("=");
					String varName = "";
					for (int i = 0; i < index; i++)
					{
						String word = tokens.get(i);
						boolean check = checkLetters(word);
						if (check)
							varName += word;
						else
						{
							i = index;
							varName = "$";
							System.out.println(0.0);
						}
					}
					ArrayList<String> names = new ArrayList<String>();
					for (int k = 0; k < variables.size(); k++)
						names.add(variables.get(k).getName());
					if (names.contains(varName))
						System.out.println("cannot add because variable name is taken.");
					else if (!varName.equals("$"))
					{
						for (int i = 0; i <= index; i++)
							tokens.remove(0);
						double answer = evaluateExpression(tokens);
						Variable var = new Variable();
						var.setName(varName);
						var.setValue(answer);
						variables.add(var);
						System.out.println(var.getName() + " = " + var.getValue());
					}
				}
				else
				{
					if (tokens.size() == 1)
					{
						ArrayList<String> names = new ArrayList<String>();
						for (int i = 0; i < variables.size(); i++)
							names.add(variables.get(i).getName());
						if (names.contains(tokens.get(0)))
							System.out.println(variables.get(names.indexOf(tokens.get(0))).getValue());
						else
							System.out.println(0.0);
					}
					else
					{
						double answer = evaluateExpression(tokens);
						System.out.println(answer);
					}
				}
			}
		}
	}

	/**
	 * This method checks if the word passed into has all alphabet letters.
	 * @param word     string that will be checked if it is all letters
	 * @return         boolean that tells whether the word is all letters (true = all letters, else false)
	 */
	public boolean checkLetters(String word)
	{
		for (int j = 0; j < word.length(); j++)
		{
			if (Character.isLetter(word.charAt(j)) == false)
				return false;
		}
		return true;
	}

	/**
	 * This method prints out the variables stored in the variables arraylist.
	 * It uses the printf method to get the correct formatting.
	 */
	public void printVariables()
	{
		System.out.println("Variables:");
		for (int i = 0; i < variables.size(); i++)
			System.out.printf("\t%s = %.2f\n", variables.get(i).getName(), variables.get(i).getValue());
	}

	/**
	 * Determines whether a string is a number or not. It uses a a try-catch
	 * block in case the string is not a number so that the exception is caught.
	 * @param str      the string that will be checked if it's a number
	 * @return         a boolean; if true, it is a number; if false, it is not a number
	 */
	public boolean isDouble(String str)
	{
		try
		{
			return Double.parseDouble(str) <= 0 || Double.parseDouble(str) > 0;
		}
		catch (Exception E)
		{
			return false;
		}
	}
	
	/**	Print help. When the user types "h", this method will be called and the
	 * help menu will be printed.*/
	public void printHelp() 
	{
		System.out.println("Help:");
		System.out.println("  h - this message\n  q - quit\n  I - show variables\n");
		System.out.println("Expressions can contain:");
		System.out.println("  integers or decimal numbers");
		System.out.println("  arithmetic operators +, -, *, /, %, ^");
		System.out.println("  parentheses '(' and ')'");
	}
	
	/**
	 *	Evaluate expression and return the value. It uses a for loop
	 *  to go through all of the tokens in the List. If it is a double, it adds
	 *  the value to the valueStack immediately. If it is an operator, it checks
	 *  if the operatorStack is empty or if the peek() does not have equal or
	 *  higher precedence. If so, it will add the operator to the stack. Else, it will
	 *  pop until the precedence is less then.
	 *	@param tokens	a List of String tokens making up an arithmetic expression
	 *	@return			a double value of the evaluated expression
	 */
	public double evaluateExpression(List<String> tokens) 
	{
		double value = 0;

		for (int i = 0; i < tokens.size(); i++)
		{
			ArrayList<String> names = new ArrayList<String>();
			for (int k = 0; k < variables.size(); k++)
				names.add(variables.get(k).getName());
			if (isDouble(tokens.get(i)))
				valueStack.push(Double.parseDouble(tokens.get(i)));
			else if (names.contains(tokens.get(i)))
				valueStack.push(variables.get(names.indexOf(tokens.get(i))).getValue());
			else if (utils.isOperator(tokens.get(i).charAt(0)))
			{
				if (operatorStack.isEmpty() || !hasPrecedence(operatorStack.peek(), tokens.get(i)))
					operatorStack.push(tokens.get(i));
				else
				{
					int num = popStack(tokens.get(i));
					if (num == 0)
						operatorStack.push(tokens.get(i));
				}
			}
		}
		popStack(")");
		value = valueStack.peek();
		return value;
	}

	/**
	 *	This method checks if it is necessary to pop the values in the stacks. It checks
	 *  if the operator stack is empty and if the current operator has less precedence than
	 *  the peek(). If so, it pops() the stacks. Then, it returns an int that determines
	 *  whether the current operator should be pushed or not.
	 *	@param tokens	a List of String tokens making up an arithmetic expression
	 *	@return			an int value that indicates whether the operator stack should push
	 *                  the current token or not. if it is a closing paranthesis, then it will return 1.
	 *                  otherwise, it will return 0 (which means to push the current operator).
	 */
	public int popStack(String operator)
	{
		while (!operatorStack.isEmpty() && hasPrecedence(operatorStack.peek(), operator))
		{
			if (operatorStack.peek().equals("(") && operator.equals(")"))
			{
				operatorStack.pop();
				return 1;
			}
			double end = valueStack.peek();
			valueStack.pop();
			double start = valueStack.peek();
			valueStack.pop();
			if (operatorStack.peek().equals("^"))
				valueStack.push(Math.pow(start,end));
			else if (operatorStack.peek().equals("%"))
				valueStack.push(start%end);
			else if (operatorStack.peek().equals("*"))
				valueStack.push(start*end);
			else if (operatorStack.peek().equals("/"))
				valueStack.push(start/end);
			else if (operatorStack.peek().equals("+"))
				valueStack.push(start+end);
			else if (operatorStack.peek().equals("-"))
				valueStack.push(start-end);
			operatorStack.pop();
		}
		return 0;
	}
	
	/**
	 *  if true:
	 *	Precedence of operators
	 *	@param op1		operator 1 (peek() at stack)
	 *	@param op2		operator 2 (current operator)
	 *	@return			true if op1 has higher or same precedence as op2 (needs to pop); false otherwise (no pop needed)
	 *	Algorithm:
	 *		if op1 is exponent or closing parenthesis, then true
	 *		if op1 is multiplication or division or modulus and 
	 *			op2 is addition or subtraction or multiplication
	 *			or division or modulus, then true
	 *		if op1 is addition or subtraction and op2 is addition
	 *			or substraction, then true
	 *		otherwise false
	 */
	private boolean hasPrecedence(String op1, String op2) 
	{
		if (op1.equals("^") || op2.equals(")"))
			return true;
		if ((op1.equals("*") || op1.equals("/") || op1.equals("%")) && ((op2.equals("+")) || op2.equals("-") || op2.equals("*") || op2.equals("/") || op2.equals("%")))
			return true;
		if ((op1.equals("+") || op1.equals("-")) && ((op2.equals("+")) || op2.equals("-")))
			return true;
		return false;
	}
}