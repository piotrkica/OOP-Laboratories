package agh.lab;

import java.util.HashMap;
import java.util.Map;

abstract public class AbstractWorldMap implements IWorldMap {
    private final MapVisualizer mapVis = new MapVisualizer(this);
    protected final Map<Vector2d, Animal> animalsHM = new HashMap<>();

    abstract protected Vector2d[] getMapBoundaries();

    public String toString() {
        Vector2d[] boundaries = getMapBoundaries();
        return mapVis.draw(boundaries[0], boundaries[1]);
    }

    @Override
    public boolean place(Animal animal) {
        if (!canMoveTo(animal.getPosition())) {
            throw new IllegalArgumentException(animal.getPosition() + " field is invalid"); // or occupied
        }
        animalsHM.put(animal.getPosition(), animal);
        return true;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return this.objectAt(position) != null;
    }
}