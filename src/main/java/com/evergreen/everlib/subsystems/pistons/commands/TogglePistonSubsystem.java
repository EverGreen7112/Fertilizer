package com.evergreen.everlib.subsystems.pistons.commands;

import java.util.List;

import com.evergreen.everlib.CommandEG;
import com.evergreen.everlib.subsystems.pistons.subsystems.PistonSubsystem;
import com.evergreen.everlib.utils.loggables.LoggableData;
import com.evergreen.everlib.utils.loggables.LoggableString;

/**TogglePistonSubsystem */
public class TogglePistonSubsystem extends CommandEG {

   PistonSubsystem m_pistons;
     
   public TogglePistonSubsystem(String name, PistonSubsystem pistons, boolean log) {
    super(name, log, pistons);
    m_pistons = pistons;
   }
  
   public TogglePistonSubsystem(String name, PistonSubsystem pistons) {
      this(name, pistons, false);
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
