package frc.robot.Subsystems.Grabber;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Subsystems.Grabber.commands.UseGrabber;


public class Grabber extends SubsystemBase {
    public DoubleSolenoid grabberPiston;
    public boolean grabberClosed;

    public Grabber() {
        this.grabberPiston = new DoubleSolenoid(PneumaticsModuleType.REVPH, Constants.Grabber.kPistonDeploy, Constants.Grabber.kPistonRetract);
        //grabberPiston.set(Value.kReverse);
        grabberClosed = false;
        //initDefaultCommand();
    } 

    @Override
    public void periodic() {
        SmartDashboard.putString("solenoid state", grabberPiston.get().toString());
    }
    public void toggleDeploy() {
        grabberPiston.toggle();
    
    }

    public void setDeploy() {
        grabberPiston.set(Value.kForward);

    }

    public void setRetract() {
        grabberPiston.set(Value.kReverse);
    }

    public void initDefaultCommand(){
        setDefaultCommand(new UseGrabber(this));
    }

    public Value getPosition() {
        return grabberPiston.get();
    }




}
