import { useAuth } from "./context/AuthContext";

function App() {
  const { user, logout } = useAuth();

  return (
    <>
      <div>
        <header>
          <nav>
            <Link to="/">Home</Link>
            {use ? (
              <>
              <span>Olá, {user.name}!</span>
              <button onClick={logout}>Sair</button>
              </>
              ) : (
                <Link to="/login">Login</Link>
              )}
          </nav>
        </header>
      </div>
    </>
  )
}