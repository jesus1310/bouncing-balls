import java.awt.*;
import java.awt.geom.*;

/**
 * Write a description of class BoxBall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BoxBall
{
    private static final int GRAVITY = 0;  // effect of gravity

    private int ballDegradation = 2;
    private Ellipse2D.Double circle;
    private Color color;
    private int diameter;
    private int xPosition;
    private int yPosition;
    private final int groundPosition;      // y position of ground
    private Canvas canvas;
    private int ySpeed = 1;                // initial downward speed
    private boolean direccionDcha;
    private boolean direccionAbajo;
    private int x1;
    private int x2;
    private int y1;
    private int y2;

    /**
     * Constructor for objects of class BoxBall
     */
    public BoxBall(int xPos, int yPos, int ballDiameter, Color ballColor, int groundPos, Canvas drawingCanvas, boolean dirVertical, boolean dirHorizontal,
                    int x1, int y1, int x2, int y2)
    {
        xPosition = xPos;
        yPosition = yPos;
        color = ballColor;
        diameter = ballDiameter;
        groundPosition = groundPos;
        canvas = drawingCanvas;
        direccionDcha = dirHorizontal;
        direccionAbajo = dirVertical;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    /**
     * Draw this ball at its current position onto the canvas.
     **/
    public void draw()
    {
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPosition, yPosition, diameter);
    }

    /**
     * Erase this ball at its current position.
     **/
    public void erase()
    {
        canvas.eraseCircle(xPosition, yPosition, diameter);
    }    

    /**
     * Move this ball according to its position and speed and redraw.
     **/
    public void move()
    {
        // remove from canvas at the current position
        erase();

        // compute new position
        if (direccionAbajo) {
            yPosition++;
        }
        else {
            yPosition--;
        }

        if (direccionDcha) {
            xPosition++;
        }
        else {
            xPosition--;
        }

        if (yPosition >= (y1-diameter) || yPosition <= y2){
            direccionAbajo = !direccionAbajo;
        }
        
        if (xPosition <= x1 || xPosition >= (x2-diameter)){
            direccionDcha = !direccionDcha;
        }

        // draw again at new position
        draw();
    }

    /**
     * return the horizontal position of this ball
     */
    public int getXPosition()
    {
        return xPosition;
    }

    /**
     * return the vertical position of this ball
     */
    public int getYPosition()
    {
        return yPosition;
    }
}
