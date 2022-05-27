package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj2.command.button.Button;

public class HazyTrigger extends Button {

    GenericHID joystick;
    int axis;
    private double THRESHOLD = 0.2;
    
    public HazyTrigger(GenericHID joystick, int axis) {
        this.joystick = joystick;
        this.axis = axis;
    }    

    public boolean get() {
        return joystick.getRawAxis(axis) > THRESHOLD;    //Return true if axis value is greater than positive threshold
    }
}