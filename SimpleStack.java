package cs2114.mazesolver;

// import java.util.EmptyStackException; This package was giving me an error

// -------------------------------------------------------------------------
/**
 * This interface represents a simple stack abstract data type.
 *
 * @param <T>
 *            the element type stored in the stack
 * @author Tony
 * @author Joe
 * @version 2011.07.14
 */
public interface SimpleStack<T>
{
    // ~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Pushes the specified item onto the top of the stack.
     *
     * @param item
     *            the item to push onto the stack
     */
    void push(T item);


    // ----------------------------------------------------------
    /**
     * Pops an item off the top of the stack.
     */
    void pop();


    // ----------------------------------------------------------
    /**
     * Gets the item at the top of the stack.
     *
     * @return the item at the top of the stack
     */
    T top();


    // ----------------------------------------------------------
    /**
     * Gets the number of items in the stack.
     *
     * @return the number of items in the stack
     */
    int size();


    // ----------------------------------------------------------
    /**
     * Gets a value indicating whether the stack is empty.
     *
     * @return true if the stack is empty, otherwise false
     */
    boolean isEmpty();
}
