// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.RobotOneSubsystems;
import frc.robot.*;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class VictorTwo extends SubsystemBase {

    private VictorSP victorTwo;


    public VictorTwo() {
        victorTwo = new VictorSP(Constants.R1V2);
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
        SmartDashboard.putNumber("Victor Two", victorTwo.get());
    }
}
