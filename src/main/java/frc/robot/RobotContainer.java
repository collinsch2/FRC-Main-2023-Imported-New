package frc.robot;

import edu.wpi.first.wpilibj.PneumaticHub;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.PrintCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.robot.Subsystems.Grabber.Grabber;
import frc.robot.Subsystems.Grabber.Pneumatics;
import frc.robot.Subsystems.Grabber.commands.UseGrabber;
import frc.robot.util.XboxController;
import frc.robot.util.XboxController.Button;

public class RobotContainer {
  private final XboxController manipulatorController = new XboxController(0);
  private final Grabber grabber = new Grabber();
  //private final UseGrabber uGrabber = new UseGrabber(grabber);
  private final Pneumatics pneumatics = new Pneumatics();

  
  public RobotContainer() {
    configureButtonBindings();
  }
  
  private void configureButtonBindings() {
    manipulatorController.whenPressed(XboxController.Button.B, new InstantCommand(() -> {
      grabber.setDeploy();
    }));

    manipulatorController.whenPressed(XboxController.Button.X, new InstantCommand(() -> {
      grabber.setRetract();
    }));
    
    manipulatorController.whenPressed(XboxController.Button.A, new InstantCommand(() -> {
      grabber.toggleDeploy();
    }));
  }

  public Command getAutonomousCommand() {
    return new PrintCommand("No Auto Written Yet");
  }

  public void doSendables(){
    SmartDashboard.putString("Solenoid value", grabber.getPosition().name());
  } 

}