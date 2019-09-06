package robot.subsystems;

public class Constants {

    public static final boolean LEFT_ENCODER_REVERSED = false;
    public static final boolean RIGHT_ENCODER_REVERSED = false;

    public static final double LEFT_TICKS_PER_METER =  2138.7750882690398; // measured average distance (robot a), [1m / (diameter=0.1524 * pi)] * (ticks_per_meter=1024s) (robot b)
    public static final double RIGHT_TICKS_PER_METER = 2138.7750882690398 ;
}
