package lab;

public class World {

    public static void main(String[] args) {
        String[] directions = {"test", "f", "f", "r", "f", "f", "b", "b", "r", "test"};
        OptionsParser parser = new OptionsParser();
        MoveDirection[] parsedDirs = parser.parse(directions);
        Animal axolotl = new Animal();

        System.out.println(axolotl);
        for (MoveDirection direction : parsedDirs) {
            axolotl.move(direction);
        }
        System.out.println(axolotl.toString());

    }

    public static void run(MoveDirection[] args) {
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
