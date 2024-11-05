package Robot;

public class Roboter {
    private double posX, posY, direction;
    private int index;

    Roboter(int index){
        posX = 0;
        posY = 0;
        direction = 0;
        this.index = index;
    }
    public double[] getPos(){
        return new double[]{posX, posY};
    }
    public void advance(){
        if(direction == 0){
            posY += index;
        } else if (direction == 0.5) {
            posX += index;
        }else if (direction == 1) {
            posY -= index;
        }else if (direction == 1.5) {
            posX -= index;
        }
    }
    public void turnLeft(){
        if(direction == 0){
            direction = 1.5;
        }else {
            direction -= 0.5;
        }
    }
    public void turnRight(){
        if(direction == 1.5){
            direction = 0;
        }else {
            direction += 0.5;
        }
    }
}
