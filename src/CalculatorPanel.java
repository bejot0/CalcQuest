import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorPanel extends JPanel implements ActionListener {

    private JTextField display;
    private final String CLEAR = "C";
    private String operation;

    public CalculatorPanel() {

        initLayout();
        initComponents();
    }

    private void initLayout() {

        setLayout(new BorderLayout());
    }

    private void initComponents() {

        display = new JTextField();
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.CENTER);
        add(display, BorderLayout.NORTH);

        JPanel panelForButtons = new JPanel();
        panelForButtons.setLayout(new GridLayout(4, 4));

        String operation = "789/"
                + "456*"
                + "123-"
                + "=0.+";


        for (int it = 0; it < operation.length(); it++) {
            JButton button = new JButton(String.valueOf(operation.charAt(it)));
            button.addActionListener(this);
            button.setPreferredSize(new Dimension(50, 50));
            button.setBorder(new LineBorder(Color.DARK_GRAY,4,true));
            panelForButtons.add(button);
        }


        add(panelForButtons, BorderLayout.CENTER);
        panelForButtons.setBackground(Color.magenta);

        JButton clearButton = new JButton(CLEAR);
        clearButton.addActionListener(this);
        add(clearButton,BorderLayout.SOUTH);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String prev = display.getText();



        String sign = e.getActionCommand();

        if(CLEAR.equals(sign)){
            display.setText("");
            prev = "";
        }else if (
                (Character.isDigit(sign.charAt(0)) || ".".equals(sign))) {
            display.setText(prev.concat((sign)));
        } else if ("=".equals((sign))) {

            double result = getResultforCurrentArguements(prev);

            display.setText(String.format("%.10f", result));
            prev = "";

            operation= "";


        } else {
            if("".equals(operation)) {

            }

            operation = sign;

            display.setText(prev + " " + sign + " ");

        }
    }

    private double getResultforCurrentArguements(String prev) {
        String regx = new StringBuilder().append("\\").append(operation).toString();


        String [] args = prev.split(regx);
        Double arg1 = Double.parseDouble(args[0]);
        Double arg2 = Double.parseDouble(args[1]);

        return performOperation(arg1,arg2,operation);
    }

    private double performOperation(double arg1, double arg2, String operation){

        switch (operation){
            case "+" : return arg1 + arg2;
            case "-" : return arg1 - arg2;
            case "/" : return arg1 / arg2;
            case "*" : return arg1* arg2;


        }

        return 0.0;
    }
}