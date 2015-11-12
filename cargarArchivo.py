# -*- coding: cp1252 -*-

import networkx as nx
def leertxt():
    archi=open('floydOrig.txt','r') ##Lee el archivo donde estan 
    linea=archi.readline()  ##Variable de linea e inicia el ciclo
    while linea!="":
        linea=archi.readline()
        if linea != "\n" and linea != "": ##Para evitar espacios en blanco
            linea = linea.replace("\n","")##Para eliminar el enter
            arrayVer = linea.split(",")##Separa las coss
            arrayVer[2] = int(float(arrayVer[2])) ##Verifica que se convierta en un peso entero
            vertices = tuple(arrayVer[0:3]) ##Lo convierte en un tuple para meterlo a la lista y luego al grafo
            listaVertices.append(vertices)##Lo guarda en la lista
    archi.close()

##Funcion que presenta un menu de bienvenida y devuelve la opcion seleccionada
def menBienvenida():
    opcion = ""
    print("Seleccione una opcion \n 1. Agregar Grafo \n 2. Quitar Grafo \n 3. Continuar")
    opcion = int(input())
    return opcion
##Funcion que guardar las ciudades y el peeso en caso que el usuario haya agregado otro grafo extra
def ingGrafo():
    print("Ingresar la ciudad 1")
    global ciu1
    ciu1 = raw_input()
    global ciu2
    ciu2 = raw_input("Ingrese la ciudad2")
    global pesos
    pesos = int(input("Ingrese su peso"))
    return True
##Funcion que elimina conexiÚn entre ciudades, y pone un peso muy grande para simular.
def elimGrafo():
    print("Ingresar la ciudad 1")
    global ciu3
    ciu3 = raw_input()
    global ciu4
    ciu4 = raw_input("Ingrese la ciudad2")
    return True

listaVertices = [] ##Define variable lista
leertxt() ##Llama a funcion para leer archivo de texto
opcionIng = False
opcionEli = False
opcionSel = menBienvenida() ##Opcion que seleccioÛ el usuario
if opcionSel == 1:
    opcionIng = ingGrafo()##En caso de ingresar otro dato
elif opcionSel == 2:
    opcionEli = elimGrafo()##En caso de eliminar una conexion


g = nx.DiGraph()##Inicia grafo
g.add_weighted_edges_from(listaVertices)##Inserta la lista de conexiones en el grafo
if opcionIng == True:
    g.add_edge(ciu1,ciu2,weight = pesos)##En caso de haber ingresado un nodo, lo agregue al grafo
if opcionEli == True:
    g.add_edge(ciu3,ciu4,weight = 999999)##En caso de querer eilminar una conexion, le agregamos un peso muy grande


predecesor, distance = nx.floyd_warshall_predecessor_and_distance(g)##Para desplegar la distancias
print "distancia mas corta: "
print distance

print
print "predecesores: "##Para desplegar el camino
print predecesor
