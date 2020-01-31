/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class MoveMotor extends CommandBase {
  /**
   * Creates a new MoveMotor.
   */
  private final DriveTrain d;
  private double left, right;
  private double startTime, time;

  //left speed/right speed
  public MoveMotor(DriveTrain d, double left, double right, double time) {
    this.d = d;
    this.left = left;
    this.right = right;
    addRequirements(d);
    //for (startTime, startTime < time, ) 
     
  }

  public MoveMotor(DriveTrain d, double speed, double time) {
    this.d = d;
    left = speed;
    right = speed;
    addRequirements(d);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    startTime = System.currentTimeMillis();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
    if(System.currentTimeMillis() - startTime < time){
      d.tankDrive(left, right);
    }else{
      end(false);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    d.tankDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
