package com.evergreen.fertilizer.subsystems.pistons.commands;

import java.util.List;

import com.evergreen.fertilizer.subsystems.EvergreenCommand;
import com.evergreen.fertilizer.subsystems.pistons.subsystems.PistonSubsystem;
import com.evergreen.fertilizer.shuffleboard.loggables.LoggableData;
import com.evergreen.fertilizer.shuffleboard.loggables.LoggableString;

/**TogglePistonSubsystem */
public class TogglePistonSubsystem extends EvergreenCommand {

   PistonSubsystem m_pistons;
  
   public TogglePistonSubsystem(String name, PistonSubsystem pistons) {
    super(name, pistons);
    m_pistons = pistons;
   }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
      m_pistons.toggle();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished()  {
    return true;
  }


  @Override
  public List<LoggableData> getLoggableData() {
    List<LoggableData> loggables = super.getLoggableData();
    loggables.add(new LoggableString(getName() + " - subsystem", m_pistons::getName));

    return loggables;
  }
}
