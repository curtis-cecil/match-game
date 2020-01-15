import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MemoryGame extends JFrame {
    public int guessesMade = 0;
    Board board;

    public static void main(String[] args){
        new MemoryGame();
    }

    public MemoryGame(){
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) { }

        JFrame frame = new JFrame("Memory Game");
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        frame.add(mainPanel);

        setMenu(mainPanel);
        setBoard(mainPanel);

        frame.setVisible(true);
        frame.pack();
    }

    void setMenu(JPanel targetPanel) {
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new FlowLayout());

        JButton startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                board.hideCards();
                startButton.setEnabled(false);
            }
        });
        menuPanel.add(startButton);

        JButton restartButton = new JButton("Restart");
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                targetPanel.removeAll();
                setMenu(targetPanel);
                setBoard(targetPanel);
                targetPanel.revalidate();
            }
        });
        menuPanel.add(restartButton);

        JLabel guessesLabel = new JLabel("Guesses: "+guessesMade);
        menuPanel.add(guessesLabel);

        targetPanel.add(menuPanel);
    }

    void setBoard(JPanel targetPanel){
        int boardRows = 5;
        int boardCols = 5;

        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(boardRows, boardCols));

        board = new Board();
        board.revealCards();
        board.addBoard(boardPanel);

        targetPanel.add(boardPanel);
    }
}
