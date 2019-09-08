package robot.subsystems.Commands;

import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj.command.Command;
import robot.Robot;

public class distanceDrive extends Command {
private Robot robot = new Robot();
private int distance;

    protected distanceDrive(int distance){
        this.distance = distance;
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
//        robot.drivetrain.setspeed(0.2,0.2);
    }

    @Override
    protected boolean isFinished() {
        return true;
//        return robot.example.getLeftDistance() > distance && robot.example.getRightDistance() > distance;
    }

    @Override
    protected void interrupted() {

    }

    @Override
    protected void end() {
//        robot.example.setspeed(0,0);
    }

}

