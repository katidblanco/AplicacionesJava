package aplicacionesTrabajoFinal;

import java.util.Scanner;

public class NumeroCapicua {

	public static void inciar() {
		// Se comparan dos numeros y el programa indica si son capicuas
		
		int[] numeros = new int [4];
		int indice; //contador
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Hola! Bienvenido, esta aplicacion te permite saber si un numero entero,");
		System.out.println("de cuatro digitos, es capicua o no");
		System.out.println("***********************************************************************");
				
		
		for (indice = 0; indice < numeros.length;indice++) {
		 System.out.print("Ingrese numero " +(indice+1)+": ");
		 numeros[indice] = teclado.nextInt();
		 }

		if ((numeros [0] == numeros [3]) && (numeros [1] == numeros [2])){
			//System.out.println("El numero "+Arrays.toString(numeros)+" es capicupa");muestro en forma de Arreglo
			System.out.println("El numero "+numeros[0]+numeros[1]+numeros[2]+numeros[3]+" es capicua");
			System.out.println("********************************************************************");
			System.out.println("Fin del programa");
			System.out.println("*********************************************************************");
	}
		else {
			//System.out.println("El numero "+Arrays.toString(numeros)+" no es capicupa"); muestra arreglo
			System.out.println("El numero "+numeros[0]+numeros[1]+numeros[2]+numeros[3]+" no es capicua");
			System.out.println("***********************************************************************");
			System.out.println("Fin del programa");
			System.out.println("***********************************************************************");
		}
	}
}
