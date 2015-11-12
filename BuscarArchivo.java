


import java.io.*;

/**
 * Esta clase se utiliza para buscar el archivo de texto que se va a utilizar
 */
public class BuscarArchivo
{
    
    File archivo;
    FileReader filereader;
    BufferedReader bufferedreader;
    InterfazGrafo grafo = new GraphMatrix();

    

    public void obtenerArchivo(String direccion)
    {
       archivo=new File(direccion); 
    }  
    

    public InterfazGrafo arregloDeNombres() throws FileNotFoundException, IOException
    {
        // Lectura del  archivo de texto
        filereader = new FileReader (archivo);
        bufferedreader = new BufferedReader(filereader);
        String linea;
        while((linea=bufferedreader.readLine())!=null)
        {
            String[] tmp;
            tmp=linea.split(" ");
            grafo.add(tmp[0]);
            grafo.add(tmp[1]);
        }
        return grafo; //Devuelve el grafo
    }
    

    public InterfazGrafo matrizDeCostos() throws FileNotFoundException, IOException
    {
        // Lectura del fichero
        filereader = new FileReader (archivo);
        bufferedreader = new BufferedReader(filereader);
        String linea;
        //SE lee el archivo
        while((linea=bufferedreader.readLine())!=null)
        {
            String[] tmp;
            tmp=linea.split(" ");
            grafo.addEdge(tmp[0], tmp[1], tmp[2]);
        }
        return grafo;
    }
    

}
