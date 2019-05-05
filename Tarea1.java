package hello;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *
 * @author eri
 */
public class Tarea1 extends JFrame implements ActionListener {
    private JLabel mensaje;
    private JLabel signo;
    private JButton boton;
    private JTextField caja;
    private JTextField caja2;
    
    public Tarea1(){
        super();
        configurarVentana();
        crearComponentes();
    }
    
    private void configurarVentana(){
        this.setTitle("MINI SUMA");
        this.setSize(400,300);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void crearComponentes(){
        mensaje = new JLabel();
        mensaje.setText("HORA DE SUMAR");
        mensaje.setBounds(65,30,100,50); //x,y,tamaño ancho, tamaño alto
        mensaje.setForeground(Color.green);
        this.add(mensaje); //Se agrega este objeto a la superclase
        
        caja = new JTextField();
        caja.setBounds(65, 80, 60, 30); //x, y, ancho, alto.
        this.add(caja);
        
        signo = new JLabel();
        signo.setText("+");
        signo.setBounds(140, 55, 80, 80);
        signo.setForeground(Color.red);
        this.add(signo);
        
        caja2 = new JTextField();
        caja2.setBounds(160, 80, 60, 30);
        this.add(caja2);
        
        boton = new JButton();
        boton.setText("Súmame");
        boton.setBounds(90,160,100,30);
        boton.setForeground(Color.blue);
        boton.addActionListener(this);
        this.add(boton);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        String numero = caja.getText();
        String numero2 = caja2.getText();
        float num = Float.valueOf(numero);
        float num2 = Float.valueOf(numero2);
        float resultado = num + num2;
        JOptionPane.showMessageDialog(this, "El valor es: " + resultado);
    }
    
    public static void main(String[] args){
        Tarea1 ventana = new Tarea1();
        ventana.setVisible(true);
    }
}
