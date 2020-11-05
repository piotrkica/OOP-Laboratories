package agh.lab;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OptionsParserTest {
    private final IWorldMap map = new RectangularMap(4, 4);
    private final Animal wombat = new Animal(map);
    private final OptionsParser parser = new OptionsParser();
    private final String[] dirs = {"f", "f", "r", "f", "f", "r"};

    @Test
    public void testOptionsParser() {
        MoveDirection[] parsedDirs = parser.parse(dirs);
        for (MoveDirection direction : parsedDirs) {
            wombat.move(direction);
        }
        assertEquals(new Vector2d(4, 4), wombat.getPosition());
        assertEquals(MapDirection.SOUTH, wombat.getOrientation());
    }
}
