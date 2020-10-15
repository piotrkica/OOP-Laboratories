package lab;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Vector2dTest {

    public final Vector2d x = new Vector2d(1, 1);
    public final Vector2d y = new Vector2d(-1, -1);
    public final Vector2d a = new Vector2d(1, -1);
    public final Vector2d b = new Vector2d(-1, 1);
    public final Vector2d c = new Vector2d(0, 0);

    @Test
    public void testEquals() {
        assertNotEquals(x, y);
        assertEquals(x, new Vector2d(1, 1));
        assertNotEquals(null, x);
    }

    @Test
    public void testToString() {
        assertEquals(x.toString(), "(1, 1)");
        assertNotEquals(x.toString(), y.toString());
    }

    @Test
    public void testPrecedes() {
        assertTrue(x.precedes(y));
        assertFalse(y.precedes(x));
        assertFalse(y.precedes(a));
        assertFalse(y.precedes(b));
        assertTrue(x.precedes(a));
        assertTrue(x.precedes(b));
    }

    @Test
    public void testFollows() {
        assertTrue(y.follows(x));
        assertFalse(x.follows(y));
        assertFalse(x.follows(a));
        assertFalse(x.follows(b));
        assertTrue(y.follows(a));
        assertTrue(y.follows(b));
    }

    @Test
    public void testUpperRight() {
        assertEquals(a.upperRight(b), x);
        assertNotEquals(a.upperRight(b), y);
    }

    @Test
    public void testLowerLeft() {
        assertEquals(a.lowerLeft(b), y);
        assertNotEquals(a.lowerLeft(b), x);
    }

    @Test
    public void testAdd() {
        assertEquals(x.add(y), c);
        assertNotEquals(x.add(c), y);
    }

    @Test
    public void testSubtract() {
        assertEquals(x.subtract(x), c);
        assertNotEquals(x.subtract(y), c);
    }

    @Test
    public void testOpposite() {
        assertEquals(x.opposite(), y);
        assertNotEquals(x.opposite(), c);
    }

}
