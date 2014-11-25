package cs2114.mazesolver;

import junit.framework.TestCase;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 *
 * @author Joe
 * @version 9.26.2012
 */

public class MazeAdapterTest
    extends TestCase
{
    private MazeAdapter maze;


    // ----------------------------------------------------------
    /**
     * This class tests the make adapter by placing walls and paths on a new
     * maze and determining whether or not it will return true. The setUp hosts
     * a new maze adapter which will be used throughout the class.
     */

    public void setUp()
    {
        maze = new MazeAdapter();
    }


    // ----------------------------------------------------------
    /**
     * testDestroyWall creates a wall and then destroys it. If there is not a
     * wall it should return true.
     */
    public void testDestroyWall()
    {
        maze.createMaze(5);
        maze.placeWall(1, 2);
        maze.destroyWall(1, 2);
        assertFalse(maze.isWall(1, 2));

        // fail("Not yet implemented");
    }


    // ----------------------------------------------------------
    /**
     * testIsWall tests if a wall is on the maze. If there is a wall it should
     * return true.
     */
    public void testIsWall()
    {
        maze.createMaze(5);
        maze.placeWall(2, 3);
        assertTrue(maze.isWall(2, 3));
    }


    // ----------------------------------------------------------
    /**
     * testPlaceWall places a wall on the maze. If there is a wall it should
     * return true.
     */
    public void testPlaceWall()
    {
        maze.createMaze(5);
        maze.placeWall(3, 4);
        assertTrue(maze.isWall(3, 4));
    }


    // ----------------------------------------------------------
    /**
     * We are currently not working on solving the maze, so to respect the other
     * tests it returns null.
     */
    public void testSolveMaze()
    {
        maze.createMaze(6);
        assertEquals(
            "(0, 0), (1, 0), (2, 0), (3, 0), "
                + "(4, 0), (5, 0), (5, 1), (5, 2), (5, 3), (5, 4), " + "(5, 5)",
            maze.solveMaze());
    }
}
