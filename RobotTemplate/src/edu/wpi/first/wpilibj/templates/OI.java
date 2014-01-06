
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.DigitalIOButton;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.templates.commands.AimSeq;
import edu.wpi.first.wpilibj.templates.commands.ChangeDriveMode;
import edu.wpi.first.wpilibj.templates.commands.Lift;
import edu.wpi.first.wpilibj.templates.commands.Load;
import edu.wpi.first.wpilibj.templates.commands.LowerMin;
import edu.wpi.first.wpilibj.templates.commands.LowerShooter;
import edu.wpi.first.wpilibj.templates.commands.Pressurize;
import edu.wpi.first.wpilibj.templates.commands.RaiseMax;
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
    Joystick rightStick;
    
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
    Button raisemax;
    Button lowermin;
    
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
        rightStick = new Joystick(RobotMap.rightStickPort);
        initButtons();
    }
    
    private void initButtons() {
        raise = new JoystickButton(shootStick, 3);
        lower = new JoystickButton(shootStick, 2);
        lowermin = new JoystickButton(shootStick, 10);
        raisemax = new JoystickButton(shootStick, 11);
        fire = new JoystickButton(shootStick, 5);
        aim = new JoystickButton(shootStick, 4);
        compressor = new JoystickButton(shootStick, 9);
        changedriveleft = new JoystickButton(leftStick, 1);
        changedriveright = new JoystickButton(rightStick, 1);
        hooksleft = new JoystickButton(leftStick, 5);
        hooksright = new JoystickButton(rightStick, 4);
 
        tieButtons();
    }
    private void tieButtons() {
        raise.whileHeld(new RaiseShooter());
        lower.whileHeld(new LowerShooter());
        aim.whenPressed(new AimSeq());
        lowermin.whenPressed(new LowerMin());
        raisemax.whenPressed(new RaiseMax());
        fire.whenPressed(new Load());
        changedriveleft.whenPressed(new ChangeDriveMode());
        changedriveright.whenPressed(new ChangeDriveMode());
        compressor.whenPressed(new Pressurize());
        hooksleft.whenPressed(new Lift());
        hooksright.whenPressed(new Lift());  
        System.out.println("Tied");
    }
    
    public Joystick getLeftStick() {
        return leftStick;
    }
    
    public Joystick getRightStick() {
        return rightStick;
    }
    
    public Joystick getShootStick() {
        return shootStick;
    }
}

