import lab1.Vector2d;
import org.junit.Assert;
import org.junit.Test;

public class Vector2dTest {

    public final Vector2d x = new Vector2d(1,1);
    public final Vector2d y = new Vector2d(-1,-1);
    public final Vector2d a = new Vector2d(1, -1);
    public final Vector2d b = new Vector2d(-1,1);
    public final Vector2d c = new Vector2d(0,0);

    @Test
    public void testEquals() {
        Assert.assertNotEquals(x, y);
        Assert.assertEquals(x, new Vector2d(1, 1));
        Assert.assertNotEquals(null, x);
    }

    @Test
    public void testToString(){
        Assert.assertEquals(x.toString(), "(1, 1)");
        Assert.assertNotEquals(x.toString(), y.toString());
    }

    @Test
    public void testPrecedes(){
        Assert.assertTrue(x.precedes(y));
        Assert.assertFalse(y.precedes(x));
        Assert.assertFalse(y.precedes(a));
        Assert.assertFalse(y.precedes(b));
        Assert.assertTrue(x.precedes(a));
        Assert.assertTrue(x.precedes(b));
    }

    @Test
    public void testFollows(){
        Assert.assertTrue(y.follows(x));
        Assert.assertFalse(x.follows(y));
        Assert.assertFalse(x.follows(a));
        Assert.assertFalse(x.follows(b));
        Assert.assertTrue(y.follows(a));
        Assert.assertTrue(y.follows(b));
    }

    @Test
    public void testUpperRight() {
        Assert.assertEquals(a.upperRight(b), x);
        Assert.assertNotEquals(a.upperRight(b), y);
    }

    @Test
    public void testLowerLeft() {
        Assert.assertEquals(a.lowerLeft(b), y);
        Assert.assertNotEquals(a.lowerLeft(b), x);
    }

    @Test
    public void testAdd(){
        Assert.assertEquals(x.add(y), c);
        Assert.assertNotEquals(x.add(c), y);
    }

    @Test
    public void testSubtract(){
        Assert.assertEquals(x.subtract(x), c);
        Assert.assertNotEquals(x.subtract(y), c);
    }

    @Test
    public void testOpposite(){
        Assert.assertEquals(x.opposite(), y);
        Assert.assertNotEquals(x.opposite(), c);
    }

}
