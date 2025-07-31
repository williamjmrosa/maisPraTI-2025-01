<<<<<<< HEAD:3-Reactjs/3-components-meu/src/components/Produto.jsx
function Produto(props) {
    return (
        <div className="produto"> 
            <h2>{props.nome}</h2>
            <p>{props.preco}</p>
            <p>{props.descricao}</p>
=======
// Criar um componente que exibe as informações de um produto. O componente pai (App) vai passar os dados do produto (nome, preço, descrição) como props para o componente filho (Produto), e o componente filho vai exibir essas informações.

function Produto(props) {
    return (
        <div>
            <h2>{props.nome}</h2>
            <h2>{props.preco}</h2>
            <h2>{props.descricao}</h2>
>>>>>>> main:3-Reactjs/3-components/src/components/Produto.jsx
        </div>
    )
}

<<<<<<< HEAD:3-Reactjs/3-components-meu/src/components/Produto.jsx
function Aplicativo(){
    const produto = {nome: 'Notebook', preco: 'R$ 2.500', descricao: 'Notebook Dell'}

    return (
        <div>
            <Produto nome={produto.nome} preco={produto.preco} descricao={produto.descricao} />
=======
function Aplicativo() {
    const produto = {
        nome: "Camiseta",
        preco: 79.90,
        descricao: "Camiseta muita maneira do Kansas"
    }

    return (
        <div>
            <Produto nome={produto.nome} preco={produto.preco} descricao={produto.descricao}/>
>>>>>>> main:3-Reactjs/3-components/src/components/Produto.jsx
        </div>
    )
}

export default Aplicativo