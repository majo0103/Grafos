import java.util.Scanner;
import javax.swing.JOptionPane;
/**
 *
 */
public class Main {

    public static void main(String[] args)
    {
      String cadenaD = "";    
              
        Floyd matriz = new Floyd(); 
        matriz.caminoMasCorto(); 
        int Ingreso; 
        int opcion1; 
        
        Scanner scan = new Scanner(System.in); //Entrada por teclado
       
        Ingreso = Integer.parseInt(JOptionPane.showInputDialog(null,
                "1. Encontrar la ruta mas corta entre dos ciudades\n"
                + "2. Nombre de la ciudad que esta en el centro del grafo\n"
                + "3. Modificar grafo\n4. Salir del programa",
                "Ingrese una opcion",3));
        
        
      
        
        
        while(Ingreso!=4)
        {
            // Desplegar la matriz
           
            String matriz_de_adyacencia = matriz.interfaz.show2();
            JOptionPane.showMessageDialog(null, matriz_de_adyacencia,"Matriz "
                    + "de adyacencia",1);
            
           
            if(Ingreso==1)
            {
                matriz.caminoMasCorto(); 
                String ciudad1 = JOptionPane.showInputDialog(null,"Ingrese la ciudad de salida","",3);
              
                
                
                String ciudad2 = JOptionPane.showInputDialog(null,"Ingrese la ciudad de destino","",3);
            
             
                if(matriz.interfaz.contains(ciudad1)&&matriz.interfaz.contains(ciudad2))
                {
                    cadenaD =  "La distancia minima es: "+matriz.interfaz.getEdge(ciudad1, ciudad2)+".";
                    
                    if(matriz.interfaz.getEdge(ciudad1, ciudad2)!=10000)
                    {
                       
                        cadenaD = cadenaD +("\nLa ruta es: "+ciudad1);
                        matriz.mostrarIntermedias(matriz.interfaz.getIndex(ciudad1), matriz.interfaz.getIndex(ciudad2));
                      
                        cadenaD = cadenaD + ", " + ciudad2;
                    }
                    JOptionPane.showMessageDialog(null,cadenaD);
                }
            }
            
         
            else if(Ingreso==2)
            {
                matriz.centroGrafo();
            }
            
            else if(Ingreso==3)
            {
               
               opcion1 = Integer.parseInt(JOptionPane.showInputDialog(
                       "1. Hay interrupcion de trafico entre un par de ciudades\n"
                     + "2. Establecer nueva conexion"));
                /*Si la respuesta es 1, preguntar por el nombre de las ciudades
                 *y colocar un numero muy grande en la matriz de adyacencia
                 *para indicar que no hay conexion*/
                if(opcion1==1)
                {
                  
                    String ciudad1 = JOptionPane.showInputDialog(null,"Ingrese "
                            + "el nombre de la ciudad de salida",
                            "Ciudad de salida",3);
                    
                    
                    String ciudad2 = JOptionPane.showInputDialog(null,
                            "Ingrese el nombre de la ciudad de destino",
                            "Ciudad de destino",3);
                    if(matriz.interfaz.contains(ciudad1)&&matriz.interfaz.contains(ciudad2))
                    {
                        matriz.interfaz.addEdge(ciudad1, ciudad2, 10000);
                    }
                }
               
                else if(opcion1==2){
                   
                    String ciudad1 = JOptionPane.showInputDialog(null,"Ingrese "
                            + "el nombre de la ciudad de salida",
                            "Ciudad de salida",3);
                   
                    String ciudad2 = JOptionPane.showInputDialog(null,
                            "Ingrese el nombre de la ciudad de destino",
                            "Ciudad de destino",3);
                
                    int distancia = Integer.parseInt(JOptionPane.showInputDialog
                    (null,"Ingrese la distancia entre las ciudades",3));
                    
                    
                    if(matriz.interfaz.contains(ciudad1)&&matriz.interfaz.contains(ciudad2))
                    {
                        matriz.interfaz.addEdge(ciudad1, ciudad2, distancia);
                    }
                    
                    else
                    {
                        matriz.interfaz.add(ciudad1);
                        matriz.interfaz.add(ciudad2);
                        matriz.interfaz.addEdge(ciudad1, ciudad2, distancia);
                    }
                }
                // Recalcular las rutas mas cortas
                matriz.caminoMasCorto();
            }
       
            Ingreso =  Integer.parseInt(JOptionPane.showInputDialog(null,"1. Se buscara la ruta mas corta entre "
                    + "entre dos ciudades\n2. El nombre de la cuidad de en medio es "
                    + "del grafo\n3. Modificar grafo\n4. Finalizar programa"));
        }
        
    }
}
