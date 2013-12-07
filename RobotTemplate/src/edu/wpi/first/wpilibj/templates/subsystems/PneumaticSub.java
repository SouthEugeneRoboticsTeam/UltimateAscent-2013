
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 */
public class PneumaticSub extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    Compressor compressor;
    Solenoid lifter;
    
    public PneumaticSub() {
        compressor = new Compressor(RobotMap.pressureSwitchPort, RobotMap.compressorChannel);
        lifter = new Solenoid(RobotMap.lifterChannel);
    }
    
    public void pressurize() {
        compressor.start();
    }
    
    public void stopCompressor() {
        compressor.stop();
    }
    
    public boolean getPressureSwitch() {
        return compressor.getPressureSwitchValue();
    }
    
    public void lift() {
        lifter.set(true);
    }
    
    public void raise() {
        lifter.set(false);
    }
    
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }


}

