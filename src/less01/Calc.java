package less01;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Calc extends JFrame {
    JTextArea text;
    int number1 = 0, number2 = 0;
    int oper;//номер операции. Путь oper=1 - это сложение, 2 - вычитание, 3 - умножение, 4 - деление


    public Calc() {
        var c = getContentPane();//создали контейнер
        var panel = new JPanel();//создали панель для размещения в ней элементов с кнопками и др
        panel.setLayout(null);//указали свободное размещение элементов по координатм
        JButton[] buttons = new JButton[18];//всего 19 кнопок
        var font = new Font("Calibri", Font.BOLD, 25);//создали шрифт для кнопок
        int x = 0;
        int x1 = 1;
        int y = 80;
        for (int i = 0; i < buttons.length; i++) {

            buttons[i] = new JButton();
            buttons[i].setSize(90, 30);
            buttons[i].setFont(font);
            buttons[i].setLocation(x, y);//сделали, чтобы каждая кнопка была ниже предыдущей
            buttons[i].setBackground(Color.white);
            buttons[i].setForeground(Color.blue);

            if (x1 < 3) {
                x += 90;
            } else {
                x = 0;
                x1 = 0;
                y += 30;
            }

            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {//e - объект event
                    JButton b = (JButton) e.getSource();//b - кнопка на которую кликнули
                    var txt = b.getText();//получили текст кнопки
                    if (txt.equalsIgnoreCase("Выход")) {
                        System.exit(0);
                    } else if (txt.equalsIgnoreCase("AC")) {
                        text.setText("");
                        number1 = 0;
                        number2 = 0;
                    } else if (txt.equalsIgnoreCase("+")) {
                        oper = 1;
                        number1 = Integer.parseInt(text.getText());
                        text.setText("");
                    } else if (txt.equalsIgnoreCase("-")) {
                        oper = 2;
                        number1 = Integer.parseInt(text.getText());
                        text.setText("");
                    } else if (txt.equalsIgnoreCase("*")) {
                        oper = 3;
                        number1 = Integer.parseInt(text.getText());
                        text.setText("");
                    } else if (txt.equalsIgnoreCase("/")) {
                        oper = 4;
                        number1 = Integer.parseInt(text.getText());
                        text.setText("");
                    } else if (txt.equalsIgnoreCase("x¹")) {
                        oper = 5;
                        number1 = Integer.parseInt(text.getText());
                        text.setText("");
                    } else if (txt.equalsIgnoreCase("√")) {
                        number1 = Integer.parseInt(text.getText());
                        text.setText("" + Math.sqrt(number1));
                    } else if (txt.equalsIgnoreCase("=")) {
                        number2 = Integer.parseInt(text.getText());
                        if (oper == 1) {
                            text.setText("" + (number1 + number2));
                        }
                        if (oper == 2) {
                            text.setText("" + (number1 - number2));
                        }
                        if (oper == 3) {
                            text.setText("" + (number1 * number2));
                        }
                        if (oper == 4) {
                            if (number2 == 0) {
                                System.out.println("На 0 делить нельзя!");
                            } else if (number1 % number2 == 0) {
                                text.setText("" + (number1 / number2));
                            } else {
                                double n1 = number1;
                                double n2 = number2;
                                text.setText("" + n1 / n2);
                            }
                        } else if (oper == 5) {
                            text.setText("" + Math.pow(number1, number2));
                        }
                    } else {
                        if (text.getText().length() != 0) {
                            var s = text.getText();
                            s += txt;
                            text.setText(s);
                        } else {
                            text.setText(txt);
                        }
                    }
                }
            });
            x1++;
            panel.add(buttons[i]);//каждую кнопку поместили в панель
        }

        for (int i = 0; i < 10; i++) {
            buttons[i].setText((i + 1) + "");
        }

        buttons[9].setText("+");
        buttons[10].setText("0");
        buttons[11].setText("-");
        buttons[12].setText("*");
        buttons[13].setText("/");
        buttons[14].setText("=");
        buttons[15].setText("AC");
        buttons[16].setText("x¹");
        buttons[17].setText("√");

        text = new JTextArea();
        text.setFont(new Font("serif", Font.BOLD, 30));
        text.setForeground(Color.red);
        text.setBounds(0, 0, 300, 80);

        panel.add(text);
        c.add(panel);
        setSize(285, 299);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        setTitle("Кальуклятор. Версия 5.0");
    }

    /*
        public static double sqrt(double a) {
            return StrictMath.sqrt(a);
        }

    */
    public static void main(String[] args) {
        new Calc();
    }
}
