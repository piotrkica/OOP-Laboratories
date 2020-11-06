package agh.lab;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;

import static java.lang.Math.*;

public class GrassField extends AbstractWorldMap {
    private List<Grass> grassTiles = new ArrayList<>();
    private List<Animal> animals = super.animals;   // ta linijka jest niepotrzebna

    public GrassField(int grassCount) {
        Random r = new Random();    // proszę unikać jednoliterowych nazw
        int bound = (int) sqrt(grassCount * 10);

        for (int i = 0; i < grassCount; i++) {
            Vector2d position = new Vector2d(r.nextInt() % bound, r.nextInt() % bound);
            while (this.isOccupied(position)) {
                position = new Vector2d(r.nextInt(bound), r.nextInt(bound));
            }   // do {} while

            grassTiles.add(new Grass(position));

        }
    }

    public Vector2d[] getMapBoundaries() {
        int minX, minY, maxX, maxY;
        minX = minY = maxX = maxY = 0;  // lepiej operować na poziomie wektorów niż współrzędnych

        for (Grass grass : grassTiles) {
            Vector2d tile = grass.getPosition();
            minX = min(minX, tile.x);
            minY = min(minY, tile.y);
            maxX = max(maxX, tile.x);
            maxY = max(maxY, tile.y);
        }
        for (Animal animal : animals) {
            Vector2d tile = animal.getPosition();
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
        if ((this.objectAt(grass.getPosition()) instanceof Grass)) {
            return false;
        }
        grassTiles.add(grass);
        return true;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (Animal animal : animals) {
            if (animal.getPosition().equals(position)) {
                return animal;
            }
        }
        for (Grass grass : grassTiles) {
            if (grass.getPosition().equals(position)) {
                return grass;
            }
        }

        return null;
    }
}
