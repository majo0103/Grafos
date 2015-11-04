# Grafos

Usted es el encargado de logística del Tribunal Supremo Electorial de la República de Guatemala. Debe planificar los viajes de
distribución de los materiales para la segunda vuelta electoral. Para apoyo de sus labores usted mantiene un grafo (con
dirección), cuyos nodos son las ciudades principales de Guatemala y los arcos son la distancia, expresada en KM, que existe
entre un par de ciudades.
Debido a los desastres naturales y bloqueos en carreteras, que afectan nuestra red vial, usted se ve en la necesidad de
actualizar constantemente su grafo, para indicar que no existe conexión directa entre algún par de ciudades. Al efectuar esa
modificación, usted necesita que el programa le indique nuevamente la distancia más corta y la ruta a tomar para viajar entre
cualquier par de ciudades. Además el programa le indica cual ciudad es el centro del grafo para que usted considere colocar
allí las oficinas centrales de la logística de distribución del Tribunal Supremos Electoral, ya que no desea que estas oficinas
estén solamente en la Ciudad Capital.
Su programa lee el archivo txt que representa el grafo, llamado guategrafo.txt Cada línea tiene, el nombre de la ciudad1,
nombre de la ciudad2 y la distancia en KM que hay desde la ciudad1 a la ciudad2 (recuerde que es un grafo con direcciones).
Ciudad1 Ciudad2 KM
Luego de leer el archivo, se construye el grafo y se aplica el algoritmo de Floyd para calcular la distancia más corta entre
cualquier par de ciudades y cuál es la ciudad que queda en el centro del grafo. Se debe mostrar la matriz de adyacencia que
representa el grafo.
