package robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Examplesubsystem extends Subsystem {
    private TalonSRX rightMaster = new TalonSRX(1);
    private VictorSPX Rslave1 = new VictorSPX(3);
    private VictorSPX Rslave2 = new VictorSPX(4);

    private TalonSRX leftMaster = new TalonSRX(2);
    private VictorSPX Lslave1 = new VictorSPX(5);
    private VictorSPX Lslave2 = new VictorSPX(6);
    public Examplesubsystem(){
        Rslave1.follow(rightMaster);
        Rslave2.follow(rightMaster);
        Lslave1.follow(leftMaster);
        Lslave2.follow(leftMaster);

        leftMaster.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
        rightMaster.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);

        leftMaster.setSensorPhase(Constants.LEFT_ENCODER_REVERSED);
        rightMaster.setSensorPhase(Constants.RIGHT_ENCODER_REVERSED);
    }
    public void setspeed(double SpeedR, double SpeedL){
        if ((SpeedR > -1 && SpeedR < 1 )&&(SpeedL > -1 && SpeedL < 1 )){
            rightMaster.set(ControlMode.PercentOutput,SpeedR);
            leftMaster.set(ControlMode.PercentOutput,SpeedL);
        }


    }

    private double convertLeftTicksToDistance(int ticks) {
        return ticks / Constants.LEFT_TICKS_PER_METER;
    }

    private double convertRightTicksToDistance(int ticks) {
        return ticks / Constants.RIGHT_TICKS_PER_METER;
    }



    public double getLeftDistance() {
        return convertLeftTicksToDistance(leftMaster.getSelectedSensorPosition(0));
    }

    /**
     * @return The distance driven on the right side of the robot since the last
     * reset
     */
    public double getRightDistance() {
        return convertRightTicksToDistance(rightMaster.getSelectedSensorPosition(0));
    }
    @Override
    protected void initDefaultCommand() {

    }
}
