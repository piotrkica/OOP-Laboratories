package agh.lab;

public class Animal implements IMapElement{
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position;
    private final IWorldMap map;

    public Animal(IWorldMap map){
        this.map = map;
        this.position = new Vector2d(2, 2);
    }

    public Animal(IWorldMap map, Vector2d initialPosition){
        this.map = map;
        this.position = initialPosition;
    }


    public String toString() {
        switch(this.orientation){
            case NORTH:
                return "N";
            case EAST:
                return "E";
            case SOUTH:
                return "S";
            case WEST:
                return "W";
            default:
                return null;
        }
    }

    public Vector2d getPosition() {
        return this.position;
    }

    public MapDirection getOrientation() {
        return this.orientation;
    }

    public void move(MoveDirection direction) {
        switch (direction) {
            case RIGHT:
                this.orientation = this.orientation.next();
                break;
            case LEFT:
                this.orientation = this.orientation.previous();
                break;
            case BACKWARD:
            case FORWARD:
                Vector2d movement = this.orientation.toUnitVector();
                if (direction == MoveDirection.BACKWARD) {
                    movement = movement.opposite();
                }
                Vector2d newPosition = this.position.add(movement);

                if (this.map.canMoveTo(newPosition)) {
                    this.position = newPosition;
                }
                break;
        }
    }


}
