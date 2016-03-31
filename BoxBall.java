import java.awt.*;

/**
 * Class BoxBall - a graphical ball that observes the effect of gravity. The ball
 * has the ability to move. Details of movement are determined by the ball itself. It
 * will fall downwards, accelerating with time due to the effect of gravity, and bounce
 * upward again when hitting the ground.
 *
 * This movement can be initiated by repeated calls to the "move" method.
 * 
 * @author Michael KÃ¶lling (mik)
 * @author David J. Barnes
 * @author Bruce Quig
 *
 * @version 2011.07.31
 */

public class BoxBall
{
    private static final int GRAVITY = 0;  // effect of gravity

    private int ballDegradation = 2;
    private Color color;
    private int diameter;
    private int xPosition;
    private int yPosition;
    private final int groundPosition;      // y position of ground
    private Canvas canvas;
    private int ySpeed = 1;                // initial downward speed
    private boolean dirIzquierda;
    private boolean dirArriba;

    /**
     * Constructor for objects of class BouncingBall
     *
     * @param xPos  the horizontal coordinate of the ball
     * @param yPos  the vertical coordinate of the ball
     * @param ballDiameter  the diameter (in pixels) of the ball
     * @param ballColor  the color of the ball
     * @param groundPos  the position of the ground (where the wall will bounce)
     * @param drawingCanvas  the canvas to draw this ball on
     * @param dirección Sera true si va a la izquierda, false si va a la derecha
     */
    public BoxBall(int xPos, int yPos, int ballDiameter, Color ballColor,
    int groundPos, Canvas drawingCanvas, boolean direccion)
    {
        xPosition = xPos;
        yPosition = yPos;
        color = ballColor;
        diameter = ballDiameter;
        groundPosition = groundPos;
        canvas = drawingCanvas;
        dirIzquierda = direccion;
        dirArriba = false;
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
        if(dirArriba){
            yPosition += ySpeed;
        }
        else
        {
            yPosition -= ySpeed;
        }
        if(!dirIzquierda)
        {
            xPosition +=1;
        }
        else
        {
            xPosition -=1;
        }

        // check if it has hit the rectangle
        if(((xPosition <= 50) || ((xPosition  >= 450 - diameter)))) {
            dirIzquierda = !dirIzquierda;
        }
        if(((yPosition <= 50)) || ((yPosition  >= 450- diameter))){
            dirArriba = !dirArriba;
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
