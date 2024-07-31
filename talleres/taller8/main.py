import sys

def dfs(v, p, aristas, visitados, backedge, valor_paloma):
    visitados[v] = visitados[p] + 1
    cubren = 0
    cubren_hijo = 0

    for u in aristas[v]:
        if(not visitados[u]):
            cubren_hijo = dfs(u , v, aristas, visitados, backedge, valor_paloma)

            if(cubren_hijo - backedge[v] == 0):
                valor_paloma[v] += 1
            
            cubren += cubren_hijo - backedge[v]
            backedge[v] = 0
        elif(u != p and visitados[u] < visitados[v]):
            cubren += 1
            backedge[u] += 1
    
    return cubren
    

def mergeSort(lista):
    if(len(lista) > 1):
        mitad = len(lista) // 2

        mitad_izq = lista[:mitad]
        mitad_der = lista[mitad:]
        mergeSort(mitad_izq)
        mergeSort(mitad_der)

        i = j = k = 0

        while(i < len(mitad_izq) and j < len(mitad_der)):
            if(mitad_izq[i][1] > mitad_der[j][1]):
                lista[k] = mitad_izq[i]
                i+= 1
            elif(mitad_izq[i][1] == mitad_der[j][1]):
                if(mitad_izq[i][0] < mitad_der[j][0]):
                    lista[k] = mitad_izq[i]
                    i+= 1
                else:
                    lista[k] = mitad_der[j]
                    j += 1
            else:
                lista[k] = mitad_der[j]
                j += 1
            k += 1
        
        while(i < len(mitad_izq)):
            lista[k] = mitad_izq[i]
            i += 1
            k += 1
        
        while(j < len(mitad_der)):
            lista[k] = mitad_der[j]
            j += 1
            k += 1


datos = input().split()
N = int(datos[0])
M = int(datos[1])
while(N != 0 and M != 0):
    cant_estaciones = N
    estaciones_candidatas = M
    aristas = [[] for _ in range(int(cant_estaciones))]
    visitados = [0 for _ in range(cant_estaciones)]
    backedge = [0 for _ in range(cant_estaciones)]
    valor_paloma = [1 for _ in range(cant_estaciones)]
    valor_paloma[0] = 0

    datos = input().split()
    v = int(datos[0])
    u = int(datos[1])
    while(v != -1 and u != -1):
        aristas[v].append(u)
        aristas[u].append(v)
        datos = input().split()
        v = int(datos[0])
        u = int(datos[1])
    
    dfs(0, -1, aristas, visitados, backedge, valor_paloma)

    for i in range(cant_estaciones):
        valor = valor_paloma[i]
        valor_paloma[i] = (i, valor)

    mergeSort(valor_paloma)

    for i in range(estaciones_candidatas):
        print(str(valor_paloma[i][0]) + " " + str(valor_paloma[i][1]))
    print(" ")
    datos = input().split()
    N = int(datos[0])
    M = int(datos[1])









    




