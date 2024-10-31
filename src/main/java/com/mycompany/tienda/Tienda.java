/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tienda;

/**
 *
 * @author USER
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Tienda {




    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Diccionario con códigos de productos y sus precios
        HashMap<String, String> productos = new HashMap<>(); 
        HashMap<String, Integer> precios = new HashMap<>();
        
        productos.put("001", "pan");
        precios.put("001", 2000);
        
        productos.put("002", "leche");
        precios.put("002", 4000);
        
        productos.put("003", "papas fritas");
        precios.put("003", 3000);
        
        productos.put("004", "gaseosa");
        precios.put("004", 2500);
        
        productos.put("005", "yogurt");
        precios.put("005", 3500);
        
        boolean opcion = true;
        System.out.println("Bienvenido a Super Konmarket");
        
        while (opcion) {
            System.out.println("");
            System.out.println("Seleccione una opción:");
            System.out.println("1. Mostrar todos los productos disponibles.");
            System.out.println("2. Traducir código de producto y mostrar su precio.");
            System.out.println("3. Agregar un nuevo producto al inventario.");
            System.out.println("4. Ingresar un listado de códigos de productos (separados por coma) y calcular el total.");
            System.out.println("5. Salir del programa.");
            
            byte opcionNumero = sc.nextByte();
            sc.nextLine(); // Limpiar el buffer
            
            switch (opcionNumero) {
                case 1: 
                    System.out.println("Listado de productos disponibles:");
                    for (Map.Entry<String, String> entry : productos.entrySet()) {
                        String codProducto = entry.getKey();
                        String nombreProducto = entry.getValue();
                        int precioProducto = precios.get(codProducto);
                        System.out.println("Código: " + codProducto + ", Producto: " + nombreProducto + ", Precio: $" + precioProducto + " COP");
                    }
                    break;

                case 2:
                    System.out.println("Ingrese el código de producto para ver su nombre y precio:");
                    String codigo = sc.nextLine();
                    String producto = productos.get(codigo);
                    Integer precio = precios.get(codigo);
    
                    if (producto != null && precio != null) {
                        System.out.println("Producto: " + producto);
                        System.out.println("Precio: $" + precio + " COP");
                    } else {
                        System.out.println("No se encontró un producto para el código: " + codigo);
                    }
                    break;
                    
                case 3:
                    System.out.println("Ingrese el código del nuevo producto:");
                    String nuevoCodigo = sc.nextLine();
                    if (!productos.containsKey(nuevoCodigo)) {
                        System.out.println("Ingrese el nombre del producto:");
                        String nuevoNombre = sc.nextLine();
                        System.out.println("Ingrese el precio del producto en pesos colombianos:");
                        int nuevoPrecio = sc.nextInt();
                        sc.nextLine();                         
                        productos.put(nuevoCodigo, nuevoNombre);
                        precios.put(nuevoCodigo, nuevoPrecio);
                        System.out.println("Producto agregado exitosamente: " + nuevoNombre + ", Precio: $" + nuevoPrecio + " COP");
                    } else {
                        System.out.println("El código ya existe en el inventario. Intente con otro código.");
                    }
                    break;

                case 4:
                    System.out.println("Ingrese el listado de códigos de productos (separados por comas):");
                    String[] listadoCodigos = sc.nextLine().split("\\s*,\\s*");
                    int totalCompra = 0;
                    int contadorProductosNuevos = 0;
                    StringBuilder detalleCompra = new StringBuilder("Productos comprados:\n");
                    
                    for (String cod : listadoCodigos) {
                        if (productos.containsKey(cod)) {
                            String nombreProducto = productos.get(cod);
                            int precioProducto = precios.get(cod);
                            detalleCompra.append("- ").append(nombreProducto).append(": $").append(precioProducto).append(" COP\n");
                            totalCompra += precioProducto;
                        } else {
                            contadorProductosNuevos++;
                            System.out.println("Ingrese el nombre del producto para el código " + cod + ":");
                            String nombreProducto = sc.nextLine();
                            System.out.println("Ingrese el precio del producto en pesos colombianos:");
                            int precioProducto = sc.nextInt();
                            sc.nextLine(); 
                            
                            productos.put(cod, nombreProducto);
                            precios.put(cod, precioProducto);
                            detalleCompra.append("- ").append(nombreProducto).append(" (nuevo): $").append(precioProducto).append(" COP\n");
                            totalCompra += precioProducto;
                        }
                    }
                    System.out.println("Cantidad de productos nuevos agregados: " + contadorProductosNuevos);
                    System.out.println(detalleCompra.toString());
                    System.out.println("Total de la compra: $" + totalCompra + " COP");
                    break;
                    
                case 5: 
                    opcion = false;
                    System.out.println("Gracias por visitar Super Konmarket. ¡Hasta pronto!");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}

