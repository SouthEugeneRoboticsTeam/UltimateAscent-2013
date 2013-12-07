package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.camera.AxisCamera;
import edu.wpi.first.wpilibj.command.Subsystem;

public class CameraSub extends Subsystem {
    
    AxisCamera camera;
    
    public CameraSub() {
        camera = AxisCamera.getInstance();
        
    }
    
    

    public void initDefaultCommand() {
    }
    
}

