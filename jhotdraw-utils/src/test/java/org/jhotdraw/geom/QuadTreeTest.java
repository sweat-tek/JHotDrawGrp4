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
    }

    @AfterMethod
    public void tearDown() {

    }

    /**
     * Test the add method of QuadNode
     */
    @Test
    public void testNodeAdd() {
        quadTree = new QuadTree<>();
        assertEquals(quadTree.getSize(), 0);
        quadTree.add(new Object(), new Rectangle2D.Double(1,1,1,1));
        assertEquals(quadTree.getSize(), 1);
    }

    /**
     * Test the add method of QuadTree
     */
    @Test
    public void testTreeAdd() {
        quadTree = new QuadTree<>();
        assertEquals(quadTree.getSize(), 0, "Assert that the QuadTree is empty upon creation");
        assertBoundsInsideTree();
        assertBoundsOutsideTree();
        assertReorganizeTree();
    }

    private void assertBoundsInsideTree() {
        quadTree = new QuadTree<>();
        // Adding bound to tree and arraylist
        Rectangle2D.Double bounds = new Rectangle2D.Double(0, 0, 10, 10);
        Object o = new Object();
        Collection<Object> objects = new ArrayList<>();

        quadTree.add(o, bounds);
        objects.add(o);

        // Assert that the bounds are inside the tree
        assertEquals(quadTree.findInside(bounds), objects);
        assertEquals(quadTree.getSize(), 1);
    }

    private void assertBoundsOutsideTree() {
        quadTree = new QuadTree<>();
        // Add and assert bounds are outside the tree
        Rectangle2D.Double bounds = new Rectangle2D.Double(90000, 90000, 1, 1);
        Object o = new Object();
        Collection<Object> objects = new ArrayList<>();

        objects.add(o);                                                 // findInside() might be working faulty.
        quadTree.add(o, bounds);                                        // bounds should not be returned doing findInside
                                                                        // it is in QuadTree in the outside map
        assertEquals(quadTree.findInside(bounds), objects); // findInside() method is implemented faulty
        assertEquals(quadTree.getSize(), 0);
        assertEquals(quadTree.getOutsideSize(), 1);
    }

    private void assertReorganizeTree() {
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