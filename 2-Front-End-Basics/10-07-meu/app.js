let calcular = []

const resultado = document.getElementById('txtResultado')

function inserir(num) {

    // if(calcular.length == 0 && num == '-') {
    //     calcular.push(num)
    // } else 
    if (isOperador(num) && calcular.length == 0 && num != '-') {
        return
    } else if (isOperador(calcular[calcular.length - 1]) && isOperador(num) && calcular.length > 1) {
        calcular.pop()
    }else if(isOperador(num) && calcular.length == 1 && calcular[0] == '-') {
        return
    }

    if (isPonto(num)) {
        let ultimoPonto = 0
        for (let i = 0; i < calcular.length; i++) {
            if (isPonto(calcular[i])) {
                ultimoPonto++
            } else if (isOperador(calcular[i])) {
                ultimoPonto--
            }
        }
        if (ultimoPonto > 0) {
            return
        }
    }

    calcular.push(num)
    resultado.value = calcular.join('')
}

function deletar() {
    calcular.pop()
    resultado.value = calcular.join('')
}

function CalcularTotal() {

    if (isOperador(calcular[calcular.length - 1]) && isPonto(calcular[calcular.length - 2])) {
        calcular.pop()
    }

    valor = math.evaluate(calcular.join(''))
    calcular = String(valor).split('')
    resultado.value = calcular.join('')
}

function isOperador(char) {
    return ['+', '-', '/', '*'].includes(char)
}

function isPonto(char) {
    return ['.'].includes(char)
}

function limparTela() {
    calcular = []
    resultado.value = ''
}

