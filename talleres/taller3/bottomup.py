def mejor_bajada(arboles, h, t, f):
    M  = [[-1] * t for _ in range(h)]
    def maxEnPos(arboles, altura, arbol, h, t, f):
        if altura == h-1:
            M[altura][arbol] = arboles[altura][arbol]
        if M[altura][arbol] != -1:
            return M[altura][arbol]
        
        max_actual = 0
        for i in range(t):
            if arbol != i and altura + f < h:
                if M[altura + f][i] > max_actual:
                    max_actual = M[altura + f][i]
                    
            elif arbol == i:
                if M[altura + 1][i] > max_actual:
                    max_actual = M[altura + 1][i]
        
        M[altura][arbol] = max_actual + arboles[altura][arbol]
        
        




    for heigh in range(h-1, -1, -1):
        for tree in range(t):
            maxEnPos(arboles, heigh, tree, h, t, f)
    
    mejor_bajada = max(M[0])
    return mejor_bajada

if __name__ == '__main__':
    cantTests = int(input())
    for i in range(cantTests):
        datos = input().split()
        t = int(datos[0])
        h = int(datos[1])
        f = int(datos[2])
        arboles = [[0] * t for _ in range(h)]
        bellotas_por_arbol = []
        for l in range(t):
            entrada = input()
            arbol = [int(alturas) for alturas in entrada.split()]
            arbol.pop(0)
            bellotas_por_arbol.append(arbol)
        
        for j in range(len(bellotas_por_arbol)):
            for k in range(len(bellotas_por_arbol[j])):
                arboles[bellotas_por_arbol[j][k] - 1][j] += 1
    
        res = mejor_bajada(arboles, h, t, f)
        print(res)


        