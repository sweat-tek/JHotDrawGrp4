package org.jhotdraw.samples.svg.util;

import java.awt.geom.Path2D;
import java.awt.geom.RoundRectangle2D;

public class Path2DTool {

  private static final double ARCFActor=2d;

  public static Path2D.Double round(RoundRectangle2D.Double roundrect, double ACV){
    Path2D.Double p = new Path2D.Double();
    double aw = devideByFactor(roundrect.arcwidth);
    double ah = devideByFactor(roundrect.archeight);
    p.moveTo((roundrect.x + aw), (float) roundrect.y);
    p.lineTo((roundrect.x + roundrect.width - aw), (float) roundrect.y);
    p.curveTo((roundrect.x + roundrect.width - aw * ACV), (float) roundrect.y, (roundrect.x + roundrect.width), (float) (roundrect.y + ah * ACV), (roundrect.x + roundrect.width), (roundrect.y + ah));
    p.lineTo((roundrect.x + roundrect.width), (roundrect.y + roundrect.height - ah));
    p.curveTo((roundrect.x + roundrect.width), (roundrect.y + roundrect.height - ah * ACV), (roundrect.x + roundrect.width - aw * ACV), (roundrect.y + roundrect.height), (roundrect.x + roundrect.width - aw), (roundrect.y + roundrect.height));
    p.lineTo((roundrect.x + aw), (roundrect.y + roundrect.height));
    p.curveTo((roundrect.x + aw * ACV), (roundrect.y + roundrect.height), (roundrect.x), (roundrect.y + roundrect.height - ah * ACV), (float) roundrect.x, (roundrect.y + roundrect.height - ah));
    p.lineTo((float) roundrect.x, (roundrect.y + ah));
    p.curveTo((roundrect.x), (roundrect.y + ah * ACV), (roundrect.x + aw * ACV), (float) (roundrect.y), (float) (roundrect.x + aw), (float) (roundrect.y));
    p.closePath();
    return p;
  }
  private static double devideByFactor(double x){
    return x/ARCFActor;
  }
}
