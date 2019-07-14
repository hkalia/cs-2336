import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {
    private StringBuilder currentExpression = new StringBuilder();
    private StringBuilder fullExpression = new StringBuilder();
    private ScriptEngineManager manager = new ScriptEngineManager();
    private ScriptEngine engine = manager.getEngineByName("JavaScript");
    private boolean result = false;

    private JPanel rootPanel;
    private JButton a6Button;
    private JButton a3Button;
    private JButton a9Button;
    private JButton a5Button;
    private JButton a8Button;
    private JButton a2Button;
    private JButton a4Button;
    private JButton a7Button;
    private JButton a1Button;
    private JButton a0Button;
    private JLabel expressionLabel;
    private JButton dButton;
    private JButton cButton;
    private JButton ceButton;
    private JButton divButton;
    private JButton mulButton;
    private JButton subButton;
    private JButton addButton;
    private JButton equalButton;
    private JButton pointButton;
    private JButton negButton;

    public Calculator() {
        ActionListener keyPadListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.out.println(fullExpression.toString());
                Object src = event.getSource();
                if (result) {
                    currentExpression.setLength(0);
                    fullExpression.setLength(0);
                    result = false;
                }
                if (src == a0Button) currentExpression.append("0");
                else if (src == a1Button) currentExpression.append("1");
                else if (src == a2Button) currentExpression.append("2");
                else if (src == a3Button) currentExpression.append("3");
                else if (src == a4Button) currentExpression.append("4");
                else if (src == a5Button) currentExpression.append("5");
                else if (src == a6Button) currentExpression.append("6");
                else if (src == a7Button) currentExpression.append("7");
                else if (src == a8Button) currentExpression.append("8");
                else if (src == a9Button) currentExpression.append("9");
                else if (src == dButton) {
                    if (currentExpression.length() > 0) {
                        currentExpression.setLength(currentExpression.length() - 1);
                    }
                } else if (src == cButton) {
                    currentExpression.setLength(0);
                    fullExpression.setLength(0);
                } else if (src == ceButton) currentExpression.setLength(0);
                else if (src == addButton) {
                    if (currentExpression.length() > 0) {
                        fullExpression.append(currentExpression);
                        fullExpression.append("+");
                        currentExpression.setLength(0);
                    }
                } else if (src == subButton) {
                    if (currentExpression.length() > 0) {
                        fullExpression.append(currentExpression);
                        fullExpression.append("-");
                        currentExpression.setLength(0);
                    }
                } else if (src == mulButton) {
                    if (currentExpression.length() > 0) {
                        fullExpression.append(currentExpression);
                        fullExpression.append("*");
                        currentExpression.setLength(0);
                    }
                } else if (src == divButton) {
                    if (currentExpression.length() > 0) {
                        fullExpression.append(currentExpression);
                        fullExpression.append("/");
                        currentExpression.setLength(0);
                    }
                } else if (src == equalButton) {
                    if (currentExpression.length() > 0) {
                        fullExpression.append(currentExpression);
                        currentExpression.setLength(0);
                        try {
                            currentExpression.append(engine.eval(fullExpression.toString()));
                            result = true;
                        } catch (ScriptException e) {
                            e.getStackTrace();
                            currentExpression.append("error");
                        }
                    }
                }
                expressionLabel.setText(currentExpression.toString());
            }
        };
        a0Button.addActionListener(keyPadListener);
        a1Button.addActionListener(keyPadListener);
        a2Button.addActionListener(keyPadListener);
        a3Button.addActionListener(keyPadListener);
        a4Button.addActionListener(keyPadListener);
        a5Button.addActionListener(keyPadListener);
        a6Button.addActionListener(keyPadListener);
        a7Button.addActionListener(keyPadListener);
        a8Button.addActionListener(keyPadListener);
        a9Button.addActionListener(keyPadListener);
        dButton.addActionListener(keyPadListener);
        cButton.addActionListener(keyPadListener);
        ceButton.addActionListener(keyPadListener);
        addButton.addActionListener(keyPadListener);
        subButton.addActionListener(keyPadListener);
        mulButton.addActionListener(keyPadListener);
        divButton.addActionListener(keyPadListener);
        equalButton.addActionListener(keyPadListener);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(new Calculator().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        rootPanel = new JPanel();
        rootPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(6, 4, new Insets(0, 0, 0, 0), -1, -1));
        rootPanel.setBackground(new Color(-1644826));
        a6Button = new JButton();
        a6Button.setBackground(new Color(-328966));
        Font a6ButtonFont = this.$$$getFont$$$("Segoe UI", Font.PLAIN, 14, a6Button.getFont());
        if (a6ButtonFont != null) a6Button.setFont(a6ButtonFont);
        a6Button.setText("6");
        rootPanel.add(a6Button, new com.intellij.uiDesigner.core.GridConstraints(3, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        a3Button = new JButton();
        a3Button.setBackground(new Color(-328966));
        Font a3ButtonFont = this.$$$getFont$$$("Segoe UI", Font.PLAIN, 14, a3Button.getFont());
        if (a3ButtonFont != null) a3Button.setFont(a3ButtonFont);
        a3Button.setText("3");
        rootPanel.add(a3Button, new com.intellij.uiDesigner.core.GridConstraints(4, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        a9Button = new JButton();
        a9Button.setBackground(new Color(-328966));
        Font a9ButtonFont = this.$$$getFont$$$("Segoe UI", Font.PLAIN, 14, a9Button.getFont());
        if (a9ButtonFont != null) a9Button.setFont(a9ButtonFont);
        a9Button.setText("9");
        rootPanel.add(a9Button, new com.intellij.uiDesigner.core.GridConstraints(2, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        a5Button = new JButton();
        a5Button.setBackground(new Color(-328966));
        Font a5ButtonFont = this.$$$getFont$$$("Segoe UI", Font.PLAIN, 14, a5Button.getFont());
        if (a5ButtonFont != null) a5Button.setFont(a5ButtonFont);
        a5Button.setText("5");
        rootPanel.add(a5Button, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        a8Button = new JButton();
        a8Button.setBackground(new Color(-328966));
        Font a8ButtonFont = this.$$$getFont$$$("Segoe UI", Font.PLAIN, 14, a8Button.getFont());
        if (a8ButtonFont != null) a8Button.setFont(a8ButtonFont);
        a8Button.setText("8");
        rootPanel.add(a8Button, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        a2Button = new JButton();
        a2Button.setBackground(new Color(-328966));
        Font a2ButtonFont = this.$$$getFont$$$("Segoe UI", Font.PLAIN, 14, a2Button.getFont());
        if (a2ButtonFont != null) a2Button.setFont(a2ButtonFont);
        a2Button.setText("2");
        rootPanel.add(a2Button, new com.intellij.uiDesigner.core.GridConstraints(4, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        a4Button = new JButton();
        a4Button.setBackground(new Color(-328966));
        Font a4ButtonFont = this.$$$getFont$$$("Segoe UI", Font.PLAIN, 14, a4Button.getFont());
        if (a4ButtonFont != null) a4Button.setFont(a4ButtonFont);
        a4Button.setText("4");
        rootPanel.add(a4Button, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        a7Button = new JButton();
        a7Button.setBackground(new Color(-328966));
        Font a7ButtonFont = this.$$$getFont$$$("Segoe UI", Font.PLAIN, 14, a7Button.getFont());
        if (a7ButtonFont != null) a7Button.setFont(a7ButtonFont);
        a7Button.setText("7");
        rootPanel.add(a7Button, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        a1Button = new JButton();
        a1Button.setBackground(new Color(-328966));
        Font a1ButtonFont = this.$$$getFont$$$("Segoe UI", Font.PLAIN, 14, a1Button.getFont());
        if (a1ButtonFont != null) a1Button.setFont(a1ButtonFont);
        a1Button.setText("1");
        rootPanel.add(a1Button, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        a0Button = new JButton();
        a0Button.setBackground(new Color(-328966));
        Font a0ButtonFont = this.$$$getFont$$$("Segoe UI", Font.PLAIN, 14, a0Button.getFont());
        if (a0ButtonFont != null) a0Button.setFont(a0ButtonFont);
        a0Button.setText("0");
        rootPanel.add(a0Button, new com.intellij.uiDesigner.core.GridConstraints(5, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        dButton = new JButton();
        dButton.setBackground(new Color(-328966));
        Font dButtonFont = this.$$$getFont$$$("Segoe UI", Font.PLAIN, 14, dButton.getFont());
        if (dButtonFont != null) dButton.setFont(dButtonFont);
        dButton.setText("D");
        rootPanel.add(dButton, new com.intellij.uiDesigner.core.GridConstraints(1, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        cButton = new JButton();
        cButton.setBackground(new Color(-328966));
        Font cButtonFont = this.$$$getFont$$$("Segoe UI", Font.PLAIN, 14, cButton.getFont());
        if (cButtonFont != null) cButton.setFont(cButtonFont);
        cButton.setText("C");
        rootPanel.add(cButton, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        ceButton = new JButton();
        ceButton.setBackground(new Color(-328966));
        Font ceButtonFont = this.$$$getFont$$$("Segoe UI", Font.PLAIN, 14, ceButton.getFont());
        if (ceButtonFont != null) ceButton.setFont(ceButtonFont);
        ceButton.setText("CE");
        rootPanel.add(ceButton, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        divButton = new JButton();
        divButton.setBackground(new Color(-328966));
        Font divButtonFont = this.$$$getFont$$$("Segoe UI", Font.PLAIN, 14, divButton.getFont());
        if (divButtonFont != null) divButton.setFont(divButtonFont);
        divButton.setText("÷");
        rootPanel.add(divButton, new com.intellij.uiDesigner.core.GridConstraints(1, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        mulButton = new JButton();
        mulButton.setBackground(new Color(-328966));
        Font mulButtonFont = this.$$$getFont$$$("Segoe UI", Font.PLAIN, 14, mulButton.getFont());
        if (mulButtonFont != null) mulButton.setFont(mulButtonFont);
        mulButton.setText("×");
        rootPanel.add(mulButton, new com.intellij.uiDesigner.core.GridConstraints(2, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        subButton = new JButton();
        subButton.setBackground(new Color(-328966));
        Font subButtonFont = this.$$$getFont$$$("Segoe UI", Font.PLAIN, 14, subButton.getFont());
        if (subButtonFont != null) subButton.setFont(subButtonFont);
        subButton.setText("-");
        rootPanel.add(subButton, new com.intellij.uiDesigner.core.GridConstraints(3, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        addButton = new JButton();
        addButton.setBackground(new Color(-328966));
        Font addButtonFont = this.$$$getFont$$$("Segoe UI", Font.PLAIN, 14, addButton.getFont());
        if (addButtonFont != null) addButton.setFont(addButtonFont);
        addButton.setText("+");
        rootPanel.add(addButton, new com.intellij.uiDesigner.core.GridConstraints(4, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        equalButton = new JButton();
        equalButton.setBackground(new Color(-328966));
        Font equalButtonFont = this.$$$getFont$$$("Segoe UI", Font.PLAIN, 14, equalButton.getFont());
        if (equalButtonFont != null) equalButton.setFont(equalButtonFont);
        equalButton.setText("=");
        rootPanel.add(equalButton, new com.intellij.uiDesigner.core.GridConstraints(5, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        pointButton = new JButton();
        pointButton.setBackground(new Color(-328966));
        pointButton.setEnabled(false);
        Font pointButtonFont = this.$$$getFont$$$("Segoe UI", Font.PLAIN, 14, pointButton.getFont());
        if (pointButtonFont != null) pointButton.setFont(pointButtonFont);
        pointButton.setText(".");
        rootPanel.add(pointButton, new com.intellij.uiDesigner.core.GridConstraints(5, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        negButton = new JButton();
        negButton.setBackground(new Color(-328966));
        Font negButtonFont = this.$$$getFont$$$("Segoe UI", Font.PLAIN, 14, negButton.getFont());
        if (negButtonFont != null) negButton.setFont(negButtonFont);
        negButton.setText("±");
        rootPanel.add(negButton, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        rootPanel.add(panel1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 4, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        expressionLabel = new JLabel();
        Font expressionLabelFont = this.$$$getFont$$$("Segoe UI Black", Font.PLAIN, 20, expressionLabel.getFont());
        if (expressionLabelFont != null) expressionLabel.setFont(expressionLabelFont);
        expressionLabel.setText("0");
        panel1.add(expressionLabel, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
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
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return rootPanel;
    }

}
