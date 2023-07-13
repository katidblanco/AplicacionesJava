package aplicacionesTrabajoFinal;

//import java.util.Random;
import java.util.Scanner;

public class PiedraPapelTijera {
	

	static String numeroAElemento (int numero) {
		String[] elementos = {"Piedra", "Papel", "Tijera"};
		String elemento = "";
		
		if(numero == 1) {
			elemento = elementos[0];
		}
		else if (numero == 2) {
			elemento = elementos[1];
		}
		else {
			elemento = elementos[2];
		}
		return elemento;
	}
	
	static int pedirDatoUsuarioInt(String mensaje) {
		int opcionUsuario;
        Scanner teclado = new Scanner(System.in);
		System.out.println(mensaje);
		opcionUsuario = teclado.nextInt();
		return opcionUsuario;
		}
	
	static int aleatorioEntre(int min, int max) { //Ramdon, funcion creada para un numero aleatorio
		int numAleat = (int) (Math.random() * (3 - 1 + 1)) + 1;
		return numAleat;
		}
	
	public static void iniciar() {
		
		int opcionUsuario, opcionComputadora, opcionSalir;
		String opcionUsuarioElem, opcionComputadoraElem;
		System.out.println("Juguemos Piedra, Papel o Tijera!!!!");
				
		do {		
			//System.out.println("Elige 1-Piedra 2-Papel 3-Tijera");
			//opcionUsuario = teclado.nextInt();
			
			opcionUsuario = pedirDatoUsuarioInt("Elige 1-Piedra 2-Papel 3-Tijera");
			//argumentos
            opcionUsuarioElem = numeroAElemento(opcionUsuario);
			opcionComputadora = aleatorioEntre(3, 1);
			opcionComputadoraElem = numeroAElemento(opcionComputadora);
			System.out.println("****************************");
			System.out.println("Opción Computadora: " + opcionComputadoraElem);
			System.out.println("Opción Usuario: " + opcionUsuarioElem);
			System.out.println("****************************");
			//empate
			if(opcionUsuarioElem.equals(opcionComputadoraElem)) {
				System.out.println("¡Empate!");
			}
			//gano usuario		
						
			else if ((opcionUsuarioElem.equals("Piedra") && opcionComputadoraElem.equals("Tijera"))
					|| (opcionUsuarioElem.equals("Papel") && opcionComputadoraElem.equals("Piedra"))
					|| (opcionUsuarioElem.equals("Tijera") && opcionComputadoraElem.equals("Papel"))) {
				System.out.println("¡Ganaste!");			
			} else {
				System.out.println("¡Perdiste!");	//gano compuadora		
			}
			
			opcionSalir = pedirDatoUsuarioInt("¿Jugar otra vez? 1-SI 2-NO");
						
		}while (opcionSalir != 2);
		
		System.out.println("Gracias, volvé pronto!!");
		System.out.println("***********************");
		
			}	
			}
		


