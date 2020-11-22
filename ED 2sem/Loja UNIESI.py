def nota (compras):
    pedido = 'Seu pedido foi concluído, OBRIGADO!'
    print("/-----------------------------------------------/")
    print(pedido.center(50))
    soma = 0.0
    for e in compras:
        print("%20s x%5d %5.2f %6.2f" % (e[0],
                        e[1],e[2],
                        e[1] * e[2]))
    soma += e[1] * e[2]
    print("Total: %7.2f" % soma)
    print('')
    print("/-----------------------------------------------/")
    
def lista (compras):
    print("/----------De uma olhada so seu carrinho de compras!---------/")
    t=0
    for e in compras:
        print(t, "%20s x%5d" %  ( e[0], e[1],))
        t=t+1
    print('')
    print("/-------------------------------------------------------------/")

def remover (compras):
    k=int(input('Digite o número do produto para remover: ')) 
    del(compras[k])




inicio = 'Loja'
print("/-----------------------------------------------/")
print(inicio.center(50))
a=True
while a == True:
    print('')
    cond=int(input('1 - Comprar: ' + '\n'  + '2 - Lista de Compra: ' + '\n' + '3 - Excluir item: ' + '\n' + '4 - Fechar compra: ' + '\n' + '5 - Sair:' + '\n' ))
    print('')

    if (cond == 1):
        print("/-------------------Hora de ir às compras-------------------/")
        compras = [   ]
        x=1
        while (x==1):
            produto = input("Produto: ")
            quantidade = int(input("Quantidade: "))
            preço = float(input("Preço: "))
            x=int(input("Deseja comprar algo a mais? Tecle: 1 para Sim - 2 para Não: "))
            compras.append([produto, quantidade, preço])
    elif (cond==2):
        lista (compras)
    elif (cond==3):
        remover(compras)
    elif (cond==4):
        nota (compras)
    else:
        encerramento = 'OBRIGADO PRO COMPRA NOSSOS PRODUTOS!'
        print('--------------------------------------------------')
        print(encerramento.center(50))
        print('---------------------------------------------------')
        print('')
        a=False