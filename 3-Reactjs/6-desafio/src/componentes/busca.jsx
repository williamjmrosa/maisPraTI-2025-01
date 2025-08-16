import React, { useState, useEffect } from "react"
import '../meu.css'


function BuscarFilmes() {

    const [inputBusca, setInputBusca] = useState('')
    const [busca, setBusca] = useState('')
    const [resultado, setResultado] = useState([])
    const [carregando, setCarregando] = useState(false)
    const [paginaAtual, setPaginaAtual] = useState(1)
    const [totalPaginas, setTotalPaginas] = useState(0)
    const [carregarDetalhes, setCarregarDetalhes] = useState(false)
    const [detalhes, setDetalhes] = useState({})
    const [favoritos, setFavoritos] = useState([])
    const [listaFavoritos, setListaFavoritos] = useState(false)
    const [error, setError] = useState('')
    const [msg, setMsg] = useState('')

    useEffect( () => {
        carregarFavoritosLocal()
    }, [])

    useEffect( () => {

        if(busca && busca !== '') {
            buscarFilmes()
        }

    }, [busca])

    useEffect(() => {
        if(busca) {
            buscarFilmes()
        }
    }, [paginaAtual])

    useEffect(() => {
        if(listaFavoritos) {
            queryFavorito()
        }
    }, [listaFavoritos])

    const buscarFilmes = async () => {
        try {

            if(busca && busca !== '') {
                const apiKey = import.meta.env.VITE_API_KEY;
            const response = await fetch(`https://api.themoviedb.org/3/search/movie?api_key=${apiKey}&language=pt-BR&query=${busca}&page=${paginaAtual}`)
            
            const data = await response.json()

            setResultado(data.results)

            setTotalPaginas(data.total_pages)
            }
            
            setCarregando(false)
        
            //console.log(data)
        
        }catch (error) {
            console.log(error)
            setError('Erro ao buscar filmes')
        }

    }

    const queryFilme = (e) => {
        e.preventDefault()
        setPaginaAtual(1)
        setBusca(encodeURI(inputBusca))

        setInputBusca('')

        if(busca && busca !== '') {
            setCarregando(true)
        }else if(!listaFavoritos) {
            setError('Busca vazia')
        }
        
        setListaFavoritos(false)

        
    }

    const mostrarPaginas = () => {
        let paginas = []

            for(let i = 1; i <= totalPaginas; i++) {
                if (i == paginaAtual) {
                    paginas.push(<button className="selecionado" key={i} onClick={() => setPaginaAtual(i)}>{i}</button>)
                }else {
                    paginas.push(<button key={i} onClick={() => setPaginaAtual(i)}>{i}</button>)
                }
            }

            return paginas
        }

    const mostrarDetalhes = async (filme) => {

        try {
            
            setDetalhes({})

            const apiKey = import.meta.env.VITE_API_KEY;
            const response = await fetch(`https://api.themoviedb.org/3/movie/${filme.id}/credits?api_key=${apiKey}&language=pt-BR`)
            
            const data = await response.json()
            
            filme.credits = data

            setDetalhes(filme)
            setCarregarDetalhes(false)

            const modal = document.getElementById('detalhes')
            modal.classList.add('mostrar')

            modal.addEventListener('click', fecharModalFora);
            

        }catch (error) {
            console.log(error)
        }
    }

    const fecharModalFora = (e) => {
        if (e.target.id === 'detalhes') {
            fecharDetalhes();
            console.log(e.target.id)
        }
    };

    function fecharDetalhes() {
        setCarregarDetalhes(false)
        setDetalhes({})
        const modal = document.getElementById('detalhes')
        modal.classList.remove('mostrar')
        //modal.removeEventListener('click', fecharModalFora)
    }
    
    

    function salvarFavoritoLocal(filme){
        let favoritosLocal = favoritos
        if(!favoritosLocal.find((idLocal) => idLocal === filme.id)) {
            favoritosLocal.push(filme.id)
              
            setMsg(`Filme ${filme.title} favoritado com sucesso`)
        }else{
            favoritosLocal = favoritosLocal.filter((idLocal) => idLocal !== filme.id)   
            
            setMsg(`Filme ${filme.title} removido dos favoritos`)
        }
        setFavoritos(favoritosLocal)
        localStorage.setItem('favoritos', JSON.stringify(favoritosLocal)) 
        
    }

    function carregarFavoritosLocal() {
        const idFavoritos = localStorage.getItem('favoritos') || []
        if(idFavoritos.length > 0) {
            setFavoritos(JSON.parse(idFavoritos))
        console.log("Favoritos carregados", favoritos)
        }
    }

    const buscarFavoritos = async (idFavorito) => {
        try {
            const apiKey = import.meta.env.VITE_API_KEY;
            const response = await fetch(`https://api.themoviedb.org/3/movie/${idFavorito}?api_key=${apiKey}&language=pt-BR`)
            
            const data = await response.json()

            setCarregando(true)
            
            return data


        }catch (error) {
            console.log(error)
        }
    }

    // Nova versão da função queryFavorito
    const queryFavorito = async () => {
        setCarregando(true); // Começa a carregar
        setBusca(''); // Limpa a busca para exibir apenas os favoritos
        setPaginaAtual(1);
        setTotalPaginas(1);

        const idsFavoritos = favoritos;

        if (idsFavoritos.length === 0) {
            setCarregando(false); // Para de carregar se não tiver favoritos
            setResultado([]);
            return; // Sai da função
        }

        try {
            const listaPromises = idsFavoritos.map((idFavorito) => {
                return buscarFavoritos(idFavorito);
            });

            const lista = await Promise.all(listaPromises);

            
            setResultado(lista); // Atualiza o resultado com a lista completa de filmes
            setCarregando(false); // Para de carregar após o sucesso
            setListaFavoritos(true);
        } catch (error) {
            setCarregando(false); // Para de carregar em caso de erro
            console.error("Erro ao buscar favoritos:", error);
        }
    }

    const fechaErro = (e) => {
        if (e.target.id === 'error') {
            setError('')
        }
    }

    const fechaMsg = (e) => {
        if (e.target.id === 'msg') {
            setMsg('')
        }
    }

    return (
        <div>
            
            <form onSubmit={queryFilme}>
                <input type="text" id="filme" placeholder="Digite o filme" value={inputBusca} onChange={(e) => setInputBusca(e.target.value)}/>
                <button type="submit">Buscar</button>
                <button id="favoritos" onClick={queryFavorito}>Favoritos</button>

            </form>

            {
                error && (
                <div className="error">
                    <p>{error}</p>
                    <button className="btn-error" id="error" onClick={fechaErro}>X</button>
                </div>
                )
            }

            {
                msg && (
                <div className="msg">
                    <p>{msg}</p>
                    <button className="btn-error" id="msg" onClick={fechaMsg}>X</button>
                </div>
                )
            }
            
            <div id="resultado">
                {carregando && <p>Carregando...</p>}
                {
                resultado.map((filme) => {
                    //console.log(filme)
                    return (
                        
                        <div className="card" key={filme.id}>
                            <img src={`https://image.tmdb.org/t/p/w500/${filme.poster_path}`} alt={filme.title} />
                            <h2>{filme.title}</h2>
                            <p>Data de lancamento: {filme.release_date}</p>
                            <p>Nota: {filme.vote_average}</p>
                            <button onClick={() => {
                                    setCarregarDetalhes(true)
                                    mostrarDetalhes(filme)
                                }
                                }>Detalhes</button>
                            <button className="favoritar" onClick={() => {
                                salvarFavoritoLocal(filme)
                                if(listaFavoritos){
                                    setResultado(resultado.filter((f) => {
                                        return f.id !== filme.id
                                    }))
                                }else{
                                    const novoReultado = resultado
                                    setResultado(novoReultado)
                                }
                            }
                                
                                }>{ favoritos.includes(filme.id) ? 'Desfavoritar' : 'Favoritar'}</button>
                        </div>
                    )
                })
                }
            </div>
            <div>
                {
                    totalPaginas > 1 && (
                        <div className="paginacao">
                            <button disabled={paginaAtual == 1} onClick={() => setPaginaAtual( paginaAtual == 1 ? 1 : paginaAtual - 1)}>Anterior</button>

                            {mostrarPaginas()}

                            <button disabled={paginaAtual == totalPaginas} onClick={() => setPaginaAtual( paginaAtual == totalPaginas ? totalPaginas : paginaAtual + 1)}>Próximo</button>
                        </div>
                    )
                }
            </div>
            <div id="detalhes">
                {
                    carregarDetalhes && (<p>Carregando...</p>)
                }
                
                {
                    Object.keys(detalhes).length > 0 && (
                        <div className="detalhes">
                            <div className="cabecalho">
                                <button onClick={fecharDetalhes}>X</button>
                                <h1>Detalhes</h1>
                            </div>
                            
                            <div className="filme">
                                <img src={`https://image.tmdb.org/t/p/w500/${detalhes.poster_path}`} alt={detalhes.title} />
                                <div className="info">
                                    <h2>{detalhes.title}</h2>
                                    <h2>Sinopse</h2>
                                    <p>{detalhes.overview}</p>
                                <p>Data de lancamento: {detalhes.release_date}</p>
                                <p>Nota: {detalhes.vote_average}</p>
                                </div>
                            </div>
                            <div style={{textAlign: "left"}}>
                                <h4>Diretor: {detalhes.credits.crew.find((personagem) => personagem.job == 'Director').name}</h4>
                                <h2>Elenco</h2> 
                                <div className="elenco">
                                {
                                    detalhes.credits.cast.map((ator, index) => {
                                                                                
                                        if (index < 10) return (
                                            <div key={ator.id}>
                                                <img src={`https://image.tmdb.org/t/p/w500/${ator.profile_path}`} alt={ator.name} />
                                                <p>{ator.name}</p>
                                                <p>{ator.character}</p>
                                            </div>
                                        )
                                    })}
                                </div>
                            </div>
                            
                        </div>
                    )
                }
            </div>
        </div>
    )
}

export default BuscarFilmes