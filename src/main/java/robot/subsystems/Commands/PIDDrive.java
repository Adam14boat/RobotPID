package robot.subsystems.Commands;

import edu.wpi.first.wpilibj.command.Command;
import robot.AdamPID;
import robot.Robot;

public class PIDDrive extends Command {
    AdamPID drivePID = new AdamPID(1,0,0,0.02);

    public PIDDrive(){
        requires(Robot.example);
    }
    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {

    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {

    }

}
