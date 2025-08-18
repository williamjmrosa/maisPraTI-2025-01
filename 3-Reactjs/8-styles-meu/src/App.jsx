import '../style/base.css'
import '../style/utilities.css'
import '../style/components.css'

import { Button } from './componentes/Button/Button'
import { Card } from './componentes/Card'
import { ButtonModuleExample } from './componentes/Button/ButtonModuleExample'

import { Themed } from './componentes/Button/ButtomStyle'
import { GlobalStyle } from './theme/GlobalStyle'
import { ButtonSyle } from './componentes/Button/ButtonStyle'

function App() {
  return (
    <>
      <main className='container'>
        <Card title="CSS - Exemplo Global">
          <p>Conteúdo do card</p>
          <Button>Enviar</Button>
          <ButtonModuleExample>Enviar</ButtonModuleExample>
        </Card>
      </main> 
    </>
  )
}

export default App
