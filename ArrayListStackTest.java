package cs2114.mazesolver;

import student.TestCase;
import java.util.EmptyStackException;

// -------------------------------------------------------------------------
/**
 * Tests for the {@link ArrayListStack} class.
 *
 * @author Joe
 * @version 10.10.2012
 */
public class ArrayListStackTest
    extends TestCase
{
    // ~ Instance/static variables .............................................

    /**
     * Declares a ArrayListStack object
     */
    private ArrayListStack<String> stack;


    // ~ Public methods ........................................................

    // ----------------------------------------------------------
    /**
     * Creates a brand new, empty stack for each test method.
     */
    public void setUp()
    {
        stack = new ArrayListStack<String>();
    }


    /**
     * Tests the pop method
     */
    public void testPop()
    {
        Exception thrown = null;
        try
        {
            stack.pop();
        }
        catch (Exception exception)
        {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof EmptyStackException);

        stack.push("Hi");
        stack.push("Hello");
        stack.pop();
        assertEquals("Hi", stack.top());

    }


    /**
     * Tests the push method
     */
    public void testPush()
    {
        stack.push("Friday");
        assertEquals(stack.top(), "Friday");
    }


    /**
     * Tests the size method
     */
    public void testSize()
    {
        assertEquals(0, stack.size());
        stack.push("item");
        assertEquals(1, stack.size());
    }


    /**
     * Tests if the stack is empty
     */
    public void testIsEmpty()
    {
        assertEquals(true, stack.isEmpty());

        stack.push("Yoo");
        assertEquals(false, stack.isEmpty());
    }


    /**
     * Tests the top of the stack
     */
    public void testTop()
    {
        Exception thrown = null;
        try
        {
            stack.top();
        }

        catch (Exception x)
        {
            thrown = x;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof EmptyStackException);

        stack.push("Hiya");
        assertEquals("Hiya", stack.top());

    }


    /**
     * tests the toString method by converting the stack to a string
     */
    public void testToString()
    {
        stack.push("Bleys rocks");
        stack.push("Random is cool");
        assertFuzzyEquals("(Bleys rocks, Random is cool)", stack.toString());
    }
}
