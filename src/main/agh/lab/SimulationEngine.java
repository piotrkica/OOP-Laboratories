package agh.lab;

import java.util.Map;

public class SimulationEngine implements IEngine {
    private final MoveDirection[] directions;
    private final IWorldMap map;
    private final Vector2d[] startingPosition;
    private final Map<Vector2d, Animal> animalsHM;

    public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] startingPosition) {
        this.directions = directions;
        this.map = map;
        this.startingPosition = startingPosition;
        for (Vector2d position : startingPosition) {
            map.place(new Animal(map, position));
        }
        animalsHM = map.getAnimalsHM();
    }

    public void run() {
        int n = startingPosition.length;
        for (int i = 0; i < directions.length; i++) {
            Animal movedAnimal = (Animal) this.map.objectAt(startingPosition[i % n]);
            Vector2d movedAnimalPosition = movedAnimal.getPosition();
            movedAnimal.move(directions[i]);
            this.startingPosition[i % n] = movedAnimal.getPosition();
            if (!movedAnimalPosition.equals(movedAnimal.getPosition())) {
                animalsHM.remove(movedAnimalPosition);
                animalsHM.put(movedAnimal.getPosition(), movedAnimal);
            }
        }
    }
}