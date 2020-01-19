/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  private VictorSP leftFront, leftBack, rightFront, rightBack;
  private SpeedControllerGroup left, right;
  private DifferentialDrive drive;

  public DriveTrain() {
    leftFront = new VictorSP(Constants.DRIVE_LEFT_FRONT);
    leftBack = new VictorSP(Constants.DRIVE_LEFT_BACK);
    rightFront = new VictorSP(Constants.DRIVE_RIGHT_FRONT);
    rightBack = new VictorSP(Constants.DRIVE_RIGHT_BACK);

    left = new SpeedControllerGroup(leftFront, leftBack);
    right = new SpeedControllerGroup(rightFront, rightBack);

    drive = new DifferentialDrive(left, right);
  }

  public void driveTank(double leftSpeed, double rightSpeed) {
    drive.tankDrive(leftSpeed, rightSpeed);
  }
}
