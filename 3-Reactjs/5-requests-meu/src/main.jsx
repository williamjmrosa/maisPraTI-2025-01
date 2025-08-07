import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
//import App from './App.jsx'
import FetchUser from './components/FetchUser'
createRoot(document.getElementById('root')).render(
  <StrictMode>
    <FetchUser usuario={"Joao"} email={"j@j.com"}/>
  </StrictMode>,
)
