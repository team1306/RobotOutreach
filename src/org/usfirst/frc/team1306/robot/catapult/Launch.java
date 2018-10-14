package org.usfirst.frc.team1306.robot.catapult;

import org.usfirst.frc.team1306.robot.commands.CommandBase;

public class Launch extends CommandBase{
	
	@Override
	protected void execute() {
		catapult.actuate();
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}
}
