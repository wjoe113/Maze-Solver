package cs2114.mazesolver;

// -------------------------------------------------------------------------
/**
 * MyCell is a class that defines the object used in the maze solver. This class
 * uses getX, getY, and myCell to define the object.
 *
 * @author Joe
 * @version 10.10.2012
 */

public class MyCell
{
    private int x;
    private int y;


    // ----------------------------------------------------------
    /**
     * Create a new MyCell object.
     *
     * @param x
     *            = x coordinate
     * @param y
     *            = y coordinate
     */
    public MyCell(int x, int y)
    {
        this.x = x;
        this.y = y;
    }


    // ----------------------------------------------------------
    /**
     * Gets the value of the x coordinate
     *
     * @return x = x coordinate
     */
    public int getX()
    {
        return x;
    }


    // ----------------------------------------------------------
    /**
     * Gets the value of the x coordinate
     *
     * @return y = y coordinate
     */
    public int getY()
    {
        return y;
    }


    /**
     * west returns the cell in MyCell directly north of the current cell.
     *
     * @return MyCell = MyCell at the new location
     */
    public MyCell north()
    {
        return new MyCell(x, y + 1);
    }


    /**
     * west returns the cell in MyCell directly south of the current cell.
     *
     * @return MyCell = MyCell at the new location
     */
    public MyCell south()
    {
        return new MyCell(x, y - 1);
    }


    /**
     * west returns the cell in MyCell directly east of the current cell.
     *
     * @return MyCell = MyCell at the new location
     */
    public MyCell east()
    {
        return new MyCell(x + 1, y);
    }


    /**
     * west returns the cell in MyCell directly west of the current cell.
     *
     * @return MyCell = MyCell at the new location
     */
    public MyCell west()
    {
        return new MyCell(x - 1, y);
    }

    /**
     * turns the answer in to a string
     * @return = returns a string of the path cells that make up the solution
     */
    public String toString()
    {
        return "(" + x + ", " + y + ")";
    }

}
