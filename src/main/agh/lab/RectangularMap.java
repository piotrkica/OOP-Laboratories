package agh.lab;

import java.util.Map;

public class RectangularMap extends AbstractWorldMap {
    private final Vector2d bottomLeft;
    private final Vector2d topRight;
    private Map<Vector2d,Animal> animalsHM = super.animalsHM;   // niepotrzebne


    public RectangularMap(int topRightX, int topRightY) {   // miało być width i height, a to trochę co innego
        this.bottomLeft = new Vector2d(0, 0);
        this.topRight = new Vector2d(topRightX, topRightY);
    }

    public Vector2d[] getMapBoundaries() {
        return new Vector2d[]{bottomLeft, topRight};
    }

    public Map<Vector2d,Animal> getAnimalsHM(){
        return animalsHM;   // tego nie może być, bo niszczy hermetyzację
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
