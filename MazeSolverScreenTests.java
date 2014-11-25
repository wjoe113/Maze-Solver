package cs2114.mazesolver;

import android.widget.Button;
import android.widget.CompoundButton;
import sofia.graphics.ShapeView;

// -------------------------------------------------------------------------
/**
 * This class tests the MazeSolverScreen to see if the GUI is correctly set up
 * to run the project. This test class tests the clearMaze button, the solveMaze
 * button, and the CompoundButton to draw walls.
 *
 * @author Joe
 * @version 2012.10.24
 */
public class MazeSolverScreenTests
    extends student.AndroidTestCase<MazeSolverScreen>
{
    // ~ Fields ................................................................

    private ShapeView      shapeView;
    private CompoundButton drawEraseMode;
    private Button         clearMaze;
    private Button         solveMaze;
    private Maze           maze;
    private float          cellSize;
    /**
     * A second new maze that will try different mazes
     */
    public Maze            board2;
    /**
     * A new maze that will fail when solved
     */
    public Maze            failBoard;


    // ~ Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * Test cases that extend AndroidTestCase must have a parameterless
     * constructor that calls super() and passes it the screen/activity class
     * being tested.
     */
    public MazeSolverScreenTests()
    {
        super(MazeSolverScreen.class);
    }


    // ~ Public methods ........................................................

    // ----------------------------------------------------------
    /**
     * Initializes the text fixtures.
     */
    public void setUp()
    {
        this.maze = this.getScreen().getMaze();

        float viewSize =
            Math.min(getScreen().getWidth(), getScreen().getHeight());

        // TODO set cellSize to be the viewSize divided by the size of your
        // maze
        cellSize = viewSize / maze.puzzleSize();

        // TODO Add any other setup code that you need.
    }


    // TODO Add your test methods here.

    // ~ Private methods .......................................................

    // ----------------------------------------------------------
    /**
     * Simulates touching down on the middle of the specified cell in the maze.
     *
     * @param x
     *            = x coordinate
     * @param y
     *            = y coordinate
     */
    private void touchDownCell(int x, int y)
    {
        touchDown(shapeView, (x + 0.5f) * cellSize, (y + 0.5f) * cellSize);
    }


    // ----------------------------------------------------------
    /**
     * Simulates moving the finger instantaneously to the middle of the
     * specified cell in the maze.
     *
     * @param x
     *            = x coordinate
     * @param y
     *            = y coordinate
     */
    private void touchMoveCell(int x, int y)
    {
        touchMove((x + 0.5f) * cellSize, (y + 0.5f) * cellSize);
    }


    // ----------------------------------------------------------
    /**
     * Simulates clicking the middle of the specified cell in the maze. This is
     * equivalent to calling: touchDownCell(x, y); touchUp();
     *
     * @param x
     *            = x coordinate
     * @param y
     *            = y coordinate
     */
    private void clickCell(int x, int y)
    {
        touchDownCell(x, y);
        touchUp();
    }


    /**
     * tests the clearMaze button. Should clear the maze of all values and set
     * them to the default path value
     */
    public void testClearMazeClicked()
    {
        click(drawEraseMode);

        Maze myMaze = getScreen().getMaze();

        touchDownCell(0, 1);
        touchMoveCell(0, 2);
        touchMoveCell(0, 3);
        touchUp();

        assertEquals(myMaze.getCell(0, 1), MazeBoardCell.WALL);
        assertEquals(myMaze.getCell(0, 2), MazeBoardCell.WALL);
        assertEquals(myMaze.getCell(0, 3), MazeBoardCell.WALL);

        click(clearMaze);

        myMaze = getScreen().getMaze();

        assertEquals(myMaze.getCell(0, 1), MazeBoardCell.PATH);
        assertEquals(myMaze.getCell(0, 2), MazeBoardCell.PATH);
        assertEquals(myMaze.getCell(0, 3), MazeBoardCell.PATH);
    }


    /**
     * tests the solveMaze button. Should return a string of points that
     * indicate the solved maze path.
     */
    public void testSolveMazeClicked()
    {

        click(drawEraseMode);

        Maze maze1 = getScreen().getMaze();

        touchDownCell(2, 0);
        touchMoveCell(2, 1);
        touchMoveCell(2, 2);
        touchMoveCell(1, 2);
        touchMoveCell(0, 2);

        touchUp();

        touchDownCell(3, 0);
        touchMoveCell(3, 1);
        touchMoveCell(3, 2);
        touchMoveCell(3, 3);
        touchMoveCell(2, 3);
        touchMoveCell(1, 3);
        touchMoveCell(0, 3);

        touchUp();

        click(solveMaze);

        maze1 = getScreen().getMaze();

        assertNotNull(getView(where.textIs("No solution was possible")));
        assertEquals(maze1.getCell(0, 1), MazeBoardCell.DEAD_END);
        assertEquals(maze1.getCell(1, 1), MazeBoardCell.DEAD_END);
        assertEquals(maze1.getCell(1, 0), MazeBoardCell.DEAD_END);
        assertEquals(maze1.getCell(3, 0), MazeBoardCell.WALL);
        assertEquals(maze1.getCell(3, 1), MazeBoardCell.WALL);
        assertEquals(maze1.getCell(3, 2), MazeBoardCell.WALL);

        click(clearMaze);

        Maze maze2 = getScreen().getMaze();

        touchDownCell(0, 2);
        touchMoveCell(1, 2);
        touchMoveCell(2, 2);
        touchMoveCell(3, 2);
        touchMoveCell(4, 2);

        touchUp();

        click(solveMaze);

        maze2 = getScreen().getMaze();

        assertEquals(maze2.getCell(0, 0), MazeBoardCell.START);
        assertEquals(maze2.getCell(5, 5), MazeBoardCell.FINISH);
        assertEquals(maze2.getCell(3, 0), MazeBoardCell.EXPLOREDCELL);
        assertEquals(maze2.getCell(-1, -1), MazeBoardCell.INVALIDCELL);
        assertNotNull(getView(where.textIs("(0, 0), (1, 0), (2, 0), (3, 0), "
            + "(4, 0), (5, 0), (5, 1), " + "(5, 2), (5, 3), (5, 4), (5, 5)")));

        click(clearMaze);

        maze2 = getScreen().getMaze();

        touchDownCell(1, 0);
        touchMoveCell(1, 1);
        touchMoveCell(1, 2);
        touchMoveCell(2, 2);
        touchUp();

        click(solveMaze);

        maze2 = getScreen().getMaze();

        assertEquals(maze2.getCell(0, 0), MazeBoardCell.START);
        assertEquals(maze2.getCell(5, 5), MazeBoardCell.FINISH);
        assertEquals(maze2.getCell(5, 0), MazeBoardCell.EXPLOREDCELL);
        assertEquals(maze2.getCell(-1, -1), MazeBoardCell.INVALIDCELL);
    }


    /**
     * tests when the user touches the screen. This test touches the screen in
     * multiple places to test the click and move methods
     */
    public void testTouch()
    {

        click(drawEraseMode);

        Maze myMaze2 = getScreen().getMaze();

        clickCell(0, 0);
        clickCell(5, 5);
        clickCell(1, 3);
        clickCell(2, 3);
        clickCell(3, 3);
        clickCell(-1, -1);
        touchDownCell(0, 1);
        touchMoveCell(0, 2);
        touchMoveCell(0, 3);
        touchMoveCell(-1, 3);
        touchUp();

        touchDownCell(-5, 3);
        touchMoveCell(-4, 3);
        touchMoveCell(-3, 3);
        touchMoveCell(-2, 3);
        touchMoveCell(-1, 3);
        touchMoveCell(0, 3);
        touchUp();

        assertEquals(myMaze2.getCell(0, 0), MazeBoardCell.START);
        assertEquals(myMaze2.getCell(5, 5), MazeBoardCell.FINISH);
        assertEquals(myMaze2.getCell(1, 3), MazeBoardCell.WALL);
        assertEquals(myMaze2.getCell(2, 3), MazeBoardCell.WALL);
        assertEquals(myMaze2.getCell(3, 3), MazeBoardCell.WALL);
        assertEquals(myMaze2.getCell(0, 1), MazeBoardCell.WALL);
        assertEquals(myMaze2.getCell(0, 2), MazeBoardCell.WALL);
        assertEquals(myMaze2.getCell(0, 3), MazeBoardCell.WALL);
        assertEquals(false, maze.getCell(-1, -1).equals(MazeBoardCell.WALL));
        assertEquals(false, maze.getCell(0, 3).equals(MazeBoardCell.PATH));
        assertEquals(false, maze.getCell(-1, 3).equals(MazeBoardCell.WALL));
        assertEquals(false, maze.getCell(-2, 3).equals(MazeBoardCell.WALL));
        assertEquals(false, maze.getCell(-3, 3).equals(MazeBoardCell.WALL));
        assertEquals(false, maze.getCell(-4, 3).equals(MazeBoardCell.WALL));
        assertEquals(false, maze.getCell(-5, 3).equals(MazeBoardCell.WALL));

        click(drawEraseMode);

        myMaze2 = getScreen().getMaze();

        clickCell(1, 3);
        clickCell(2, 3);
        clickCell(3, 3);
        clickCell(-1, -1);
        touchDownCell(0, 1);
        touchMoveCell(0, 2);
        touchMoveCell(0, 3);
        touchMoveCell(-1, 3);
        touchUp();

        touchDownCell(-5, 3);
        touchMoveCell(-4, 3);
        touchMoveCell(-3, 3);
        touchMoveCell(-2, 3);
        touchMoveCell(-1, 3);
        touchMoveCell(0, 3);
        touchUp();

        assertEquals(myMaze2.getCell(1, 3), MazeBoardCell.PATH);
        assertEquals(myMaze2.getCell(2, 3), MazeBoardCell.PATH);
        assertEquals(myMaze2.getCell(3, 3), MazeBoardCell.PATH);
        assertEquals(myMaze2.getCell(0, 1), MazeBoardCell.PATH);
        assertEquals(myMaze2.getCell(0, 2), MazeBoardCell.PATH);
        assertEquals(myMaze2.getCell(0, 3), MazeBoardCell.PATH);
        assertEquals(false, maze.getCell(-1, -1).equals(MazeBoardCell.PATH));
        assertEquals(false, maze.getCell(0, 3).equals(MazeBoardCell.WALL));
        assertEquals(false, maze.getCell(-1, 3).equals(MazeBoardCell.PATH));
        assertEquals(false, maze.getCell(-2, 3).equals(MazeBoardCell.PATH));
        assertEquals(false, maze.getCell(-3, 3).equals(MazeBoardCell.PATH));
        assertEquals(false, maze.getCell(-4, 3).equals(MazeBoardCell.PATH));
        assertEquals(false, maze.getCell(-5, 3).equals(MazeBoardCell.PATH));

    }


    /**
     * more tests to try to fix occurrence error. These tests solve the maze in
     * different ways to try to find different solutions.
     */
    public void testMoreMaze()
    {
        click(drawEraseMode);
        click(clearMaze);

        Maze maze2 = getScreen().getMaze();

        touchDownCell(1, 0);
        touchMoveCell(1, 1);
        touchMoveCell(1, 2);
        touchMoveCell(1, 3);
        touchMoveCell(1, 4);
        touchMoveCell(2, 4);
        touchMoveCell(3, 4);
        touchMoveCell(4, 4);
        touchMoveCell(5, 4);
        touchUp();

        click(solveMaze);

        maze2 = getScreen().getMaze();

        assertEquals(maze2.getCell(1, 3), MazeBoardCell.WALL);
        assertEquals(maze2.getCell(0, 0), MazeBoardCell.START);
        assertEquals(maze2.getCell(5, 5), MazeBoardCell.FINISH);
        assertEquals(maze2.getCell(-6, -6), MazeBoardCell.INVALIDCELL);

        click(clearMaze);

        maze2 = getScreen().getMaze();

        clickCell(1, 4);
        clickCell(2, 4);
        clickCell(1, 4);

        assertEquals(maze2.getCell(1, 4), MazeBoardCell.WALL);
        assertEquals(maze2.getCell(2, 4), MazeBoardCell.WALL);

        click(drawEraseMode);

        maze2 = getScreen().getMaze();

        clickCell(1, 4);
        clickCell(2, 4);
        clickCell(1, 4);

        assertEquals(maze2.getCell(1, 4), MazeBoardCell.PATH);
        assertEquals(maze2.getCell(2, 4), MazeBoardCell.PATH);

        click(drawEraseMode);

        maze2 = getScreen().getMaze();

        touchDownCell(1, 4);
        touchMoveCell(2, 4);
        touchMoveCell(1, 4);
        touchUp();

        assertEquals(maze2.getCell(1, 4), MazeBoardCell.WALL);
        assertEquals(maze2.getCell(2, 4), MazeBoardCell.WALL);

        click(drawEraseMode);

        maze2 = getScreen().getMaze();

        touchDownCell(1, 4);
        touchMoveCell(2, 4);
        touchMoveCell(1, 4);
        touchUp();

        assertEquals(maze2.getCell(1, 4), MazeBoardCell.PATH);
        assertEquals(maze2.getCell(2, 4), MazeBoardCell.PATH);

    }

}
