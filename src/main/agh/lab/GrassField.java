package agh.lab;

import java.util.*;

import static java.lang.Math.*;

public class GrassField extends AbstractWorldMap {
    private Map<Vector2d,Grass> grassTiles = new HashMap<>();
    protected Map<Vector2d,Animal> animals = super.animalsHM;

    public GrassField(int grassCount) {
        Random r = new Random();
        int bound = (int) sqrt(grassCount * 10);

        for (int i = 0; i < grassCount; i++) {
            Vector2d position = new Vector2d(r.nextInt() % bound, r.nextInt() % bound);
            while (this.isOccupied(position)) {
                position = new Vector2d(r.nextInt(bound), r.nextInt(bound));
            }

            grassTiles.put(position, new Grass(position));

        }
    }

    public Map<Vector2d,Animal> getAnimalsHM(){
        return animalsHM;
    }

    public Vector2d[] getMapBoundaries() {
        int minX, minY, maxX, maxY;
        minX = minY = maxX = maxY = 0;


        for (Map.Entry<Vector2d,Grass> grass : grassTiles.entrySet()) {
            Vector2d tile = grass.getKey();
            minX = min(minX, tile.x);
            minY = min(minY, tile.y);
            maxX = max(maxX, tile.x);
            maxY = max(maxY, tile.y);
        }
        for (Map.Entry<Vector2d,Animal> animal : animals.entrySet()) {
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
        grassTiles.put(position, new Grass(position));
        return true;
    }

    @Override
    public Object objectAt(Vector2d position) {
        Object animalOrGrass = animals.get(position);
        if (animalOrGrass != null){
            return animalOrGrass;
        }
        animalOrGrass = grassTiles.get(position);
        return animalOrGrass;
    }
}
