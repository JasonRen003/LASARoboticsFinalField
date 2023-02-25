// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.FieldSubsystems;
import frc.robot.*;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj.Servo;

public class FieldServo extends SubsystemBase {

    private Servo fieldServo;

    public FieldServo() {
        fieldServo = new Servo(Constants.FSP);
    }

    public void defaultPos(){
        fieldServo.set(0);
    }
    
    public void turn90(){
    fieldServo.setAngle(90);
    }
    

    public void putData(){}

}
