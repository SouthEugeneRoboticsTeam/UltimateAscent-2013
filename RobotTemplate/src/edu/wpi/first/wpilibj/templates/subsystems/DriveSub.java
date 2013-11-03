
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.ArcadeDrive;
import edu.wpi.first.wpilibj.templates.commands.TankDrive;

/**
 *
 */
public class DriveSub extends Subsystem {
    RobotDrive drive;
    private boolean arcadedrive = true;
    
    public DriveSub() throws CANTimeoutException {
        drive = new RobotDrive(new CANJaguar(RobotMap.leftMotor1ID), new CANJaguar(RobotMap.leftMotor2ID), new CANJaguar(RobotMap.rightMotor1ID), new CANJaguar(RobotMap.rightMotor2ID));
    }
    
    public void changeDriveMode() {
        if (arcadedrive) {
            setDefaultCommand(new TankDrive());
        } else {
            setDefaultCommand(new ArcadeDrive());
        }
    }
    
    public void tank() {
        drive.tankDrive(OI.getInstance().getLeftStick().getY(), OI.getInstance().getRightStick().getY());
    }
    
    public void arcade() {
        drive.arcadeDrive(OI.getInstance().getLeftStick().getY(), OI.getInstance().getRightStick().getY());
    }
    
    public void initDefaultCommand() {
        setDefaultCommand(new ArcadeDrive());
    }
}

