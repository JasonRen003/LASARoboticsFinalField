// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.RobotOneCommands;
import frc.robot.RobotOneSubsystems.*;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Servo;

/** An example command that uses an example subsystem. */
public class ServoZero extends CommandBase {
  private final ServoOne se;

  public ServoZero(ServoOne s) {
    se = s;
    addRequirements(se);    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    se.defaultPos();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
