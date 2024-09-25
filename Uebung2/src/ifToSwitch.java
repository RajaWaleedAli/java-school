public class ifToSwitch {
    public static void main(String[] args) {
        int x=2, y;
        /*
        if ( x == 2)
            y=x;
        else if( x == 4)
            y=2*x;
        else if( x== 6)
            y=4*x;
        */
        switch(x){
            case 2:
                y=x;
                break;
            case 4:
                y=2*x;
                break;
            case 6:
                y=4*x;
                break;
        }
    }
}
