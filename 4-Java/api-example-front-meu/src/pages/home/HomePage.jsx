// Novo arquivo: src/pages/home/HomePage.jsx
import { useAuth } from '../../app/state/auth.jsx'
import { Link } from 'react-router-dom'

export default function HomePage() {
    const { user, setToken } = useAuth()

    const logout = () => {
        setToken(null)
    }

    // O 'user' pode demorar um frame para carregar
    if (!user) {
        return <div>Carregando...</div>
    }

    return (
        <div>
            <h1>Bem-vindo, {user.name}!</h1>
            <p>Seu username (email) é: {user.username}</p>
            <p>Suas roles são: {user.roles.join(', ')}</p>
            <button onClick={logout}>Logout</button>
            <br />
            {/* Você pode adicionar links para outras áreas aqui */}
            {/* <Link to="/courses">Ver Cursos</Link> */}
        </div>
    )
}