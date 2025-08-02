import { userState , useEffct } from "react";

function LifeCycleFunctionalComponent() {
    const [count, setCount] = useState(0)

    useEffect(() => {
        console.log("Componente montado")

        return () => {
            console.log("Componente será desmontado")
        }
    }, [])

    useEffct(() => {
        console.log("Componente Atualizado!")
    }, [count])

    const increment = () => {
        setCount(count + 1)
    }

    return (
        <div>
            <p>Contagem: {count}</p>
            <button onClick={this.increment}>Incrementar + 1</button>
        </div>
    )
}

export default LifeCycleFunctionalComponent