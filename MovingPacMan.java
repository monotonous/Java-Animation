/*
 *  Author: Joshua Parker
 * 
 *  ===============================================================================
 *  MovingPacman.java : A shape that is Pacman.
 *  A circle which has 4 handles shown when it is selected (by clicking on it).
 *  ===============================================================================
 */
 
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;

public class MovingPacMan extends MovingCircle {
  private int angleStart = 45;
  private int angleExtent = 270;
  private int mouth = CLOSE;
  private static final int CLOSE = 0;
  private static final int OPEN = 1;
	    
  /** 
   * Constructor to create a pacman with default values
   */
  public MovingPacMan() {
   super();
  }

  /** 
   * Constructor to create an pacman shape
   */
  public MovingPacMan(int x, int y, int w, int h, int mw, int mh, Color f, Color b, int pathType) {
    super(x ,y ,w, h ,mw ,mh, f, b, pathType);
  }

  /** 
   * Draw the pacman with the fill colour
   * If it is selected, draw the handles
   * @param g	the Graphics control
   */
  public void draw(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;
	Arc2D pieArc = pacMain();
	    
	AffineTransform at = AffineTransform.getTranslateInstance(p.x, p.y);

    g2.setColor(this.fill);
    g2.fill(at.createTransformedShape(pieArc));
    g2.setColor(this.border);
    g2.draw(at.createTransformedShape(pieArc));
    drawHandles(g);
  }
	  
  /**
   * Makes the pacman shape
   * @return pacman		the pacman shape
   */
  private Arc2D pacMain(){
	Arc2D pacman = new Arc2D.Float(Arc2D.PIE);
	pacman.setFrame(0, 0, this.width, this.height);
	pacman.setAngleStart(angleStart);
	pacman.setAngleExtent(angleExtent);
	mouth();
	return pacman;
  }

  /**
   * Changes the current mouth position of pacman
   */
  private void mouth() {
    if (mouth == CLOSE) {
      angleStart -= 5;
      angleExtent += 10;
    }
    if (mouth == OPEN) {
      angleStart += 5;
      angleExtent -= 10;
    }
    if (angleStart == 0){
      mouth = OPEN;
    }
    if (angleStart > 45){
      mouth = CLOSE;
    }
  }  
}
