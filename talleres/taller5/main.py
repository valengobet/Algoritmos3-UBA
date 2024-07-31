def trabajo_minimo(demandas):
    # Primero creo las variables trabajo donde voy a almacenar el trabajo que se realiza en cada paso
    # y la variable carga donde guardo la cantidad de vino que estoy transportando en cada paso
    trabajo = 0
    carga = 0
    # Recorro las casas y en cada casa si quieren vender sumo ese vino a la carga y si quieren vender lo resto
    # A la variable trabajo le sumo la cantidad de vino que estoy cargando (ya que para moverlo a la casa adyacente es lo que cuesta)
    for i in range(len(demandas)):
        carga = carga + demandas[i]
        trabajo = trabajo + abs(carga)
    print(trabajo)
            
            
if __name__ == '__main__':
    cantCasas = int(input())
    while(cantCasas != 0):
        demandas = input().split()
        for i in range(len(demandas)):
            demandas[i] = int(demandas[i])
        
        trabajo_minimo(demandas)
        cantCasas = int(input())