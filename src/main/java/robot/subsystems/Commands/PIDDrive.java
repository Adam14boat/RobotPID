package robot.subsystems.Commands;

import edu.wpi.first.wpilibj.command.Command;
import robot.Robot;

import static robot.Robot.drivetrain;

public class PIDDrive extends Command {
    AdamPID drivePID = new AdamPID(0.4,0,0,0.02);

    public PIDDrive(){
        requires(drivetrain);
    }
    @Override
    protected void initialize() {
        drivePID.setSetpoint(drivetrain.getLeftDistance() + 1);

    }

    @Override
    protected void execute() {
        drivePID.update(drivetrain.getLeftDistance());
        System.out.println("distance " + drivetrain.getLeftDistance());
        System.out.println("output" + drivePID.getOutput());
        drivetrain.setLeftSpeed(drivePID.getOutput());
        drivetrain.setRightSpeed(drivePID.getOutput());
        System.out.println("running");

    }

    @Override
    protected boolean isFinished() {
        return drivetrain.getLeftDistance() > 1;
    }

    @Override
    protected void interrupted() {
        end();
    }

    @Override
    protected void end() {
        drivetrain.setLeftSpeed(0);
        drivetrain.setRightSpeed(0);

    }

}
