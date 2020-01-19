/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.climbtrain;

import java.util.function.BooleanSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClimbTrain;

public class RunClimbTrain extends CommandBase {
  ClimbTrain climbTrain;
  BooleanSupplier enable;

  private static final double SPEED = -0.75;

  public RunClimbTrain(ClimbTrain _climbTrain, BooleanSupplier _enable) {
    climbTrain = _climbTrain;
    enable = _enable;
    addRequirements(climbTrain);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (enable.getAsBoolean())
      climbTrain.run(SPEED);
    else
      climbTrain.driveStop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
