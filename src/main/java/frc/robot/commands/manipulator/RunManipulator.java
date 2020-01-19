/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.manipulator;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Manipulator;

public class RunManipulator extends CommandBase {
  private Manipulator manipulator;
  private DoubleSupplier speed;

  private double SPEED = 1.0;

  public RunManipulator(Manipulator _manipulator, DoubleSupplier _speed) {
    manipulator = _manipulator;
    speed = _speed;
    addRequirements(manipulator);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double rawSpeed = speed.getAsDouble();

    if (rawSpeed > 0.9)
      manipulator.runManipulator(-SPEED);
    else if (rawSpeed < 0.9)
      manipulator.runManipulator(SPEED);
    else
      manipulator.runManipulator(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
