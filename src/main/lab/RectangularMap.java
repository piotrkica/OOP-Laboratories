package lab;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap {
    private Vector2d botLeft;
    private Vector2d topRight;
    private List<Animal> animals = new ArrayList<>();
    private MapVisualizer mapVis = new MapVisualizer(this);

    public RectangularMap(int width, int height){
        this.botLeft = new Vector2d(0,0);
        this.topRight = new Vector2d(width, height);    // width - 1
    }

    public String toString(){
        return mapVis.draw(botLeft, topRight);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if (isOccupied(position)){
            return false;
        }
        return position.follows(botLeft) && position.precedes(topRight);
    }

    @Override
    public boolean place(Animal animal) {
        if (this.isOccupied(animal.getPosition())){ // czy isOccupied jest dobrym wyborem?
            return false;
        }
        animals.add(animal);
        return true;
    }

    @Override
    public void run(MoveDirection[] directions) {
        for(int i = 0; i < directions.length;i++){
            Animal movedAnimal = animals.get(i % animals.size());
            movedAnimal.move(directions[i]);
            animals.set(i % animals.size(), movedAnimal);
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (Animal animal: animals){
            if (animal.getPosition().equals(position)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) { // uderzająco podobna do isOccupied
        for (Animal animal: animals){
            if (animal.getPosition().equals(position)){
                return animal;
            }
        }
        return null;
    }
}
