package lab;

import org.junit.Test;
import static org.junit.Assert.*;

public class IntegrationTest {
    private IWorldMap map = new RectangularMap(10, 5);
    private OptionsParser parser = new OptionsParser();


    @Test
    public void testIntegration(){
        Animal wombat = new Animal(map);
        Animal lemur = new Animal(map, new Vector2d(3,4));
        map.place(wombat);
        map.place(lemur);

        String [] directions = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        map.run(parser.parse(directions));
        assertEquals(new Vector2d(2,0), wombat.getPosition());
        assertEquals(new Vector2d(3,5), lemur.getPosition());
    }

}
