import { Component } from "react"

class ViaCepClasse extends Component {
    constructor(props) {
        super(props)
        this.state = {
            cep: '',
            logradouro: '',
            bairro: '',
            cidade: '',
            estado: ''
        }
    }

    componentDidMount() {
        console.log("Componente montado")
    }

    componentWillUnmount() {
        console.log("Componente desmontado")
    }

    componentDidUpdate(prevState) {
        console.log("Componente atualizado")
        if (this.state.cep !== prevState.cep) {
            this.consultarCep(this.state.cep)
        }      
    }

    consultarCep(cep){
        fetch(`https://viacep.com.br/ws/${cep}/json/`)
            .then(response => response.json())
            .then(data => {
                this.setState({
                    logradouro: data.logradouro,
                    bairro: data.bairro,
                    cidade: data.localidade,
                    estado: data.uf
                })
            })
            .catch(error => console.log(error))
    }

    entradaCep = (e) => {
        e.preventDefault()
        const cep = document.querySelector('input').value
        this.setState({ cep: cep })
        
    }



    render() {
        return (
            <div>
                <form>
                <input type="text" />
                <button onClick={this.entradaCep} type="submit">Buscar</button>
                </form>
                <p> CEP: {this.state.cep}</p>
                <p> Logradouro: {this.state.logradouro}</p>
                <p> Bairro: {this.state.bairro}</p>
                <p> Cidade: {this.state.cidade}</p>
                <p> Estado: {this.state.estado}</p>
            </div>
        )
    }
}

export default ViaCepClasse