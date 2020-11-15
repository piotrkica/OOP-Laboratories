package agh.lab;

public class RectangularMap extends AbstractWorldMap {
    private final Vector2d bottomLeft;
    private final Vector2d topRight;

    public RectangularMap(int topRightX, int topRightY) { // miało być width i height ale jak zapytałem czy nie można tym zastąpić
        this.bottomLeft = new Vector2d(0, 0);       // to uzyskałem zgodę
        this.topRight = new Vector2d(topRightX, topRightY);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !isOccupied(position) && position.follows(bottomLeft) && position.precedes(topRight);
    }

    @Override
    public Object objectAt(Vector2d position) {
        return animalsHM.get(position);
    }
}
