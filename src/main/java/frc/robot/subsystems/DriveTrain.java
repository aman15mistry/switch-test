package frc.robot.subsystems;

import com.revrobotics.SparkMax;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class DriveTrain extends SubsystemBase {
    //public CANSparkMax frontL, frontR, backL, backR;
    public Spark frontR, backR, frontL, backL;
    public SpeedControllerGroup left, right;
    public DifferentialDrive drive;

    public DriveTrain() {
        /*frontL = new CANSparkMax(Constants.FRONTL, MotorType.kBrushless);
        frontR = new CANSparkMax(Constants.FRONTR, MotorType.kBrushless);
        backL = new CANSparkMax(Constants.BACKL, MotorType.kBrushless);
        backR = new CANSparkMax(Constants.BACKL, MotorType.kBrushless);*/
       frontR = new Spark(Constants.FRONTR);
       frontL = new Spark(Constants.FRONTL);
       backR = new Spark(Constants.BACKR);
       backL = new Spark(Constants.BACKL);

       left = new SpeedControllerGroup(frontL, backL);
       right = new SpeedControllerGroup(frontR, backR);

       drive = new DifferentialDrive(left, right);


    }


@Override 
public void periodic () {
}    

public void tankDrive(double leftSpeed, double rightSpeed){
    drive.tankDrive(leftSpeed, rightSpeed);
}



}