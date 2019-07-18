import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Calculator {
    private JPanel rootPanel = new JPanel(new GridBagLayout(), true);

    private JButton hamburgerMenu = new JButton("M");
    private JLabel programmer = new JLabel("Programmer");
    private JLabel expressionLabel = new JLabel("0");
    private JLabel hex = new JLabel("HEX");
    private JLabel hexLabel = new JLabel("0");
    private JLabel dec = new JLabel("DEC");
    private JLabel decLabel = new JLabel("0");
    private JLabel bin = new JLabel("BIN");
    private JLabel binLabel = new JLabel("0");
    private JButton upArrow = new JButton("↑");
    private JButton mod = new JButton("Mod");
    private JButton keyCE = new JButton("CE");
    private JButton keyClear = new JButton("C");
    private JButton delete = new JButton("⌫");
    private JButton div = new JButton("÷");
    private JButton keyA = new JButton("A");
    private JButton keyB = new JButton("B");
    private JButton key7 = new JButton("7");
    private JButton key8 = new JButton("8");
    private JButton key9 = new JButton("9");
    private JButton mul = new JButton("✕");
    private JButton keyC = new JButton("C");
    private JButton keyD = new JButton("D");
    private JButton key4 = new JButton("4");
    private JButton key5 = new JButton("5");
    private JButton key6 = new JButton("6");
    private JButton sub = new JButton("-");
    private JButton keyE = new JButton("E");
    private JButton keyF = new JButton("F");
    private JButton key1 = new JButton("1");
    private JButton key2 = new JButton("2");
    private JButton key3 = new JButton("3");
    private JButton add = new JButton("+");
    private JButton openParen = new JButton("(");
    private JButton closeParen = new JButton(")");
    private JButton neg = new JButton("±");
    private JButton key0 = new JButton("0");
    private JButton point = new JButton(".");
    private JButton equal = new JButton("=");

    private JButton[] padButtons = new JButton[]{upArrow, mod, keyCE, keyClear, delete, div, keyA, keyB, key7, key8, key9, mul, keyC, keyD, key4, key5, key6, sub, keyE, keyF, key1, key2, key3, add, openParen, closeParen, neg, key0, point, equal};
    private JButton[] valueKeys = new JButton[]{key0, key1, key2, key3, key4, key5, key6, key7, key8, key9, keyA, keyB, keyC, keyD, keyE, keyF};
    private JButton[] numKeys = new JButton[]{key0, key1, key2, key3, key4, key5, key6, key7, key8, key9};
    private JButton[] letterKeys = new JButton[]{keyA, keyB, keyC, keyD, keyE, keyF};
    private JButton[] otherKeys = new JButton[]{upArrow, mod, keyCE, keyClear, delete, div, mul, sub, add, openParen, closeParen, neg, point, equal};

    private StringBuilder currentNumber = new StringBuilder();
    private ArrayList<String> fullExpression = new ArrayList<String>();
    private long currentResult = 0;
    private boolean resultWasLast = false;

    private String listToString(ArrayList<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s);
            sb.append(" ");
        }
        return sb.toString();
    }

    private Calculator() {
        setupUI();
        ActionListener keyPadListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                Object src = event.getSource();
                if (resultWasLast) {
                    resultWasLast = false;
                    currentNumber.setLength(0);
                    fullExpression.clear();
                    expressionLabel.setText("0");
                }
                if (src == mod) {
                    if (currentNumber.length() > 0) {
                        fullExpression.add(currentNumber.toString());
                        currentNumber.setLength(0);
                    }
                    fullExpression.add("%");
                } else if (src == keyCE) {
                } else if (src == keyClear) {
                    currentNumber.setLength(0);
                    fullExpression.clear();
                    expressionLabel.setText("0");
                    return;
                } else if (src == delete) {
                } else if (src == div) {
                    if (currentNumber.length() > 0) {
                        fullExpression.add(currentNumber.toString());
                        currentNumber.setLength(0);
                    }
                    fullExpression.add("/");
                } else if (src == keyA) currentNumber.append("A");
                else if (src == keyB) currentNumber.append("B");
                else if (src == key7) currentNumber.append("7");
                else if (src == key8) currentNumber.append("8");
                else if (src == key9) currentNumber.append("9");
                else if (src == mul) {
                    if (currentNumber.length() > 0) {
                        fullExpression.add(currentNumber.toString());
                        currentNumber.setLength(0);
                    }
                    fullExpression.add("*");
                } else if (src == keyC) currentNumber.append("C");
                else if (src == keyD) currentNumber.append("D");
                else if (src == key4) currentNumber.append("4");
                else if (src == key5) currentNumber.append("5");
                else if (src == key6) currentNumber.append("6");
                else if (src == sub) {
                    if (currentNumber.length() > 0) {
                        fullExpression.add(currentNumber.toString());
                        currentNumber.setLength(0);
                    }
                    fullExpression.add("-");
                } else if (src == keyE) currentNumber.append("E");
                else if (src == keyF) currentNumber.append("F");
                else if (src == key1) currentNumber.append("1");
                else if (src == key2) currentNumber.append("2");
                else if (src == key3) currentNumber.append("3");
                else if (src == add) {
                    if (currentNumber.length() > 0) {
                        fullExpression.add(currentNumber.toString());
                        currentNumber.setLength(0);
                    }
                    fullExpression.add("+");
                } else if (src == openParen) {
                    if (currentNumber.length() > 0) {
                        fullExpression.add(currentNumber.toString());
                        currentNumber.setLength(0);
                    }
                    fullExpression.add("(");
                } else if (src == closeParen) {
                    if (currentNumber.length() > 0) {
                        fullExpression.add(currentNumber.toString());
                        currentNumber.setLength(0);
                    }
                    fullExpression.add(")");
                } else if (src == neg) {
                    if (currentNumber.charAt(0) == '-') currentNumber.deleteCharAt(0);
                    else currentNumber.insert(0, "-");
                } else if (src == key0) {
                    if (!(currentNumber.length() == 1 && currentNumber.charAt(0) == '0')) {
                        currentNumber.append("0");
                    }
                } else if (src == equal) {
                    if (currentNumber.length() > 0) {
                        fullExpression.add(currentNumber.toString());
                        currentNumber.setLength(0);
                    }
                    getResult();
                    resultWasLast = true;
                }
                expressionLabel.setText(currentNumber.length() == 0 ? "0" : currentNumber.toString());
                System.out.println(listToString(fullExpression));
            }
        };
        for (JButton padButton : padButtons) {
            padButton.addActionListener(keyPadListener);
        }
    }

    private void getResult() {
        /* maps operators to their precedence value */
        final Map<String, Integer> operatorPrecedence = new HashMap<String, Integer>() {{
            put("*", 1);
            put("/", 1);
            put("%", 1);
            put("+", 0);
            put("-", 0);
        }};
        ArrayList<String> outputQueue = new ArrayList<String>();
        Stack<Double> outputStack = new Stack<Double>();
        Stack<String> operatorStack = new Stack<String>();

        for (String token : fullExpression) {
            if (token.matches("^-?\\d+(\\d+)?$")) {
                outputQueue.add(token);
            } else if (token.matches("^[%/*\\-+]$")) {
                while (!operatorStack.empty()
                        && operatorStack.peek().matches("^[%/*\\-+]$")
                        && operatorPrecedence.get(operatorStack.peek()) >= operatorPrecedence.get(token)
                        && !operatorStack.peek().equals("(")) {
                    outputQueue.add(operatorStack.pop());
                }
                operatorStack.push(token);
            } else if (token.equals("(")) {
                operatorStack.push(token);
            } else if (token.equals(")")) {
                while (!operatorStack.empty() &&
                        !operatorStack.peek().equals("(")) {
                    outputQueue.add(operatorStack.pop());
                }
                if (operatorStack.peek().equals("(")) {
                    operatorStack.pop();
                }
            }
        }
        while (!operatorStack.empty()) {
            outputQueue.add(operatorStack.pop());
        }
        Double operand1;
        Double operand2;
        for (String token : outputQueue) {
            if (token.equals("%")) {
                operand1 = outputStack.pop();
                operand2 = outputStack.pop();
                outputStack.push(operand2 % operand1);
            } else if (token.equals("/")) {
                operand1 = outputStack.pop();
                operand2 = outputStack.pop();
                outputStack.push(operand2 / operand1);
            } else if (token.equals("*")) {
                operand1 = outputStack.pop();
                operand2 = outputStack.pop();
                outputStack.push(operand2 * operand1);
            } else if (token.equals("-")) {
                operand1 = outputStack.pop();
                operand2 = outputStack.pop();
                outputStack.push(operand2 - operand1);
            } else if (token.equals("+")) {
                operand1 = outputStack.pop();
                operand2 = outputStack.pop();
                outputStack.push(operand2 + operand1);
            } else if (token.matches("^-?\\d+(\\d+)?$")) {
                outputStack.push(Double.parseDouble(token));
            }
        }
    }

    private void setFonts(Font font) {
    }

    private void setupUI() {
        rootPanel.setBackground(new Color(-1644826));
        Color buttonBackground = new Color(-328966);
//      Font font = getFont("Segoe UI", Font.PLAIN, 14, a6Button.getFont());
        for (JButton padButton : padButtons) {
            padButton.setBackground(buttonBackground);
        }
        rootPanel.add(hamburgerMenu, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
        rootPanel.add(programmer, new GridBagConstraints(1, 0, GridBagConstraints.REMAINDER, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
        rootPanel.add(expressionLabel, new GridBagConstraints(0, 1, GridBagConstraints.REMAINDER, 1, 0, 0, GridBagConstraints.LINE_END, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
        rootPanel.add(hex, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
        rootPanel.add(hexLabel, new GridBagConstraints(1, 2, GridBagConstraints.REMAINDER, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
        rootPanel.add(dec, new GridBagConstraints(0, 3, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
        rootPanel.add(decLabel, new GridBagConstraints(1, 3, GridBagConstraints.REMAINDER, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
        rootPanel.add(bin, new GridBagConstraints(0, 4, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
        rootPanel.add(binLabel, new GridBagConstraints(1, 4, GridBagConstraints.REMAINDER, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
        for (int i = 0; i < padButtons.length; i++) {
            rootPanel.add(padButtons[i], new GridBagConstraints((i % 6), (i / 6) + 5, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
        }
        for (JButton letterKey : letterKeys) {
            letterKey.setEnabled(false);
        }
        hamburgerMenu.setEnabled(false);
        point.setEnabled(false);
    }

    private Font getFont(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        return new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Set up the content pane.
        frame.setContentPane(new Calculator().rootPanel);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
