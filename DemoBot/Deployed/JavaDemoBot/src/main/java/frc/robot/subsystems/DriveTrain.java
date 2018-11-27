/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import com.ctre.phoenix.*;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.ADIS16448_IMU;
import frc.robot.commands.DriveWithStick;

/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public WPI_TalonSRX frontLeft;
  public WPI_TalonSRX frontRight;
  public WPI_TalonSRX backLeft;
  public WPI_TalonSRX backRight;

  public ADIS16448_IMU gyro;

  private MecanumDrive drivetrain;

  public DriveTrain(){
    initialization();
  }

  public void initialization(){
    frontLeft = new WPI_TalonSRX(1);
    backLeft = new WPI_TalonSRX(2);
    frontRight = new WPI_TalonSRX(3);
    backRight = new WPI_TalonSRX(4);
    frontLeft.setInverted(true);
    backLeft.setInverted(true);
    gyro = new ADIS16448_IMU();
    gyro.reset();

    drivetrain = new MecanumDrive(frontLeft,backLeft,frontRight,backRight);
  }

  @Override
  protected void initDefaultCommand() {
    setDefaultCommand(new DriveWithStick());
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
  public void DriveWithGyro(double X, double Y, double rotate){
    drivetrain.driveCartesian(X,Y,rotate,gyro.getAngleZ());
  }
}
