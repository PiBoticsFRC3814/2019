/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.*;
import frc.robot.commands.driveJoystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Drivetrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  WPI_TalonSRX leftFront;
  WPI_TalonSRX rightFront;
  WPI_TalonSRX leftBack;
  WPI_TalonSRX rightBack;

  SpeedControllerGroup leftMotors;
  SpeedControllerGroup rightMotors;

  DifferentialDrive piboticsDrive;

  public Drivetrain() {
    leftFront = new WPI_TalonSRX(0);
    leftBack = new WPI_TalonSRX(1);
    rightFront = new WPI_TalonSRX(2);
    rightBack = new WPI_TalonSRX(3);

    leftMotors = new SpeedControllerGroup(leftFront,leftBack);
    rightMotors = new SpeedControllerGroup(rightFront,rightBack);
    
		piboticsDrive = new DifferentialDrive(leftMotors, rightMotors);
	}

	public void arcadeDrive(double x, double y) {
		differentialDrive.arcadeDrive(x, y);
	}

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new driveJoystick());
  }
}
