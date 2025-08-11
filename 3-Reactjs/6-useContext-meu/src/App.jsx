import { AuthProvider } from "./context/auth.jsx" // Caminho de importação corrigido
import { ThemeProvider } from "./context/theme.jsx"
import ThemeToggle from "./componentes/ThemeToggle.jsx"
import Header from "./componentes/Header"

function App() {
  return (
    <>
        <AuthProvider>
          <Header />
        </AuthProvider>
        <ThemeProvider>
          <ThemeToggle />
        </ThemeProvider>
    </>
  )
}

export default App