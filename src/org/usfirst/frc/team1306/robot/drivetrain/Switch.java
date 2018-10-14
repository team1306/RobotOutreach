package org.usfirst.frc.team1306.robot.drivetrain;

import org.usfirst.frc.team1306.robot.commands.CommandBase;
import org.usfirst.frc.team1306.robot.subsystems.Drivetrain.DriveMode;

public class Switch extends CommandBase {
	
	private DriveMode mode;
	
	public Switch(DriveMode driveStatus) {	
		mode = driveStatus;
	}

	@Override
	protected void execute() {
		if (mode.equals(DriveMode.MECH)) {
			drivetrain.setDriveMode(DriveMode.MECH);
		}
		else {
			drivetrain.setDriveMode(DriveMode.TANK);
		}
	}
		

	@Override
	protected boolean isFinished() {
		return true;
	}

	@Override
	protected void end() {
		
	}
}
