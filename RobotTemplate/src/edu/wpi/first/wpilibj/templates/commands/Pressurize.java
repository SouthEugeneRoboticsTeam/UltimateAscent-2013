
package edu.wpi.first.wpilibj.templates.commands;



/**
 *
 * @author bradmiller
 */
public class Pressurize extends CommandBase {

    public Pressurize() {
        requires(pneumaticsub);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
       pneumaticsub.pressurize();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (pneumaticsub.getPressureSwitch()) {
            return true;
        } else {
            return false;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
        pneumaticsub.stopCompressor();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
