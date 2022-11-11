import React from 'react'
import Button from '@mui/material/Button';
import TextField from '@mui/material/TextField';
import Typography from '@mui/material/Typography';
import FormControlLabel from '@mui/material/FormControlLabel';
import Checkbox from '@mui/material/Checkbox';
import Grid from '@mui/material/Grid';
import { useNavigate } from 'react-router-dom';

import logo from 'assets/images/logo.png'

import { PaperContainer, Container} from './styles'
import { useAuth } from 'hooks/useAuth';

function SignUp() {

  const { signUp } = useAuth()

  const navigate = useNavigate();

  const handleSignIn = () => {
    navigate('/')
  }

  const handleSignUp = () => {
    signUp();
  }

  return (
    <Container>
        <PaperContainer elevation={10}>
            <Grid align='center' my={2}>
              <img src={logo} alt="logo academia" style={{cursor: 'pointer'}} width="180px" height="40px" / >
            </Grid>
            <Grid align='center' mb={2}>
              <TextField label='Nome' name="name" placeholder='Entre com email' variant="outlined" fullWidth required/>
            </Grid>
            <Grid align='center' mb={2}>
              <TextField label='E-mail' name="email" placeholder='Entre com email' type="email" variant="outlined" fullWidth required/>
            </Grid>
            <Grid align='center' mb={2}>
              <TextField label='Senha' name="password" placeholder='Digite aqui sua senha' type='password' variant="outlined" fullWidth required/>
            </Grid>
            <Grid align='center' mb={2}>
              <TextField label='Confirme sua senha' name="confirmPassword" placeholder='confirme aqui sua senha' type='password' variant="outlined" fullWidth required/>
            </Grid>
            <Grid align='center' mb={2}>
              <FormControlLabel
                  control={
                  <Checkbox
                      name="checkedB"
                      color="primary"
                  />
                  }
                  label="Concordo com os termos de uso"
              />
            </Grid>
            <Grid align='center' mb={2}>
              <Button type='submit' color='primary' variant="contained" fullWidth onClick={handleSignUp}>Entrar</Button>
            </Grid>
           
            <Grid mt={1}>
              <Typography > Já tem uma conta?
              <Button variant='text' onClick={handleSignIn}>
                  Entre agora  
              </Button>
              </Typography>
            </Grid>
        </PaperContainer>
    </Container>
  );
}


export default SignUp;
