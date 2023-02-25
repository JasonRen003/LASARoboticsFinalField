// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import frc.robot.RobotOneCommands.*;
import frc.robot.RobotTwoCommands.*;

import frc.robot.RobotOneSubsystems.*;
import frc.robot.RobotTwoSubsystems.*;

import frc.robot.FieldSubsystems.*;
import frc.robot.FieldCommands.*;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...


  private final XboxController controller = new XboxController(Constants.CONTROLLERPORT);
  private final XboxController r2controller = new XboxController(Constants.R2CONTROLLERPORT);
  //private final HazyTrigger righthazyTrigger = new HazyTrigger(controller, 3);
  //private final HazyTrigger lefthazyTrigger = new HazyTrigger(controller, 2);

  //private final HazyTrigger r2righthazyTrigger = new HazyTrigger(r2controller, 3);
  //private final HazyTrigger r2lefthazyTrigger = new HazyTrigger(r2controller, 2);


  // Robot One //
  private final ServoOne servoOne = new ServoOne();
  private final SolenoidOne solenoidOne = new SolenoidOne();
  private final DriveTalons driveTalons = new DriveTalons();
  private final VictorOne victorOne = new VictorOne();
  private final VictorTwo victorTwo = new VictorTwo();

  private final ServoZero servoZero = new ServoZero(servoOne);
  private final Servo90 servo90 = new Servo90(servoOne);
  private final SolenoidIn solenoidIn = new SolenoidIn(solenoidOne);
  private final SolenoidOut solenoidOut = new SolenoidOut(solenoidOne);
  private final TankDrive tankDrive = new TankDrive(driveTalons, controller);
  private final ArcadeDrive arcadeDrive = new ArcadeDrive(driveTalons, controller);
  private final VOneDefault vOneDefault = new VOneDefault(victorOne);
  private final VTwoDefault vTwoDefault = new VTwoDefault(victorTwo);
  private final VOneForward vOneForward = new VOneForward(victorOne);
  private final VTwoForward vTwoForward = new VTwoForward(victorTwo);
  private final VOneBackwards vOneBackwards = new VOneBackwards(victorOne);
  private final VTwoBackwards vTwoBackwards = new VTwoBackwards(victorTwo);
  SendableChooser<Command> m_chooser;


  // Robot Two //
  private final R2ServoOne r2servoOne = new R2ServoOne();
  private final R2SolenoidOne r2solenoidOne = new R2SolenoidOne();
  private final R2DriveTalons r2driveTalons = new R2DriveTalons();
  private final R2VictorOne r2victorOne = new R2VictorOne();
  private final R2VictorTwo r2victorTwo = new R2VictorTwo();

  private final R2ServoZero r2servoZero = new R2ServoZero(r2servoOne);
  private final R2Servo90 r2servo90 = new R2Servo90(r2servoOne);
  private final R2SolenoidIn r2solenoidIn = new R2SolenoidIn(r2solenoidOne);
  private final R2SolenoidOut r2solenoidOut = new R2SolenoidOut(r2solenoidOne);
  private final R2TankDrive r2tankDrive = new R2TankDrive(r2driveTalons, r2controller);
  private final R2ArcadeDrive r2arcadeDrive = new R2ArcadeDrive(r2driveTalons, r2controller);
  private final R2VOneDefault r2vOneDefault = new R2VOneDefault(r2victorOne);
  private final R2VTwoDefault r2vTwoDefault = new R2VTwoDefault(r2victorTwo);
  private final R2VOneForward r2vOneForward = new R2VOneForward(r2victorOne);
  private final R2VTwoForward r2vTwoForward = new R2VTwoForward(r2victorTwo);
  private final R2VOneBackwards r2vOneBackwards = new R2VOneBackwards(r2victorOne);
  private final R2VTwoBackwards r2vTwoBackwards = new R2VTwoBackwards(r2victorTwo);
  SendableChooser<Command> r2chooser;

  // Field //
  private final FieldServo fieldServo = new FieldServo();
  
  private final WaitAndTurn wt = new WaitAndTurn(fieldServo, Constants.FSWT);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    m_chooser = new SendableChooser<>();
    m_chooser.setDefaultOption("R1 Tank Drive", tankDrive);
    m_chooser.addOption("R1 Arcade Drive", arcadeDrive);
    SmartDashboard.putData(m_chooser);

    
    victorOne.setDefaultCommand(vOneDefault);
    victorTwo.setDefaultCommand(vTwoDefault);
    solenoidOne.setDefaultCommand(solenoidIn);
    servoOne.setDefaultCommand(servoZero);


    r2chooser = new SendableChooser<>();
    r2chooser.setDefaultOption("R2 Tank Drive", r2tankDrive);
    r2chooser.addOption("R2 Arcade Drive", r2arcadeDrive);
    SmartDashboard.putData(r2chooser);

    
    r2victorOne.setDefaultCommand(r2vOneDefault);
    r2victorTwo.setDefaultCommand(r2vTwoDefault);
    r2solenoidOne.setDefaultCommand(r2solenoidIn);
    r2servoOne.setDefaultCommand(r2servoZero);

    //fieldServo.setDefaultCommand(fieldServoZero);
  }

  public void DriveMode(){
    driveTalons.setDefaultCommand(m_chooser.getSelected());
    r2driveTalons.setDefaultCommand(r2chooser.getSelected());
  }

  public WaitAndTurn getFST(){ //Returns command that makes field servo wait and then turn
    return wt;
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    //lefthazyTrigger.toggleWhenPressed(vOneBackwards);
    new JoystickButton(controller, 7).toggleWhenPressed(vOneBackwards);
    new JoystickButton(controller, Button.kLeftBumper.value).toggleWhenPressed(vOneForward);
    //righthazyTrigger.toggleWhenPressed(vTwoBackwards);
    new JoystickButton(controller, 8).toggleWhenPressed(vTwoBackwards);
    new JoystickButton(controller, Button.kRightBumper.value).toggleWhenPressed(vTwoForward);
    new JoystickButton(controller, Button.kA.value).toggleWhenPressed(solenoidOut);
    new JoystickButton(controller, Button.kB.value).toggleWhenPressed(servo90);
    
    //r2lefthazyTrigger.toggleWhenPressed(r2vOneBackwards);
    new JoystickButton(r2controller, 7).toggleWhenPressed(r2vOneBackwards);
    new JoystickButton(r2controller, Button.kLeftBumper.value).toggleWhenPressed(r2vOneForward);
    //r2righthazyTrigger.toggleWhenPressed(r2vTwoBackwards);
    new JoystickButton(r2controller, 8).toggleWhenPressed(r2vTwoBackwards);
    new JoystickButton(r2controller, Button.kRightBumper.value).toggleWhenPressed(r2vTwoForward);
    new JoystickButton(r2controller, Button.kA.value).toggleWhenPressed(r2solenoidOut);
    new JoystickButton(r2controller, Button.kB.value).toggleWhenPressed(r2servo90);
  }

  public void putAllData(){
    servoOne.putData();
    solenoidOne.putData();
    driveTalons.putData();
    victorOne.putData();
    victorTwo.putData();

    r2servoOne.putData();
    r2solenoidOne.putData();
    r2driveTalons.putData();
    r2victorOne.putData();
    r2victorTwo.putData();
  }

}
