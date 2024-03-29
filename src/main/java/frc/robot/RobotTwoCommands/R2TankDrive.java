// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.RobotTwoCommands;
import frc.robot.RobotTwoSubsystems.*;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class R2TankDrive extends CommandBase {
  private final R2DriveTalons tOne;
  private final XboxController controller;

  public R2TankDrive(R2DriveTalons t, XboxController c) {
    tOne = t;
    controller = c;
    addRequirements(tOne);    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(tOne.getReversed())
      tOne.tankDrive(controller.getRawAxis(1), controller.getRawAxis(3));
    else
      tOne.tankDrive(-controller.getRawAxis(1), -controller.getRawAxis(3));
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
