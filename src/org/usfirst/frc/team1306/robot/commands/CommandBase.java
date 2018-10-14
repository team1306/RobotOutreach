package org.usfirst.frc.team1306.robot.commands;

import org.usfirst.frc.team1306.robot.OI;
import org.usfirst.frc.team1306.robot.subsystems.Catapult;
import org.usfirst.frc.team1306.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.command.Command;

/**
 * @CommandBase
 * 
 * This class is the abstract for all other commands. This static class contains instances of all the subsystems and the OI class 
 * so that each command that extends this class can have access to the subsystems.
 * 
 * @authors Jackson Goth, Sam Roquitte, and Ethan Dong
 */
public abstract class CommandBase extends Command {

	protected static Drivetrain drivetrain;
	protected static Catapult catapult;
	protected static OI oi;
	
	public static void init() {
		
		drivetrain = new Drivetrain();
		catapult = new Catapult();
		
		oi = new OI(); //OI is always initialized last
	}
}
