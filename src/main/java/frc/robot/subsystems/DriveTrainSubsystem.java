/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrainSubsystem extends SubsystemBase {

  //Motorcontroller attached to PWM port 0
  private static final Victor victorMotorController = new Victor(0);

  public void drive(double joystickValue) {
    //set the speed/direction of the motorcontroller
    System.out.println("joystick value is: " + joystickValue);
    victorMotorController.set(joystickValue);
  }

  /**
   * Creates a new DriveTrain.
   */
  public DriveTrainSubsystem() {
    super();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
