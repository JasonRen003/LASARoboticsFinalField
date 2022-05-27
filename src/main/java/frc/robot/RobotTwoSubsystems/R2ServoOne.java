// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.RobotTwoSubsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.*;
public class R2ServoOne extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */

  private Servo servo;

  public R2ServoOne() {
    servo = new Servo(Constants.R2SE);
  }

  public void defaultPos(){
    servo.setPosition(0);
  }

  public void turn90(){
    servo.setPosition(0.5);
  }

  public void putData(){
    SmartDashboard.putNumber("R2 Servo Position",servo.getPosition());
  }
}
