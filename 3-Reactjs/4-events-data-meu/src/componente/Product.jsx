import { useState, useEffect } from "react";

// class Prod{
//     constructor(nome, preco, categoria, descricao) {
//         this.nome = nome
//         this.preco = preco
//         this.categoria = categoria
//         this.descricao = descricao
//     }
// }

// function Product({nome, preco, categoria, descricao}) {
//     const [nome, setNome] = useState("")
//     const [preco, setPreco] = useState(0)
//     const [categoria, setCategoria] = useState("")
//     const [descricao, setDescricao] = useState("")
//     const [products, setProducts] = useState([])

//     useEffect((e) => {
//         setNome(nome)
//         setPreco(preco)
//         setCategoria(categoria)
//         setDescricao(descricao)

//     }, [nome, preco, categoria, descricao])

//     const addProduct = (e) => {
//         e.preventDefault()

//         if(!nome || !preco || !categoria || !descricao) {
//             alert("Preencha todos os campos")
//             return
//         }else if(preco < 0) {
//             alert("Preço inválido")
//             return
//         }

//         const newProduct = new Prod(nome, preco, categoria, descricao)
//         setProducts([...products, newProduct])
//     }

//     return (
//         <form action="" onSubmit={addProduct}>
//             <h1>Novo Produto</h1>
//             <div>
//                 <input type="text" placeholder="nome" />
//                 <input type="number" placeholder="preco"/>
//                 <select name="categoria" id="">
//                     <option value="Jogos">Jogos</option>
//                     <option value="Consoles">Consoles</option>
//                     <option value="Acessórios">Acessórios</option>
//                     <option value="Smartphones">Smartphones</option>
//                 </select>
//                 <input type="text" placeholder="descricao"/>
//             </div>
//         </form>
        
//     )
// }

// export default Product

function Product(){
    const [productName, setProductName] = useState("")
    const [price, setPrice] = useState(0)
    const [category, setCategory] = useState("")
    const [description, setDescription] = useState("")

    const [products, setProducts] = useState([])
    const [error, setError] = useState("")

    const handleNameChange = (event) => setProductName(event.target.value)
    const handlePriceChange = (event) => setPrice(event.target.value)
    const handleCategoryChange = (event) => setCategory(event.target.value)
    const handleDescriptionChange = (event) => setDescription(event.target.value)

    const handleAddProduct = (event) => {
        event.preventDefault()

        if(!productName || !price || !description) {
            setError("Por favor, preencha todos os campos!")
            return
        }else if(isNaN(price) || Number(price) < 0) {
            setError('O Preço deve ser um valor positivo')
            return
        }

        setError("")

        const newProduct = {
            id: Date.now(),
            name: productName,
            price: parseFloat(price).toFixed(2),
            category: category,
            description: description
        }

        setProducts([...products, newProduct])
        setProductName("")
        setPrice(0)
        setCategory("")
        setDescription("")
    }

    const handleRemoveProduct = (id) => {
        setProducts(products.filter((product) => product.id !== id))
    }

    const filteredProducts = products.filter((product) => product.category === category)

    return(
        <div>
            <h1>Cadastro de produto</h1>
            {error && <p style={{color: "red"}}>{error}</p>}
            <form onSubmit={handleAddProduct}>
                <label>Nome do Produto:
                <input type="text" value={productName} onChange={handleNameChange} />
                </label>
                <br />
                <label htmlFor="preco">Preço:
                    <input type="text" value={price} onChange={handlePriceChange} />
                </label>
                <br />
                <label htmlFor="categoria">Categoria:
                    <select value={category} onChange={handleCategoryChange}>
                        <option value="Jogos">Jogos</option>
                        <option value="Consoles">Consoles</option>
                        <option value="Acessórios">Acessórios</option>
                        <option value="Smartphones">Smartphones</option>
                    </select>
                </label>
                <br />
                <label htmlFor="descricao">Descrição:</label>
                <input type="text" value={description} onChange={handleDescriptionChange} />
                <br />
                <button type="submit">Adicionar Produto</button>
            </form>

            <label>
                Filtrar por categoria:
                <select value={categoryFilter} onChange={(event) => setCategoryFilter(event.target.value)}>
                    <option value="all">Todos</option>
                    <option value="Jogos">Jogos</option>
                    <option value="Consoles">Consoles</option>
                    <option value="Acessórios">Acessórios</option>
                    <option value="Smartphones">Smartphones</option>
                </select>
            </label>

            <ul>
                {products.map((product) => (
                    <li key={product.id}>
                        <strong>{product.name}</strong> - {product.price} - {product.category} - {product.description}
                    </li>
                ))

                }
            </ul>

        </div>
    )
}

export default Product