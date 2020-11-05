package agh.lab;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap extends AbstractWorldMap {
    private final Vector2d bottomLeft;
    private final Vector2d topRight;
    private List<Animal> animals = super.animals;

    public RectangularMap(int topRightX, int topRightY) {
        this.bottomLeft = new Vector2d(0, 0);
        this.topRight = new Vector2d(topRightX, topRightY);
    }

    public Vector2d[] getMapBoundaries() {
        return new Vector2d[]{bottomLeft, topRight};
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !isOccupied(position) && position.follows(bottomLeft) && position.precedes(topRight);
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (Animal animal : animals) {
            if (animal.getPosition().equals(position)) {
                return animal;
            }
        }
        return null;
    }
}
