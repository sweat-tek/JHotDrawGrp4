package org.jhotdraw.geom;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Collection;

import static org.testng.Assert.*;

public class QuadTreeTest {
    private QuadTree<Object> quadTree;

    @BeforeMethod
    public void setUp() {
        quadTree = new QuadTree<>();
    }

    @AfterMethod
    public void tearDown() {

    }

    @Test
    public void testAdd() {
        assertBoundsInsideTree();
        assertBoundsOutsideTree();
        assertReorganizeTree();
    }

    private void assertBoundsInsideTree() {
        // Adding bound to tree and arraylist
        Rectangle2D.Double bounds = new Rectangle2D.Double(0, 0, 10, 10);
        Object o = new Object();
        Collection<Object> objects = new ArrayList<>();
        quadTree.add(o, bounds);
        objects.add(o);
        // Assert that the bounds are inside the tree
        assertEquals(quadTree.findInside(bounds), objects);
        quadTree.remove(o);
    }

    private void assertBoundsOutsideTree() {
        // Add and assert bounds are outside the tree
        Rectangle2D.Double failBounds = new Rectangle2D.Double(90000, 90000, 1, 1);
        Object oFail = new Object();
        Collection<Object> failObjects = new ArrayList<>();
        failObjects.add(oFail);                                             // findInside() might be working wrongly.
        quadTree.add(oFail, failBounds);                                    // failBounds should not be returned doing findInside
        assertEquals(quadTree.findInside(failBounds), failObjects);         // it is in QuadTree in the outside map
        quadTree.remove(oFail);
    }

    private void assertReorganizeTree() {
        assertEquals(quadTree.getSize(), 0);
        // Trigger reorganize when adding new bounds until max capacity
        for (int i = 0; i <= quadTree.getMaxCapacity(); i++) {
            quadTree.add(new Object(), new Rectangle2D.Double(i, i, i, i));
        }
        assertEquals(quadTree.getSize(), quadTree.getMaxCapacity());
        quadTree.add(new Object(), new Rectangle2D.Double(1, 2, 3, 4));
        assertEquals(quadTree.getSize(), 0);
    }

}