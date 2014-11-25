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

public class MazeTest
    extends TestCase
{
    private Maze maze;


    // ----------------------------------------------------------
    /**
     * This class makes an adapter to fix the maze by placing walls and paths on
     * the maze where they are needed. The setUp hosts a new maze which will be
     * used throughout the class.
     */

    public void setUp()
    {
        maze = new Maze(5);
    }


    // ----------------------------------------------------------
    /**
     * testSetCell tests setCell which changes a cell into a wall, path, invalid
     * cell, finish, or start.
     */

    public void testSetCell()
    {
        maze.setCell(1, 2, MazeBoardCell.WALL);
        assertEquals(MazeBoardCell.WALL, maze.getCell(1, 2));

        maze.setCell(0, 0, MazeBoardCell.START);
        assertEquals(MazeBoardCell.START, maze.getCell(0, 0));

        maze.setCell(4, 4, MazeBoardCell.FINISH);
        assertEquals(MazeBoardCell.FINISH, maze.getCell(4, 4));

        maze.setCell(-1, -1, MazeBoardCell.PATH);
        assertEquals(false, maze.getCell(-1, -1).equals(MazeBoardCell.PATH));

    }


    // ----------------------------------------------------------
    /**
     * testGetCell tests getCell which retrieves a cell.
     */
    public void testGetCell()
    {
        assertEquals(MazeBoardCell.PATH, maze.getCell(2, 2));
        assertEquals(MazeBoardCell.INVALIDCELL, maze.getCell(-1, -1));
    }


    // ----------------------------------------------------------
    /**
     * testSize tests the size of the maze. The size of the maze should
     * represent both the height and width of the maze.
     */
    public void testSize()
    {
        assertEquals(5, maze.puzzleSize());
    }


    /**
     * testPlaceWall tests if a wall is placed in a cell and whether or not the
     * cell is start or finish.
     */
    public void testPlaceWall()
    {

        maze.setCell(1, 2, MazeBoardCell.WALL);
        assertEquals(MazeBoardCell.WALL, maze.getCell(1, 2));

        maze.placeWall(0, 0);
        assertEquals(MazeBoardCell.START, maze.getCell(0, 0));

        maze.placeWall(4, 4);
        assertEquals(MazeBoardCell.FINISH, maze.getCell(4, 4));
    }
}
