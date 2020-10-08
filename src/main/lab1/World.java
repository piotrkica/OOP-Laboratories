package lab1;

import java.util.Arrays;

public class World {
    public static void main(String[] args) {
        //System.out.println("Start");
        //String[] x = {"test","f", "b", "r","test"};
        //run(strToDir(x));
        //System.out.println("Koniec");
        Vector2d tmp = new Vector2d(2,6);
        Vector2d tmp2 = new Vector2d(3,5);
        MapDirection x = MapDirection.EAST;
        System.out.println(x);


    }

    public static MoveDirection[] strToDir(String[] args) {
        MoveDirection[] directions = new MoveDirection[args.length];
        int skipped = 0;
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "f":
                    directions[i-skipped] = MoveDirection.FORWARD;
                    break;
                case "b":
                    directions[i-skipped] = MoveDirection.BACKWARD;
                    break;
                case "r":
                    directions[i-skipped] = MoveDirection.RIGHT;
                    break;
                case "l":
                    directions[i-skipped] = MoveDirection.LEFT;
                    break;
                default:
                    skipped++;
                    break;

            }
        }
        return Arrays.copyOfRange(directions, 0,args.length-skipped);
    }

    public static void run(MoveDirection[] args) {
        //for (int i = 0; i < args.length - 1; i++) {
        //    System.out.print(args[i] + ", ");
        //}
        //System.out.println(args[args.length - 1]);

        for (MoveDirection arg : args) {
            switch (arg) {
                case FORWARD:
                    System.out.println("Zwierzak idzie do przodu");
                    break;
                case BACKWARD:
                    System.out.println("Zwierzak idzie do tyłu");
                    break;
                case RIGHT:
                    System.out.println("Zwierzak skręca w prawo");
                    break;
                case LEFT:
                    System.out.println("Zwierzak skręca w lewo");
                    break;
                default:
                    break;
            }
        }
    }
}
