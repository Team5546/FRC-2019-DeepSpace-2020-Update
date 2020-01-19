/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.climb;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climb;

public class DriveClimb extends CommandBase {
  private Climb climb;
  private DoubleSupplier speed;

  public DriveClimb(Climb _climb, DoubleSupplier _speed) {
    climb = _climb;
    speed = _speed;
    addRequirements(climb);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double rawSpeed = speed.getAsDouble();
    if (rawSpeed > 0.5 || rawSpeed < 0.5)
      climb.run(rawSpeed);
    else
      climb.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
