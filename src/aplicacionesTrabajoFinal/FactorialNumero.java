package aplicacionesTrabajoFinal;

import java.util.Scanner;

public class FactorialNumero {

	static int factorialNumero(int numero) {

		if (numero == 0 || numero == 1) {
			return 1;
		} else {
			return numero * factorialNumero(numero - 1);
		}
	}

	public static void iniciar() {
		Scanner teclado;
		System.out.println("FACTORIAL DE UN NÚMERO");
		System.out.println("Escriba 1-Continuar 2-Salir");
		teclado = new Scanner(System.in);
		int salir = teclado.nextInt();

		do {

			switch (salir) {
				case 1:
					System.out.println("***************************************");
					System.out.println("Ingrese un número entero");

					teclado = new Scanner(System.in);
					int numero = teclado.nextInt();

					int factorial = factorialNumero(numero);
					System.out.println("El factorial del número " + numero + " es " + factorial);
					System.out.println("Escriba 1-Continuar 2-Salir");
					System.out.println("***************************************");
					teclado = new Scanner(System.in);
					salir = teclado.nextInt();
					break;

				case 2:
					System.out.println("Hasta pronto");
					break;

				default:
					System.out.println("Opción inválida");
					System.out.println("Escriba 1-Continuar 2-Salir");
					System.out.println("***************************************");
					teclado = new Scanner(System.in);
					salir = teclado.nextInt();
					break;
			}

		} while (salir != 2);
	}

}
