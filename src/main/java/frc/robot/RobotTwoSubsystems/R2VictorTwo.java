// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.RobotTwoSubsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.*;
public class R2VictorTwo extends SubsystemBase {
    /** Creates a new ExampleSubsystem. */
    private VictorSP victorTwo;


    public R2VictorTwo() {
        victorTwo = new VictorSP(Constants.R2V2);
    }

    public void defaultC(){
        victorTwo.set(0);
    }

    public void forward(){
        victorTwo.set(.5);
    }

    public void backwards(){
        victorTwo.set(-.5);
    }

    public void putData(){
        SmartDashboard.putNumber("R2 Victor Two", victorTwo.get());
    }
}
