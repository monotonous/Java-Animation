/*
 *  Author: Joshua Parker
 * 
 *  ===============================================================================
 *  MovingBowTie.java : A shape that is a Bow Tie.
 *  A Bow Tie has 4 handles shown when it is selected (by clicking on it).
 *  ===============================================================================
 */
 
import java.awt.*;

public class MovingBowTie extends MovingShape {
  /** 
   * Constructor to create a bow tie with default values
   */
  public MovingBowTie() {
    super();
  }

  /** 
   * Constructor to create a bow tie shape
   */
  public MovingBowTie(int x, int y, int w, int h, int mw, int mh, Color f, Color b, int pathType) {
    super(x ,y ,w, h, mw ,mh, f, b ,pathType);
  }

  /** 
   * Draws the bow tie with the fill colour
   * If it is selected, draw the handles
   * @param g	the Graphics control
   */
  public void draw(Graphics g) {
	Polygon bowtie = bowtieOuter();
	Polygon centre = bowtieCentre();

	g.setColor(this.fill);
	g.fillPolygon(bowtie);

	g.setColor(this.border);
	g.fillPolygon(centre);

    drawHandles(g);
  }

  /**
   * Creates the outer bow tie shape
   * @return the outer bow tie
   */
  private Polygon bowtieOuter(){
	int offSet = this.height / 3;
	int halfWidth = this.width / 2;

	int[] tieX = {p.x, p.x + halfWidth, p.x + this.width, p.x + this.width, p.x + halfWidth, p.x};
	int[] tieY = {p.y, p.y + offSet, p.y, p.y + this.height, p.y + this.height - offSet, p.y + this.height};

	return new Polygon(tieX, tieY, 6);
  }

  /**
   * Creates the centre diamond shape of the bow tie
   * @return the centre bow tie diamond
   */
  private Polygon bowtieCentre(){
	int offSet = this.width / 4;
	int heightOffSet = this.height / 3;
	int halfHeight = this.height / 2;
	int halfWidth = this.width / 2;

	int[] tieX = {p.x + offSet, p.x + halfWidth, p.x + halfWidth + offSet, p.x + halfWidth};
	int[] tieY = {p.y + halfHeight, p.y + heightOffSet, p.y + halfHeight, p.y + this.height - heightOffSet};

	return new Polygon(tieX, tieY, 4);
  }

  /**
   * Returns whether the point is in the bow tie or not
   * @return true if and only if the point is in the bow tie, false otherwise.
   */
  public boolean contains(Point mousePt) {
    return bowtieOuter().contains(mousePt.x, mousePt.y);
  }
}
