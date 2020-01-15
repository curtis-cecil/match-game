import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Board {
    int rows = 5;
    int cols = 5;
    Card lastClickedCard = new Card();
    Card cards[][] = new Card[rows][cols];
    private String iconNames[] = {"icons8-steven-universe-48.png","icons8-chinese-noodle-50.png","icons8-chocolate-bar-50.png","icons8-cookie-50.png","icons8-croissant-50.png","icons8-cupcake-50.png","icons8-french-fries-50.png","icons8-hot-dog-50.png","icons8-ice-cream-cone-50.png","icons8-macaron-50.png","icons8-pie-50.png","icons8-sandwich-50.png","icons8-sushi-50.png","icons8-chinese-noodle-50.png","icons8-chocolate-bar-50.png","icons8-cookie-50.png","icons8-croissant-50.png","icons8-cupcake-50.png","icons8-french-fries-50.png","icons8-hot-dog-50.png","icons8-ice-cream-cone-50.png","icons8-macaron-50.png","icons8-pie-50.png","icons8-sandwich-50.png","icons8-sushi-50.png"};

    public Board(){
        iconNames = shuffleIcons(iconNames);
        int iconIndex = 0;
        ImageIcon newCardIcon;

        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                cards[row][col] = new Card();
                newCardIcon = new ImageIcon(getClass().getResource(iconNames[iconIndex]));
                cards[row][col].setHiddenCardIcon(newCardIcon);
                cards[row][col].setIconName(iconNames[iconIndex]);

                cards[row][col].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        Card clickedCard = (Card)actionEvent.getSource();
                        if(clickedCard.getIconName().equals(lastClickedCard.getIconName())){

                        }
                    }
                });

                iconIndex++;
            }
        }
    }

    void addBoard(JPanel targetPanel){
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                targetPanel.add(this.cards[row][col]);
            }
        }
    }

    String[] shuffleIcons(String icons[]){
        Random rand = new Random();

        for(int i = 0; i < rows*cols-1; i++){
            int randomIndex = rand.nextInt(rows*cols-1);
            String temp = icons[i];
            icons[i] = icons[randomIndex];
            icons[randomIndex] = temp;
        }

        return icons;
    }

    String setLastCardClicked(){
        String result = new String();

        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                if(cards[row][col].getClickedLast()){
                    result = cards[row][col].getIconName();
                }
            }
        }

        return result;
    }

    void revealCards(){
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                this.cards[row][col].setCardIcon(cards[row][col].getHiddenCardIcon());
            }
        }
    }

    void hideCards(){
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                this.cards[row][col].setCardIcon(new ImageIcon(getClass().getResource("icons8-roblox-50.png")));
            }
        }
    }
}
