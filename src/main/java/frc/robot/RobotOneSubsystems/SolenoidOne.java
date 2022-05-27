// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.RobotOneSubsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.*;
public class SolenoidOne extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */


  private Solenoid sol;

  public SolenoidOne() {
    sol = new Solenoid(4,PneumaticsModuleType.CTREPCM, Constants.R1SO);
  }

  public void solOff(){
    sol.set(false);
  }

  public void solOn(){
    sol.set(true);
  }

  public void putData(){
    SmartDashboard.putBoolean("Solenoid Status", sol.get());
  }
  
}
