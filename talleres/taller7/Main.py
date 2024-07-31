from collections import deque
import sys
def solucion(cuarto_inicial, puertas, teclas, r, luces):
    def bfs(cuarto_inicial, puertas, teclas, r, luces):
        # Primero declaro el estado inicial que es estar en la habitacion 1 con todas las luces 
        # apagadas excepto la primera
        estado_inicial = (1, luces)
        # Armo una cola donde voy a guardar los estados y los pasos realizados para llegar a ese estado
        # y agrego el estado inicial
        cola = deque([(estado_inicial, [])])
        # Guardo los estados que ya fueron generados para evitar bucles
        visitados = [estado_inicial]

        while cola:
            # De la cola desencolo el estado y los pasos
            (cuarto_actual, luces), pasos = cola.popleft()

            # Reviso que no este en el estado el cual se esta en la habitacion del dormitorio
            # y todas las demas luces apagadas
            if (cuarto_actual == r and all(luces[i] == (i == r-1) for i in range(r))):
                return pasos

            # Visito todos los cuartos adyacentes los cuales tengan la luz prendida
            for siguiente_cuarto in puertas[cuarto_actual-1]:
                if luces[siguiente_cuarto-1]:
                    estado_nuevo = (siguiente_cuarto, luces)
                    if(estado_nuevo not in visitados):
                        visitados.append(estado_nuevo)
                        cola.append((estado_nuevo, pasos + ["- Move to room " + str(siguiente_cuarto) + "."]))
            
            # Genero estados donde me mantengo en la misma habitacion pero cambio
            # las luces que se pueden controlar desde esta habitacion, para poder explorar todos
            # los posibles caminos
            for tecla in teclas[cuarto_actual-1]:
                cuarto_controlado = tecla
                if(cuarto_actual != cuarto_controlado):
                    luces_nuevas = list(luces)
                    luces_nuevas[cuarto_controlado - 1] = not luces_nuevas[cuarto_controlado -1]
                    estado_nuevo = (cuarto_actual, luces_nuevas)

                    if(estado_nuevo not in visitados):
                        visitados.append(estado_nuevo)
                        if(luces_nuevas[cuarto_controlado-1]):
                            cola.append((estado_nuevo, pasos + ["- Switch on light in room " + str(cuarto_controlado) + "."]))
                        else:
                            cola.append((estado_nuevo, pasos + ["- Switch off light in room " + str(cuarto_controlado) + "."]))
        
        return None
    
    res = bfs(1, puertas, teclas, r, luces)

    # Imprimo la respuesta
    if(res == None):
        print("The problem cannot be solved.")
    
    else:
        print("The problem can be solved in " + str(len(res)) + " steps:")
        for paso in res:
            print(paso)

r = -1
d = -1
s = -1
contador = 1
test_num = 1
for linea in sys.stdin:
    datos = linea.split()
    if(len(datos) == 0):
        print("Villa #" + str(test_num))
        solucion(1, puertas, teclas, r, luces)
        print("")
        test_num += 1

    if(len(datos) > 0):
        if(len(datos) == 3):
            r = int(datos[0])
            d = int(datos[1])
            s = int(datos[2])
            if(r == d == s == 0):
                sys.exit()
            luces = [False] * r
            luces[0] = True
            puertas = [[] for _ in range(r)]
            teclas = [[] for _ in range(r)]
            contador = 1
        elif(contador <= d):
            puertas[int(datos[0]) - 1].append(int(datos[1]))
            puertas[int(datos[1]) - 1].append(int(datos[0]))
            contador += 1
        elif(contador > d and contador <= (d+s)):
            teclas[int(datos[0])-1].append(int(datos[1]))
            contador += 1

    
    
    