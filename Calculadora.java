package calculadora;
/**
 *
 * @author eri
 */

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Calculadora extends JFrame{
    private JLabel signoIgual;
    private JLabel valorResultante;
    
    private JTextField caja;
    private JTextField caja2;
    private JTextField cajaProcedimiento;
    
    private JButton suma;
    private JButton resta;
    private JButton multiplicacion;
    private JButton division;
    private JButton potencia;
    private JButton raiz;
    
    public Calculadora(){
        super();
        configurarVentana();
        crearComponentes();
    }
    
    private void configurarVentana(){
        this.setTitle("CALCULADORA");
        this.setSize(300, 350);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void crearComponentes(){
        signoIgual = new JLabel();
        signoIgual.setText("=");
        signoIgual.setBounds(130, 260, 30, 30);
        signoIgual.setForeground(Color.black);
        signoIgual.setVisible(false);
        this.add(signoIgual);
        
        valorResultante = new JLabel();
        valorResultante.setBounds(150, 260, 100, 30 );
        valorResultante.setForeground(Color.red);
        valorResultante.setVisible(false);
        this.add(valorResultante);
        
        caja = new JTextField();
        caja.setBounds(50, 30, 80, 30);
        this.add(caja);
        
        caja2 = new JTextField();
        caja2.setBounds(150, 30, 80, 30);
        this.add(caja2);
        
        cajaProcedimiento = new JTextField();
        cajaProcedimiento.setBounds(40, 210, 200, 30);
        cajaProcedimiento.setEditable(false);
        cajaProcedimiento.setVisible(false);
        this.add(cajaProcedimiento);
        
        suma = new JButton();
        suma.setText("+");
        suma.setBounds(54, 80, 50, 50);
        suma.setForeground(Color.black);
        suma.addActionListener(new BotonPulsadoListener());
        this.add(suma);
        
        resta = new JButton();
        resta.setText("-");
        resta.setBounds(114, 80, 50, 50);
        resta.setForeground(Color.black);
        resta.addActionListener(new BotonPulsadoListener());
        this.add(resta);
        
        multiplicacion = new JButton();
        multiplicacion.setText("×");
        multiplicacion.setBounds(174, 80, 50, 50);
        multiplicacion.setForeground(Color.black);
        multiplicacion.addActionListener(new BotonPulsadoListener());
        this.add(multiplicacion);
        
        division = new JButton();
        division.setText("÷");
        division.setBounds(54, 140, 50, 50);
        division.setForeground(Color.black);
        division.addActionListener(new BotonPulsadoListener());
        this.add(division);
        
        potencia = new JButton();
        potencia.setText("^");
        potencia.setBounds(114, 140, 50, 50);
        potencia.setForeground(Color.black);
        potencia.addActionListener(new BotonPulsadoListener());
        this.add(potencia);
        
        raiz = new JButton();
        raiz.setText("√");
        raiz.setBounds(174, 140, 50, 50);
        raiz.setForeground(Color.black);
        raiz.addActionListener(new BotonPulsadoListener());
        this.add(raiz);
    }
    
    private class BotonPulsadoListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            String signo = e.getActionCommand();
            double resultado = calcular(signo);
            signoIgual.setVisible(true);
            valorResultante.setText(" " + resultado + " ");
            valorResultante.setVisible(true);
        }   
    }
    
    public static void main(String[] args) {
        Calculadora ventana = new Calculadora();
        ventana.setVisible(true);
    }
    
    private double calcular(String signo){
        String numero = caja.getText();
        String numero2 = caja2.getText();
        double resultado = 0;
        
        try{
            double num = Double.valueOf(numero);
            double num2 = Double.valueOf(numero2);

            switch(signo){
                case "+":
                    resultado = num + num2;
                break;
                case "-":
                    resultado = num - num2;
                break;
                case "×":
                    resultado = num * num2;
                break;
                case "÷":
                    resultado = num/num2;
                break;
                case "^":
                    resultado = Math.pow(num, num2);
                break;
                case "√":
                    resultado = Math.pow(num2, 1/num);
                    /*if(num %1 == 0){
                       resultado = Math.pow(num2, 1/num); 
                    }
                    else{
                        JOptionPane.showMessageDialog(this, "Ups..." + num + " no es valido para obtener raiz");
                    }*/
                break;
            }
            
            cajaProcedimiento.setText("  " + num + " " + signo + " " + num2);
            cajaProcedimiento.setVisible(true);
            

            return resultado;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Syntax ERROR");
        }
        
        return resultado;
    }
    
}
