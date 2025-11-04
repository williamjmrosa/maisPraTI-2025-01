class Aluno:
    def __init__(self, nome, idade, matricula):
        self.nome = nome
        self.idade = idade
        self.matricula = matricula
    
    def apresentar(self):
        return f"Ola, meu nome é {self.nome}, tenho {self.idade} anos e minha matricula é {self.matricula}"

# aluno1 = Aluno("João", 20, 2024001)
# print(aluno1.apresentar())

# lista = []

# try:
#     lista.append(10)
#     lista.append(20)
#     divisao = lista[0]/1
#     print(f"Resultado da divisão: {divisao}")
# except ZeroDivisionError:
#     print("Erro: Divisão por zero não é permitida.")
# except IndexError:
#     print("Erro: Indice fora do alcance da lista.")
# else:
#     print("Operação realizada com sucesso.")

class Pessoa:
    def __init__(self, nome, idade):
        self.nome = nome
        self.idade = idade

    def aniversario(self):
        self.idade += 1
        return f"Feliz aniversário, {self.nome}! Agora você tem {self.idade} anos."

class PessoaFisica(Pessoa):
    def __init__(self, nome, idade, cpf):
        super().__init__(nome, idade)
        self.cpf = cpf

    def apresentar(self):
        return f"Olá, meu nome é {self.nome}, tenho {self.idade} anos e meu CPF é {self.cpf}."

    def aniversario(self):
        mensagem = super().aniversario()
        return mensagem + " Aproveite seu dia especial!"

    def aniversario(self):
        print("Parabéns!")


class PessoaJuridica(Pessoa):
    def __init__(self, nome, idade, cnpj):
        super().__init__(nome, idade)
        self.cnpj = cnpj

    def apresentar(self):
        return f"Olá, minha empresa se chama {self.nome}, tem {self.idade} anos de mercado e meu CNPJ é {self.cnpj}."

# pessoa_fisica = PessoaFisica("Maria", 30, "123.456.789-00")
# print(pessoa_fisica.apresentar())
# print(pessoa_fisica.aniversario())

class Comanda:
    def __init__(self):
        self.itens = []
        self._total = 0.0
        self.__desconto = 0.0 # atributo privado

    def adicionar_item(self, nome, preco):
        self.itens.append({'nome': nome, 'preco': preco})

    def calcular_total(self):
        return sum(item['preco'] for item in self.itens)

    def exibir_comanda(self):
        for item in self.itens:
            print(f"{item['nome']}: R$ {item['preco']:.2f}")
        print(f"Total: R$ {self.calcular_total():.2f}")