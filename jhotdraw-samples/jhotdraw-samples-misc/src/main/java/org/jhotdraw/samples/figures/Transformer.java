package org.jhotdraw.samples.figures;

import org.jhotdraw.draw.AttributeKey;
import org.jhotdraw.draw.figure.Figure;

import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;

import static org.jhotdraw.draw.AttributeKeys.TRANSFORM;
import static org.jhotdraw.samples.svg.SVGAttributeKeys.FILL_GRADIENT;
import static org.jhotdraw.samples.svg.SVGAttributeKeys.STROKE_GRADIENT;

public class Transformer {
    public static void transform(Figure figure, AffineTransform tx) {
        if (figure.get(TRANSFORM) != null) {
            AffineTransform t = TRANSFORM.getClone(figure);
            t.preConcatenate(tx);
            figure.set(TRANSFORM, t);
        } else if ((tx.getType() & (AffineTransform.TYPE_TRANSLATION)) != tx.getType()) {
            TRANSFORM.setClone(figure, tx);
        } else {
            Point2D.Double anchor = figure.getStartPoint();
            Point2D.Double lead = figure.getEndPoint();
            figure.setBounds((Point2D.Double) tx.transform(anchor, anchor), (Point2D.Double) tx.transform(lead, lead));
            transformAttributeKey(figure, FILL_GRADIENT, tx);
            transformAttributeKey(figure, STROKE_GRADIENT, tx);
        }
    }

    private static void transformAttributeKey(Figure figure, AttributeKey<Gradient> AKGradient, AffineTransform tx) {
        if (figure.get(AKGradient) != null
                && !figure.get(AKGradient).isRelativeToFigureBounds()) {
            Gradient g = AKGradient.getClone(figure);
            g.transform(tx);
            figure.set(AKGradient, g);
        }
    }
}
