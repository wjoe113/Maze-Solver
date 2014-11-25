package cs2114.mazesolver;

// -------------------------------------------------------------------------
/**
 * This class creates the basics of the maze that the user will be able to
 * create. Follow it with additional details about its purpose, what abstraction
 * it represents, and how to use it.
 *
 * @author Joe
 * @version 9.26.2012
 */
public class Maze
{
    /**
     * The size of the puzzle
     */
    protected static int        puzzleSize;
    /**
     * An empty maze board
     */
    protected MazeBoardCell[][] board;


    // ----------------------------------------------------------
    /**
     * Create a new Maze object that takes in the size of the puzzle you want to
     * create.
     *
     * @param puzzleSize
     *            = puzzle size
     */
    public Maze(int puzzleSize)
    {
        Maze.puzzleSize = puzzleSize;
        this.board = new MazeBoardCell[puzzleSize][puzzleSize];
        for (int x = 0; x < puzzleSize; x++)
        {
            for (int y = 0; y < puzzleSize; y++)
            {
                setCell(x, y, MazeBoardCell.PATH);
            }
        }
    }


    // ----------------------------------------------------------
    /**
     * A board is created if it passes all of the conditions. If it passes the
     * conditions it is a cell on the board, if not it will be an invalid cell.
     *
     * @param x
     *            = the width of the maze
     * @param y
     *            = the height of the maze
     * @return board = the maze board
     */
    public MazeBoardCell getCell(int x, int y)
    {
        if (x >= 0 && x < puzzleSize && y >= 0 && y < puzzleSize)
        {
            return board[x][y];
        }
        return MazeBoardCell.INVALIDCELL;
    }


    /**
     * A board is created if it passes all of the conditions. If it passes the
     * conditions it is a cell on the board, if not it will be an invalid cell.
     *
     * @param position
     *            = the position of MyCell
     * @return the location of x and y in at the position.
     */
    public MazeBoardCell getCell(MyCell position)
    {
        return this.getCell(position.getX(), position.getY());
    }


    // ----------------------------------------------------------
    /**
     * Determines what to set the cell as. If it passes the conditions it will
     * be a cell on the board. If it does not pass one of the conditions it may
     * be the start or finish cell.
     *
     * @param x
     *            = width
     * @param y
     *            = height
     * @param value
     *            = value of the cell
     */
    public void setCell(int x, int y, MazeBoardCell value)
    {
        if (x == 0 && y == 0)
        {
            board[x][y] = MazeBoardCell.START;
        }

        else if (x == puzzleSize - 1 && y == puzzleSize - 1)
        {
            board[x][y] = MazeBoardCell.FINISH;
        }

        else if (x >= 0 && x < puzzleSize && y >= 0 && y < puzzleSize)
        {
            board[x][y] = value;
        }
    }


    /**
     * This method is a version of setCell that takes in MyCell values.
     *
     * @param position
     *            = the position in MyCell
     * @param value
     *            = the value of the cellS
     */
    public void setCell(MyCell position, MazeBoardCell value)
    {
        this.setCell(position.getX(), position.getY(), value);
    }


    // ----------------------------------------------------------
    /**
     * Initializes puzzleSize as the puzzle size.
     *
     * @return puzzleSize = puzzle size
     */
    public int puzzleSize()
    {
        return puzzleSize;
    }


    // ----------------------------------------------------------
    /**
     * Places a wall in a cell when it is not start and finish.
     *
     * @param x
     *            = x value
     * @param y
     *            = y value
     */
    public void placeWall(int x, int y)
    {

        if (x == 0 && y == 0)
        {
            setCell(x, y, MazeBoardCell.START);
        }
        else if ((x == puzzleSize - 1) && (y == puzzleSize - 1))
        {
            setCell(x, y, MazeBoardCell.FINISH);
        }
        else
        {
            setCell(x, y, MazeBoardCell.WALL);
        }
    }
}
