import { Link } from "react-router-dom"

export default function NotFound() {
    return (
        <div>
            <h1>404</h1>
            <p>Página não encontrada</p>
            <p>
                <Link to="/">Volta para Pagina Principal</Link>
            </p>
        </div>
    )
}