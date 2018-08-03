package controller;

import javafx.scene.Cursor;
import ui.DynamicViewer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public abstract class Controller implements MouseMotionListener, MouseListener, MouseWheelListener
{
    protected DynamicViewer viewer;
    private int x, y;
    private boolean pan;

    /**
     * Controller Constructor - creates a controller object to listen
     * to ui events from a DynamicViewer
     */
    public Controller()
    {
        x = y = -1;
        pan = false;
    }

    public void setViewer(DynamicViewer viewer)
    {
        this.viewer = viewer;
    }

    /**
     * Mouse Clicked event - no default action
     *
     * @param e MouseEvent object
     */
    @Override
    public void mouseClicked(MouseEvent e)
    {

    }

    /**
     * Mouse Pressed event - sets the cursor to the move cursor and stores
     * info for possible panning
     *
     * @param e MouseEvent object
     */
    @Override
    public void mousePressed(MouseEvent e)
    {
        if(e.getButton() == MouseEvent.BUTTON2)
        {
            pan = true;
            x = e.getX();
            y = e.getY();
            viewer.setCursor(javafx.scene.Cursor.CLOSED_HAND);
        }
    }

    /**
     * Mouse Released event - sets the cursor back to the default cursor and reset
     * info for panning
     *
     * @param e MouseEvent object
     */
    @Override
    public void mouseReleased(MouseEvent e)
    {
        if(e.getButton() == MouseEvent.BUTTON2)
        {
            pan = false;
            viewer.setCursor(Cursor.DEFAULT);
        }
    }

    /**
     * Mouse Entered event - no default action
     *
     * @param e MouseEvent object
     */
    @Override
    public void mouseEntered(MouseEvent e)
    {

    }

    /**
     * Mouse Exited event - no default action
     *
     * @param e MouseEvent object
     */
    @Override
    public void mouseExited(MouseEvent e)
    {

    }

    /**
     * Mouse Dragged event - adjusts the viewport
     *
     * @param e MouseEvent object
     */
    @Override
    public void mouseDragged(MouseEvent e)
    {

    }

    /**
     * Mouse Moved event - no default action
     *
     * @param e MouseEvent object
     */
    @Override
    public void mouseMoved(MouseEvent e)
    {

    }

    /**
     * Mouse Wheel Moved event - zooms in on the viewport
     *
     * @param e MouseEvent object
     */
    @Override
    public void mouseWheelMoved(MouseWheelEvent e)
    {

    }
}