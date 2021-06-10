/**
 * ArrayStack.java
 *
 * A class to represent a Stack, making use of a List and an ArrayList.
 *
 * @author Kelly Tung
 * @version 1.0
 * @since 3/23/2021
 */

import java.util.List;
import java.util.ArrayList;

public class ArrayStack<E> implements Stack<E>
{
    List<E> elements;           // the elements on the Stack.

    public ArrayStack()
    {
        elements = new ArrayList<E>();
    }

    public boolean isEmpty()
    {
        return elements.isEmpty();
    }

    public E peek()
    {
        return elements.get(elements.size()-1);
    }

    public void push(E obj)
    {
        elements.add(obj);
    }

    public E pop()
    {
        return elements.remove(elements.size()-1);
    }

    public static void main(String [] args)
    {
        ArrayStack<String> stringStack = new ArrayStack<String>();
        stringStack.push("First String");
        stringStack.push("Second String");
        stringStack.push("Third String");

        System.out.println("\n\n\n");
        System.out.println(stringStack.isEmpty());
        System.out.println(stringStack.peek());
        System.out.println(stringStack.pop());
        System.out.println(stringStack.peek());
        System.out.println(stringStack.pop());
        System.out.println(stringStack.peek());
        System.out.println(stringStack.pop());
        System.out.println(stringStack.isEmpty());
        System.out.println("\n\n\n");
    }
}