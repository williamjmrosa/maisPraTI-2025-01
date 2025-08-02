function Produto(props) {
    return (
        <div>
            <h1>{props.name}</h1>
            <p>{props.price}</p>    
            <p>{props.description}</p>    
        </div>
    )
}

function App() {
    const product = {
        name: "Avell XLR8",
        price: "+ de 7000",
        description: "30 minutos e acabou o pagode"
    }

    return(
        <Produto name={product.name} price={product.price} description={product.description} />
    )
}

export default App