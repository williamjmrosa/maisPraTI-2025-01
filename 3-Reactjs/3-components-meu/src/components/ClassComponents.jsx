import { Component } from "react"

class ClassComponents extends Component{
    constructor(props){
        super(props)
        this.state = {
            count: 0
        }
    }

    incrementCount = () => {
        this.setState({count: this.state.count + 1})
    }

    render(){
        <div>
            <p>Contagem: {this.state.count}</p>
            <button onClick={this.incrementCount}>Incrementar</button>
        </div>
    }
}