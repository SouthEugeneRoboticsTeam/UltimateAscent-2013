
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.camera.AxisCamera;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.ArcadeDrive;
import edu.wpi.first.wpilibj.templates.commands.TankDrive;

/**
 *
 */
public class CameraSub extends Subsystem {
    
    AxisCamera camera;
    
    public CameraSub() throws CANTimeoutException {
        camera = AxisCamera.getInstance();
    }
    
    

    public void initDefaultCommand() {
    }
}

