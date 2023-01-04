package test;


import org.jhotdraw.samples.svg.figures.SVGRectFigure;
import org.junit.Test;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;


public class SVGRectFigureTest2 extends SVGRectFigure {
  @Test
  public void drawStroke() {
    Point2D.Double pointOne= new Point2D.Double(5,5);
    Point2D.Double pointtwo= new Point2D.Double(10,10);
    this.setBounds(pointOne, pointtwo);
    BufferedImage image = new BufferedImage(10, 10, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g2d = image.createGraphics();
    this.drawStroke(g2d);
  }
}