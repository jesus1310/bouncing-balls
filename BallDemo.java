import java.awt.Color;
import java.util.Random;
import java.util.ArrayList;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;
    private Random rnd;
    private ArrayList<BouncingBall> listaBolas;
    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
        rnd = new Random();
        listaBolas = new ArrayList<>();
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce(int numeroBolas)
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);

        BouncingBall bola = null;
        
        int posX = 40;
        int posY = 40;
        int radio = 15;
        for (int i=0;i<numeroBolas;i++){
            listaBolas.add(new BouncingBall(posX, posY, radio, Color.BLUE, ground, myCanvas));
            bola = listaBolas.get(i);
            bola.draw();
            posX+=10;
            posY+=10;
            radio+=5;
        }

        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);
            for (int indice = 0;indice<listaBolas.size();indice++){
                listaBolas.get(indice).move();
                if(bola.getXPosition() >= 550) {
                    finished = true;
                }
            }
        }
    }
}
