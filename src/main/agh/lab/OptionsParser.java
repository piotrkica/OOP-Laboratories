package agh.lab;

public class OptionsParser {
    private final String[] legalMoves = {"f", "forward", "b", "backward", "r", "right", "l", "left"};

    private boolean verifyMove(String move) {
        for (String legalMove : legalMoves) {
            if (move.equals(legalMove)) {
                return true;
            }
        }
        return false;
    }

    public MoveDirection[] parse(String[] args) {
        MoveDirection[] directions = new MoveDirection[args.length];
        for (int i = 0; i < directions.length; i++) {
            if (!verifyMove(args[i])) {
                throw new IllegalArgumentException(args[i] + " is not legal move specification");
            }

            switch (args[i]) {
                case "f":
                case "forward":
                    directions[i] = MoveDirection.FORWARD;
                    break;
                case "b":
                case "backward":
                    directions[i] = MoveDirection.BACKWARD;
                    break;
                case "r":
                case "right":
                    directions[i] = MoveDirection.RIGHT;
                    break;
                case "l":
                case "left":
                    directions[i] = MoveDirection.LEFT;
                    break;
                default:
                    return null; // nie zdarzy się
            }
        }
        return directions;
    }
}
