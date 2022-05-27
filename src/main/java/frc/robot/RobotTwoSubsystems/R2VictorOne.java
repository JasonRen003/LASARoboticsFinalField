// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.RobotTwoSubsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.*;
public class R2VictorOne extends SubsystemBase {
    /** Creates a new ExampleSubsystem. */
    private VictorSP victorOne;


    public R2VictorOne() {
    victorOne = new VictorSP(Constants.R2V1);
    }

    public void defaultC(){
        victorOne.set(0);
    }

    public void forward(){
        victorOne.set(.5);
    }

    public void backwards(){
        victorOne.set(-.5);
    }

    public void putData(){
        SmartDashboard.putNumber("R2 Victor One", victorOne.get());
    }
  
}
