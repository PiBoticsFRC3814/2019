/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import com.ctre.phoenix.motorcontrol.can.*;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * This is a demo program showing the use of the RobotDrive class, specifically
 * it contains the code necessary to operate a robot with tank drive.
 */
public class Robot extends IterativeRobot {
  private DifferentialDrive m_myRobot;
  private Joystick m_leftStick;
  private Joystick m_rightStick;
  WPI_TalonSRX _frontLeftMotor;
  WPI_TalonSRX _frontRightMotor;
  DoubleSolenoid exampleDouble; 
  Compressor comp;

  @Override
  public void robotInit() {
    m_myRobot = new DifferentialDrive(new WPI_TalonSRX(3), new WPI_TalonSRX(4));
    m_leftStick = new Joystick(0);
    m_rightStick = new Joystick(1);
    exampleDouble = new DoubleSolenoid(0, 1);
    comp = new Compressor(0);
  }

  @Override
  public void teleopPeriodic() {
    comp.setClosedLoopControl(true);
    m_myRobot.tankDrive(-m_leftStick.getY(), -m_rightStick.getY());
    //m_myRobot.arcadeDrive(-m_leftStick.getY(), m_leftStick.getX());
    if (m_leftStick.getRawButton(1))
    {
      exampleDouble.set(DoubleSolenoid.Value.kForward);
    }
    else
    {
      exampleDouble.set(DoubleSolenoid.Value.kReverse);
    }
  }
}
