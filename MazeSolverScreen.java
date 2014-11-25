package cs2114.mazesolver;

import android.widget.Toast;
import android.widget.CheckBox;
import android.view.MotionEvent;
import sofia.graphics.Color;
import sofia.graphics.RectangleShape;
import sofia.app.ShapeScreen;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 *
 * @author Joe
 * @version 2012.10.19
 */
public class MazeSolverScreen
    extends ShapeScreen
{

    private RectangleShape[][] cell;

    /**
     * maze is a new protected version of SolveMaze
     */
    private Maze               maze;
    private float              cellSize;
    private CheckBox           drawEraseMode;
    private SolveMaze          solveMaze;


    // ----------------------------------------------------------
    /**
     * initializes the methods
     */
    public void initialize()
    {
        this.maze = new Maze(6);
        this.cell = new RectangleShape[maze.puzzleSize()][maze.puzzleSize()];
        setBackgroundColor(Color.black);
        float mazeSize = Math.min(getWidth(), getHeight());
        cellSize = mazeSize / maze.puzzleSize();

        for (int x = 0; x < maze.puzzleSize(); x++)
        {
            for (int y = 0; y < maze.puzzleSize(); y++)
            {
                float startX = x * cellSize;
                float startY = y * cellSize;
                RectangleShape emptyCell =
                    new RectangleShape(
                        startX,
                        startY,
                        startX + cellSize,
                        startY + cellSize);
                emptyCell.setColor(Color.black);
                emptyCell.setFillColor(Color.red);
                emptyCell.setFilled(true);
                add(emptyCell);
                this.cell[x][y] = emptyCell;
            }
        }
    }


    // ----------------------------------------------------------
    // Uncomment this method and have it return the instance of the maze you
    // created in initialize(). You will use this method in your tests to
    // assert the state of the maze after touching the shape view. Then,
    // replace this comment with a meaningful Javadoc.
    //
    // ----------------------------------------------------------
    /**
     * Gets the maze
     *
     * @return = maze
     */
    public Maze getMaze()
    {
        return maze;
    }


    // ----------------------------------------------------------
    /**
     * Clears the maze when the clearMaze button is clicked.
     */
    public void clearMazeClicked()
    {
        for (int x = 0; x < maze.puzzleSize(); x++)
        {
            for (int y = 0; y < maze.puzzleSize(); y++)
            {
                this.cell[x][y].setFillColor(Color.red);
                this.cell[x][y].setFilled(true);
                this.maze = new Maze(6);
            }
        }
    }


    /**
     * solveMazeClicked is used when the user clicks on the solveMaze button.
     */
    public void solveMazeClicked()
    {
        this.solveMaze = new SolveMaze(maze);
        String mySolveMaze = this.solveMaze.solveMaze(maze);
        for (int x = 0; x < maze.puzzleSize(); x++)
        {
            for (int y = 0; y < maze.puzzleSize(); y++)
            {
                if (maze.getCell(x, y).equals(MazeBoardCell.EXPLOREDCELL))
                {
                    this.cell[x][y].setFillColor(Color.white);
                    this.cell[x][y].setFilled(true);
                }
                else if (maze.getCell(x, y).equals(MazeBoardCell.DEAD_END))
                {
                    this.cell[x][y].setFillColor(Color.gray);
                    this.cell[x][y].setFilled(true);
                }
            }
            if (mySolveMaze == null)
            {
                mySolveMaze = "No solution was possible";

            }

        }
        Toast.makeText(this, mySolveMaze, Toast.LENGTH_LONG).show();
    }


    // ----------------------------------------------------------
    /**
     * This method describes what happens when the user touches down on the
     * view.
     *
     * @param event
     *            = the user touching the screen
     */
    public void onTouchDown(MotionEvent event)
    {
        int x = (int)(event.getX() / cellSize);
        int y = (int)(event.getY() / cellSize);

        if (drawEraseMode.isChecked())
        {
            maze.setCell(x, y, MazeBoardCell.WALL);
            if (maze.getCell(x, y).equals(MazeBoardCell.WALL))
            {
                this.cell[x][y].setFillColor(Color.green);
                this.cell[x][y].setFilled(true);
            }
        }
        else
        {
            maze.setCell(x, y, MazeBoardCell.PATH);
            if (maze.getCell(x, y).equals(MazeBoardCell.PATH))
            {
                this.cell[x][y].setFillColor(Color.red);
                this.cell[x][y].setFilled(true);
            }
        }
    }


    /**
     * This method describes what happens when the user touches down and moves
     * on the view.
     *
     * @param event
     *            = the user touching the screen
     */
    public void onTouchMove(MotionEvent event)
    {
        int x = (int)(event.getX() / cellSize);
        int y = (int)(event.getY() / cellSize);

        if (drawEraseMode.isChecked())
        {
            maze.setCell(x, y, MazeBoardCell.WALL);
            if (maze.getCell(x, y).equals(MazeBoardCell.WALL))
            {
                this.cell[x][y].setFillColor(Color.green);
                this.cell[x][y].setFilled(true);
            }
        }
        else
        {
            maze.setCell(x, y, MazeBoardCell.PATH);
            if (maze.getCell(x, y).equals(MazeBoardCell.PATH))
            {
                this.cell[x][y].setFillColor(Color.red);
                this.cell[x][y].setFilled(true);
            }
        }
    }
}
