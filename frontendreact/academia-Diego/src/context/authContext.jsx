import { createContext, useState, useCallback } from 'react'


const INITIAL_AUTH_CONTEXT = {
    isLogged: false,
    user: {
        name: '',
        email: '',
    }
}

export const AuthContext = createContext(INITIAL_AUTH_CONTEXT);

export const AuthProviver = ({children}) => {

    const [isLogged, setIsLogged] = useState(false)

    const signIn = useCallback(() => {
        setIsLogged(true)
    },[])
    
    const signUp =  useCallback(() => {
        setIsLogged(true)
    },[])

    const logoff =  useCallback(() => {
        setIsLogged(false)
    },[])


    
    return (
        <AuthContext.Provider value={{isLogged, signIn, signUp, logoff}}>
            {children}
        </AuthContext.Provider>
    )
}