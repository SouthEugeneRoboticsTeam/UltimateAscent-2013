
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.SpinUpShooter;

/**
 *
 * @author Aubrey
 */
public class FiringSub extends Subsystem {
    CANJaguar shooter;
    CANJaguar altitude;
    Victor loader;
    AnalogChannel altitudePot;
    DigitalInput loadLimit; 
    PIDController altitudePID;
    
    public FiringSub() throws CANTimeoutException {
        shooter = new CANJaguar(RobotMap.shooterID);
        altitude = new CANJaguar(RobotMap.altitudeID);
        loader = new Victor(RobotMap.loaderID);
        altitudePot = new AnalogChannel(RobotMap.altitudePotPort);
        loadLimit = new DigitalInput(RobotMap.loadLimitID);
        altitudePID = new PIDController(1, 0, 0, altitudePot, altitude);
        altitudePID.setInputRange(311, 639);
        altitudePID.setOutputRange(-1, 1);
        altitudePID.setPercentTolerance(1);
    }
    
    public void raiseMax() throws CANTimeoutException {
            raise();
    }
    
    public void lowerMin() throws CANTimeoutException {
            lower();
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
    
    public void enableAltitudePID(boolean enable) {
        if (enable) {
            altitudePID.enable();
        } else {
            altitudePID.disable();
        }
    }
    
    public void altitudeSetpoint(double setpoint) throws CANTimeoutException {
        //altitude.changeControlMode(CANJaguar.ControlMode.kPosition);
        //altitude.setPositionReference(CANJaguar.PositionReference.kPotentiometer);
        //altitude.setPID(0, 0, 0);
        //double setpoint = SmartDashboard.getNumber("setpoint", RobotMap.midAltitude);
        //altitude.setX(setpoint);
        //altitudePID.enable();
        //altitude.setX(.5);
        //while (altitude.getOutputVoltage() > .1);
        //altitude.changeControlMode(CANJaguar.ControlMode.kVoltage);
        //stopAltitude();
        
        altitudePID.setSetpoint(setpoint);
        altitude.setX(altitudePID.get());
    }
    
    public boolean targetAquired() {
        if (altitudePID.onTarget()) {
            return true;
        } else {
            return false;
        }
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
    
    
    public void load() {
        loader.set(1);
    }
    
    public void spinUp(double x) throws CANTimeoutException {
        shooter.setX(x);
    }
    
    public double getAltitudePot() {
        return altitudePot.getVoltage();
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new SpinUpShooter());
    }
    
    public boolean getLoadLimit() {
        return loadLimit.get();
    }
}

