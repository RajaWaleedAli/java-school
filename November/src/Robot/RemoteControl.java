package Robot;

import java.util.Arrays;

public class RemoteControl implements Roboter{
    Roboter90 robot90;
    Roboter45 robot45;
    private boolean chooseBot;
    public RemoteControl(Roboter90 robot90, Roboter45 robot45) {
        this.robot90 = robot90;
        this.robot45 = robot45;
        this.chooseBot = false;
    }
    private Roboter getBot(){
        if(chooseBot){
            return robot45;
        }else
            return robot90;
    }

    @Override
    public double[] getPos() {
        return getBot().getPos();
    }

    @Override
    public void advance() {
        getBot().advance();
    }

    @Override
    public void turnLeft() {
        getBot().turnLeft();
    }

    @Override
    public void turnRight() {
        getBot().turnRight();
    }

    public void controls(String command) {
        for (char c : command.toCharArray()) {
            switch (c) {
                case 'r':
                    turnRight();
                    break;
                case 'l':
                    turnLeft();
                    break;
                case 'a':
                    advance();
                    break;
                case 'p':
                    System.out.println("Current Bot: "+chooseBot+"\n"+Arrays.toString(getBot().getPos()));
                    break;
                default:
                    chooseBot=!chooseBot;
                    break;
            }
        }
    }
}
