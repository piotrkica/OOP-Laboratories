package lab1;

import java.util.Arrays;

public class World {
    public static void main(String[] args) {
        System.out.println("Start");
        String[] x = {"test","f", "b", "r","test"};
        run(strToDir(x));
        System.out.println("Koniec");
    }

    public static Direction[] strToDir(String[] args) {
        Direction[] directions = new Direction[args.length];
        int skipped = 0;
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "f":
                    directions[i-skipped] = Direction.FORWARD;
                    break;
                case "b":
                    directions[i-skipped] = Direction.BACKWARD;
                    break;
                case "r":
                    directions[i-skipped] = Direction.RIGHT;
                    break;
                case "l":
                    directions[i-skipped] = Direction.LEFT;
                    break;
                default:
                    skipped++;
                    break;

            }
        }
        return Arrays.copyOfRange(directions, 0,args.length-skipped);
    }

    public static void run(Direction[] args) {
        //for (int i = 0; i < args.length - 1; i++) {
        //    System.out.print(args[i] + ", ");
        //}
        //System.out.println(args[args.length - 1]);

        for (Direction arg : args) {
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
