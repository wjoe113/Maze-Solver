package cs2114.mazesolver;

// -------------------------------------------------------------------------
/**
 * This test class is to test SolveMaze. SolveMaze is supposed to take the maze
 * created and solve the maze from start to finish.
 *
 * @author Joe
 * @version 10.10.2012
 */
public class SolveMazeTest
    extends student.TestCase
{
    /**
     * new maze object
     */
    public SolveMaze              solveMaze;
    /**
     * A new maze that will pass when solved
     */
    public Maze                   board;
    /**
     * A new maze that will pass a different maze when solved
     */
    public Maze                   board1;
    /**
     * A new maze that will pass a different maze when solved
     */
    public Maze                   board2;
    /**
     * A new maze that will fail when solved
     */
    public Maze                   failBoard;

    /**
     * stack1 is a new array list created for the test.
     */
    public ArrayListStack<MyCell> stack;


    // -----------------------------------------------------------
    /**
     * The constructor for solveMaze does not require any tests
     */
    public SolveMazeTest()
    {
        // no tests needed
    }


    /**
     * setUp creates two mazes that both fail and use all four cardinal
     * directions in the maze.
     */
    public void setUp()
    {
        board = new Maze(6);
        board1 = new Maze(6);
        board2 = new Maze(2);
        failBoard = new Maze(6);

        solveMaze = new SolveMaze(failBoard);

        solveMaze = new SolveMaze(board);

    }


    /**
     * tests the solveMaze method in solveMaze for both a maze that cannot be
     * solved and a maze that uses all four cardinal directions.
     */
    public void testSolveMaze()
    {

        failBoard.setCell(2, 0, MazeBoardCell.WALL);
        failBoard.setCell(2, 1, MazeBoardCell.WALL);
        failBoard.setCell(2, 2, MazeBoardCell.WALL);
        failBoard.setCell(1, 2, MazeBoardCell.WALL);
        failBoard.setCell(0, 2, MazeBoardCell.WALL);

        assertEquals(null, solveMaze.solveMaze(failBoard));

        board.setCell(2, 0, MazeBoardCell.WALL);
        board.setCell(2, 1, MazeBoardCell.WALL);
        board.setCell(2, 2, MazeBoardCell.WALL);
        board.setCell(0, 1, MazeBoardCell.WALL);
        board.setCell(1, 3, MazeBoardCell.WALL);
        board.setCell(1, 4, MazeBoardCell.WALL);
        board.setCell(3, 4, MazeBoardCell.WALL);
        board.setCell(3, 5, MazeBoardCell.WALL);
        board.setCell(3, 2, MazeBoardCell.WALL);
        board.setCell(4, 2, MazeBoardCell.WALL);
        board.setCell(5, 2, MazeBoardCell.WALL);
        board.setCell(5, 3, MazeBoardCell.WALL);
        board.setCell(5, 4, MazeBoardCell.WALL);

        assertEquals("(0, 0), (1, 0), (1, 1), (1, 2), (0, 2), (0, 3), (0, 4), "
            + "(0, 5), (1, 5), (2, 5), (2, 4), (2, 3), (3, 3), (4, 3), "
            + "(4, 4), (4, 5), (5, 5)", solveMaze.solveMaze(board));

        board1.setCell(1, 0, MazeBoardCell.WALL);
        board1.setCell(1, 1, MazeBoardCell.WALL);
        board1.setCell(1, 2, MazeBoardCell.WALL);
        board1.setCell(2, 2, MazeBoardCell.WALL);

        assertEquals("(0, 0), (0, 1), (0, 2), (0, 3), (1, 3), (2, 3), "
            + "(3, 3), (3, 2), (3, 1), (3, 0), (4, 0), (5, 0), (5, 1), "
            + "(5, 2), (5, 3), (5, 4), (5, 5)", solveMaze.solveMaze(board1));

        board2.setCell(0, 1, MazeBoardCell.WALL);
        board2.setCell(1, 0, MazeBoardCell.WALL);

        assertEquals(null, solveMaze.solveMaze(board2));

    }


    /**
     * tests the current position of a cell. if the cell is a path or the finish
     * it will return true
     */
    public void testCurrentLocation()
    {
        board.setCell(2, 0, MazeBoardCell.WALL);
        board.setCell(2, 1, MazeBoardCell.WALL);

        assertEquals(MazeBoardCell.WALL, board.getCell(2, 0));
    }

}
