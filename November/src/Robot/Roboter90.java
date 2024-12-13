package Robot;

public class Roboter90 implements Roboter{
    private double posX, posY, direction;
    private int index;

    Roboter90(int index){
        posX = 0;
        posY = 0;
        direction = 0;
        this.index = index;
    }
    @Override
    public double[] getPos(){
        return new double[]{posX, posY};
    }
    @Override
    public void advance(){
        if(direction == 0){
            posY += index;
        } else if (direction == 90) {
            posX += index;
        }else if (direction == 180) {
            posY -= index;
        }else if (direction == 270) {
            posX -= index;
        }
    }
    @Override
    public void turnLeft(){
        direction -= 90;
        direction = direction % 360;
    }
    @Override
    public void turnRight(){
        direction += 90;
        direction = direction % 360;
    }
}
