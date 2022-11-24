import PeopleIcon from '@mui/icons-material/People';
import PersonIcon from '@mui/icons-material/Person';
import MonetizationOn from '@mui/icons-material/MonetizationOn';

export const menuList = [
    {
        label: 'Clientes',
        link: '/client-list',
        icon: <PeopleIcon />
    },
    {
        label: 'Colaboradores',
        link: '/collaborators-list',
        icon: <PersonIcon />
    },
    {
        label: 'Financeiro',
        link: '/financial-list',
        icon: <MonetizationOn />
    },
]