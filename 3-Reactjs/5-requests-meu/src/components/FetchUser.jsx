import React, { useState, useEffect} from 'react'
import axios from 'axios'

const FetchUser = () => {
    const [users, setUsers] = useState([])
    const [loading, setLoading] = useState(true)
    const [error, setError] = useState(null)

    const [name, setName] = useState('')
    const [email, setEmail] = useState('')
    const [message, setMessage] = useState('')
    
    const getUsers = async () => {
        try {
            const response = await fetch("https://jsonplaceholder.typicode.com/users")
            //const response = await axios.get("https://jsonplaceholder.typicode.com/users")
            if(!response.ok){
                throw new Error('Falha na requisição')
            }
            const data = await response.json()
            setUsers(data)
            // setUsers(response.data) 
            setLoading(false)
        }catch(err){
            setError(err.message)
            setLoading(false)
        }
    }

    const postUser = async () => {
        setLoading(true)
        setError(null)

        const newUser = {
            name,
            email
        }

        try{
            const response = await axios.post("https://jsonplaceholder.typicode.com/users", newUser)
            
            setMessage('Usuário criado com sucesso')
        }catch(err){
            setError(err.message)
            setLoading(false)
        }

    }

    useEffect(() => {
        postUser()
        getUsers()
    }, [])

    return (
        <div>
            {loading && <p>Carregando...</p>}
            {error && <p>{error}</p>}
            {message && <p style={{backgroundColor: 'green'}}>{message}</p>}
            
            <ul>
                {users.map(user => (
                    <li key={user.id}>{user.email}</li>
                ))}
            </ul>

        </div>
    )

}

export default FetchUser