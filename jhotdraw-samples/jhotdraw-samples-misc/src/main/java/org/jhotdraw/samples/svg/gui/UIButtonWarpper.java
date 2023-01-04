package org.jhotdraw.samples.svg.gui;

import javax.swing.*;
import java.awt.*;

public class UIButtonWarpper {
  private AbstractButton  btn;
  private GridBagConstraints gbc;

  public UIButtonWarpper(AbstractButton btn, GridBagConstraints gbc) {
    this.btn = btn;
    this.gbc = gbc;
  }

  public AbstractButton getBtn() {
    return btn;
  }

  public GridBagConstraints getGbc() {
    return gbc;
  }
}
