package cs2114.mazesolver;

// -------------------------------------------------------------------------
/**
 * This enum class stores the enums for each of the conditions for the cells.
 * The conditions include start, finish, wall, path, and invalid cell. These
 * conditions define each of the cells on the board and therefore any possible
 * scenario from each cell.
 *
 * @author Joe
 * @version 9.26.2012
 */

public enum MazeBoardCell
{
    /**
     * Start refers to the cell in which the program will start to solve the
     * maze. The start cell should be at position (x = 0,y = 0).
     */
    START,

    /**
     * Finish refers to the cell in which the program will stop solving the
     * maze. The finish cell is the goal cell and should be at position (x =
     * size of board - 1, y = size of board - 1)
     */
    FINISH,

    /**
     * Wall refers to a cell that cannot be accessed from a surrounding cell.
     */
    WALL,

    /**
     * Path refers to a cell that can be accessed from a surrounding cell.
     */
    PATH,

    /**
     * Cell that has been explored.
     */
    EXPLOREDCELL,


    /**
     * Invalid cell refers to a cell that cannot have another value such as the
     * start or finish cell becoming a wall.
     */
    INVALIDCELL,

    /**
     * Dead end refers to when solve maze reaches a location that is surrounded
     * by walls except for the way it came.
     */
    DEAD_END;
}
