import React from 'react'
import Box from '@mui/material/Box';
import Grid from '@mui/material/Grid';
import MenuItem from '@mui/material/MenuItem';
import InputLabel from '@mui/material/InputLabel';
import Select from '@mui/material/Select';
import Divider from '@mui/material/Divider';
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

  const handleBackPage = () => {
    navigate('/client-list');
  }  

  return (
      <Box sx={{width: '100%'}}>
        <Typography variant="h4" fontWeight="bold">
          Criar novo colaborador
        </Typography>
        <Box component="form" noValidate onSubmit={handleOnSave} sx={{ mt: 3, width: '100%' }}>
            <Grid container spacing={2}>
              <Grid item xs={12}>
                  <Typography variant="h5">
                    Dados pessoais
                  </Typography>
                  <Divider />
              </Grid>
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
                  id="telefone"
                  label="Telefone"
                  name="telefone"
                />
              </Grid>
              <Grid item xs={12} sm={6}>
                <TextField
                  required
                  fullWidth
                  variant="outlined"
                  id="celular"
                  label="Celular"
                  name="celular"
                />
              </Grid>
              <Grid item xs={12} sm={1}>
                  <TextField
                    name="CEP"
                    variant="outlined"
                    required
                    fullWidth
                    id="cep"
                    label="Cep"
                  />
                </Grid>
                <Grid item xs={12} sm={10}>
                  <TextField
                    required
                    variant="outlined"
                    fullWidth
                    id="endereco"
                    label="Endereço"
                    name="endereco"
                  />
                </Grid>
                <Grid item xs={12} sm={1}>
                  <TextField
                    required
                    fullWidth
                    variant="outlined"
                    id="numero"
                    label="Número"
                    name="numero"
                  />
                </Grid>
                <Grid item xs={12} sm={4}>
                  <TextField
                    required
                    fullWidth
                    variant="outlined"
                    id="bairro"
                    label="Bairro"
                    name="bairro"
                  />
                </Grid>
                <Grid item xs={12} sm={4}>
                  <TextField
                    required
                    fullWidth
                    variant="outlined"
                    name="cidade"
                    label="Cidade"
                    id="cidade"
                  />
                </Grid>
                <Grid item xs={12} sm={4}>
                  <TextField
                    required
                    fullWidth
                    variant="outlined"
                    name="estado"
                    label="Estado"
                    id="estado"
                    autoComplete="new-password"
                  />
                </Grid>
            </Grid>
            <Grid container spacing={2} mt={2}>
              <Grid item xs={12}>
                  <Typography variant="h5">
                    Dados de acessos
                  </Typography>
                  <Divider />
              </Grid>
              <Grid item xs={12} sm={6}>
                  <InputLabel id="funcao-label">Função</InputLabel>
                  <Select
                    fullWidth
                    labelId="funcao-label"
                    id="funcao"
                    placeholder='Selecione a função'
                    label="Função"
                  >
                    <MenuItem selected value={20}>Professor</MenuItem>
                    <MenuItem value={10}>Recepcionista</MenuItem>
                    <MenuItem value={30}>Secretário(a)</MenuItem>
                    <MenuItem value={30}>Administrador</MenuItem>
                    <MenuItem value={30}>Financeiro</MenuItem>
                  </Select>
                </Grid>
                <Grid item xs={12} sm={6}>
                  <InputLabel id="tipo-label">Tipo</InputLabel>
                  <Select
                    fullWidth
                    labelId="tipo-label"
                    id="tipo"
                    placeholder='Selecione o Tipo'
                    label="Tipo"
                  >
                    <MenuItem selected value={20}>Colaborador</MenuItem>
                    <MenuItem value={10}>Proprietário</MenuItem>
                  </Select>
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
                type="button"
                size='large'
                onClick={handleBackPage}
                variant="outlined"
                sx={{ mt: 3, mb: 2, mr: 2 }}
              >
                Cancelar
              </Button>
              <Button
                type="submit"
                size='large'
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