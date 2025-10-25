// Crie esta nova pasta e arquivo: src/pages/auth/CallbackPage.jsx
import { useEffect } from 'react';
import { useSearchParams, useNavigate } from 'react-router-dom';
import { useAuth } from '../../app/state/auth';

export default function CallbackPage() {
    const { setToken } = useAuth();
    const [searchParams] = useSearchParams();
    const navigate = useNavigate();

    useEffect(() => {
        // 1. Pega o token da URL (ex: ?token=...)
        const token = searchParams.get('token');

        if (token) {
            // 2. Salva o token no estado global (auth.jsx)
            setToken(token);
            // 3. Redireciona para a página principal
            navigate('/home', { replace: true });
        } else {
            // 4. Se não houver token, redireciona para o login
            navigate('/login', { replace: true });
        }
    }, [searchParams, setToken, navigate]);

    // Renderiza uma mensagem de carregamento enquanto o processo ocorre
    return <div>Autenticando...</div>;
}