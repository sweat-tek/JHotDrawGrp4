package org.jhotdraw.geom;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.geom.Rectangle2D;
import static org.testng.Assert.*;

public class QuadTreeTest {
    private QuadTree<Object> quadTree;

    @BeforeMethod
    public void setUp() {
    }

    @AfterMethod
    public void tearDown() {
    }

    /**
     * Test the bounds added to the QuadTree
     * are inside the bounds of the tree
     */
    @Test
    private void testBoundsInsideTree() {
        quadTree = new QuadTree<>();
        assertEquals(quadTree.getSize(), 0, "Assert that the QuadTree is empty upon creation");
        // Adding bound to tree and arraylist
        Rectangle2D.Double bounds = new Rectangle2D.Double(0, 0, 10, 10);
        Object o = new Object();

        quadTree.add(o, bounds);
        // Assert that the bounds are inside the tree
        assertEquals(quadTree.getSize(), 1);
    }

    /**
     * Test the bounds added to the QuadTree
     * are outside the bounds of the tree
     */
    @Test
    private void testBoundsOutsideTree() {
        quadTree = new QuadTree<>();
        Rectangle2D.Double bounds = new Rectangle2D.Double(90000, 90000, 1, 1);
        Object o = new Object();

        quadTree.add(o, bounds);
        // Assert bounds are outside the tree
        assertEquals(quadTree.getSize(), 0);
        assertEquals(quadTree.getOutsideSize(), 1);
    }

    /**
     * Test the QuadTree is reorganized
     * when it has surpassed its max capacity
     */
    @Test
    private void testReorganizeTree() {
        quadTree = new QuadTree<>();

        // Trigger reorganize when adding new bounds until max capacity
        for (int i = 0; i <= quadTree.getMaxCapacity(); i++) {
            quadTree.add(new Object(), new Rectangle2D.Double(i, i, i, i));
        }
        assertEquals(quadTree.getSize(), quadTree.getMaxCapacity());
        quadTree.add(new Object(), new Rectangle2D.Double(1, 2, 3, 4));
        assertEquals(quadTree.getSize(), 0);
    }

}