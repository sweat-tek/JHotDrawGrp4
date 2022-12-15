package org.jhotdraw.geom;

import java.awt.geom.Rectangle2D;
import org.junit.*;
import static org.junit.Assert.assertEquals;

public class QuadTreeTest {
    private QuadTree<Object> quadTree;

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test the bounds added to the QuadTree
     * are inside the bounds of the tree
     */
    @Test()
    public void testBoundsInsideTree() {
        quadTree = new QuadTree<>();
        assertEquals("Assert that the QuadTree is empty upon creation", 0,
                quadTree.getSize());
        // Adding bound to tree and arraylist
        Rectangle2D.Double bounds = new Rectangle2D.Double(0, 0, 10, 10);
        Object o = new Object();

        quadTree.add(o, bounds);
        assertEquals("Assert that the bounds of the object are inside the bounds of the tree",
                quadTree.getSize(), 1);
    }

    /**
     * Test the bounds added to the QuadTree
     * are outside the bounds of the tree
     */
    @Test
    public void testBoundsOutsideTree() {
        quadTree = new QuadTree<>();
        Rectangle2D.Double bounds = new Rectangle2D.Double(90000, 90000, 1, 1);
        Object o = new Object();

        quadTree.add(o, bounds);
        assertEquals("Assert that the bounds of the object are not inside the bounds of the tree",
                quadTree.getSize(), 0);
        assertEquals("Assert that the bounds of the object are outside the bounds of the tree",
                quadTree.getOutsideSize(), 1);
    }

    /**
     * Test the QuadTree is reorganized
     * when it has surpassed its max capacity
     */
    @Test
    public void testReorganizeTree() {
        quadTree = new QuadTree<>();

        // Trigger reorganize when adding new bounds until max capacity
        for (int i = 0; i <= quadTree.getMaxCapacity(); i++) {
            quadTree.add(new Object(), new Rectangle2D.Double(i, i, i, i));
        }
        assertEquals("Assert that the tree is at max capacity", quadTree.getSize(),
                quadTree.getMaxCapacity());
        quadTree.add(new Object(), new Rectangle2D.Double(1, 2, 3, 4));
        assertEquals("Assert that the tree has been reorganized", quadTree.getSize(), 0);
    }

}