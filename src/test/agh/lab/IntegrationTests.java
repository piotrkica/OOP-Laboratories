package agh.lab;

import org.junit.Test;
import static org.junit.Assert.*;

public class IntegrationTests {
    private final IWorldMap map = new RectangularMap(10, 5);
    private final OptionsParser parser = new OptionsParser();
    private final IWorldMap grassMap = new GrassField(10);

    @Test
    public void testIntegrationRectangular(){
        Animal wombat = new Animal(map);
        Animal lemur = new Animal(map, new Vector2d(3,4));
        map.place(wombat);
        map.place(lemur);

        String [] directions = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        map.run(parser.parse(directions));
        assertEquals(new Vector2d(2,0), wombat.getPosition());
        assertEquals(new Vector2d(3,5), lemur.getPosition());
    }

    @Test
    public void testIntegrationGrassField(){
        Animal wombat = new Animal(grassMap);
        Animal lemur = new Animal(grassMap, new Vector2d(3,4));
        grassMap.place(wombat);
        grassMap.place(lemur);

        String [] directions = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        grassMap.run(parser.parse(directions));
        assertEquals(new Vector2d(2,-1), wombat.getPosition());
        assertEquals(new Vector2d(3,7), lemur.getPosition());
    }

}
