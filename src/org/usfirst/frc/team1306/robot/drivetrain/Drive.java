package org.usfirst.frc.team1306.robot.drivetrain;

import org.usfirst.frc.team1306.robot.Constants;
import org.usfirst.frc.team1306.robot.OI;
import org.usfirst.frc.team1306.robot.OI.Axis;
import org.usfirst.frc.team1306.robot.OI.Controller;
import org.usfirst.frc.team1306.robot.OI.Joystick;
import org.usfirst.frc.team1306.robot.OI.Trigger;
import org.usfirst.frc.team1306.robot.commands.CommandBase;
import org.usfirst.frc.team1306.robot.subsystems.Drivetrain.DriveMode;

public class Drive extends CommandBase{
	
	public Drive() {
		requires(drivetrain);
		
	}
	
	@Override
	protected void execute() {
		double leftVal;
		double rightVal;
		double leftFrontVal;
		double leftBackVal;
		double rightFrontVal;
		double rightBackVal;
		
		
		if (drivetrain.mode.equals(DriveMode.TANK)) {
			leftVal = OI.getJoyVal(Controller.P, Joystick.L, Axis.Y);
			rightVal = OI.getJoyVal(Controller.P, Joystick.R, Axis.Y);
			
			drivetrain.driveMotors(leftVal, -rightVal, leftVal, -rightVal);
		}
		else if(drivetrain.mode.equals(DriveMode.ARCADE)) {
			if(OI.getTriggerVal(Controller.P, Trigger.L) >= Constants.DEADBAND || OI.getTriggerVal(Controller.P, Trigger.R) >= Constants.DEADBAND) {
				double triggerVal = OI.getTriggerVal(Controller.P, Trigger.R) - OI.getTriggerVal(Controller.P, Trigger.L);

				if(OI.getTriggerVal(Controller.P, Trigger.L) >= Constants.DEADBAND) {
					drivetrain.drivePercentOutput(triggerVal+OI.getJoyVal(Controller.P, Joystick.L, Axis.X), triggerVal-OI.getJoyVal(Controller.P, Joystick.L, Axis.X));
				}
				
				else if(OI.getTriggerVal(Controller.P, Trigger.R) >= Constants.DEADBAND) {
					drivetrain.drivePercentOutput(triggerVal+OI.getJoyVal(Controller.P, Joystick.R, Axis.X), triggerVal-OI.getJoyVal(Controller.P, Joystick.R, Axis.X));
				}
				else {drivetrain.stop();}
			}
		}
		else {
			leftFrontVal = 0.25*(OI.getJoyVal(Controller.P, Joystick.R, Axis.Y) + OI.getJoyVal(Controller.P, Joystick.L, Axis.X) + OI.getJoyVal(Controller.P, Joystick.R, Axis.X));
			leftBackVal = 0.25*(OI.getJoyVal(Controller.P, Joystick.R, Axis.Y) + OI.getJoyVal(Controller.P, Joystick.L, Axis.X) -  OI.getJoyVal(Controller.P, Joystick.R, Axis.X));
			rightFrontVal = 0.25*(OI.getJoyVal(Controller.P, Joystick.R, Axis.Y) - OI.getJoyVal(Controller.P, Joystick.L, Axis.X) + OI.getJoyVal(Controller.P, Joystick.R, Axis.X));
			rightBackVal = 0.25*(OI.getJoyVal(Controller.P, Joystick.R, Axis.Y) - OI.getJoyVal(Controller.P, Joystick.L, Axis.X) - OI.getJoyVal(Controller.P, Joystick.R, Axis.X));
			
			drivetrain.driveMotors(leftFrontVal, rightFrontVal, leftBackVal, rightBackVal);
		}
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
}
