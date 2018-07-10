package xyz.rashidul.intelij.fontawesomesnippets;

import javax.swing.*;
import java.awt.*;

class PopupCellRenderer extends DefaultListCellRenderer {

    private static final long serialVersionUID = 1L;
    Font font;

    public PopupCellRenderer(Font font) {
        setOpaque(true);
        this.font = font;
    }

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
                                                  boolean cellHasFocus) {

        FontIcon fontIcon = (FontIcon) value;
        JPanel jPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JLabel c = new JLabel(fontIcon.getCode());
        c.setFont(font);
        JLabel text = new JLabel(fontIcon.getName());
        jPanel.add(c);
        jPanel.add(text);

        if (isSelected) {
            jPanel.setBackground(Color.BLUE);
        }
        return jPanel;
    }
}
