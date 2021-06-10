/**
 * This is the Variable class. It will store the variables
 * that are used in the StackCalculator class. It includes
 * two class variables to store the name and value of the variable.
 * It includes setters and getters to set and get the name and
 * value of the variable.
 *
 *	@author	Kelly Tung
 *	@since 4/6/2021
 */
public class Variable
{
	/** A String that stores the name of the variable. */
	private String name;

	/** A double that stores the value of the variable. */
	private double value;

	/**
	 * The constructor that initializes the variable with
	 * default values.
	 */
	public Variable()
	{
		name = "";
		value = 0;
	}

	/**
	 * Sets the name of the variable.
	 * @param str      the string that will be set as the variable's name
	 */
	public void setName(String str)
	{
		name = new String(str);
	}

	/**
	 * Sets the value of the variable.
	 * @param val      the number that will be set as the variable's value
	 */
	public void setValue(double val)
	{
		value = val;
	}

	/**
	 * returns the name of the variable.
	 * @return     the name of the variable.
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * returns the value of the variable.
	 * @return     the value of the variable.
	 */
	public double getValue()
	{
		return value;
	}
}