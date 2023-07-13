package aplicacionesTrabajoFinal;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ListaCompras {
	
	//Creamos una funcion de tipo Array para cargar los items del arreglo:
	static ArrayList<String> agregarItem(ArrayList<String> listaCompras) {
		String item;
		Scanner tecladoItem = new Scanner(System.in);
		
		System.out.println("Agrega items a tu lista - SALIR para terminar");
		do {								
			item = tecladoItem.nextLine(); 
			
			if(!item.equals("SALIR")) {
				if(listaCompras.indexOf(item) != -1) {
					System.out.println("El item ya existe en la lista");
					System.out.println("Continue ingresando - SALIR para terminar");
				} else {
					listaCompras.add(item);
				}				
			}
		}while (!item.equals("SALIR") );
		return listaCompras;
	}
	
	//Creamos una funcion para mostrar los items del arreglo:
	static void verLista(ArrayList<String> listaCompras) {
		System.out.println("***********************");
		System.out.println(listaCompras);
		System.out.println("***********************");
	}
	
	//Creamos una funcion para poder modificar y agregar items del arreglo:
	static ArrayList<String> modificarItem(ArrayList<String> listaCompras) {
		String item, itemNuevo;
		Scanner tecladoItem = new Scanner(System.in);
		int indiceItem;
		
		verLista(listaCompras);  
		
		System.out.println("¿Qué item quieres modificar?");
		item = tecladoItem.nextLine(); 
		indiceItem = listaCompras.indexOf(item); //2   
		if(indiceItem == -1) {
			System.out.println("Ese item no está en la lista");
		} else {
			System.out.println("Agrega nuevo item");
			itemNuevo = tecladoItem.nextLine(); 
			listaCompras.set(indiceItem, itemNuevo);
			System.out.println("item modificado");
			verLista(listaCompras);
		}
		return listaCompras;		
	}
	
	//Creamos una funcion para poder eliminar items del arreglo:
	static ArrayList<String> eliminarItem(ArrayList<String> listaCompras) {
		String item;
		Scanner tecladoItem = new Scanner(System.in);
		int indiceItem;
		
		verLista(listaCompras);  
		
		System.out.println("¿Qué item quieres eliminar?");
		item = tecladoItem.nextLine(); 
		indiceItem = listaCompras.indexOf(item);
		if(indiceItem == -1) {
			System.out.println("Ese item no está en la lista");
		} else {
			listaCompras.remove(indiceItem);
			System.out.println("Item eliminado");
			verLista(listaCompras);
		}
		return listaCompras;
	}
	
	//Creamos una funcion para poder borrar todo el contenido del arreglo:
	static ArrayList<String> borrarLista(ArrayList<String> listaCompras) {
		String respuesta;
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("¿Estás seguro de borrar la lista? (SI/NO)");
		respuesta = teclado.nextLine();
		if(respuesta.equals("SI")) {
			listaCompras.clear();
			System.out.println("Tu lista se borró correctamente");
			System.out.println("*******************************");
		} else {
			System.out.println("Operación cancelada");
		}		
		return listaCompras;
	}

	//Creamos una funcion para crear un archivo de extencion txt con los items de nuestra lista:
	static void guardarLista(ArrayList<String> listaCompras) {
		FileWriter archivo = null;
		String rutaNombreArchivo = "listaCompras.txt";
		
		try {
			archivo = new FileWriter(rutaNombreArchivo);
			for(String item : listaCompras) {
				archivo.write(item + "\n");
			}
			System.out.println("La lista se guardò correctamente");
			archivo.close();
		} catch (Exception error) {
			System.out.println("No se pudo guardar la lista");
			System.out.println(error.getMessage());
		}
	}

	//Creamos una funcion para leer el archivo de la lista:
	static void leerLista(ArrayList<String> listaCompras) {
		String rutaArchivo = "listaCompras.txt";
		File archivo = new File(rutaArchivo);
		Scanner contenidoArchivo = null;
	// Leemos el contenido del archivo
		try {			
			System.out.println("... Leemos el contenido del archivo ...");
			contenidoArchivo = new Scanner(archivo);
			
			while (contenidoArchivo.hasNextLine()) {	
				String linea = contenidoArchivo.nextLine();
				listaCompras.add(linea);		
			}
			contenidoArchivo.close();
		} catch (Exception error) {					 
			System.out.println("No se puede leer la lista");
			System.out.println("Error: " + error.getMessage());
		}
	}
	
	public static void iniciar() {
				
		ArrayList<String> lista = new ArrayList<String>();
		int opcionUsuario;
		Scanner teclado = new Scanner(System.in);
		
		leerLista(lista);
		System.out.println("********************************************");
		System.out.println("Hola!!, esta aplicación te permite crear");
		System.out.println("tu propia lista de compras, pruébalo!!");
		System.out.println("********************************************");
				
		do {
			System.out.println("Elige una opción del menú:");
			System.out.println("**************************");
			System.out.println("1- Agregar item a tu lista");
			System.out.println("2- Ver la lista");
			System.out.println("3- Modificar un item");
			System.out.println("4- Eliminar un item");
			System.out.println("5- Borrar la lista");
			System.out.println("6- Guardar Lista");
			System.out.println("7- Salir");
			System.out.println("**************************");
			
			try {
				opcionUsuario = teclado.nextInt();  	
			} catch (Exception error){				
				opcionUsuario = 0;
				teclado.next();
			}
						
			switch(opcionUsuario) {
			case 1:
				System.out.println("1- Agregar item");
				lista = agregarItem(lista);
				break;
			case 2:
				System.out.println("2- Ver Lista");
				verLista(lista);
				break;
			case 3:
				System.out.println("3- Modificar item");
				lista = modificarItem(lista);
				break;
			case 4:
				System.out.println("4- Eliminar item");
				lista = eliminarItem(lista);
				break;
			case 5:
				System.out.println("5- Borrar Lista");
				borrarLista(lista);
				break;
			case 6:
				System.out.println("6- Guardar lista");
				guardarLista(lista);
				break;
			case 7:
				System.out.println("**************************");
				System.out.println("Gracias por participar!!");//salir
				System.out.println("**************************");
				break;
			
			default:
				System.out.println("************************************");
				System.out.println("Opción inválida!! Ingrese del 1 al 6");
				System.out.println("************************************");
				break;
			}
			
		}while(opcionUsuario != 7);
	}

}

