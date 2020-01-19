/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Elevator extends SubsystemBase {
  private DoubleSolenoid tiltenoid, grabenoid;
  private VictorSP winchMotorLeft, winchMotorRight;
  private SpeedControllerGroup winch;

  public Elevator() {
    winchMotorLeft = new VictorSP(Constants.WINCH_MOTOR_1);
    winchMotorRight = new VictorSP(Constants.WINCH_MOTOR_2);

    winch = new SpeedControllerGroup(winchMotorLeft, winchMotorRight);

    tiltenoid = new DoubleSolenoid(Constants.ELEVATOR_TILT_SOLENOID_1, Constants.ELEVATOR_TILT_SOLENOID_2);
    grabenoid = new DoubleSolenoid(Constants.MANIPULATOR_SOLENOID_1, Constants.MANIPULATOR_SOLENOID_2);
  }

  public void runWinch(double speed) {
    winch.set(speed);
  }

  public void tilt() {
    tiltenoid.set(Value.kForward);
  }

  public void unTilt() {
    tiltenoid.set(Value.kReverse);
  }

  public void grab() {
    grabenoid.set(Value.kReverse);
  }

  public void letGo() {
    grabenoid.set(Value.kForward);
  }
}
