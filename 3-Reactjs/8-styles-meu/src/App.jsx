import './style/base.css'
import './style/utilities.css'
import './style/components.css'

import { Button } from './componentes/Button/Button'
import { Card } from './componentes/Card'

import { ButtonModuleExample } from './componentes/Button/ButtonModuleExample'

import { Themed } from './componentes/Button/ButtonStyled'
import { GlobalStyle } from './theme/GlobalStyle'
import { ButtonStyled } from './componentes/Button/ButtonStyled'

function App() {
  return (
    <>
      <main className='container'>
        <Card title="CSS - Exemplo Global">
          <p>Conteúdo do card</p>
          <Button>Enviar</Button>
          <ButtonModuleExample>Send Message</ButtonModuleExample>
          <ButtonStyled variant='ghost'>Ghost</ButtonStyled>
        </Card>
      </main> 
    </>
  )
}

export default App
