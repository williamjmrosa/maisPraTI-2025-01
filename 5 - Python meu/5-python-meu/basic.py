# numero = 3
# pi = 3.14
# numero_euler = 2.71828
# escala_terremoto = 9.1

# print(pi)
# print(numero)
# print(numero_euler)
# print(escala_terremoto)

# letra = "I"
# palavra = "Internacional"
# frase = "'Internacional é o melhor time do mundo!'"
# paragafo = "Internacional é o melhor clube do mundo!"

# print(letra)
# print(palavra)
# print(frase)
# print(paragafo)

# print(letra, palavra, frase, paragafo)

# print('Estou aprendendo Python na Alura!',frase)

# idade = int(input("Digite sua idade: "))
# print("Sua idade é: ", idade)

# salario = float(input("Digite seu salario: "))
# print("Seu salario é: ", salario)

# nome = str(input("Digite seu nome: "))
# print("Seu nome é: ", nome)

# def ola_mundo():
#     print("Ola mundo")

# ola_mundo()

# minusculo = 'BRASIL'
# print(minusculo.lower())

# maiusculo = 'brasil'
# print(maiusculo.upper())

# maiusculo.capitalize()
# print(maiusculo.capitalize())

# frase = '   Internacional é o melhor time do mundo!   '
# print(frase)
# print(frase[3:17])
# print(frase[-4:])

# a = 'casaco'
# b = a.replace('ca', 'br')
# print(b)

# print(a.find('o'))
# print(frase.strip())

# print(f'somando 1 + 1 = {1 + 1}')

# print('A subtracao de 5 - 2 = {}'.format(5 - 2))

# print('A multiplicacao de 3 * 4 = %.2f' % (3 * 4))

# print('A divisao de 10 / 2 = %.3f' % (10 / 2))

# print('A divisao inteira de 10 // 3 = %d' % (10 // 3))

# print('O resto da divisao de 10 %% 3 = %d' % (10 % 3))

# print('O valor de 2 elevado a 3 = %.0f' % (2 ** 3))

# import math

# math.sqrt(16)

# casos_doenca = 1000
# populacao = 50000
# casos_por_100k = (casos_doenca / populacao) * 100000
# print('Casos por 100k habitantes: %.2f' % casos_por_100k)

# round(casos_por_100k)

# if 5 > 3:
#     print('5 maior que 3')
# else:
#     print('3 é maior que 5')

# if 5 < 2:
#     print('5 menor que 2')

# if 5 == 2:
#     print('5 igual a 2')

# a = True
# b = False

# print(a, b)

# c = a and b
# print("'A' e 'B' são:", c)

# d = a or b
# print(a|b)
# print("'A' ou 'B' é:", d)

# print (not a)

# print (5 > 3)
# print (5 < 3)
# print (5 >= 3)
# print (5 <= 3)
# print (5 == 3)
# print (5 != 3)

# if 5 > 4:
#     print('5 maior que 4')
# else:
#     print('4 maior que 5')

# if 3 < 4 and 5 > 2:
#     print('Verdadeiro')
#     if 10 == 10:
#         print('10 igual a 10')
#     else:
#         print('10 não é igual a 10')

# else:
#     print('Falso')

# idade = int(input('Digite sua idade: '))
# if idade >= 18:
#     print('Você é maior de idade')
# elif(idade < 18 and idade >= 0):
#     print('Voce é menor de idade')
# else:
#     print('Idade inválida')

# nota1 = float(input('Digite a primeira nota: '))
# nota2 = float(input('Digite a segunda nota: '))
# media = (nota1 + nota2) / 2
    
# status = 'Aprovado' if media >= 7 else 'Reprovado'
# print(f'Sua media foi {media} e voce foi {status}')

# print(1)
# print(2)
# print(3)
# print(4)
# print(5)

# for numero in range(1, 6):
#     print(numero)

# for numero in range(5, 0, -1):
#     print(numero)

# for i in range(0, 5):
#     print(i)
#     print('_______')
#     for j in range(0, 3):
#         print(j)
#     print('________')

# numero = 1
# while numero < 6:
#     print(numero)
#     numero += 1

# tupla = ("Internacional", "Flamengo", "Palmeiras", "Santos", 1910)

# print(tupla.index("Flamengo"))

# for elemento in tupla:
#     print(elemento)

# l1 = ['Ferrero', 'Filó', 'Peter', 'Miles', 'Felícia', 'Bruce']
# l2 = [19, 17, 18, 15, 19, 15]

# l3 = l1 + l2
# print(l3)

# l2_2 = l2 * 2
# print(l2_2)

# print(l1[0:2])

# l1.append('Natasha')
# l2.append(16)
# print(l1)
# print(l2)

# l2.remove(16)
# print(l2)

# del(l2)
# # print(l2)

# for item in l1:
#     print(item)

dicionario = {
    'nome': 'Internacional',
    'fundacao': 1910,
    'cores': ['vermelho', 'branco'],
    'titulos_gringos': 10
}

# print(dicionario['nome'])
# print(dicionario.items())

# for chave, valor in dicionario.items():
#     print(f'{chave}: {valor}')

# print(dicionario.keys())
# print(dicionario.values())

dicionario2 = {
    'fundacao2': 1995,
    'cores2': ['vermelho', 'preto'],
    'titulos_gringos2': 10
}

# dicionario.update(dicionario2)
# print(dicionario)

# dicionario3 = {**dicionario, **dicionario2}
# print(dicionario3)

biomoleculas = {'Proteínas' : 'Aminoácidos', 'Açúcares' : 'Açúcares', 'Açúcares' : 'Gorduras', 'Ácidos Nucleicos' : 'Nucleotídeos'}
print(set(biomoleculas))

# Lista -> Sequência ordenada, mutavel, permite duplicadas
# Tupla -> Sequência ordenada, imutável, permite duplicadas
# Dicionário -> Mapeamento chave-valor, mutável
# Conjunto (set) -> Coleção de valores únicos, sem ordem

# import numpy as np

# matriz = np.array([
#     [1, 2, 3],
#     [4, 5, 6],
#     [7, 8, 9]
# ])

# print(matriz)

# print(matriz.shape)
# print(matriz[1, 2])


# print(matriz.shape[0]) # número de linhas
# print(matriz.shape[1]) # número de colunas

# for linha in range(matriz.shape[0]):
#     for coluna in range(matriz.shape[1]):
#         print(matriz[linha, coluna])

# def mensagem():
#     print('Olá, +MaisPraTi!')

# mensagem()

# def mensagem(texto):
#     print(texto)

# mensagem('Grêmio é o melhor clube do mundo')