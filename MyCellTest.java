package cs2114.mazesolver;

// -------------------------------------------------------------------------
/**
 * This test class tests the MyCell class. The two methods being testsed in this
 * test class are getX and getY.
 *
 * @author Joe
 * @version 10.10.2012
 */
public class MyCellTest
    extends student.TestCase
{
    /**
     * The new MyCell value
     */
    public MyCell cell;

    /**
     * sets up the cell
     */
    public void setUp()
    {
        cell = new MyCell(1, 2);
    }


    // ----------------------------------------------------------
    /**
     * This test tests getX by getting the x value in the new cell.
     */
    public void testGetX()
    {
        assertEquals(1, cell.getX());
    }


    // ----------------------------------------------------------
    /**
     * This test tests getY by getting the y value in the new cell.
     */
    public void testGetY()
    {
        assertEquals(2, cell.getY());
    }
}
