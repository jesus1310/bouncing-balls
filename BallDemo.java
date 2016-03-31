import java.awt.Color;
import java.util.Random;
import java.util.ArrayList;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael KÃ¶lling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;
    private Random rnd;
    private ArrayList<BouncingBall> listaBolas;
    private ArrayList<BoxBall> listaBoxBall;
    
    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
        rnd = new Random();
        listaBolas = new ArrayList<>();
        listaBoxBall = new ArrayList<>();
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

        for (int i=0;i<numeroBolas;i++){
            int r = rnd.nextInt(256);
            int g = rnd.nextInt(256);
            int b = rnd.nextInt(256);
            Color rndColor = new Color(r,g,b);
            listaBolas.add(new BouncingBall(rnd.nextInt(150), rnd.nextInt(150), rnd.nextInt(100), rndColor, ground, myCanvas));
            bola = listaBolas.get(i);
            bola.draw();
        }

        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(20);
            for (int indice = 0;indice<listaBolas.size();indice++){
                listaBolas.get(indice).move();
                if(listaBolas.get(indice).getXPosition() >= 550) {
                    finished = true;
                }
            }
        }
    }

    /**
     * Método para que las bolas se muevan en diagonal y reboten al llegar a las paredes de un rectangulo dibujado
     */
    public void boxBounce(int numBolas)
    {
        int ground = 400;   // position of the ground line
        myCanvas.setVisible(true);

        myCanvas.drawLine(50,ground,550,ground);
        myCanvas.drawLine(50,ground,50,100);
        myCanvas.drawLine(550,ground,550,100);
        myCanvas.drawLine(50,100,550,100);
        
        for (int i=0;i<numBolas;i++){
            int r = rnd.nextInt(256);
            int g = rnd.nextInt(256);
            int b = rnd.nextInt(256);
            Color rndColor = new Color(r,g,b);
            listaBoxBall.add(new BoxBall(rnd.nextInt(150)+60, rnd.nextInt(200)+110, rnd.nextInt(50), rndColor, ground, myCanvas,
                                            rnd.nextBoolean(), rnd.nextBoolean()));
            listaBoxBall.get(i).draw();
        }
        
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(10);
            for (int indice = 0;indice<listaBoxBall.size();indice++){
                listaBoxBall.get(indice).move();
                if(listaBoxBall.get(indice).getXPosition() >= 550) {
                    finished = false;
                }
            }
        }
    }
}
