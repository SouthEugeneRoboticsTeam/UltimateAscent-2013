
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.can.CANTimeoutException;

/**
 *
 * @author bradmiller
 */
public class Load extends CommandBase {
    protected long timer;
    
    public Load() {
        requires(firingsub);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        firingsub.load();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        firingsub.load();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        Timer.delay(.25);
        if (firingsub.getLoadLimit()) {
            return true;
        } else {
            return false;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
        firingsub.stopLoader();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
