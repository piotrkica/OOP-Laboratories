package lab;

public class Animal {

    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d location = new Vector2d(2, 2);

    public String toString() {
        return (location + " " + orientation);
    }

    public Vector2d getLocation() {
        return this.location;
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
            case BACKWARD: // abu uniknąć duplikacji kodu, if-em zmieniam wartości na przeciwne
            case FORWARD:
                Vector2d movement = this.orientation.toUnitVector();
                if (direction == MoveDirection.BACKWARD) {
                    movement = movement.opposite();
                }
                Vector2d newLocation = this.location.add(movement);

                if (newLocation.precedes(new Vector2d(0, 0)) // dziala ale nielogiczny zapis z follows i precedes
                        && newLocation.follows(new Vector2d(4, 4))) {
                    this.location = newLocation;
                }
        }
    }


}
