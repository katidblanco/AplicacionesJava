package aplicacionesTrabajoFinal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ConversorDivisas implements ActionListener{
	
	//Definimos las variables:
	private JFrame ventana;
	private JTextField pesosArgentinos;
	private JTextField dolaresUSA;
	private JLabel rotuloPesos;
	private JLabel rotuloDolares;
	private JButton botonConvertir;
	private JButton botonBorrar;
	
	//Constructor
	public ConversorDivisas () {
		
		// Configuracion de ventana:
		ventana = new JFrame();
		ventana.setLayout(null); // posicionamiento absoluto, con coordenadas
		ventana.setBounds(400, 250, 315, 160);
		ventana.setTitle("Conversor de divisas");
		ventana.setResizable(false);
		//ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true);
		
		// Rótulo Pesos
		rotuloPesos = new JLabel("Pesos Arg.:");
		rotuloPesos.setBounds(20, 10, 100, 30);
		ventana.add(rotuloPesos);
				
		// Rótulo Dolares
		rotuloDolares = new JLabel("Dólar Blue:");
		rotuloDolares.setBounds(20, 40, 120, 30);
		ventana.add(rotuloDolares);
		
		// Campo de texto pesos
		pesosArgentinos = new JTextField("");
		pesosArgentinos.setBounds(130, 14, 150, 20);
		ventana.add(pesosArgentinos);
		pesosArgentinos.repaint();
		
    	// Campo de texto dolares
		dolaresUSA = new JTextField("");
		dolaresUSA.setBounds(130, 44, 150, 20);
		ventana.add(dolaresUSA);
		dolaresUSA.repaint();
		
		// Botón Borrar
		botonBorrar = new JButton("Borrar");
		botonBorrar.setBounds(20, 80, 100, 30);
		ventana.add(botonBorrar);
		botonBorrar.repaint();
		
		// Botón Convertir 
		botonConvertir = new JButton("Convertir");
		botonConvertir.setBounds(180, 80, 100, 30);
		ventana.add(botonConvertir);
		botonConvertir.repaint();
		
		// Inicializo escuchador del botón 
		botonConvertir.addActionListener(this);
		botonBorrar.addActionListener(this);
		botonConvertir.repaint();
		botonBorrar.repaint();
		
		// Muestro la ventana //
		ventana.setVisible(true);
	}
	
	// Método que implementa la acción del botón //
	@Override
	public void actionPerformed(ActionEvent evento) {
		if (evento.getSource() == botonConvertir) {
			double pesos = Double.valueOf(pesosArgentinos.getText());
			double dolarBlue = (pesos / 497);
			dolaresUSA.setText("" + dolarBlue);
		}
		if (evento.getSource() == botonBorrar) {
			pesosArgentinos.setText("");
			dolaresUSA.setText("");
		}
		}
	public static void inciar() {
		new ConversorDivisas();
	
	}
}

