package aplicacionesTrabajoFinal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ConversorDeTemperatura implements ActionListener{
	
	//Definimos las variables:
	private JFrame ventana;
	private JTextField gradosCelcius;
	private JTextField gradosFarenheit;
	private JLabel rotuloCelcius;
	private JLabel rotuloFarenheit;
	private JButton botonConvertir;
	private JButton botonBorrar;
	
	//Constructor
	public ConversorDeTemperatura () {
		
		/* Configuración de la ventana */
		ventana = new JFrame();
		ventana.setLayout(null); // posicionamiento absoluto, con coordenadas
		ventana.setBounds(400, 250, 315, 160);
		ventana.setTitle("Convertir temperatura");
		ventana.setResizable(false);
		//ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true);
		
		/* Rótulo de grados celcius */
		rotuloCelcius = new JLabel("Grados Celcius:");
		rotuloCelcius.setBounds(20, 10, 100, 30);
		ventana.add(rotuloCelcius);
				
		/* Rótulo de grados farenheit */
		rotuloFarenheit = new JLabel("Grados Farenheit:");
		rotuloFarenheit.setBounds(20, 40, 120, 30);
		ventana.add(rotuloFarenheit);
		
		/* Campo de texto grados celcius */
		gradosCelcius = new JTextField("");
		gradosCelcius.setBounds(130, 14, 150, 20);
		ventana.add(gradosCelcius);
		gradosCelcius.repaint();
		
		/* Campo de texto grados farenheit */
		gradosFarenheit = new JTextField("");
		gradosFarenheit.setBounds(130, 44, 150, 20);
		ventana.add(gradosFarenheit);
		gradosFarenheit.repaint();
		
		/* Botón Borrar */
		botonBorrar = new JButton("Borrar");
		botonBorrar.setBounds(20, 80, 100, 30);
		ventana.add(botonBorrar);
		botonBorrar.repaint();
		
		/* Botón Convertir */
		botonConvertir = new JButton("Convertir");
		botonConvertir.setBounds(180, 80, 100, 30);
		ventana.add(botonConvertir);
		botonConvertir.repaint();
		
		/* Inicializo escuchador del botón */
		botonConvertir.addActionListener(this);
		botonBorrar.addActionListener(this);
		
		
		/* Muestro la ventana */
		ventana.setVisible(true);
	}
	
	/* Método que implementa la acción del botón */
	@Override
	public void actionPerformed(ActionEvent evento) {
		if (evento.getSource() == botonConvertir) {
			double celcius = Double.valueOf(gradosCelcius.getText());
			double farenheit = (celcius * 9 / 5) + 32;
			gradosFarenheit.setText("" + farenheit);
		}
		if (evento.getSource() == botonBorrar) {
			gradosCelcius.setText("");
			gradosFarenheit.setText("");
		}
		}
	public static void inciar() {
		new ConversorDeTemperatura();
	
	}
}
