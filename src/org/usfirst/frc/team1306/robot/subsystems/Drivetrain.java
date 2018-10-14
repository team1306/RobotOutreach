package org.usfirst.frc.team1306.robot.subsystems;

import org.usfirst.frc.team1306.robot.Constants;
import org.usfirst.frc.team1306.robot.RobotMap;
import org.usfirst.frc.team1306.robot.drivetrain.Drive;
//import org.usfirst.frc.team1306.robot.drivetrain.AdjustSpeedMode.Speed;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Drivetrain extends Subsystem {

	private Spark leftFront, rightFront, leftBack, rightBack;
	public DriveMode mode;
	
	
	public Drivetrain (){
		leftFront = new Spark(RobotMap.LEFT_FRONT_PORT);
		rightFront = new Spark(RobotMap.RIGHT_FRONT_PORT);
		leftBack = new Spark(RobotMap.LEFT_BACK_PORT);
		rightBack = new Spark(RobotMap.RIGHT_BACK_PORT);
		mode = DriveMode.TANK;
	}
	
	public void driveMotors (double leftFrontSpeed, double rightFrontSpeed, double leftBackSpeed, double rightBackSpeed) {
		leftFront.set(leftFrontSpeed);
		rightFront.set(rightFrontSpeed);
		leftBack.set(leftBackSpeed);
		rightBack.set(rightBackSpeed);
	}
	
	public void stop() {
		leftFront.set(0.0);
		leftBack.set(0.0);
		rightFront.set(0.0);
		rightBack.set(0.0);
	}
	
	public void drivePercentOutput(double leftVal, double rightVal) {
		if(Constants.DRIVETRAIN_ENABLED) {
			leftFront.set(leftVal);
			leftBack.set(leftVal);
			rightFront.set(-rightVal); 
			rightBack.set(-rightVal);
		}
	}
	
	public void setDriveMode (DriveMode driveStatus) {
		if (driveStatus.equals(DriveMode.MECH)) {
			mode = DriveMode.MECH;
		}
		else if (driveStatus.equals(DriveMode.ARCADE)) {
			mode = DriveMode.ARCADE;
		}
		else {
			mode = DriveMode.TANK;
		}
	}
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new Drive());
	}
	
	public enum DriveMode {TANK, MECH, ARCADE};
}
