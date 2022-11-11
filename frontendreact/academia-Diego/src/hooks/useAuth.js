import { AuthContext } from 'context/authContext';
import { useContext } from 'react';

export const useAuth = () => {
    const context = useContext(AuthContext);

    if(!context){
        throw new Error('Não existe um contexto de Auth')
    }

    return context
}