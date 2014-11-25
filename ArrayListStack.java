package cs2114.mazesolver;

import java.util.ArrayList;
import java.util.EmptyStackException;

// -------------------------------------------------------------------------
/**
 * An implementation of the stack data type that adapts an ArrayList to store
 * its contents. This is a PARTIAL IMPLEMENTATION that needs completion.
 *
 * @param <T>
 *            the type of elements stored in the stack
 * @author Joe
 * @version 2012.09.28
 */
public class ArrayListStack<T>
    implements SimpleStack<T>
{
    // ~ Instance/static variables ............................................

    /**
     * Declares an ArrayList called list
     */
    ArrayList<T> list;


    // ~ Constructors .........................................................

    /**
     * Constructor for ArrayListStack class
     */
    public ArrayListStack()
    {
        this.list = new ArrayList<T>();
    }


    // ~ Methods ..............................................................

    /**
     * Adds item to top of stack
     *
     * @param item
     *            The object to add
     */
    public void push(T item)
    {

        list.add(item);
    }


    /**
     * Removes the top item from the stack
     */
    public void pop()
    {

        if (!list.isEmpty())
        {
            list.remove(list.size() - 1);
        }
        else
        {
            throw new EmptyStackException();
        }

    }


    /**
     * Returns the object at the top of stack
     *
     * @return The object of the top of the stack
     */
    public T top()
    {
        if (list.size() > 0)
        {
            T obj = list.get(list.size() - 1);
            return obj;
        }
        else
        {
            throw new EmptyStackException();
        }
    }


    /**
     * The size of the stack
     *
     * @return The size
     */
    public int size()
    {
        return list.size();
    }


    /**
     * Checks to see if stack is empty
     *
     * @return True if stack is empty, false otherwise
     */
    public boolean isEmpty()
    {

        boolean test = true;
        if (list.size() > 0)
        {
            test = false;
        }
        return test;
    }


    // ----------------------------------------------------------
    /**
     * creates a string when toString is called.
     *
     * @return newString returns the element at the location
     */
    public String toString()
    {
        String newString = "";
        for (int x = 0; x < list.size(); x++)
        {
            newString += list.get(x);
            if (x != list.size() - 1)
            {
                newString += ", ";
            }
        }
        return newString;
    }
}
