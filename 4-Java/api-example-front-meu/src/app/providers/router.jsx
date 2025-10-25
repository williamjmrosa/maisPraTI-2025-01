import { createBrowserRouter, RouterProvider, Navigate } from "react-router-dom"
import { AuthProvider, useAuth } from "../state/auth.jsx"
import LoginPage from "../../pages/login/LoginPage.jsx"
import RegisterPage from "../../pages/register/RegisterPage.jsx"
import HomePage from "../../pages/home/HomePage.jsx"
import CallbackPage from "../../pages/auth/CallbackPage.jsx"

function PrivateRoute({ children }) {
    const { isAuthenticated, loading } = useAuth()

    if (loading) {
        return <div>Carregando autenticação...</div>
    }

    if (!isAuthenticated) return <Navigate to="/login" />
    return children
}

export default function AppRouter() {
    
    const router = createBrowserRouter([
        {
            path: '/',
            children: [
                { path: 'login', element: <LoginPage /> },
                { path: 'register', element: <RegisterPage /> },
                {
                    // 4. ADICIONE A ROTA /home PROTEGIDA
                    path: 'home',
                    element: (
                        <PrivateRoute>
                            <HomePage />
                        </PrivateRoute>
                    )
                },
                { path: 'auth/callback', element: <CallbackPage /> },
                {
                    // 5. FAÇA A ROTA RAIZ REDIRECIONAR PARA /home
                    path: '/',
                    element: <Navigate to="/home" />
                }
            ]
        }
    ])

    return (
        <AuthProvider>
            <RouterProvider router={router} />
        </AuthProvider>
    )
}