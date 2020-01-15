import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Card extends JButton{
    private ImageIcon hiddenCardIcon;
    private String iconName = "";
    private boolean clickedLast = false;
    private int height = 50;
    private int width = 50;

    public Card(){
        super();

        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setCardIcon(hiddenCardIcon);
                clickedLast = true;

            }
        });

        this.setPreferredSize(new Dimension(height, width));
    }

    void setCardIcon(ImageIcon newCardIcon){
        this.setIcon(newCardIcon);
    }

    void setHiddenCardIcon(ImageIcon newHiddenIcon){
        this.hiddenCardIcon = newHiddenIcon;
    }

    ImageIcon getHiddenCardIcon(){
        return this.hiddenCardIcon;
    }

    boolean getClickedLast(){
        return this.clickedLast;
    }

    void setIconName(String name){
        this.iconName = name;
    }

    String getIconName(){
        return this.iconName;
    }
}
