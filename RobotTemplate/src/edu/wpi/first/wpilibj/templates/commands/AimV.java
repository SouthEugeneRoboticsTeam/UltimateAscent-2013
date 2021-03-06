
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.can.CANTimeoutException;

/**
 *
 * @author bradmiller
 */
public class AimV extends CommandBase {

    public AimV() {
        requires(firingsub);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        firingsub.enableAltitudePID(true);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        try {
            firingsub.altitudeSetpoint(450);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return firingsub.targetAquired();
    }

    // Called once after isFinished returns true
    protected void end() {
        try {
            firingsub.enableAltitudePID(false);
            firingsub.stopAltitude();
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
