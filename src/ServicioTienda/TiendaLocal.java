/*
 Se necesita una aplicación para una tienda en la cual queremos almacenar los distintos
productos que venderemos y el precio que tendrán. Además, se necesita que la
aplicación cuente con las funciones básicas.
Estas las realizaremos en el servicio. Como, introducir un elemento, modificar su precio,
eliminar un producto y mostrar los productos que tenemos con su precio (Utilizar
Hashmap). El HashMap tendrá de llave el nombre del producto y de valor el precio.
Realizar un menú para lograr todas las acciones previamente mencionadas
 */
package ServicioTienda;

import EntidadTeinda.tienda;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TiendaLocal {

    Scanner sc = new Scanner(System.in).useDelimiter("\n");
    tienda ti = new tienda();
    HashMap<String, Integer> lista = new HashMap();

    public void agregar() {
        int num;
        do{
        System.out.println("ingrese el producto");
        ti.setProducto(sc.next());
        System.out.println("ingrese su precio");
        ti.setPrecio(sc.nextInt());
        lista.put(ti.getProducto(), ti.getPrecio());
            System.out.println("necesitas agregar otro producto?"
                    + "1 agregar / 2 salir");
            num=sc.nextInt();
        }while(num==1);
    }

    public void modificarPrecio() {
        String aux;
        Integer nuevo;
        System.out.println("ingrese el producto a modificar su precio");
        aux = sc.next();
        if (lista.containsKey(aux)) {
            Integer viejo = lista.get(aux);
            System.out.println("el precio actual es" + viejo);
            System.out.println("ingrese nuevo precio");
            nuevo = sc.nextInt();
            lista.put(aux, nuevo);
            System.out.println("actualizo el precio de " + aux + " valor anterior era: $" + viejo + " el precio nuevo es: $" + nuevo);

        } else {
            System.out.println("no se encontro el producto" + aux);
        }
    }
    
    public void eliminar(){
        System.out.println("ingrese producto a eliminar");
        String aux = sc.next();
        int opcion;
        if(lista.containsKey(aux)){
            System.out.println("el producto "+aux+" esta por eliminarse"
                    + "precione 1 para confirmar o 2 para cancelar");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    lista.remove(aux);
                    break;
                default:
                    System.out.println("el porducto "+aux+" no se eliminara");
            }            
        }else {
            System.out.println("no se encontro el producto" + aux);
        }
    }
    
    public void mostrarLista() {
        System.out.println("Las entradas en el HashMap son:");
        for (Map.Entry<String, Integer> entry : lista.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
    
    public void menu() {
        
        System.out.println("Bienvenido");
       
        int opc = 0;
        do {
            System.out.println("Qué acción desea realizar.");
            System.out.println("1. Añadir nuevos productos");
            System.out.println("2. Modificar productos existentes");
            System.out.println("3. Eliminar productos existentes");
            System.out.println("4. Mostrat productos actuales");
            System.out.println("5. Salir");
            opc = sc.nextInt();
            switch (opc) {
                case 1:
                    agregar();
                    break;
                case 2:
                    modificarPrecio();
                    break;
                case 3:
                    eliminar();
                    break;
                case 4:
                    mostrarLista();
                    break;
                case 5:
                    System.out.println("Gracias por usar el sistema");
                    break;
                default:
                    System.out.println("opción no válida");
            }
        } while (opc!=5);
    }
}

