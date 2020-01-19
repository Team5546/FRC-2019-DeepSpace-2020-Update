/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.drivetrain;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class Drive extends CommandBase {
  private DriveTrain driveTrain;
  private DoubleSupplier left, right;

  public Drive(DriveTrain _driveTrain, DoubleSupplier _left, DoubleSupplier _right) {
    driveTrain = _driveTrain;
    left = _left;
    right = _right;

    addRequirements(driveTrain);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    driveTrain.driveTank(left.getAsDouble(), right.getAsDouble());
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
