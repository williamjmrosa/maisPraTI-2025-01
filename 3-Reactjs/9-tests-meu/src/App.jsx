import { useState } from "react"
import CounterJSX from "./components/CounterJSX"

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <div>
        <h1>Counter com JSX</h1>
        <CounterJSX />
      </div>
    </>
  )
}

export default App
