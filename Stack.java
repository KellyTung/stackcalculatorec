/**
 * Stack.java
 *
 * An interface to represent a Stack.
 *
 * @author Kelly Tung
 * @version 1.0
 * @since 3/23/2021
 */

public interface Stack<E>
{
    public abstract boolean isEmpty();
    public abstract E peek();
    public abstract void push(E obj);
    public abstract E pop();
}