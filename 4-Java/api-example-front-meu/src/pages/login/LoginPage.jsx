import { useState } from 'react'
import { useNavigate, Navigate, Link } from 'react-router-dom'
import { useAuth } from '../../app/state/auth.jsx'

const { VITE_API_BASE_URL } = import.meta.env.VITE_API_BASE_URL

function LoginPage() {
    const { login, isAuthenticated } = useAuth()
    const [form, setForm] = useState({ username: '', password: '' })
    const navigate = useNavigate()

    const onChange = (event) => setForm({ ...form, [event.target.name]: event.target.value })

    const onSubmit = async (event) => {
        event.preventDefault()
        try {
            await login(form.username, form.password)
            navigate('/home')
        } catch (error) {
            alert('Erro ao fazer login: ' + error.message)
        }
    }
    //if(isAuthenticated) return <Navigate to="/home" />
    if(isAuthenticated) return (<div>Você já está autenticado - <Link to='/home'>Ir para página inicial</Link></div>)

    return (
        <div>
            <form onSubmit={onSubmit}>

                <label>Username</label>
                <input type="text" name='username' value={form.username} onChange={onChange}/>

                <label>Senha</label>
                <input type="password" name='password' value={form.password} onChange={onChange}/>

                <button>Login!</button>
            </form>
            {/* 4. ADICIONE LINKS ÚTEIS */}
            <br />
            <Link to="/register">Não tem conta? Registre-se</Link>

            <hr />

            <div>
                <a href={`${import.meta.env.VITE_API_BASE_URL}/oauth2/authorization/github`}>Entrar com GitHub</a>
            </div>
            
        </div>
    )
}

export default LoginPage