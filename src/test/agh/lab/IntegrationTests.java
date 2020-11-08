package agh.lab;

import org.junit.Test;

import java.util.Iterator;
import java.util.Map;
import static org.junit.Assert.*;

public class IntegrationTests {
    private final RectangularMap rectMap = new RectangularMap(10, 5);
    private final OptionsParser parser = new OptionsParser();
    private final GrassField grassMap = new GrassField(10);

    @Test
    public void testIntegrationRectangular() {
        Vector2d[] startingPositions = {new Vector2d(2,2), new Vector2d(3,4)};
        String[] directions = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        SimulationEngine engine = new SimulationEngine(parser.parse(directions), rectMap, startingPositions);
        engine.run();
        Map<Vector2d, Animal> animalsHM = rectMap.getAnimalsHM();
        Iterator<Map.Entry<Vector2d, Animal>> animals = animalsHM.entrySet().iterator();
        Map.Entry<Vector2d, Animal> wombat = animals.next();
        Map.Entry<Vector2d, Animal> lemur = animals.next();
        assertEquals(new Vector2d(2,0), wombat.getKey());
        assertEquals(new Vector2d(3,5), lemur.getKey());
    }

    @Test
    public void testIntegrationGrassField() {
        Vector2d[] startingPositions = {new Vector2d(2,2), new Vector2d(3,4)};
        String[] directions = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        SimulationEngine engine = new SimulationEngine(parser.parse(directions), grassMap, startingPositions);
        engine.run();
        Map<Vector2d, Animal> animalsHM = grassMap.getAnimalsHM();
        Iterator<Map.Entry<Vector2d, Animal>> animals = animalsHM.entrySet().iterator();
        Map.Entry<Vector2d, Animal> wombat = animals.next();
        Map.Entry<Vector2d, Animal> lemur = animals.next();
        assertEquals(new Vector2d(3,7), wombat.getKey());
        assertEquals(new Vector2d(2,-1), lemur.getKey());
    }

}
