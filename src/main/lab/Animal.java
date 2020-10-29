package lab;    // proszę zmienić nazwę pakietu, żeby chociaż 1 kropka w niej była

public class Animal {
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2, 2);
    private IWorldMap map;

    public Animal(IWorldMap map){
        this.map = map;
    }

    public Animal(IWorldMap map, Vector2d initialPosition){
        this.map = map;
        this.position = initialPosition;
    }   // zwierzę wisi w próżni - nie dodane do mapy


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
                return "x"; // do tej sytuacji nigdy nie powinno dojść; jeśli dojdzie, to Pan nie zauważy, bo metoda zwraca prawidłowy napis
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
