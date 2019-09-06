package robot.subsystems.Commands;

import edu.wpi.first.wpilibj.command.Command;
import robot.AdamPID;
import robot.Robot;

public class PIDDrive extends Command {
    AdamPID drivePID = new AdamPID(1,0,0,0.02);

    public PIDDrive(){
        requires(Robot.drivetrain);
    }
    @Override
    protected void initialize() {
        drivePID.setSetpoint(Robot.drivetrain.getLeftDistance() + 2);
    }

    @Override
    protected void execute() {
        drivePID.update(Robot.drivetrain.getLeftDistance());
        Robot.drivetrain.setLeftSpeed(drivePID.getOutput());

    }

    @Override
    protected boolean isFinished() {
        return drivePID.isFinished();
    }

    @Override
    protected void end() {
        drivePID.reset();
    }

}
