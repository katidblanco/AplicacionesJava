package aplicacionesTrabajoFinal;

import java.util.ArrayList;
import java.util.Scanner;

public class cajeroAutomaticoII {

    // FUNCIÓN PEDIR DATO*********************************
    static String pedirDato(String mensaje) {
        String opcionUsuario;
        Scanner teclado = new Scanner(System.in);
        System.out.println(mensaje);
        opcionUsuario = teclado.nextLine();
        return opcionUsuario;
    }

    // FUNCION BIENVENIDA******************************
    static String bienvenida() {
        String opcionUsuario;

        System.out.println("****************************************");
        System.out.println("Bienvenido(a) a tu banca online");
        System.out.println("Ingrese tarjeta");
        System.out.println("****************************************");
        opcionUsuario = pedirDato(" 1-Iniciar sesión \n 2-Salir \n Elige una opción: ");
        System.out.println("****************************************");
        return opcionUsuario;
    }

    // FUNCIÓN LOGIN**************************************
    static boolean login(ArrayList<String> datos) {
        String pin;
        pin = pedirDato(" Ingrese su pin");
        if (pin.equals(datos.get(1))) {
            return true;
        } else {
            return false;
        }
    }

    // FUNCIÓN ver Datos del cliente**************************************
    static void verDatosCliente(ArrayList<String> datos) {
        System.out.println("*********************************");
        System.out.println("DATOS DEL CLIENTE:");
        System.out.println("Nombre y apellidos: " + datos.get(0));
        System.out.println("CBU: " + datos.get(2));
        System.out.println("Saldo: $ " + datos.get(3));
    }

    // FUNCIÓN ver saldo actual**************************************
    static void verSaldoActual(ArrayList<String> datos) {
        System.out.println("*********************************");
        System.out.println("SALDO ACTUAL");
        System.out.println("Su saldo es: $" + datos.get(3));
    }

    /* Función Realizar depósito */
    static void realizarDeposito(ArrayList<String> datos) {
        String deposito;
        int saldoActualizado;
        System.out.println("*********************************");
        System.out.println("REALIZAR DEPÓSITO:");
        deposito = pedirDato("Ingrese la cantidad que desea depositar: $");
        saldoActualizado = Integer.parseInt(datos.get(3)) + Integer.parseInt(deposito);
        datos.set(3, Integer.toString(saldoActualizado));
        System.out.println("Depósito realizado satisfactoriamente");
        System.out.println("Su saldo actualizado es de: $" + datos.get(3));
    }

    /* Función Realizar extracción */
    static void realizarExtraccion(ArrayList<String> datos) {
        String extraccion;
        int saldoActualizado;
        System.out.println("*********************************");
        System.out.println("REALIZAR EXTRACCIÓN:");
        extraccion = pedirDato("Ingrese la cantidad que desea extraer: $");
        // movimientos.add(extraccion);
        if (Integer.parseInt(extraccion) <= Integer.parseInt(datos.get(3))) {
            saldoActualizado = Integer.parseInt(datos.get(3)) - Integer.parseInt(extraccion);
            datos.set(3, Integer.toString(saldoActualizado));

            System.out.println("Extracción realizada satisfactoriamente");
            System.out.println("Su saldo actualizado es de: $" + datos.get(3));
        } else {
            System.out.println("Fondos insuficientes");
        }
    }

    /* Función Realizar transferencia */

    static void realizarTransferencia(ArrayList<String> datos) {
        String transferencia, cbu;
        int saldoActualizado, transferenciaInt, saldoInt;

        System.out.println("*********************************");
        System.out.println("REALIZAR TRANSFERENCIA:");
        transferencia = pedirDato("Ingrese la cantidad que desea transferir: $");
        cbu = pedirDato("Ingrese CBU o No de cuenta bancaria de destino: ");
        transferenciaInt = Integer.parseInt(transferencia);
        saldoInt = Integer.parseInt(datos.get(3));

        if (transferenciaInt <= saldoInt) {
            saldoActualizado = saldoInt - transferenciaInt;
            datos.set(3, Integer.toString(saldoActualizado));
            System.out.println("*************************************************************************");
            System.out.println(
                    "Transferencia realizada con éxito al CBU: " + cbu + " \n Monto transferido: " + transferencia);
            System.out.println("Su saldo actualizado es de: $" + datos.get(3));
        } else {
            System.out.println("Fondos insuficientes");
        }
    }

    // INICIA EL MAIN********************************************
    public static void iniciar() {

        ArrayList<String> datosUsuario = new ArrayList<String>(); // Array List Datos de Usuario
        // ArrayList<Integer> movimientos = new ArrayList<Integer>(); // Array List
        // movimientos

        String opcionUsuarioInicio, opcionUsuarioMenu;
        int opcionInt, opcionIntMenu;

        // Datos de usuario

        datosUsuario.add("Juanito Blanco");
        datosUsuario.add("pass");
        datosUsuario.add("23234567890");
        datosUsuario.add("100000");
        
        System.out.println("Esta aplicacion simula un cajero automatico y sus funciones");
		System.out.println("Los datos del usuario ya fueron cargados, los mostramos a continuacion:");
		System.out.println("**********************************************************************");
		System.out.println("Eltitular de la cuenta es:  "+datosUsuario.get(0));
		System.out.println("PIN de ingreso:  "+datosUsuario.get(1));
		System.out.println("CBU: "+datosUsuario.get(2));
		System.out.println("Saldo de la cuenta en pesos:  $"+datosUsuario.get(3));
		System.out.println("**********************************************************************");
        opcionUsuarioInicio = bienvenida();
        opcionInt = Integer.parseInt(opcionUsuarioInicio);
        
         do {

            switch (opcionInt) {
                case 1:
                    if (login(datosUsuario)) {
                        do {
                            // MENU DE OPCIONES************************************
                            System.out.println("*********************************");
                            System.out.println("MENÚ DE OPCIONES:");
                            System.out.println("1- Ver datos del cliente");
                            System.out.println("2- Consultar saldo actual");
                            System.out.println("3- Realizar depósito");
                            System.out.println("4- Realizar extracción");
                            System.out.println("5- Realizar transferencia");
                            System.out.println("6- Salir");

                            opcionUsuarioMenu = pedirDato("Elige una opción");
                            opcionIntMenu = Integer.parseInt(opcionUsuarioMenu);

                            switch (opcionIntMenu) {
                                case 1:
                                    verDatosCliente(datosUsuario);
                                    break;
                                case 2:
                                    verSaldoActual(datosUsuario);
                                    break;
                                case 3:
                                    realizarDeposito(datosUsuario);
                                    break;
                                case 4:
                                    realizarExtraccion(datosUsuario);
                                    break;
                                case 5:
                                    realizarTransferencia(datosUsuario);
                                    break;
                                case 6:
                                    System.out.println("Puede retirar su tarjeta");
                                    System.out.println("Hasta pronto");
                                    System.out.println("*********************************");
                                    opcionInt = 2;
                                    break;

                                default:
                                    System.out.println("Opción no válida");
                                    break;

                            }
                        } while (opcionIntMenu != 6);

                    } else {
                        System.out.println("PIN INVÁLIDO");
                        System.out.println("*********************");
                    }
                    break;

                case 2:
                    System.out.println("Puede retirar su tarjeta");
                    System.out.println("Hasta pronto");
                    System.out.println("*********************************");
                    break;

                default:
                    System.out.println("Opción no válida");
                    break;
            }

        } while (opcionInt != 2);

    }
}
