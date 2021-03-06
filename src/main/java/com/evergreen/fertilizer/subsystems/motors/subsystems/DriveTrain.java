package com.evergreen.fertilizer.subsystems.motors.subsystems;

import java.util.Map;

import com.evergreen.fertilizer.oi.joysticks.EvergreenJoystick;
import com.evergreen.fertilizer.subsystems.motors.commands.TankDrive;
import com.evergreen.fertilizer.subsystems.sensors.DistanceSensor;

import edu.wpi.first.wpilibj.Joystick.AxisType;


/**
 * DriveTank
 */
public class DriveTrain extends MotorSubsystem {

    public DriveTrain(String name, MotorController leftMotors, MotorController rightMotors) {
        super(name, leftMotors, rightMotors);
    }

    public DriveTrain(String name, MotorController leftMotors, MotorController rightMotors, DistanceSensor sensor) {
        super(name, leftMotors, rightMotors);
    }

    public DriveTrain(String name, DistanceSensor sensor, MotorController leftMotors, MotorController rightMotors) {
        super(name, leftMotors, rightMotors);
    }

    public void drive(double leftSpeed, double rightSpeed) {
        set(Map.of(0, leftSpeed, 1, rightSpeed));
    }

    @Override
    public void rotate(double speed) {
        set(0, speed);
    }

    public void setDefaultByJoystick(EvergreenJoystick joystick, AxisType leftAxis, AxisType rightAxis) {
        setDefaultCommand(
            new TankDrive(
                getName() + " default command (drive tank by joystick)", 
                this,
                () -> joystick.getRawAxis(leftAxis),
                () -> joystick.getRawAxis(rightAxis)));
    }
}