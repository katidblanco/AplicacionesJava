package aplicacionesTrabajoFinal;

import java.util.ArrayList;
import java.util.Scanner;

public class PromedioNotas {

	static ArrayList<Integer> cargarNotas(ArrayList<Integer> listaNotas) {
		Scanner teclado = new Scanner(System.in);
		int nota;
		System.out.println("Ingrese una nota - 0 para Salir");
			do {
			nota = teclado.nextInt();
			   if(nota > 0 && nota <=10) {
				listaNotas.add(nota);
			   }else if (nota !=0) {
				System.out.println("Nota ingresada inválida - Ingrese un número del 1 al 10");
			   }
		   } while (nota != 0);
		return listaNotas;
		
		}
	
	static void verNotas (ArrayList<Integer>listaNotas) {
		System.out.println("**************************");
		for (int indice = 0; indice < listaNotas.size(); indice++) {//recorremos los valores ingresados 
		System.out.println(listaNotas.get(indice) + " ");
		}
		System.out.println("**************************");
	}
	
	static double calcularPromedio (ArrayList<Integer> listaNotas) {
		double promedio, suma;
		suma = 0;
		for (int indice=0; indice < listaNotas.size(); indice++) {
			suma = suma + listaNotas.get(indice);
		}
		promedio = suma / listaNotas.size();
	return promedio;
	}
		
	public static void iniciar() {
        
		ArrayList<Integer> notas = new ArrayList<Integer>();
		int opcionUsuario;
		Scanner teclado = new Scanner(System.in);
		
	   do {	
			System.out.println("Calcular Promedio de Notas (Enteros entre 1-10):");
			System.out.println("************************************************");
			System.out.println("Elija una opción: ");
			System.out.println("1 - Cargar notas");
			System.out.println("2 - Ver notas cargadas");
			System.out.println("3 - Calcular Promedio");
			System.out.println("4 - Salir");
			System.out.println("************************************************");
			opcionUsuario = teclado.nextInt();
			
			switch (opcionUsuario) {
			case 1:
				System.out.println("Opción seleccionada: 1 - Cargar notas");
				System.out.println("*************************************");
				notas = cargarNotas(notas);			
				break;
			case 2:
				System.out.println("Opción seleccionada: 2 - Ver Notas cargadas");
				System.out.println("*******************************************");
				verNotas(notas);
				break;
			case 3:
				verNotas(notas);
				System.out.println("Opción seleccionada: 3 - El promedio es: "+ calcularPromedio(notas));
				System.out.println("*****************************************");
			    break;
			case 4:
				System.out.println("Opción seleccionada: 4 - Fin del programa");
				System.out.println("*****************************************");
				break;
				
				default: 
				System.out.println("La opción seleccionada es inválida");
				System.out.println("**********************************");
				break;
		}
	  }while (opcionUsuario !=4);
		
	}
}


