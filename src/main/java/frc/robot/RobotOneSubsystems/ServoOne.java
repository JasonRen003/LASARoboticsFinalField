// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.RobotOneSubsystems;
import frc.robot.*;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ServoOne extends SubsystemBase {

  private Servo servo;

  public ServoOne() {
    servo = new Servo(Constants.R1SE);
  }

  public void defaultPos(){
    servo.setPosition(0);
  }

  public void turn90(){
    servo.setPosition(0.5);
  }

  public void putData(){
    SmartDashboard.putNumber("Servo Position",servo.getPosition());
  }

  
}
