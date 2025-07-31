import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import App from './components/App.jsx'
import Greeting from './components/Greeting.jsx'
import Aplicativo from './components/Produto.jsx'
import ClassComponents from './components/ClassComponents.jsx'



createRoot(document.getElementById('root')).render(
  <StrictMode>
    <ClassComponents />
  </StrictMode>
)