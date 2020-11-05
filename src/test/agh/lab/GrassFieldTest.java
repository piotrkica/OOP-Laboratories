package agh.lab;

import org.junit.Test;

import static org.junit.Assert.*;

public class GrassFieldTest {
    private final GrassField map = new GrassField(10);

    @Test
    public void testGetMapBoundaries(){
        map.place(new Animal(map, new Vector2d(99,100)));
        map.place(new Animal(map, new Vector2d(100,99)));  // testy zależą do ilości traw, żadna trawa nie wyjdzie na jakiejś pozycji poza (int sqrt(10*n))
        map.place(new Animal(map, new Vector2d(-99,-100))); // w tym przypadku poza 10
        map.place(new Animal(map, new Vector2d(-100,-99)));
        Vector2d[] minMaxXY = map.getMapBoundaries();
        assertEquals(new Vector2d(-100,-100), minMaxXY[0]);
        assertEquals(new Vector2d(100,100), minMaxXY[1]);
        map.placeGrass(new Grass(new Vector2d(149,150)));
        map.placeGrass(new Grass(new Vector2d(150,149)));
        map.placeGrass(new Grass(new Vector2d(-149,-150)));
        map.placeGrass(new Grass(new Vector2d(-150,-149)));
        minMaxXY = map.getMapBoundaries();
        assertEquals(new Vector2d(-150,-150), minMaxXY[0]);
        assertEquals(new Vector2d(150,150), minMaxXY[1]);
    }

    @Test
    public void testCanMoveTo(){
        assertTrue(map.canMoveTo(new Vector2d(4,4)));
        map.place(new Animal(map, new Vector2d(4,4)));
        assertFalse(map.canMoveTo(new Vector2d(4,4)));
    }

    @Test
    public void testPlace(){
        assertTrue(map.place(new Animal(map, new Vector2d(4,4))));
    }

    @Test
    public void testPlaceGrass(){
        assertTrue(map.placeGrass(new Grass(new Vector2d(150,150))));
        assertFalse(map.placeGrass(new Grass(new Vector2d(150,150))));
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
