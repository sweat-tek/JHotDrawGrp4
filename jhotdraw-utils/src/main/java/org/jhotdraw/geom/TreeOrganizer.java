package org.jhotdraw.geom;

import java.awt.geom.Rectangle2D;
import java.util.Iterator;
import java.util.Map;

public class TreeOrganizer<T> {
    public Rectangle2D.Double uniteAllBounds(Map<T, Rectangle2D.Double> outside) {
        Iterator<Map.Entry<T, Rectangle2D.Double>> i = outside.entrySet().iterator();
        Map.Entry<T, Rectangle2D.Double> entry = i.next();
        Rectangle2D.Double treeBounds = (Rectangle2D.Double) (entry.getValue()).clone();
        while (i.hasNext()) {
            entry = i.next();
            Rectangle2D.Double bounds = entry.getValue();
            treeBounds.add(bounds); // uniting the bounds to one big bound containing all bounds
        }
        return treeBounds;
    }
}
