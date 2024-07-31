
def calcula_horizonte(alturas, anchos, n, test):
    #calculo la secuencua de crecimiento mas larga usando programacion dinamica bottom-up
    def secuencia_creciente():
        #creo la tabla para memorizar
        tabla = [0] * n
        #el maximo ancho posible usando el primer edificio es su propio ancho asi que lo guardo en la tabla
        tabla[0] = anchos[0]
        for i in range(1, n):
            max_actual = 0
            for j in range(i):
                #comparo que el edificio i sea mas alto que el j y que el maximo posible usando el edificio j (guardado en la tabla) es mayor al maximo actual del edificio i
                if(alturas[i] > alturas[j] and max_actual < tabla[j]):
                    max_actual = tabla[j]
            #una vez que ya tengo calculado el maximo posible del edificio i lo guardo en la tabla para no calcularlo en siguientes iteraciones 
            tabla[i] = max_actual + anchos[i]

        return max(tabla)

    #calculo la secuencia de decrecimiento mas larga usando programacion dinamica bottom-up
    def secuencia_decreciente():
        #creo la tabla para memorizar
        tabla = [0] * n
        #el maximo ancho posible usando el primer edificio es su propio ancho asi que lo guardo en la tabla
        tabla[0] = anchos[0]
        for i in range(1, n):
            max_actual = 0
            for j in range(i):
                #comparo que el edificio i sea mas bajp que el j y que el maximo posible usando el edificio j (guardado en la tabla) es mayor al maximo actual del edificio i
                if(alturas[i] < alturas[j] and max_actual < tabla[j]):
                    max_actual = tabla[j]
            #una vez que ya tengo calculado el maximo posible del edificio i lo guardo en la tabla para no calcularlo en siguientes iteraciones 
            tabla[i] = max_actual + anchos[i]

        return max(tabla)

    creciente = secuencia_creciente()
    decreciente = secuencia_decreciente()
    #comparo las 2 secuencias e imprimo lo que corresponda segun el caso
    if creciente >= decreciente:
        print("Case " + str(test) + ". Increasing (" + str(creciente) + "). " + "Decreasing (" + str(decreciente) + ").")
    else:
        print("Case " + str(test) + ". Decreasing (" + str(decreciente) + "). " + "Increasing (" + str(creciente) + ").")


cantTests = int(input())
for i in range(cantTests):
    n = int(input())
    alturas = list(map(int, input().split()))
    anchuras = list(map(int, input().split()))
    calcula_horizonte(alturas, anchuras, n,  i+1)