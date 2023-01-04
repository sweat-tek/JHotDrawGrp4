package test;

import org.jhotdraw.draw.handle.BoundsOutlineHandle;
import org.jhotdraw.draw.handle.Handle;
import org.jhotdraw.samples.svg.figures.LinkHandle;
import org.jhotdraw.samples.svg.figures.SVGRectFigure;
import org.jhotdraw.samples.svg.figures.SVGRectRadiusHandle;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class SVGRectFigureTest extends SVGRectFigure{

  private SVGRectFigure rectFigure;

  @Before
  public void setUp() throws Exception {
    this.rectFigure = new SVGRectFigure();
  }

  @After
  public void tearDown() throws Exception {
  }



  @Test
  public void setBounds() {
    Point2D.Double pointOne= new Point2D.Double(5,5);
    Point2D.Double pointtwo= new Point2D.Double(10,10);
    double delta = 0.000000001;
    this.rectFigure.setBounds(pointOne, pointtwo);
    assertEquals( this.rectFigure.getRoundrect().x,5.0, delta);
    assertEquals( this.rectFigure.getRoundrect().y,5.0, delta);
    assertEquals( this.rectFigure.getRoundrect().width,5.0, delta);
    assertEquals( this.rectFigure.getRoundrect().height,5.0, delta);
    pointOne= new Point2D.Double(20,10);
    pointtwo= new Point2D.Double(30,40);
    this.rectFigure.setBounds(pointOne, pointtwo);
    assertEquals( this.rectFigure.getRoundrect().x,20, delta);
    assertEquals( this.rectFigure.getRoundrect().y,10, delta);
    assertEquals( this.rectFigure.getRoundrect().width,10, delta);
    assertEquals( this.rectFigure.getRoundrect().height,30, delta);
  }



  @Test
  public void createHandleswith1() {
    this.rectFigure = new SVGRectFigure();
    LinkedList<Handle> handles  = (LinkedList<Handle>) this.rectFigure.createHandles(-2);
    assertFalse(handles.isEmpty());
    assertTrue(handles.getFirst() instanceof BoundsOutlineHandle);
  }





}