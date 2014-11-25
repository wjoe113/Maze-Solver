package cs2114.mazesolver;

import cs2114.mazesolver.MyCell;
// import java.util.ArrayList;

// -------------------------------------------------------------------------
/**
 * This class solves the maze that is created in the maze class. This class
 * observers the location of the current cell and which direction it can take to
 * solve the maze.
 *
 * @author Joe
 * @version 10.02.2012
 */

public class SolveMaze
{

    private ArrayListStack<MyCell> stack;
    private Maze                   maze;


    // ----------------------------------------------------------
    /**
     * This is the constructor for the class. Here a new array list is created
     * and puzzleSize is inherited from the maze class.
     *
     * @param maze
     *            = the new maze
     */
    public SolveMaze(Maze maze)
    {
        // empty
    }


    // ----------------------------------------------------------
    /**
     * The current location tests each of the cases possible for the cell that
     * the solver is moving towards.
     *
     * @param position
     *            = position of the cell
     * @return i = whether the case is true of false. This data will be used in
     *         the index method.
     */
    public boolean currentLocation(MyCell position)
    {
        switch (maze.getCell(position))
        {
            case PATH:
            case FINISH:
                return true;
            default:
                return false;
        }
    }


    /**
     * solveMaze looks at the four cardinal directions and sees if they are
     * valid movements.
     *
     * @param myMaze
     *            = maze being used
     * @return null = returns null because the stack does not need to be
     *         returned.
     */
    public String solveMaze(Maze myMaze)
    {
        this.maze = myMaze;
        this.stack = new ArrayListStack<MyCell>();
        stack.push(new MyCell(0, 0));

        while (!stack.isEmpty())
        {
            MyCell current = stack.top();
            myMaze.setCell(current, MazeBoardCell.EXPLOREDCELL);

            if (myMaze.getCell(current).equals(MazeBoardCell.FINISH)
                || myMaze.puzzleSize() <= 1)
            {
                return stack.toString();
            }
            else if (currentLocation(current.south()))
            {
                stack.push(current.south());
            }
            else if (currentLocation(current.east()))
            {
                stack.push(current.east());
            }
            else if (currentLocation(current.north()))
            {
                stack.push(current.north());
            }
            else if (currentLocation(current.west()))
            {
                stack.push(current.west());
            }
            else
            {
                myMaze.setCell(current, MazeBoardCell.DEAD_END);
                stack.pop();
            }
        }
        return null;
    }
}
