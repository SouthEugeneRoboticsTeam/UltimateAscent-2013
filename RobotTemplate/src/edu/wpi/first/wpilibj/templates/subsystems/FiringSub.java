
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 */
public class FiringSub extends Subsystem {
    CANJaguar shooter;
    CANJaguar altitude;
    Victor loader;
    AnalogChannel altitudePot;
    
    public FiringSub() throws CANTimeoutException {
        shooter = new CANJaguar(RobotMap.shooterID);
        altitude = new CANJaguar(RobotMap.altitudeID);
        loader = new Victor(RobotMap.loaderID);
        altitudePot = new AnalogChannel(RobotMap.altitudePotPort);
    }
    
    public void raiseMax() throws CANTimeoutException {
        while(altitudePot.getVoltage() < RobotMap.maxAltitude) {
            raise();
        }
        stopAltitude();
    }
    
    public void lowerMax() throws CANTimeoutException {
        while(altitudePot.getVoltage() > RobotMap.minAltitude) {
            lower();
        }
        stopAltitude();
    }

    public void raise() throws CANTimeoutException {
        altitude.setX(1);
    }
    
    public void lower() throws CANTimeoutException {
        altitude.setX(-1);
    }
    
    public void altitudeSetpoint() throws CANTimeoutException {
        altitude.changeControlMode(CANJaguar.ControlMode.kPosition);
        altitude.setPositionReference(CANJaguar.PositionReference.kPotentiometer);
        altitude.setPID(0, 0, 0);
        double setpoint = SmartDashboard.getDouble("setpoint", RobotMap.midAltitude);
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
    
    public void stopLoader() throws CANTimeoutException {
        loader.set(0);
    }
    
    
    public void load() throws CANTimeoutException {
        loader.set(1);
        Timer.delay(.5);
        stopLoader();
    }
    
    public void spinUp() throws CANTimeoutException {
        shooter.setX(SmartDashboard.getDouble("shooterspeed", 0));
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

