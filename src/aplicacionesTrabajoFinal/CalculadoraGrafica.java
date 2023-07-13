package aplicacionesTrabajoFinal;

import static java.awt.Font.PLAIN;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class CalculadoraGrafica {
	//propiedades de la clase
	private JFrame ventana;
	private JLabel operacion;
	private JLabel display;
	private JButton boton;
	
	private double operando1 = 0;
	private double operando2 = 0;
	private double resultado = 0;
	private String operador = "";
	private boolean nuevoOperando = true;
	private boolean puntoDecimal = false;
	
	//métodos de la clase
	public CalculadoraGrafica() {
		//crear ventana
		ventana = new JFrame();
		ventana.setLocation(new Point(400, 200));
		ventana.setSize(new Dimension(290, 485));
		ventana.setTitle("Calculadora");
		ventana.getContentPane().setBackground(Color.BLACK);
		ventana.setResizable(false);
		//ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setLayout(null);
		ventana.setVisible(true);
		
		//Agregar el display de la operación
		operacion = new JLabel("");
		operacion.setBounds(15, 10, 245, 30); //posición y tamaño
		operacion.setBorder(new LineBorder(Color.DARK_GRAY));
		operacion.setForeground(Color.WHITE);
		operacion.setHorizontalAlignment(SwingConstants.RIGHT);
		ventana.add(operacion);
		
		//Agregar el display de números
		display = new JLabel("0");
		display.setBounds(15, 45, 245, 60);
		display.setBorder(new LineBorder(Color.DARK_GRAY));
		display.setFont(new Font("ARIAL", PLAIN, 30));
		display.setOpaque(true);
		display.setHorizontalAlignment(SwingConstants.RIGHT);
		ventana.add(display);
		
		//Agregar botones de numeros y operadores
		//Fila 1
		crearBoton("C", 145, 120);
		crearBoton("/", 210, 120);
		//Fila 2
		crearBoton("7", 15, 185);
		crearBoton("8", 80, 185);
		crearBoton("9", 145, 185);
		crearBoton("*", 210, 185);
		//Fila 3
		crearBoton("4", 15, 250);
		crearBoton("5", 80, 250);
		crearBoton("6", 145, 250);
		crearBoton("-", 210, 250);
		//Fila 4
		crearBoton("1", 15, 315);
		crearBoton("2", 80, 315);
		crearBoton("3", 145, 315);
		crearBoton("+", 210, 315);
		//Fila 4
		crearBoton("0", 80, 380);
		crearBoton(".", 145, 380);
		crearBoton("=", 210, 380);
		
		
	}
	
	private void crearBoton(String texto, int posX, int posY) {
		boton = new JButton(texto);
		boton.setBounds(posX, posY, 50, 50);
		boton.setOpaque(true);
		if(texto == "=") {
			boton.setBackground(Color.RED);
		} else {
			boton.setBackground(Color.DARK_GRAY);
		}		
		boton.setForeground(Color.WHITE);
		boton.setFocusPainted(false);
		ventana.add(boton);
		boton.repaint();
		
		boton.addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				switch (texto) {
				case "0":
				case "1":
				case "2":
				case "3":
				case "4":
				case "5":
				case "6":
				case "7":
				case "8":
				case "9":
					if(nuevoOperando == true) {   //si es nuevo operando
						if(!texto.equals("0") || !display.getText().equals("0")) {   //texto != "0"
							display.setText(texto);
							nuevoOperando = false;
							//puntoDecimal = true;
							System.out.println("primer numero");
						} 
					} else {
						display.setText(display.getText() + texto);
						System.out.println("siguiente numero");
					}
					break;
				case ".":
					if(puntoDecimal == false) {
						if(display.getText().equals("0")){
							display.setText(display.getText() + texto);
							nuevoOperando = false;
							puntoDecimal = true;
						} else {
							display.setText("0" + texto);
							nuevoOperando = false;
							puntoDecimal = true;
						}
					}
					break;
				case "/":
				case "*":
				case "-":
				case "+":
					System.out.println("operador");
					if(operador.equals("")) {
						operador = texto;
						operando1 = Double.parseDouble(display.getText());
						nuevoOperando = true;
						puntoDecimal = false;
						operacion.setText(formatoSalidaDisplay(operando1) + " " + operador);
					} else {
						operando1 = resultado();
						puntoDecimal = false;
						operador = texto;
					}
					//operacion.setText(formatoSalidaDisplay(operando1) + " " + operador);
					break;
				case "C":
					display.setText("0");
					operacion.setText("");
					resetVariables();
					break;
				case "=":
					if(!operador.equals("")) {
						resultado();						
					}					
					break;
				}
				
			}
			
		});
				
	}
	
	private double resultado() {
		operando2 = Double.parseDouble(display.getText());
		switch (operador) {
		case "+":
			resultado = operando1 + operando2;
			break;
		case "-":
			resultado = operando1 - operando2;
			break;
		case "*":
			resultado = operando1 * operando2;
			break;
		case "/":
			resultado = operando1 / operando2;
			break;
		}
		operacion.setText(formatoSalidaDisplay(operando1) + " " + operador + " " + formatoSalidaDisplay(operando2) + " =");
		display.setText(formatoSalidaDisplay(resultado));
		resetVariables();
		return resultado;
	}
	
	private String formatoSalidaDisplay(double numero) {
		String numeroDisplay = "";
		DecimalFormatSymbols separador = new DecimalFormatSymbols();
		separador.setDecimalSeparator('.');
		DecimalFormat formatoResultado = new DecimalFormat("#.#########", separador);
		numeroDisplay = String.valueOf(formatoResultado.format(numero));
		return numeroDisplay;
	}
	
	private void resetVariables() {
		operando1 = 0;
		operando2 = 0;
		operador = "";
		nuevoOperando = true;
		puntoDecimal = false;
	}

	public static void iniciar() {
		
		new CalculadoraGrafica();
		
	}

}

