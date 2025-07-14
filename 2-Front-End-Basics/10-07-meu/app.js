let calcular = []

const resultado = document.getElementById('txtResultado')

function inserir(num) {

    // if(calcular.length == 0 && num == '-') {
    //     calcular.push(num)
    // } else 
    calcular.push(num)
    resultado.value = calcular.join('')
}

function deletar() {
    calcular.pop()
    resultado.value = calcular.join('')
}

function CalcularTotal() {

    if(isNaN(Number(calcular[calcular.length - 1]))){
        calcular.pop()
    }

    valor = math.evaluate(calcular.join(''))
    calcular = String(valor).split('')
    resultado.value = calcular.join('')
}

function operador(num){
    if(calcular.length == 0 && num == '-') {
            calcular.push(num)
        }else if(calcular.length > 2 && isNaN(Number(calcular[calcular.length - 1]))){
            calcular.pop()
            calcular.push(num)
        }else if(!isNaN(Number(calcular[calcular.length - 1]))){
            let ultimoPonto = 0
            for(let i = 0; i < calcular.length; i++){
                if(calcular[i] == '.'){
                    ultimoPonto++
                }else if(isNaN(Number(calcular[i]))){
                    ultimoPonto--
                }
            }
            if(num == '.' && ultimoPonto == 0){
                calcular.push(num)
            }else if(num != '.'){
                calcular.push(num)
            }
        }
}



function limparTela() {
    calcular = []
    resultado.value = ''
}

