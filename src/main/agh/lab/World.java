package agh.lab;

public class World {

    public static void main(String[] args) {
        String[] dirs = {"f", "b", "r", "l", "f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(dirs);
        IWorldMap map = new GrassField(10);
        //map.place(new Animal(map));
        map.place(new Animal(map,new Vector2d(0,0)));
        //map.run(directions);
        System.out.print(map);
    }
}
