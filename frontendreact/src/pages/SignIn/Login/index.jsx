import React from 'react'
import Button from '@mui/material/Button';
import TextField from '@mui/material/TextField';
import Typography from '@mui/material/Typography';
import Link from '@mui/material/Link';
import Checkbox from '@mui/material/Checkbox';
import FormControlLabel from '@mui/material/FormControlLabel';
import Grid from '@mui/material/Grid';
import { useNavigate } from 'react-router-dom';

import logo from 'assets/images/logo.png'

import { PaperContainer, Container} from './styles'
import { useAuth } from 'hooks/useAuth';

function Login() {

  const navigate = useNavigate();
  const { signIn } = useAuth()

  const handleSignUp = () => {
    navigate('/signup')
  }

  const handleSignIn = () => {
    signIn();
  }

  return (
    <Container>
        <PaperContainer elevation={10}>
            <Grid align='center' my={2}>
              <img src={logo} alt="logo academia" style={{cursor: 'pointer'}} width="180px" height="40px" / >
            </Grid>
            <Grid align='center' mb={2}>
              <TextField label='E-mail' placeholder='Entre com email' type="email" variant="outlined" fullWidth required/>
            </Grid>
            <Grid align='center' mb={2}>
              <TextField label='Senha' placeholder='Digite aqui sua senha' type='password' variant="outlined" fullWidth required/>
            </Grid>
            <Grid align="right">
            <Typography >
              <Link href="#" >
                Esqueceu sua senha?
              </Link>
            </Typography>
            </Grid>
            <Grid my={1}>
            <FormControlLabel
                control={
                <Checkbox
                    name="checkedB"
                    color="primary"
                />
                }
                label="Lembrar meus dados"
            />

            </Grid>
            <Grid align='center' mb={2}>
              <Button type='submit' onClick={handleSignIn} color='primary' variant="contained" fullWidth>Entrar</Button>
            </Grid>
            <Grid align='center' mb={2}>
              <Typography > ainda não é cadastrado?
              <Button variant='text' onClick={handleSignUp}>
                  Entre agora  
              </Button>
              </Typography>
            </Grid>
        </PaperContainer>
    </Container>
  );
}


export default Login;
