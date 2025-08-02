function Produto(props) {
    return (
        <div className="produto"> 
            <h2>{props.nome}</h2>
            <p>{props.preco}</p>
            <p>{props.descricao}</p>
        </div>
    )
}

// Criar um componente que exibe as informações de um produto. O componente pai (App) vai passar os dados do produto (nome, preço, descrição) como props para o componente filho (Produto), e o componente filho vai exibir essas informações.


function Aplicativo(){
    const produto = {nome: 'Notebook', preco: 'R$ 2.500', descricao: 'Notebook Dell'}

    return (
        <div>
            <Produto nome={produto.nome} preco={produto.preco} descricao={produto.descricao} />
        </div>
    )
}

export default Aplicativo