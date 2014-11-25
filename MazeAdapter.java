package cs2114.mazesolver;

// -------------------------------------------------------------------------
/**
 * The MazeAdapter fills in any gaps within the maze. Some of the gaps include
 * determining if a path is a wall and if a wall should be destroyed to make a
 * path.
 *
 * @author Joe
 * @version 9.26.2012
 */

public class MazeAdapter
    extends MazeAdapterBase
{
    private Maze board;


    // ----------------------------------------------------------
    /**
     * createMaze creates a new maze to use the adapter.
     *
     * @param puzzleSize
     *            = the size of the puzzle (height and width).
     */
    public void createMaze(int puzzleSize)
    {
        this.board = new Maze(puzzleSize);

    }


    // ----------------------------------------------------------
    /**
     * destroyWall destroys a wall and creates a path.
     *
     * @param x
     *            = location of the cell on the x-axis.
     * @param y
     *            = location of the cell on the y-axis.
     */

    public void destroyWall(int x, int y)
    {
        this.board.setCell(x, y, MazeBoardCell.PATH);
    }


    // ----------------------------------------------------------
    /**
     * isWall determines if the cell is a wall using getCell.
     *
     * @param x
     *            = location of the cell on the x-axis.
     * @param y
     *            = location of the cell on the y-axis.
     * @return = returns if the cell is a wall.
     */

    public boolean isWall(int x, int y)
    {
        return this.board.getCell(x, y).equals(MazeBoardCell.WALL);
    }


    // ----------------------------------------------------------
    /**
     * placeWall places a wall on the cell uding setCell.
     *
     * @param x
     *            = location of the cell on the x-axis.
     * @param y
     *            = location of the cell on the y-axis.
     */

    public void placeWall(int x, int y)
    {
        board.placeWall(x, y);
    }


    // ----------------------------------------------------------
    /**
     * solveMaze is currently not being used so it returns null.
     *
     * @return = returns the solveMaze as null because it is not used.
     */

    public String solveMaze()
    {
        SolveMaze mazeSolver = new SolveMaze(board);
        return mazeSolver.solveMaze(board);
    }

}
