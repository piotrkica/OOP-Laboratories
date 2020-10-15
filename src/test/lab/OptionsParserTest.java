package lab;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OptionsParserTest {
    Animal galago = new Animal();
    OptionsParser parser = new OptionsParser();
    String[] dirs = {"test", "f", "f", "r", "f", "f", "r", "test", "test"};

    @Test
    public void optionsParserTest() {
        MoveDirection[] parsedDirs = parser.parse(dirs);
        for (MoveDirection direction : parsedDirs) {
            galago.move(direction);
        }
        assertEquals(galago.getLocation(), new Vector2d(4, 4));
        assertEquals(galago.getOrientation(), MapDirection.SOUTH);
    }
}
