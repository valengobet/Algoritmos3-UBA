import math
from queue import PriorityQueue


def prim(raiz, costos_aristas, nodos, pq):
    nodos_vistos = [raiz]
    aristas_minimas = []
    agregarAristasValidas(0, costos_aristas, pq)
    i = 1
    while(not pq.empty() and i < nodos):


    return movimientos_totales


def rolls(v1, v2):
    numero1 = [int(digito) for digito in str(v1)]
    numero2 = [int(digito) for digito in str(v2)]
    res = 0

    for i in range(4):
        a = numero1[i]
        b = numero2[i]
        res += min((a - b) % 10, (b - a) % 10)
    return res


# grafo = [[0000, 1111], [0000, 1155], [0000, 5511], [1111, 1155], [1111, 5511], [1155, 5511]]
# n = 4
# AG, movimientos= prim(grafo, 0000, n)

# print(movimientos)


cant_test = int(input())
for i in range(cant_test):
    datos = input().split()
    datos.insert(1, "0000")
    cant_codigos = int(datos[0]) + 1
    codigos = [num for num in datos[1:]]
    costos_aristas = [[] for _ in range(cant_codigos)]
    pq = PriorityQueue()
    for j in range(1, cant_codigos):
        for k in range(0, cant_codigos):
            if(j != k ):
                print("se agrega: " + str((codigos[j], codigos[k])) + " en: " + str(j))
                costos_aristas[j].append((rolls(codigos[j], codigos[k]), j, k)) 


    minimos = 37
    for l in range(1, len(codigos)):
        if(rolls(codigos[l], "0000") < minimos):
            minimos = rolls(codigos[l], "0000")
            codigo_inicial = l
    costos_aristas[0].append((minimos, 0, l))
    # res = prim("0000",arista_inicial,  cant_codigos, pq)
    # print(res)


print(rolls("0213", "9113"))