/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrainSubsystem;

public class MoveMotorCommand extends CommandBase {
  private DriveTrainSubsystem driveTrainSubsystem;

  /**
   * Creates a new TankDrive.
   */
  public MoveMotorCommand(DriveTrainSubsystem driveTrain) {
    // Use addRequirements() here to declare subsystem dependencies.
    driveTrainSubsystem = driveTrain;
    addRequirements(driveTrainSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //How does one pass the joystick value here? There has to be a better way.
    driveTrainSubsystem.drive(1.0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    System.out.println("Stopping");
    driveTrainSubsystem.drive(0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
