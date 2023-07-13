package aplicacionesTrabajoFinal;

import java.util.Scanner;

public class Main {

public static void main(String[] args) {
		
		int opcionUsuario;
		Scanner teclado = new Scanner(System.in);
				
		do {
		
		    System.out.println("Bienvenidos al menú de aplicaciones");
			System.out.println("Seleccione cual de ellas desea ejecutar");
			System.out.println("***********************************************");
		    System.out.println("**     1 - Numero par o impar                **");
		    System.out.println("**     2 - Numero capicúa                    **");
		    System.out.println("**     3 - Factorial de un numero            **");
		    System.out.println("**     4 - Promedio de notas                 **");
		    System.out.println("**     5 - Piedra, Papel o Tijera            **");
		    System.out.println("**     6 - Simulacro cajero                  **");
		    System.out.println("**     7 - Lista de compras                  **");
		    System.out.println("**     8 - Conversor de temperatura (Gráfico)**");
		    System.out.println("**     9 - Conversor de divisas (Gráfico)    **");
		    System.out.println("**     10 - Calculadora                      **");
		    System.out.println("**     11 - Salir                            **");
		    System.out.println("***********************************************");
		    		    
		    try {
				opcionUsuario = teclado.nextInt();  	
			} catch (Exception error){				
				opcionUsuario = 0;
				teclado.next();
			}		    
			    switch (opcionUsuario) {
			    
			    case 1:
			    	System.out.println("Opcion seleccionada: "+opcionUsuario);
			    	System.out.println("***************************************");
			    	NumerosPares.iniciar();
			    	break;
			    case 2:
			    	System.out.println("Opcion seleccionada: "+opcionUsuario);
			    	System.out.println("***************************************");
			    	NumeroCapicua.inciar();
			    	break;
			    case 3:
			    	System.out.println("Opcion seleccionada: "+opcionUsuario);
			    	System.out.println("***************************************");
			    	FactorialNumero.iniciar();
			    	break;
			    case 4:
			    	System.out.println("Opcion seleccionada: "+opcionUsuario);
			    	System.out.println("***************************************");
			    	PromedioNotas.iniciar();
			    	break;
			    case 5:
			    	System.out.println("Opcion seleccionada: "+opcionUsuario);
			    	System.out.println("***************************************");
			    	PiedraPapelTijera.iniciar();
			    	break;
			    case 6:
			    	System.out.println("Opcion seleccionada: "+opcionUsuario);
			    	System.out.println("***************************************");
			    	cajeroAutomaticoII.iniciar();
			    	break;
			    case 7:
			    	System.out.println("Opcion seleccionada: "+opcionUsuario);
			    	System.out.println("***************************************");
			    	ListaCompras.iniciar();
			    	break;
			    case 8:
			    	System.out.println("Opcion seleccionada: "+opcionUsuario);
			    	System.out.println("Hola! se iniciara el conversor de temperatura de forma grafica");
			    	System.out.println("***************************************");
			    	ConversorDeTemperatura.inciar();
			    	break;
			    case 9:
			    	System.out.println("Opcion seleccionada: "+opcionUsuario);
			    	System.out.println("Hola! se iniciara el conversor de divisas de forma grafica");
			    	System.out.println("***************************************");
			    	ConversorDivisas.inciar();
			    	break;
			    case 10:
			    	System.out.println("Opcion seleccionada: "+opcionUsuario);
			    	System.out.println("Hola! se iniciara la calculadora grafica");
			    	System.out.println("***************************************");
			    	CalculadoraGrafica.iniciar();
			    	break;
			    case 11:
			    	System.out.println("Opcion seleccionada: "+opcionUsuario);
			    	System.out.println("Hasta pronto!");
			    	System.out.println("***************************************");
			    	break;
			    default:
			    	System.out.println("Error - Opcion invalida, seleccione del 1 al 10");
			    	System.out.println("***************************************");
			    	break;
			    }
		    
	    }while(opcionUsuario != 11);
	    
	    teclado.close();
	    }
	    }
	  
