package aplicacionesTrabajoFinal;

import java.util.Scanner;

public class NumerosPares {

	static boolean parInpar(int numero) {
		Scanner teclado;

		System.out.println("Ingrese un número entero y la aplicación indicará si es par o impar");
		System.out.println("***************************************");
		teclado = new Scanner(System.in);
		numero = teclado.nextInt();

		if (numero % 2 == 0) {
			System.out.println("El número ingresado es par");
			System.out.println("***************************************");
			System.out.println("***************************************");
			System.out.println("***************************************");
			return true;
		} else {
			System.out.println("El número ingresado es impar");
			System.out.println("***************************************");
			System.out.println("***************************************");
			System.out.println("***************************************");
			return false;

		}
	}

	public static void iniciar() {
        Scanner teclado;
		int salir;
		
    parInpar(0);

	do{ 

		System.out.println("¿Desea escribir otro número o desea salir?");
		System.out.println("1- Continuar   2-Salir");
		System.out.println("***************************************");
		teclado = new Scanner(System.in);
		salir = teclado.nextInt();


		switch (salir){
			case 1:
			parInpar(0);
			break;

			case 2:
			System.out.println("Hasta pronto!!");
			System.out.println("***************************************");
			break;
			
			default:
			System.out.println("Opción inválida");
			break;
        }

	}while(salir!=2);

}
}
