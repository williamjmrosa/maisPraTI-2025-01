import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
//import './index.css'
// import App from './App.jsx'
import BuscarFilmes from './componentes/busca.jsx'
createRoot(document.getElementById('root')).render(
  <StrictMode>
    <BuscarFilmes />
  </StrictMode>,
)
