
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.DigitalIOButton;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.templates.commands.LowerShooter;
import edu.wpi.first.wpilibj.templates.commands.RaiseShooter;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // Another type of button you can create is a DigitalIOButton, which is
    // a button or switch hooked up to the cypress module. These are useful if
    // you want to build a customized operator interface.
    // Button button = new DigitalIOButton(1);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
    
    //Joysticks
    Joystick shootStick;
    Joystick leftStick;
    Joystick rightstick;
    
    //Buttons
    Button raise;
    Button lower;
    Button fire;
    Button aim;
    Button compressor;
    Button changedriveleft;
    Button changedriveright;
    Button hooksleft;
    Button hooksright;
    
    protected static OI instance;
    
    public static OI getInstance(){
		if(instance == null){
			instance = new OI();
		}
		return instance;
	}

    private OI() {
        shootStick = new Joystick(RobotMap.shootStickPort);
        leftStick = new Joystick(RobotMap.leftStickPort);
        rightstick = new Joystick(RobotMap.rightStickPort);
        initButtons();
    }
    
    private void initButtons() {
        raise = new JoystickButton(shootStick, 3);
        lower = new JoystickButton(shootStick, 2);
        fire = new JoystickButton(shootStick, 4);
        aim= new JoystickButton(shootStick, 5);
        compressor = new JoystickButton(shootStick, 10);
        changedriveleft = new JoystickButton(leftStick, 1);
        changedriveright = new JoystickButton(rightstick, 1);
        hooksleft = new JoystickButton(leftStick, 10);
        hooksright = new JoystickButton(rightstick, 10);
        
        tieButtons();
    }
    private void tieButtons() {
        raise.whileHeld(new RaiseShooter());
        lower.whileHeld(new LowerShooter());
        // aim.whenPressed(new Aim());
        
    }
    
    public Joystick getLeftStick() {
        return leftStick;
    }
    
    public Joystick getRightStick() {
        return rightstick;
    }
}

