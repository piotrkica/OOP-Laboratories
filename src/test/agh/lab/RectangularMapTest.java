package agh.lab;

import org.junit.Test;

import static org.junit.Assert.*;

public class RectangularMapTest {
    private final IWorldMap map = new RectangularMap(10, 5);

    @Test
    public void testCanMoveTo(){
        assertFalse(map.canMoveTo(new Vector2d(-1,-1)));
        assertFalse(map.canMoveTo(new Vector2d(11,2)));
        assertFalse(map.canMoveTo(new Vector2d(2,6)));
        assertTrue(map.canMoveTo(new Vector2d(2,2)));

        map.place(new Animal(map, new Vector2d(4,4)));
        assertFalse(map.canMoveTo(new Vector2d(4,4)));
    }

    @Test
    public void testPlace(){
        assertTrue(map.place(new Animal(map, new Vector2d(4,4))));
        assertFalse(map.place(new Animal(map, new Vector2d(4,4))));
    }

    @Test
    public void testIsOccupied(){
        map.place(new Animal(map, new Vector2d(4,4)));
        map.place(new Animal(map, new Vector2d(3,3)));
        assertTrue(map.isOccupied(new Vector2d(3,3)));
        assertFalse(map.isOccupied(new Vector2d(1,1)));
    }

    @Test
    public void testObjectAt(){
        map.place(new Animal(map, new Vector2d(4,4)));
        assertNull(map.objectAt(new Vector2d(1,1)));
        Animal animal = new Animal(map);
        map.place(animal);
        assertEquals(animal, map.objectAt(new Vector2d(2,2)));
    }
}
