import React, { useState, useEffect } from "react"
import axios from "axios"

axios.interceptors.request.use(
    (config) => {
        config.headers['Authorization'] = 'Bearer token123456'
        console.log('Requisição interceptada, Token adicionado')
        return config
    
    },
    (error) => {
        return Promise.reject(error)
    }

)

