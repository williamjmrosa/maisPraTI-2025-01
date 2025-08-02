import { useState, useEffect } from "react"

function viaCepFunction() {
    const [cep, setCep] = useState("")
    const [logradouro, setLogradouro] = useState("")
    const [bairro, setBairro] = useState("")
    const [cidade, setCidade] = useState("")
    const [uf, setUf] = useState("")

    useEffect(() => {
        fetch(`https://viacep.com.br/ws/${cep}/json/`)
            .then(response => {
                if (!response.ok) {
                    throw new Error("CEP inválido")
                }
                return response.json()
            })
            .then(data => {
                setLogradouro(data.logradouro)
                setBairro(data.bairro)
                setCidade(data.localidade)
                setUf(data.uf)
            })
            .catch(error => console.log(error))
    }, [cep])

    const entradaCep = (e) => {
        e.preventDefault()
        const cep = document.querySelector('input').value
        setCep(cep)
    }

    return (
        <div>
            <form>
                <input type="text" />
                <button type="submit" onClick={entradaCep}>Buscar</button>
            </form>
            <p> CEP: {cep}</p>
            <p> Logradouro: {logradouro}</p>
            <p> Bairro: {bairro}</p>
            <p> Cidade: {cidade}</p>
            <p> Estado: {uf}</p>
        </div>  
    )
}

export default viaCepFunction