package Robot;

import static java.lang.Math.sqrt;

public class Roboter45 implements Roboter {
    private double posX, posY;
    private int direction;
    private final int index;
    Roboter45(int index) {
        this.index = index;
        this.posX = 0;
        this.posY = 0;
        this.direction = 0;
    }

    @Override
    public double[] getPos() {
        return new double[]{posX, posY};
    }

    @Override
    public void turnRight() {
        direction += 45;
        direction = direction % 360;
    }
    @Override
    public void turnLeft() {
        direction -= 45;
        direction = direction % 360;
    }

    @Override
    public void advance(){
        double temp=Math.sqrt(2)/2;
        switch (direction){
            case 45:
                posY += temp*index;
                posX += temp*index;
                break;
            case 135:
                posX += temp*index;
                posY -= temp*index;
                break;
            case 225:
                posY -= temp*index;
                posX -= temp*index;
                break;
            case 315:
                posY += temp*index;
                posX -= temp*index;
                break;
            case 0:
                posY += index;
                break;
            case 90:
                posX += index;
                break;
            case 180:
                posY -= index;
                break;
            case 270:
                posX -= index;
                break;

        }

    }
}
