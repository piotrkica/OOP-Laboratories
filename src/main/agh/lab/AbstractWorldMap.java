package agh.lab;

import java.util.ArrayList;
import java.util.List;

abstract public class AbstractWorldMap implements IWorldMap {
    private final MapVisualizer mapVis = new MapVisualizer(this);
    protected List<Animal> animals = new ArrayList<>(); // może być finalne

    abstract protected Vector2d[] getMapBoundaries();   // można użyć Pair<>, bo "gwarantuje", że obiekty będą dwa

    public String toString() {
        Vector2d[] boundaries = getMapBoundaries();
        return mapVis.draw(boundaries[0], boundaries[1]);
    }

    @Override
    public boolean place(Animal animal) {
        if (!canMoveTo(animal.getPosition())) {
            return false;
        }
        animals.add(animal);
        return true;
    }

    @Override
    public void run(MoveDirection[] directions) {
        for (int i = 0; i < directions.length; i++) {
            Animal movedAnimal = animals.get(i % animals.size());
            movedAnimal.move(directions[i]);
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return this.objectAt(position) != null;
    }

    // a objectAt się nie dało tu zaimplementować?

}
