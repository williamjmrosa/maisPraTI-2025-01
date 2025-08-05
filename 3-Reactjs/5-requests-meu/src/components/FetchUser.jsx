import React, { useState, useEffect, use } from 'react'
import axios from 'axios'

const FetchUser = () => {
    const [users, setUsers] = useState([])
    const [loading, setLoading] = useState(true)
    const [error, setError] = useState(null)

    
    const getUsers = async () => {
        try{
            const response = fetch('https://jsonplaceholder.typicode.com/users')
        
            if(!response.ok){
                throw new Error('Falha na requisição')
            }
            const data = await response.json()
            setUsers(data)
            setLoading(false)
        }catch(err){
            setError(err.message)
            setLoading(false)
        }
    }

    useEffect(() => {
        getUsers()
    }, [])

    return (
        <div>
            {loading && <p>Carregando...</p>}
            {error && <p>{error}</p>}
            
            <ul>
                {users.map(user => (
                    <li key={user.id}>{user.email}</li>
                ))}
            </ul>

        </div>
    )

}

export default FetchUser