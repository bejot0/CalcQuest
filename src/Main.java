import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        JFrame calcframe = new JFrame ("Calculator pro");



        calcframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        calcframe.add(new CalculatorPanel());
        Dimension minDimension = new Dimension(200, 200);
        calcframe.setMinimumSize(minDimension);
        //calcframe.setMaximumSize(minDimension);
        calcframe.pack();
        calcframe.setVisible(true);
    }
}
