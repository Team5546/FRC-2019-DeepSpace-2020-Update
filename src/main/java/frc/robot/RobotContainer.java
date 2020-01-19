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
import frc.robot.commands.drivetrain.Drive;
import frc.robot.commands.elevator.Init;
import frc.robot.commands.elevator.RunManual;
import frc.robot.commands.manipulator.RunManipulator;
import frc.robot.commands.climb.DriveClimb;
import frc.robot.commands.climbtrain.RunClimbTrain;
import frc.robot.subsystems.Climb;
import frc.robot.subsystems.ClimbTrain;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Manipulator;
import edu.wpi.first.wpilibj2.command.Command;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  private final DriveTrain driveTrain = new DriveTrain();
  private final Elevator elevator = new Elevator();
  private final Climb climb = new Climb();
  private final ClimbTrain climbTrain = new ClimbTrain();
  private final Manipulator manipulator = new Manipulator();

  private final Init autoCommand = new Init(elevator);

  private final Joystick leftStick = new Joystick(Constants.LEFT_JOYSTICK);
  private final Joystick rightStick = new Joystick(Constants.RIGHT_JOYSTICK);

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    configureButtonBindings();

    driveTrain.setDefaultCommand(new Drive(driveTrain, () -> leftStick.getY(), () -> rightStick.getY()));
    elevator.setDefaultCommand(new RunManual(elevator, () -> leftStick.getTwist()));
    climb.setDefaultCommand(new DriveClimb(climb, () -> rightStick.getX()));
    climbTrain.setDefaultCommand(new RunClimbTrain(climbTrain, () -> rightStick.getTrigger()));
    manipulator.setDefaultCommand(new RunManipulator(manipulator, () -> rightStick.getTwist()));
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by instantiating a {@link GenericHID} or one of its subclasses
   * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
   * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return autoCommand;
  }
}
