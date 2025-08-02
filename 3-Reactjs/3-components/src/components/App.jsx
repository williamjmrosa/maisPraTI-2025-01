import Produto from "./Produto"

function Button(props) {
  return <button onClick={props.onClick}>Clique aqui!</button>
}



function App() {

  const handleClick = () => {
    alert('Botão Clicado!')
  }
 
  return (
    <>
      <Produto nome="Notebook" preco="R$ 2.500" descricao="Notebook Dell" />
      <Button onClick={handleClick}>Clique aqui!</Button>
    </>
  )
}

export default App
