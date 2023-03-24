// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.RobotTwoSubsystems;
import frc.robot.*;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class R2DriveTalons extends SubsystemBase {

  private TalonSRX talonOne;
  private TalonSRX talonTwo;
  private boolean reversed;

  public R2DriveTalons() {
    talonOne = new TalonSRX(Constants.R2T1);
    talonTwo = new TalonSRX(Constants.R2T2);
    reversed = false;
  }

  //Keeps input value between the high and low values
  private double clamp(double input, double low, double high){ //utility function for drive cartesian
    if (input > high)
        return high;
    else if (input < low)
        return low;
    return input;
  }

  public void tankDrive(double y1, double y2){
    y1 = clamp(y1, -1.0, 1.0);
    y2 = clamp(y2, -1.0, 1.0);
    talonOne.set(ControlMode.PercentOutput, y1);
    talonTwo.set(ControlMode.PercentOutput, y2);
  }

  public void arcadeDrive(double y, double x){
    x = Math.pow(x,3);
    y = Math.pow(y,3);
    x = clamp(x, -1.0, 1.0);
    y = clamp(y, -1.0, 1.0);  
      
    talonOne.set(ControlMode.PercentOutput, y + x);
    talonTwo.set(ControlMode.PercentOutput, y - x);          
  }

  public void setReversed(boolean dir){
    reversed = dir;
  }

  public boolean getReversed(){
    return reversed;
  }

  public void putData(){
    if(!reversed){
      SmartDashboard.putNumber("R2 Talon One", talonOne.getMotorOutputPercent());
      SmartDashboard.putNumber("R2 Talon Two", talonTwo.getMotorOutputPercent());
    }
    else{
      SmartDashboard.putNumber("R2 Talon One", -talonOne.getMotorOutputPercent());
      SmartDashboard.putNumber("R2 Talon Two", -talonTwo.getMotorOutputPercent());
    }
  }
}
