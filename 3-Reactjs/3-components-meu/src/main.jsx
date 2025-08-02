import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import LifeCycleClassComponent from './components/LifeCycleClassComponent.jsx'
import LifeCycleFunctionalComponent from './components/LifeCycleFunctionalComponent.jsx'
import App from './components/App.jsx'
import Greeting from './components/Greeting.jsx'
import ClassComponent from './components/ClassComponent.jsx'
import ViaCepClasse from './components/viaCepClasse.jsx'
import ViaCepFuncao from './components/viaCepFunction.jsx'

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <ViaCepFuncao />
  </StrictMode>,
)