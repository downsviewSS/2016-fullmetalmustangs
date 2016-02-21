
package robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	RobotDrive Drive = new RobotDrive(8,9); 
	Joystick driverJoystick = new Joystick(0);
	Joystick Control = new Joystick(1);	
	Talon Shooter = new Talon(2);
	Talon Intake = new Talon(6);
	Talon Arm = new Talon(3);
	Victor Intake2 = new Victor(4);
	int autoLoopCounter;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		autoLoopCounter=200;
	}


	public void autonomousInit() {
		autoLoopCounter = 0;
	}
        
		
	//5400

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		while(isAutonomous() && isEnabled()){
			if(autoLoopCounter < 10850) //Check if we've completed 5000 loops (approximately ... seconds)
			{
				Drive.drive(-0.35, 0.0); 	// drive forwards 3/4 speed
				autoLoopCounter++;
				//Drive.drive(-0.1,0.5);// turn right
				//autoLoopCounter++;
				//Drive.drive(-0.5,0.0);// turn right
			}else{
				//Intake.set(1.0);//release boulder
				Drive.drive(0.0,0.0);
			}}}
			
	


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {

		double LeftJ  = driverJoystick.getRawAxis(1);    
		double RightJ = driverJoystick.getRawAxis(3);    
		Drive.tankDrive(LeftJ, RightJ);

		if (Control.getRawButton(5)) { //In take 
			Intake.set(1.0);
		}
		else if (Control.getRawButton(4)){ // release
			Intake.set(-1.0);
		}  
		else{
			Intake.set(0.0);
		}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		
		if (Control.getTrigger()){//shoot
			Intake.set(1.0);
			Shooter.set(-1.0);
		}
		else if(Control.getRawButton(3)){//OPT RELEASE
			Intake.set(-1.0);
			Shooter.set(1.0);
		}
		else{
			Intake.set(0.0);
			Shooter.set(0.0);
		}}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	





	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {

	}

}

