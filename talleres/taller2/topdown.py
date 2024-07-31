
def calcula_horizonte(alturas, anchuras, n, test):

    tabla_creciente = [0] * n
    tabla_decreciente = [0] * n

    #algoritmo que usa programacion dinamica con enfoqu topdown
    def dinamica(edificio, crece):
        if crece:
            tabla = tabla_creciente
        else:
            tabla = tabla_decreciente
        #si ya esta en la tabla no lo calcula y lo devuelve directamente
        if tabla[edificio] != 0:
            return tabla[edificio]

        max_actual = 0
        #caso base si es el ultimo edificio de la lista
        if edificio == n -1:
            max_actual = 0

        #calcula teniendo en cuenta si estamos buscando secuencia de crecimiento o decrecimiento el ancho maximo para cada edificio y elige ek de mayor ancho maximo
        for i in range(edificio + 1, n):
            if (crece and alturas[i] > alturas[edificio]) or (not crece and alturas[i] < alturas[edificio]):
                ancho = dinamica(i, crece)
                if(ancho > max_actual):
                    max_actual = ancho

        #guarda lo calculado en la tabka
        tabla[edificio] = max_actual + anchuras[edificio]
        return tabla[edificio]

    #calcula maximo ancho de crecimiento y de decrecimiento
    max_creciente = 0
    max_decreciente = 0
    for i in range(n):
        max_creciente = max(max_creciente, dinamica(i, True))
        max_decreciente = max(max_decreciente, dinamica(i, False))

    #compara ambos anchos y decide si el horizonte esta decreciendo o creciendo
    if max_creciente >= max_decreciente:
        print("Case " + str(test) + ". Increasing (" + str(max_creciente) + "). " + "Decreasing (" + str(max_decreciente) + ").")
    else:
        print("Case " + str(test) + ". Decreasing (" + str(max_decreciente) + "). " + "Increasing (" + str(max_creciente) + ").")


if __name__ == '__main__':
    cantTests = int(input())
    for i in range(cantTests):
        n = int(input())
        alturas = list(map(int, input().split()))
        anchuras = list(map(int, input().split()))
        calcula_horizonte(alturas, anchuras, n, i+1)


