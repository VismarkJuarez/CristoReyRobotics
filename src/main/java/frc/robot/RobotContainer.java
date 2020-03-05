/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.MoveMotorCommand;
import frc.robot.commands.PneumaticsExtendPistonCommand;
import frc.robot.commands.PneumaticsRetractPistonCommand;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.PneumaticsSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  /*
  Specify what port (as labeled on the FRC Driver's Station)
  the physical controller is connected to. This is listed in
  the Driver Station's "USB order list". If the controller is
  the only thing attached to the computer, then the port is
  almost always 0.  You should double check, though.
  */
  public static Joystick controller = new Joystick(0); //This variable represents the physical game controller

  //Pneumatics Subsystems and Commands
  PneumaticsSubsystem pneumaticsSubsystem = new PneumaticsSubsystem();
  PneumaticsExtendPistonCommand pneumaticsExtendPistonCommand = new PneumaticsExtendPistonCommand(pneumaticsSubsystem);
  PneumaticsRetractPistonCommand pneumaticsRetractPistonCommand = new PneumaticsRetractPistonCommand(pneumaticsSubsystem);

  //Intake Subsystem and Commands
  IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  IntakeCommand intakeCommand = new IntakeCommand(intakeSubsystem);

  //robot subsystem variable to be used when it needs to be triggered:
  private final DriveTrainSubsystem driveTrainSubsystem = new DriveTrainSubsystem();

  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);


  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    //TODO: Add button mappings to the Constants file.

    //Map buttons 3 and 4 on the controller to extend and retract the piston, respectively:
    final JoystickButton extendPistonButton = new JoystickButton(controller, 5);
    final JoystickButton retractPistonButton = new JoystickButton(controller, 6);

    //Define each button's behaviour:
    extendPistonButton.whenHeld(pneumaticsExtendPistonCommand);
    retractPistonButton.whenHeld(pneumaticsRetractPistonCommand);

    //---------------------------------------------
    final JoystickButton activateIntakeButton = new JoystickButton(controller, 4);
    activateIntakeButton.whenHeld(intakeCommand);

    //---------------------------------------------
    //selecting the gamepad's L1 button
    final JoystickButton L_1Button = new JoystickButton(controller, 4);

    //when pressed, trigger command:
    L_1Button.whenHeld(new MoveMotorCommand(driveTrainSubsystem));
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
