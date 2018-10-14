package org.usfirst.frc.team1306.robot;

/**
 * @RobotMap
 * 
 * The RobotMap is a mapping from the ports sensors and actuators are wired into to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers floating around.
 * 
 * @authors Jackson Goth, Sam Roquitte, and Ethan Dong
 */
public class RobotMap {
	
	/** OI Ports */
	public static final int PRIMARY_PORT = 0;
	public static final int SECONDARY_PORT = 1;

	/*Drivetrain Ports*/
	public static final int LEFT_FRONT_PORT = 0;
	public static final int RIGHT_FRONT_PORT = 1;
	public static final int LEFT_BACK_PORT = 2;
	public static final int RIGHT_BACK_PORT = 3;
	
	/*Catapult Ports*/
	public static final int CATAPULT_SOLENOID_CHANNEL_ONE = 0;
	public static final int CATAPULT_SOLENOID_CHANNEL_TWO = 1;
}

