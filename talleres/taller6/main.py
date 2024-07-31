def cambios(s1, s2):
    cambiosAB = []
    cambiosBA = []
    for i in range(len(s1) -1, -1, -1):
        if(s1[i] == "a" and s2[i] == "b"):
            cambiosAB.append(i+1)
        
        if(s1[i] == "b" and s2[i] == "a"):
            cambiosBA.append(i+1)
    ab = len(cambiosAB)
    ba = len(cambiosBA)
    if(ab+ba)%2 == 1:
        print(-1)
    else:
        if(ab%2 ==0):
            print((ab+ba)// 2)
        else: print((ab+ba)//2 +1)

        while(len(cambiosAB) > 1):
            index1 = cambiosAB.pop()
            index2 = cambiosAB.pop()
            print(str(index1) + " " + str(index2))
    
        while(len(cambiosBA) > 1):
            index1 = cambiosBA.pop()
            index2 = cambiosBA.pop()
            print(str(index1) + " " + str(index2))
    
        if(len(cambiosAB) == 1 and len(cambiosBA) == 1):
            indexAB = cambiosAB.pop()
            indexBA = cambiosBA.pop()
            print(str(indexAB) + " " + str(indexAB))
            print(str(indexAB) + " " + str(indexBA))





if __name__ == '__main__':
    longitud = int(input())
    s1 = input()
    s2 = input()
    cambios(s1, s2)


        
    
