/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {

  //A TalonSRX to control the intake motor
  private TalonSRX intakeTalon;

  /**
   * Creates a new IntakeSubsystem.
   */
  public IntakeSubsystem() {
    super();
    //TODO Utilize the Constants file instead of hardcoding the CAN IDs
    intakeTalon = new TalonSRX(15);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void activateIntake() {
    //TODO Move to Constants file
    //activates the motor at half speed.  This can be altered.
    final double TALON_PERCENT_OUTPUT_HALF_SPEED_INTAKE = 0.5;
    intakeTalon.set(TalonSRXControlMode.PercentOutput, TALON_PERCENT_OUTPUT_HALF_SPEED_INTAKE);
  }

  public void stopIntake() {
    //TODO move final variable to Constants file
    final double TALON_PERCENT_OUTPUT_STOP_INTAKE = 0.0;
    intakeTalon.set(TalonSRXControlMode.PercentOutput, TALON_PERCENT_OUTPUT_STOP_INTAKE);
  }
}
