
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
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (!finish) {
            drivesub.changeDriveMode();
            finish = true;
        }
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
