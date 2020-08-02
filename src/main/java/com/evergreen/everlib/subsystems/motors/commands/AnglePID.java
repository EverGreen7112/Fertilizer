package com.evergreen.everlib.subsystems.motors.commands;

import java.util.function.Supplier;

import com.evergreen.everlib.subsystems.motors.subsystems.MotorSubsystem;

/**
 * AnglePIDCommand
 */
public class AnglePID extends RunPID {

    public AnglePID(MotorSubsystem subsystem, Supplier<Double> setpoint) {
        super(
            subsystem.getName() + "/Angle PID",
            subsystem.getAnglePID(), 
            setpoint, 
            subsystem::rotate, 
            subsystem::getAngle,
            subsystem);
    }
    
}