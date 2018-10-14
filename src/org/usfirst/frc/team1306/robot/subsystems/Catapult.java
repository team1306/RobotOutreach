package org.usfirst.frc.team1306.robot.subsystems;

import org.usfirst.frc.team1306.robot.Constants;
import org.usfirst.frc.team1306.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Catapult extends Subsystem{

	private DoubleSolenoid launchSolenoid;
	
	public Catapult() {
		launchSolenoid = new DoubleSolenoid(RobotMap.CATAPULT_SOLENOID_CHANNEL_ONE, RobotMap.CATAPULT_SOLENOID_CHANNEL_TWO);
	}
	
	public void actuate() {
		if (Constants.CATAPULT_ENABLED) {
			launchSolenoid.set(DoubleSolenoid.Value.kForward);
		}
	}
	
	public void retract() {
		if (Constants.CATAPULT_ENABLED) {
			launchSolenoid.set(DoubleSolenoid.Value.kReverse);
		}
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
}
