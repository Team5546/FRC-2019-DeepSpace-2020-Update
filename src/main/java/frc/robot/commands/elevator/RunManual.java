/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.elevator;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Elevator;

public class RunManual extends CommandBase {
  private Elevator elevator;
  private DoubleSupplier speed;

  public RunManual(Elevator _elevator, DoubleSupplier _speed) {
    elevator = _elevator;
    speed = _speed;

    addRequirements(elevator);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double rawSpeed = speed.getAsDouble();
    if (rawSpeed > 0.5 || rawSpeed < -0.5) {
      if (DriverStation.getInstance().getMatchTime() > 30) {
        elevator.runWinch(rawSpeed * 0.75);
      } else {
        elevator.runWinch(rawSpeed);
      }
      return;
    }
    elevator.runWinch(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
