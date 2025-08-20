import { useState } from "react"

function Counter() {
    const [count, setCount] = useState(0)

    return (
        <div>
            <p id="count" data-testid="count">{count}</p>
            <button id="increment" data-testid="Increment" onClick={() => setCount(count + 1)}>Incrementar</button>
        </div>
    )
}

export default Counter