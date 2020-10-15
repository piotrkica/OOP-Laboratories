package lab;

import java.util.Arrays;

public class OptionsParser {

    public MoveDirection[] parse(String[] args){
        MoveDirection[] directions = new MoveDirection[args.length];
        int skipped = 0;
        for (int i = 0; i < directions.length; i++) {
            switch (args[i]) {
                case "f":
                case "forward":
                    directions[i-skipped] = MoveDirection.FORWARD;
                    break;
                case "b":
                case "backward":
                    directions[i-skipped] = MoveDirection.BACKWARD;
                    break;
                case "r":
                case "right":
                    directions[i-skipped] = MoveDirection.RIGHT;
                    break;
                case "l":
                case "left":
                    directions[i-skipped] = MoveDirection.LEFT;
                    break;
                default:
                    skipped++;
                    break;

            }
        }
        return Arrays.copyOfRange(directions, 0,args.length-skipped);

    }
}
