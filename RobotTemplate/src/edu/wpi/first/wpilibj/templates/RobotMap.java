package edu.wpi.first.wpilibj.templates;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static final int leftMotor = 1;
    // public static final int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static final int rangefinderPort = 1;
    // public static final int rangefinderModule = 1;
    
    public static final int leftMotor1ID = 15;
    public static final int leftMotor2ID = 16;
    public static final int rightMotor1ID = 14;
    public static final int rightMotor2ID = 17;
    public static final int loadLimitID = 1;
    public static final int loaderID = 1;
    public static final int altitudeID = 11;
    public static final int lifterChannel = 1;
    public static final int shooterID = 12;
    public static final int altitudePotPort = 1;
    public static final int shootStickPort = 3;
    public static final int leftStickPort = 1;
    public static final int rightStickPort = 2;
    public static final double maxAltitude = 3.284;
    public static final double minAltitude = 1.6;
    public static final double midAltitude = (maxAltitude + minAltitude)/2;
    public static final int pressureSwitchPort = 2;
    public static final int compressorChannel = 1;
    public static float xDirection;
    public static float yDirection;
    public static float power;
}
