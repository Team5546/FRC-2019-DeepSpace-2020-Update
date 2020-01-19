/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Climb extends SubsystemBase {
  private VictorSP left, right;
  private SpeedControllerGroup climbDrive;

  public Climb() {
    left = new VictorSP(Constants.CLIMB_LEFT);
    right = new VictorSP(Constants.CLIMB_RIGHT);
    right.setInverted(true);
    climbDrive = new SpeedControllerGroup(left, right);
  }

  public void stop() {
    climbDrive.set(0);
  }

  public void run(double speed) {
    climbDrive.set(speed);
  }
}
