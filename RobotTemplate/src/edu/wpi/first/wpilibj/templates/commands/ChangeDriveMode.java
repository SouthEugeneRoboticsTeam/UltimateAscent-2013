
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author bradmiller
 */
public class ChangeDriveMode extends CommandBase {
    boolean finish = false;
    
    public ChangeDriveMode() {
        requires(drivesub);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
            drivesub.changeDriveMode();
            finish = true;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return finish;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
