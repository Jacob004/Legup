package edu.rpi.legup.model.gameboard;

import java.awt.*;

public class GridBoard extends Board {

    protected Dimension dimension;

    /**
     * GridBoard Constructor creates a board for grid using puzzles from a width and height.
     *
     * @param width  width of the board
     * @param height height of the board
     */
    public GridBoard(int width, int height) {
        this.dimension = new Dimension(width, height);

        for (int i = 0; i < width * height; i++) {
            puzzleElements.add(null);
        }
    }

    /**
     * GridBoard Constructor creates a board for grid using puzzles from a size.
     *
     * @param size width and height of the GridBoard
     */
    public GridBoard(int size) {
        this(size, size);
    }

    /**
     * Gets a {@link GridCell} from the board.
     *
     * @param x x location of the cell
     * @param y y location of the cell
     * @return grid cell at location (x, y)
     */
    public GridCell getCell(int x, int y) {
        if (y * dimension.width + x >= puzzleElements.size() || x >= dimension.width ||
                y >= dimension.height || x < 0 || y < 0) {
            return null;
        }
        return (GridCell) puzzleElements.get(y * dimension.width + x);
    }

    /**
     * Sets the {@link GridCell} at the location (x,y). This method does not set the cell if the location specified is
     * out of bounds.
     *
     * @param x    x location of the cell
     * @param y    y location of the cell
     * @param cell grid cell to set at location (x,y)
     */
    public void setCell(int x, int y, GridCell cell) {
        if (y * dimension.width + x >= puzzleElements.size() || x >= dimension.width ||
                y >= dimension.height || x < 0 || y < 0) {
            return;
        }
        puzzleElements.set(y * dimension.width + x, cell);
    }

    /**
     * Gets the width of the board.
     *
     * @return width of the board
     */
    public int getWidth() {
        return dimension.width;
    }

    /**
     * Gets the height of the board.
     *
     * @return height of the board
     */
    public int getHeight() {
        return dimension.height;
    }

    /**
     * Gets the dimension of the grid board
     *
     * @return the dimension of the grid board
     */
    public Dimension getDimension() {
        return dimension;
    }

    /**
     * Performs a deep copy of the Board
     *
     * @return a new copy of the board that is independent of this one
     */
    public GridBoard copy() {
        GridBoard newGridBoard = new GridBoard(this.dimension.width, this.dimension.height);
        for (int x = 0; x < this.dimension.width; x++) {
            for (int y = 0; y < this.dimension.height; y++) {
                newGridBoard.setCell(x, y, getCell(x, y).copy());
            }
        }
        return newGridBoard;
    }
}