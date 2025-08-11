import { useAuth } from "../context/auth.jsx" // Caminho de importação corrigido
import { use, useState } from "react"

function Header() {
    const { user, login, logout} = useAuth()
    const [userName, setUserName] = useState("")

    function input(e) {
        setUserName(e.target.value)
    }

    return(
        <header>
            {
                user ? (
                    <>
                        <p>Logado como: {user}</p>
                        <button onClick={logout}>Deslogar</button>
                    </>
                ) : (
                    <>
                        <p>Deslogado</p>
                        <input type="text" name="user" id="user" onChange={input}/>
                        <button onClick={() => login(userName)}>Logar</button>
                    </>
                )
            }
        </header>
    )
}

export default Header