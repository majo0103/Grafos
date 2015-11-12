import java.io.IOException;
import javax.swing.JOptionPane;


public class Floyd {
    
    BuscarArchivo archivo= new BuscarArchivo();
    public InterfazGrafo interfaz;
    int[][] P;
    int[] max;
    int centro;
    int minimo=10000;
    String direccion;
    

    public Floyd()
    {
        
        direccion = JOptionPane.showInputDialog("Ingrese la direccion del archivo de texto." );
        archivo.obtenerArchivo(direccion);
        archivo.arregloDeNombres();
        interfaz = archivo.matrizDeCostos();
        P = new int[25][25];
        max = new int[25];
        for(int n=0;n<archivo.grafo.size();n++)
        {
            for(int m=0;m<archivo.grafo.size();m++)
            {
                P[n][m]=10000;
            }
        }
    }
    
    public void caminoMasCorto()
    {
        for(int k=0;k<interfaz.size();k++)
        {
            for(int i=0;i<interfaz.size();i++)
            {
                for(int j=0;j<interfaz.size();j++)
                {
                    if(interfaz.getEdge(interfaz.get(i),interfaz.get(j))>(interfaz.getEdge(interfaz.get(i), interfaz.get(k))+interfaz.getEdge(interfaz.get(k), interfaz.get(j))))
                    {
                        interfaz.addEdge(interfaz.get(i), interfaz.get(j), (interfaz.getEdge(interfaz.get(i), interfaz.get(k))+interfaz.getEdge(interfaz.get(k), interfaz.get(j))));
                        P[i][j]=k;
                    }
                }
            }
        }
        
    }
    
    public void centroGrafo()
    {
        caminoMasCorto();
        int n=0;       
        for(int i=0;i<interfaz.size();i++)
        {
            for(int j=0;j<interfaz.size()-1;j++)
            {
                int num1=interfaz.getEdge(interfaz.get(j), interfaz.get(i));
                n=j;
                n++;
                int num2=interfaz.getEdge(interfaz.get(n), interfaz.get(i));
                if(num1>num2)
                {
                    max[i]=num1;
                }
                else
                {
                    max[i]=num2;
                }
            }
            n++;
        }
        for(int i=0;i<interfaz.size();i++)
        {
            int num1=max[i];
            if(num1<minimo)
            {
                centro=i;
                minimo=num1;
            }
        }
        JOptionPane.showMessageDialog(null, "La ciudad que esta en el centro "
                + "del grafo es: " +interfaz.get(centro)+"\n");
    }
    

    public void mostrarIntermedias(int num1, int num2)
    {
        if(P[num1][num2]!=10000)
        {
            mostrarIntermedias(num1,P[num1][num2]);
            System.out.print(", "+interfaz.get(P[num1][num2]));
            mostrarIntermedias(P[num1][num2],num2);
        }
        else {
        }
           
    }
}
