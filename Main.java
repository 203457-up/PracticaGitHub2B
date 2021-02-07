import java.util.Scanner;
public class Main {
    static Scanner scanner = new Scanner (System.in);
    static double total = 0;
    static double Monedero = 0;
    public static void main(String[] args) {

        Productos productos [] = new Productos[3];
        productos[0] = new Productos();
        productos[0].setProducto(1, "Vitaminas y minerales", 142, 1.42);
        productos[1] = new Productos();
        productos[1].setProducto(2, "Suero", 19, 0.95);
        productos[2] = new Productos();
        productos[2].setProducto(3, "Leche en polvo", 128, 1.13);

        System.out.println("Bienvenido");    
    for (int i = 0; i < productos.length; i++) {
        System.out.println("id: " + productos[i].getNumeroProducto() + " Nombre: " + productos[i].getNombre() + " - Precio: "
                + productos[i].getPrecio());
    }
        System.out.println("---------------------------------------------------------");
        compra(productos);
        System.out.println("Gracias por su compra");
    }

    public static void compra(Productos productos[]) {
        int id, Aux = 1;
        double cantidad;
        do {
            System.out.println("Ingrese el producto que desea comprar");
            id = scanner.nextInt();
            System.out.println("Cuantos productos lleva?");
            cantidad = scanner.nextDouble();
            if (id < 1 || id > 3) {
                System.out.println("Intentelo de nuevo");
            } else {
                Monedero =  cantidad * productos[id-1].abono();
                total = total + (productos[id-1].getPrecio() * cantidad);
                System.out.println("Si desea comprar otro producto precione 1 de lo contrario 2");
                Aux=scanner.nextInt();
            }
        } while (Aux != 2);
        pago(productos);
    }

    public static void pago(Productos productos[]) {
        int conMonedero; 
        int error=0;
        String numeroMonedero;

        MonElectronico monElectronico = new MonElectronico();
        monElectronico.setNumMonedero("12345678");
        monElectronico.setDineroElec(149); //saldo actuial en monedero
        System.out.println("Cuenta con monedero electronico");
        System.out.println("1 = si, 2 = no");
        conMonedero = scanner.nextInt();
        if (conMonedero == 1) {
            do {
                System.out.println("Ingrese su numero de monedero electronico");
                numeroMonedero = scanner.next();  
                if (numeroMonedero.equals(monElectronico.getNumMonedero())) {
                    monElectronico.setDineroElec(monElectronico.getDineroElec()+Monedero);  
                    System.out.println("Pago y abono a monedero realizado");
                    System.out.println("su abono a monedero es de " + monElectronico.getDineroElec() + " pesos");    
                if (monElectronico.getDineroElec()>150) {
                    System.out.println("Por acumular más de 150 le regalaremos otros 150");
                    System.out.println("Saldo: "+monElectronico.getDineroElec());
                }
                error = 1;
            }else{
                System.out.println("Intentelo de nuevo");
            }
        } while (error == 0);        
    }else{
        System.out.println("Pago sin monedero, no abona");
    } 
    }
}