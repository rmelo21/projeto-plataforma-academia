import React from 'react'
import Box from '@mui/material/Box';
import Grid from '@mui/material/Grid';
import TextField from '@mui/material/TextField';
import Typography  from '@mui/material/Typography';
import Button  from '@mui/material/Button';
import { useNavigate } from 'react-router-dom';
import { toast } from 'react-toastify';

const NewCollaborator = () => {
  const navigate = useNavigate();

  const handleOnSave = () => {
    toast.success('Colaborador salvo com sucesso')
    navigate('/collaborators-list')
  }

  return (
      <Box sx={{width: '100%'}}>
        <Typography variant="h5" color="">
          Criar novo colaborador
        </Typography>
        <Box component="form" noValidate onSubmit={handleOnSave} sx={{ mt: 3, width: '100%' }}>
            <Grid container spacing={2}>
              <Grid item xs={12} sm={6}>
                <TextField
                  autoComplete="given-name"
                  name="Nome"
                  variant="outlined"
                  required
                  fullWidth
                  id="firstName"
                  label="Nome"
                  autoFocus
                />
              </Grid>
              <Grid item xs={12} sm={6}>
                <TextField
                  required
                  variant="outlined"
                  fullWidth
                  id="lastName"
                  label="Sobrenome"
                  name="lastName"
                  autoComplete="family-name"
                />
              </Grid>
              <Grid item xs={12} sm={6}>
                <TextField
                  required
                  fullWidth
                  variant="outlined"
                  id="email"
                  label="Email"
                  name="email"
                  autoComplete="email"
                />
              </Grid>
              <Grid item xs={12} sm={6}>
                <TextField
                  required
                  fullWidth
                  variant="outlined"
                  id="email"
                  label="Confirmar Email"
                  name="email"
                  autoComplete="email"
                />
              </Grid>
              <Grid item xs={12} sm={6}>
                <TextField
                  required
                  fullWidth
                  variant="outlined"
                  name="password"
                  label="Senha"
                  type="password"
                  id="password"
                  autoComplete="new-password"
                />
              </Grid>
              <Grid item xs={12} sm={6}>
                <TextField
                  required
                  fullWidth
                  variant="outlined"
                  name="password"
                  label="Confirmar senha"
                  type="password"
                  id="password"
                  autoComplete="new-password"
                />
              </Grid>
            </Grid>
            <Grid display="flex" justifyContent="flex-end">
              <Button
                type="submit"

                variant="contained"
                sx={{ mt: 3, mb: 2 }}
              >
                Salvar
              </Button>
            </Grid>
        </Box>
      </Box>
  )
}

export  {NewCollaborator}