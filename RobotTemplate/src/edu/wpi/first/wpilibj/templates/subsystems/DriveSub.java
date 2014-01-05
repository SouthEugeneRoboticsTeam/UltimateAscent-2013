
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.Drive;

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
            arcadedrive = false;
            System.out.println("Tank Drive");
        } else {
            arcadedrive = true;
            System.out.println("Arcade Drive");
        }
    }
    
    public void drive() {
        if (arcadedrive) {
            drive.tankDrive(OI.getInstance().getLeftStick(), OI.getInstance().getRightStick());
        } else {
            drive.arcadeDrive(OI.getInstance().getLeftStick());
        }
    }
    
    public void initDefaultCommand() {
        setDefaultCommand(new Drive());
    }
}


