package org.jhotdraw.geom;

import java.awt.geom.Rectangle2D;
import java.util.HashMap;
import java.util.Map;

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

    @Test
    public void testTreeIsEmpty_UponCreation() {
        quadTree = new QuadTree<>();
        assertEquals("Assert that the QuadTree is empty upon creation",
                0, quadTree.getSize());
    }

    /**
     * Test the bounds added to the QuadTree
     * are inside the bounds of the tree
     */
    @Test
    public void testBoundsOfObject_AreInside_BoundsOfTree() {
        quadTree = new QuadTree<>();
        // Adding bound to tree and arraylist
        Rectangle2D.Double bounds = new Rectangle2D.Double(0, 0, 10, 10);
        Object o = new Object();

        quadTree.add(o, bounds);
        assertEquals("Assert that the bounds of the object are inside the bounds of the tree",
                1, quadTree.getSize());
    }

    /**
     * Test the bounds added to the QuadTree
     * are outside the bounds of the tree
     */
    @Test
    public void testBoundsOfObject_AreOutside_BoundsOfTree() {
        quadTree = new QuadTree<>();
        Rectangle2D.Double bounds = new Rectangle2D.Double(90000, 90000, 1, 1);
        Object o = new Object();

        quadTree.add(o, bounds);
        assertEquals("Assert that the bounds of the object are outside the bounds of the tree",
                1, quadTree.getOutsideSize());
    }

    @Test
    public void testBoundsOfObject_AreNotInside_WhenItShouldBeOutside() {
        quadTree = new QuadTree<>();
        Rectangle2D.Double bounds = new Rectangle2D.Double(90000, 90000, 1, 1);
        Object o = new Object();

        quadTree.add(o, bounds);
        assertEquals("Assert that the bounds of the object are not inside the bounds of the tree",
                0, quadTree.getSize());
    }

    @Test
    public void testTreeIsAt_MaxCapacity() {
        quadTree = new QuadTree<>();

        for (int i = 0; i <= quadTree.getMaxCapacity(); i++) {
            quadTree.add(new Object(), new Rectangle2D.Double(i, i, i, i));
        }
        assertEquals("Assert that the tree is at max capacity",
                quadTree.getMaxCapacity(), quadTree.getSize());
    }

    /**
     * Test the QuadTree is reorganized
     * when it has surpassed its max capacity
     */
    @Test
    public void testTreeIsReorganized_WhenItIs_AtMaxCapacity() {
        quadTree = new QuadTree<>();

        // Trigger reorganize when adding new bounds until max capacity
        for (int i = 0; i <= quadTree.getMaxCapacity()+1; i++) {
            quadTree.add(new Object(), new Rectangle2D.Double(i, i, i, i));
        }
        assertEquals("Assert that the tree has been reorganized",
                0, quadTree.getSize());
    }

    @Test
    public void testUniteAllBounds_BoundsShouldNotChange() {
        Map<Object, Rectangle2D.Double> outside = new HashMap<>();
        outside.put(new Object(), new Rectangle2D.Double(0, 0, 1000, 1000));
        outside.put(new Object(), new Rectangle2D.Double(0, 0, 1, 1));

        Rectangle2D.Double unitedBounds = new TreeOrganizer<>().uniteAllBounds(outside);
        assertEquals("Assert that the union of the bounds are equal to the first bounds",
                new Rectangle2D.Double(0, 0, 1000, 1000), unitedBounds);
    }

    @Test
    public void testUniteAllBounds_BoundsShouldChange() {
        Map<Object, Rectangle2D.Double> outside = new HashMap<>();
        outside.put(new Object(), new Rectangle2D.Double(0, 0, 1000, 1000));
        outside.put(new Object(), new Rectangle2D.Double(1000, 1000, 1, 1));

        Rectangle2D.Double unitedBounds = new TreeOrganizer<>().uniteAllBounds(outside);
        assertEquals("Assert that the union of the bounds are a new bounds equal to the two added up",
                new Rectangle2D.Double(0, 0, 1001, 1001), unitedBounds);

    }

}