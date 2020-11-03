package agh.lab;

public class SimulationEngine implements IEngine {
    MoveDirection[] directions;
    IWorldMap map;
    Vector2d[] startingPosition;

    public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] startingPosition){
        this.directions = directions;
        this.map = map;
        this.startingPosition = startingPosition;
        for (Vector2d position : startingPosition) {
            map.place(new Animal(map, position));
        }
    }

    public void run(){
        for(int i = 0; i < directions.length;i++){
            Animal movedAnimal = (Animal) this.map.objectAt(startingPosition[i%startingPosition.length]);
            movedAnimal.move(directions[i]);
            this.startingPosition[i%startingPosition.length] = movedAnimal.getPosition();
            //Vector2d position = this.startingPosition[i % startingPosition.length];
            //if (this.map.objectAt(position) instanceof Animal){
            //    Animal movedAnimal = (Animal) this.map.objectAt(position);
            //    movedAnimal.move(directions[i]);
            //    this.startingPosition[i%this.startingPosition.length] = movedAnimal.getPosition();
            //}

        }

    }


}
