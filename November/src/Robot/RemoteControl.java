package Robot;

import java.util.Arrays;

public class RemoteControl {
    Roboter robot;
    public RemoteControl(Roboter robot) {
        this.robot = robot;
    }
    public void controls(String command) {
        for (char c : command.toCharArray()) {
            switch (c) {
                case 'r':
                    robot.turnRight();
                    break;
                case 'l':
                    robot.turnLeft();
                    break;
                case 'a':
                    robot.advance();
                    break;
                case 'p':
                    System.out.println(Arrays.toString(robot.getPos()));
                    break;
                default:
                    break;
            }
        }
    }
}
