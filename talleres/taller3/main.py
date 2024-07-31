def mejor_bajada(arboles, j, t, f, M):
    def maxEnPos(arboles, altura, arbol, h, t, f):
        if(altura == h - 1):
            M[altura][arbol] = 0
        if(M[altura][arbol] != -1):
            return M[altura][arbol]

        
        max_actual = 0
        for i in range(t):
            if(i != arbol and altura + f < h):
                if(M[altura + f][i] == -1):
                    M[altura + f][i] = maxEnPos(arboles, altura + f, i, h, t, f);
                
                if(M[altura+f][i] > max_actual):
                    max_actual = M[altura+f][i]

                
            elif(i == arbol):
                if(M[altura + 1][i] == -1):
                    M[altura + 1][i] = maxEnPos(arboles, altura + 1, i, h, t, f);
                 
                if(M[altura+1][i] > max_actual):
                    max_actual = M[altura+1][i]
                
        M[altura][arbol] = arboles[altura][arbol] + max_actual;
        return M[altura][arbol];




    for i in range(t):
        maxEnPos(arboles, 0, i, h, t, f)
    
arboles = [
    [1,0,0],
    [0,2,1],
    [0,1,0],
    [0,1,0],
    [0,0,1],
    [0,1,1],
    [1,0,1],
    [0,1,1],
    [0,0,0],
    [1,0,0]
]

h = 10
t = 3
f = 2
M  = [[-1] * t for _ in range(h)]
res = mejor_bajada(arboles, h, t, f, M);
for i in range(len(M)):
    print("columna: " + str(i) + " ")

    for j in range(len(M[i])):
        print(str(M[i][j]) + " ")
            

        
print(res);
        
    

