import { useState } from "react"

function CounterJSX() {
    const [count, setCount] = useState(0)

    const increment = () => {
        setCount(count + 1)
    }

    return (
        <div>
            <p data-testid="count">{count}</p>
            <button data-testid="Increment" onClick={increment}>Incrementar</button>
        </div>
    )
}

export default CounterJSX