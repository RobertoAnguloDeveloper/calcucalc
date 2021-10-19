import javax.swing.*;
import java.awt.*;

public class Calculadora {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora");
        frame.setLayout(new FlowLayout());
        
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JTextField resultadoField = new JTextField("0");
        resultadoField.setPreferredSize(new Dimension(200, 50));
        resultadoField.setBorder(BorderFactory.createTitledBorder("Resultado"));
        
        JButton button = new JButton("+");
        button.addActionListener(event -> {
            if(!resultadoField.getText().contains(".")){
                int num = Integer.parseInt(resultadoField.getText());
            }
        });

        JButton button2 = new JButton("-");
        button2.addActionListener(event -> {
            /* System.exit(0); */
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setSize(100, 100);
        buttonPanel.setBorder(BorderFactory.createTitledBorder("Operaciones"));
        
        

        buttonPanel.add(button);
        buttonPanel.add(button2);

        frame.add(resultadoField);
        frame.add(buttonPanel);
        frame.pack();
        frame.setVisible(true);

        resultadoField.addKeyListener(new java.awt.event.KeyAdapter() {
            int puntos = 0;
            public void keyTyped(java.awt.event.KeyEvent evt) {
                char c = evt.getKeyChar();
                
                if(!resultadoField.getText().contains(".")){
                    puntos = 0;
                }

                if(!resultadoField.getText().isEmpty()){
                    if(resultadoField.getText().charAt(0) == '.'){
                        resultadoField.setText("0"+resultadoField.getText());
                    }
                    if(resultadoField.getText().charAt(0) == '0' && resultadoField.getText().length() > 2 
                        && resultadoField.getText().charAt(1) != '.'){
                        resultadoField.setText(resultadoField.getText().substring(1));
                    }
                }else{
                    if(c == '.'){
                        resultadoField.setText("0");
                    }
                }

                if(!(Character.isDigit(c))){
                    if(c == '.'){
                        if(puntos == 0){
                            resultadoField.setText(resultadoField.getText() + c);
                            puntos = 1;
                        }else{
                            Toolkit.getDefaultToolkit().beep();
                        }
                    }
                    evt.consume();
                }
            }

            public void keyPressed(java.awt.event.KeyEvent evt) {
                if(evt.getKeyCode() == 27){
                    System.exit(0);
                }
            }
        });
    }
}