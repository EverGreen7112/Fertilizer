package com.evergreen.everlib.shuffleboard.constants.commands;

import java.util.List;

import com.evergreen.everlib.shuffleboard.constants.ConstantBoolean;
import com.evergreen.everlib.shuffleboard.loggables.LoggableData;
import com.evergreen.everlib.shuffleboard.loggables.LoggableString;
import com.evergreen.everlib.utils.InstantEvergreenCommand;

/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

/**A command that sets a {@link ConstantBoolean shuffleboard switch} an input value. <p>
 * This command has a shuffleboard switch (set at constucion), which, if diabled,
 * will stop this command from running.
 * 
 * @author Atai Ambus
*/
public class SetSwitch extends InstantEvergreenCommand {

  private String m_switchPath;

  /**
   * Constructs a command that sets the input switches at input value
   * 
   * @param name - The name of this command and its shuffleboard switch.
   * @param value - The value to set the switches
   * @param switches - The switches to set.
   */
  public SetSwitch(String name, ConstantBoolean booleanSwitch, boolean value) {
    this(name, booleanSwitch, () -> value);
  }


  public SetSwitch(String name, ConstantBoolean booleanSwitch, Supplier<Boolean> valueSupplier) {
    super(name, () -> booleanSwitch.set(valueSupplier.get()));
    m_switchPath = booleanSwitch.getPath();
  }


  @Override
  public List<LoggableData> getLoggableData() {
    //Here - the path of the switch to set
      return List.of(new LoggableString(
        "switch to set",
        () -> m_switchPath));
  }

}
