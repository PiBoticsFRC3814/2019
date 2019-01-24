/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.ControlFrontWheels;
import frc.robot.commands.ExtendFrontWheels;
import frc.robot.commands.TiltHatchCommand;
import frc.robot.commands.GrabHatchCommand;
import frc.robot.commands.GrabBallCommand;
import main.java.frc.robot.commands.ControlBackWheels;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  
public OI() {
  Joystick driveStick = new Joystick(1);
  Joystick buttonStick = new Joystick(2);

  Button extendHatch = new JoystickButton(buttonStick, 1),
  retractHatch = new JoystickButton(buttonStick, 2),
  ButtontiltHatchUp = new JoystickButton(buttonStick, 3),
  tiltHatchDown = new JoystickButton(buttonStick, 4),
  hatchLeft = new JoystickButton(buttonStick, 5),
  hatchRight = new JoystickButton(buttonStick, 6),
  
  extendFrontClimb = new JoystickButton(buttonStick, 7),
  retractFrontClimb = new JoystickButton(buttonStick, 8),
  extendBackClimb = new JoystickButton(buttonStick, 9),
  retractBackClimb = new JoystickButton(buttonStick, 10),
  extendAllClimb = new JoystickButton(buttonStick, 11),
  driveForwards = new JoystickButton(buttonStick, 12),
  driveBackwards = new JoystickButton(buttonStick, 13),
  
  intakeBall = new JoystickButton(buttonStick, 14),
  outputBall = new JoystickButton(buttonStick, 15),
  tiltBallUp = new JoystickButton(buttonStick, 16),
  tiltBallDown = new JoystickButton(buttonStick, 17),
  liftBallUp = new JoystickButton(buttonStick, 18),
  liftBallDown = new JoystickButton(buttonStick, 19);
  
  extendHatch.whenPressed(new GrabHatchCommand(DoubleSolenoid.Value.kForward));
  retractHatch.whenPressed(new GrabHatchCommand(DoubleSolenoid.Value.kReverse));
  tiltHatchUp.whenPressed(new TiltHatchCommand(DoubleSolenoid.Value.kForward));
  tiltHatchDown.whenPressed(new TiltHatchCommand(DoubleSolenoid.Value.kReverse));
  hatchLeft.whenPressed(new HatchLateralCommand(1.0));
  hatchRight.whenPressed(new HatchLateralCommand(-1.0));

  extendFrontClimb.whenPressed(new ControlFrontWheels(DoubleSolenoid.Value.kForward));
	retractFrontClimb.whenPressed(new ControlFrontWheels(DoubleSolenoid.Value.kReverse));
	extendBackClimb.whenPressed(new ControlBackWheels(DoubleSolenoid.Value.kForward));
	extendBackClimb.whenPressed(new ControlBackWheels(DoubleSolenoid.Value.kReverse));
  extendAllClimb.whenPressed((new ControlFrontWheels(DoubleSolenoid.Value.kForward)),(new ControlBackWheels(DoubleSolenoid.Value.kForward)));
  driveForwards.whilePressed(new ClimbDrive(1.0));
  driveBackwards.whilePressed(new ClimbDrive(-1.0));
	
  intakeBall.whenPressed(new GrabBallCommand(-1.0));
  outputBall.whenPressed(new GrabBallCommand(1.0));




}
}


