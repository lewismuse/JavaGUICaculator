/**
 * <h1>Simple GUI Calculator</h1>
 * The simple calculator program implements an application that
 * simply can do add, minus, multiply, divide, power, and etc.
 *
 *
 * @author  Guangyuan Cai (Lewis)
 * @version 1.0
 * @since   2017-08-23
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;





public class CalculatorGUI {
    private JButton buttonNum;
    JButton buttonClear;
    JButton buttonOP;

    JTextField textShow;
    private JButton buttonOPS;


    boolean startNumber = true;
    String previousOp = "=";
    CalcLogic logic = new CalcLogic();


    ActionListener opListener = new OpListener();
    ActionListener numListener = new NumListener();
    ActionListener clearListener = new ClearListener();
    ActionListener opsListener = new OpsListener();







    public static void main (String[] args) {
        CalculatorGUI gui = new CalculatorGUI();
        gui.init();
    }




    public void init() {
        JFrame frame = new JFrame();
        int calWidth = 233;

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(calWidth,340);
        frame.setVisible(true);
        frame.setResizable(false);

        //north
        /**
         * north panel
         */

        JPanel northPanel = new JPanel();
        northPanel.setBackground(Color.gray);
        textShow = new JTextField("0");

        textShow.setPreferredSize(new Dimension(calWidth, 40));

        textShow.setHorizontalAlignment(JTextField.RIGHT);

        textShow.setEditable(false);
        northPanel.add(textShow);

        frame.add(northPanel, BorderLayout.NORTH);

        //center
        /**
         * center panel
         */

        JPanel centerPanel = new JPanel();

        centerPanel.setBackground(Color.gray);


        centerPanel.setPreferredSize(new Dimension(50, 0));


        String[] arrayA = { "AC", "±", "%",  "7", "8", "9",  "4", "5", "6",  "1",

                "2", "3",  "0", ".", "√","^"};
        buttonClear = new JButton(arrayA[0]);
        buttonClear.setPreferredSize(new Dimension(40,40));
        buttonClear.addActionListener(clearListener);
        centerPanel.add(buttonClear);
        for (int i = 1; i < 3; i++) {
            buttonOPS = new JButton(arrayA[i]);
            buttonOPS.setPreferredSize(new Dimension(40,40));
            buttonOPS.addActionListener(opsListener);
            centerPanel.add(buttonOPS);
        }



        for (int j = 3; j < arrayA.length-2; j++) {

            buttonNum = new JButton(arrayA[j]);


            buttonNum.setPreferredSize(new Dimension(40, 40));

            buttonNum.addActionListener(numListener);
            centerPanel.add(buttonNum);



        }

        buttonOPS = new JButton(arrayA[14]);
        buttonOPS.setPreferredSize(new Dimension(40,40));
        buttonOPS.addActionListener(opsListener);
        centerPanel.add(buttonOPS);


        buttonOP = new JButton(arrayA[15]);
        buttonOP.setPreferredSize(new Dimension(130,40));
        buttonOP.addActionListener(opListener);
        centerPanel.add(buttonOP);


        frame.add(centerPanel, BorderLayout.CENTER);





        /**
         * east panel
         */

        JPanel eastPanel = new JPanel();

        eastPanel.setBackground(Color.orange);

        eastPanel.setPreferredSize(new Dimension(70, 0));

        String[] arrayB = { "/", "x", "-", "+", "=" };

        for (int i = 0; i < arrayB.length; i++) {


            buttonOP = new JButton(arrayB[i]);



            buttonOP.setPreferredSize(new Dimension(40, 40));


            buttonOP.addActionListener(opListener);
            eastPanel.add(buttonOP);


        }

        frame.add(eastPanel, BorderLayout.EAST);

        frame.setVisible(true);


    }


    class OpListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (startNumber) {
                actionClear();
                textShow.setText("Error!");
            }
            else {
                startNumber = true;
                String text = textShow.getText();

                if (previousOp.equals("=")) {
                    logic.setTotal(text);
                }
                else if (previousOp.equals("+")) {
                    logic.add(text);
                }
                else if (previousOp.equals("-")) {
                    logic.sub(text);
                }
                else if (previousOp.equals("x")) {
                    logic.mutiply(text);
                }
                else if (previousOp.equals("/")) {

                    logic.divide(text);
                }
                else if (previousOp.equals("^")) {
                    logic.power(text);
                }

                textShow.setText(" " + logic.getTotalString());
                previousOp = event.getActionCommand();
            }
        }
    }

    class NumListener implements ActionListener {
        public  void actionPerformed(ActionEvent event) {
            String digit = event.getActionCommand();
            if (startNumber) {
                textShow.setText(digit);
                startNumber = false;
            }
            else {
                textShow.setText(textShow.getText() + digit);
            }
        }
    }

    /**
     * Clear function
     */
    public void actionClear () {
        startNumber = true;
        textShow.setText("0");
        previousOp = "=";
        logic.setTotal("0");
    }
    class ClearListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            actionClear();
        }
    }


    class OpsListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String text = textShow.getText();
            previousOp = event.getActionCommand();
            if (previousOp.equals("%")) {
                logic.percentage(text);
            }
            else if (previousOp.equals("±")){
                logic.positveNective(text);
            }
            else if (previousOp.equals("√")) {
                logic.squareroot(text);
            }
            textShow.setText(" " + logic.getTotalString());
            previousOp = event.getActionCommand();
        }
    }


}

