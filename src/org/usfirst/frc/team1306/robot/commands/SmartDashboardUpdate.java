package org.usfirst.frc.team1306.robot.commands;

import org.usfirst.frc.team1306.robot.Constants;
import org.usfirst.frc.team1306.robot.OI;
import org.usfirst.frc.team1306.robot.OI.Axis;
import org.usfirst.frc.team1306.robot.OI.Controller;
import org.usfirst.frc.team1306.robot.OI.Joystick;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * @SmartDashboardUpdate - Updates the SmartDashboard with debug info for each subsystem if it's requested.
 * @author Jackson Goth
 */
public class SmartDashboardUpdate extends CommandBase {
	
	public SmartDashboardUpdate() {
		setRunWhenDisabled(true); //Useful to run at all times
	}
	
	@Override
	protected void execute() {
		if (Constants.DRIVETRAIN_DEBUG) {
			SmartDashboard.putNumber("Left Joystick", OI.getJoyVal(Controller.P, Joystick.L, Axis.Y));
		}
	}

	@Override
	protected boolean isFinished() {
		return false; //Should never end
	}
}
