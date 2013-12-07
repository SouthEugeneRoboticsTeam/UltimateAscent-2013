
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author Aubrey
 */
public class FiringSub extends Subsystem {
    CANJaguar shooter;
    CANJaguar altitude;
    Victor loader;
    AnalogChannel altitudePot;
    DigitalInput LoadLimit; 
    
    public FiringSub() throws CANTimeoutException {
        shooter = new CANJaguar(RobotMap.shooterID);
        altitude = new CANJaguar(RobotMap.altitudeID);
        //loader = new Victor(RobotMap.loaderID);
        altitudePot = new AnalogChannel(RobotMap.altitudePotPort);
    }
    
    public void raiseMax() throws CANTimeoutException {
        while(altitudePot.getVoltage() < RobotMap.maxAltitude) {
            raise();
        }
    }
    
    public void lowerMin() throws CANTimeoutException {
        while(altitudePot.getVoltage() > RobotMap.minAltitude) {
            lower();
        }
    }

    public void raise() throws CANTimeoutException {
        if (altitudePot.getVoltage() < RobotMap.maxAltitude) {
            altitude.setX(1);
        } else {
            altitude.setX(0);
        }
            
    }
    
    public void lower() throws CANTimeoutException {
       if (altitudePot.getVoltage() > RobotMap.minAltitude) {
            altitude.setX(-1);
        } else {
            altitude.setX(0);
        }
    }
    
    public void altitudeSetpoint() throws CANTimeoutException {
        altitude.changeControlMode(CANJaguar.ControlMode.kPosition);
        altitude.setPositionReference(CANJaguar.PositionReference.kPotentiometer);
        altitude.setPID(0, 0, 0);
        double setpoint = SmartDashboard.getNumber("setpoint", RobotMap.midAltitude);
        altitude.setX(setpoint);
        while (altitude.getOutputVoltage() > .1);
        altitude.changeControlMode(CANJaguar.ControlMode.kVoltage);
        stopAltitude();
        
    }
    
    public void stopAltitude() throws CANTimeoutException {
        altitude.setX(0);
    }
    
    public void stopShooter() throws CANTimeoutException {
        shooter.setX(0);
    }
    
    public void stopLoader() {
        loader.set(0);
    }
    
    
//    public void load() {
//        loader.set(1);
//    }
    
    public void spinUp(double x) throws CANTimeoutException {
        shooter.setX(x);
    }
    
    public double getAltitudePot() {
        return altitudePot.getVoltage();
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

