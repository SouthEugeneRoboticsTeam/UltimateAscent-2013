
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.OI;



/**
 *
 * @author bradmiller
 */
public class Lift extends CommandBase {

    public Lift() {
        requires(pneumaticsub);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
       while (!OI.getInstance().getLeftStick().getRawButton(5) || !OI.getInstance().getRightStick().getRawButton(4)) { 
            pneumaticsub.raise();
       }
       
       pneumaticsub.lift();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
