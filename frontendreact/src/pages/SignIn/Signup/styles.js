
import { styled } from '@mui/material/styles';

import Paper from '@mui/material/Paper';
import Avatar from '@mui/material/Avatar';
import Grid from '@mui/material/Grid';

export const Container = styled(Grid)({
    height: "100vh",
    width: '100%',
    display: 'flex',
    alignItems: 'center',
    justifyContent: 'center',
    backgroundColor: '#5700E3'
})

export const PaperContainer = styled(Paper)({
    padding :20,
    height:'auto',
    width: 420, 
    margin:"20px auto"
});

export const AvatarStyled = styled(Avatar)({
    backgroundColor:'#1bbd7e',
    width: 56, 
    height: 56
});