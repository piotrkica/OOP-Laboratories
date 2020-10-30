package agh.lab;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OptionsParserTest {
    private IWorldMap map = new RectangularMap(4, 4);
    Animal galago = new Animal(map);
    OptionsParser parser = new OptionsParser();
    String[] dirs = {"test", "f", "f", "r", "f", "f", "r", "test", "test"};

    @Test
    public void testOptionsParser() {
        MoveDirection[] parsedDirs = parser.parse(dirs);
        for (MoveDirection direction : parsedDirs) {
            galago.move(direction);
        }
        assertEquals(galago.getPosition(), new Vector2d(4, 4));
        assertEquals(galago.getOrientation(), MapDirection.SOUTH);
    }
}
