package org.jhotdraw.samples.svg.gui;

import org.jhotdraw.draw.AttributeKey;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.tool.CreationTool;
import org.jhotdraw.gui.action.ButtonFactory;
import org.jhotdraw.gui.plaf.palette.PaletteButtonUI;
import org.jhotdraw.samples.svg.figures.SVGRectFigure;
import org.jhotdraw.util.ResourceBundleUtil;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class ButtonUIFactory {

 /* public static UIButtonWarpper createUIButton(String type,JToolBar tb, DrawingEditor editor, CreationTool creationTool, ResourceBundleUtil labels){
    HashMap<ButtonFactory, GridBagConstraints> product = new HashMap<>();
    AbstractButton btn;
    if(type.equalsIgnoreCase("createRectangle")){
      return new UIButtonWarpper(createAbstractButton(tb,editor,creationTool,labels),createGridBagConstraints(0,0,0,0,0,0));
    }
    if(type.equalsIgnoreCase("createEllipse")){

    }

  }



  private static AbstractButton createAbstractButton(JToolBar tb, DrawingEditor editor, CreationTool creationTool, ResourceBundleUtil labels){
    HashMap<AttributeKey<?>, Object> attributes = new HashMap<AttributeKey<?>, Object>();
    AbstractButton btn = ButtonFactory.addToolTo(tb, editor, creationTool = new CreationTool(new SVGRectFigure(),attributes), "createRectangle", labels);
    creationTool.setToolDoneAfterCreation(false);
    btn.setUI((PaletteButtonUI) PaletteButtonUI.createUI(btn));
    return btn;

  }
  private static AbstractButton createAbstractButton(JToolBar tb, DrawingEditor editor, CreationTool creationTool, ResourceBundleUtil labels){
    HashMap<AttributeKey<?>, Object> attributes = new HashMap<AttributeKey<?>, Object>();
    AbstractButton btn = ButtonFactory.addToolTo(tb, editor, creationTool = new CreationTool(new SVGRectFigure(),attributes), "createRectangle", labels);
    creationTool.setToolDoneAfterCreation(false);
    btn.setUI((PaletteButtonUI) PaletteButtonUI.createUI(btn));
    return btn;

  }
*/




  private static GridBagConstraints createGridBagConstraints(int x,int y, int top, int left, int bottom, int right){
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = x;
    gbc.gridy = y;
    gbc.insets = new Insets(top, left, bottom, right);
    return gbc;
  }
}
