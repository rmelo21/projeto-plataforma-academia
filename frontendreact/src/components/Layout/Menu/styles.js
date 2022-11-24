import MuiDrawer from '@mui/material/Drawer';
import { styled } from '@mui/material/styles';

export const Drawer = styled(MuiDrawer)(({ theme }) => ({
       width: '240px',
       paper: {
        backgroundColor: theme.palette.primary,
       },
       '& .MuiDrawer-paper': {
        position: 'relative',
        backgroundColor: theme.palette.primary,
        whiteSpace: 'nowrap',
        width: '100%',
        height: '100vh',
        boxSizing: 'border-box',
        overflowX: 'hidden',
      },
    }),
);