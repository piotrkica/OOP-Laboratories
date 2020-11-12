package agh.lab;

import java.util.*;

import static java.lang.Math.*;

public class GrassField extends AbstractWorldMap {
    private final Map<Vector2d,Grass> grassTilesHM = new HashMap<>();
    private final Map<Vector2d,Animal> animalsHM = super.animalsHM;

    public GrassField(int grassCount) {
        Random rand = new Random();
        int bound = (int) sqrt(grassCount * 10);
        Vector2d position;
        for (int i = 0; i < grassCount; i++) {
            do {
                position = new Vector2d(rand.nextInt() % bound, rand.nextInt() % bound);
            } while (this.isOccupied(position));

            grassTilesHM.put(position, new Grass(position));

        }
    }

    @Override
    public Map<Vector2d,Animal> getAnimalsHM(){ // tak samo jak w RectangularMap
        return animalsHM;
    }

    public Vector2d[] getMapBoundaries() {
        int minX, minY, maxX, maxY; // lepiej operować na wektorach
        minX = minY = maxX = maxY = 0;

        for (Map.Entry<Vector2d,Grass> grass : grassTilesHM.entrySet()) {
            Vector2d tile = grass.getKey();
            minX = min(minX, tile.x);
            minY = min(minY, tile.y);
            maxX = max(maxX, tile.x);
            maxY = max(maxY, tile.y);
        }
        for (Map.Entry<Vector2d,Animal> animal : animalsHM.entrySet()) {
            Vector2d tile = animal.getKey();
            minX = min(minX, tile.x);
            minY = min(minY, tile.y);
            maxX = max(maxX, tile.x);
            maxY = max(maxY, tile.y);
        }
        return new Vector2d[]{new Vector2d(minX, minY), new Vector2d(maxX, maxY)};
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return (!(this.objectAt(position) instanceof Animal));
    }

    public boolean placeGrass(Grass grass) {
        Vector2d position = grass.getPosition();
        if ((this.objectAt(position) instanceof Grass)) {
            //throw new IllegalArgumentException(position + " already has grass");
            return false;
        }
        grassTilesHM.put(position, new Grass(position));
        return true;
    }

    @Override
    public Object objectAt(Vector2d position) {
        Object animalOrGrass = animalsHM.get(position);
        if (animalOrGrass != null){
            return animalOrGrass;
        }
        animalOrGrass = grassTilesHM.get(position);
        return animalOrGrass;
    }
}
