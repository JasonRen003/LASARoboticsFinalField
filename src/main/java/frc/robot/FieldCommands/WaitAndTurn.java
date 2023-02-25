package frc.robot.FieldCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.FieldSubsystems.*;

public class WaitAndTurn extends SequentialCommandGroup{

    public WaitAndTurn(FieldServo fs, int time){
        addCommands(new WaitCommand(time), new FieldServo90(fs), new WaitCommand(2), new FieldServoZero(fs));
    }
    
}
