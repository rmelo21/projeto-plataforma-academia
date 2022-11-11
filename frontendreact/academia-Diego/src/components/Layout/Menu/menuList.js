import PeopleIcon from '@mui/icons-material/People';
import PersonIcon from '@mui/icons-material/Person';

export const menuList = [
    {
        label: 'Usuários',
        link: '/user-list',
        icon: <PeopleIcon />
    },
    {
        label: 'Colaboradores',
        link: '/collaborators-list',
        icon: <PersonIcon />
    },
]