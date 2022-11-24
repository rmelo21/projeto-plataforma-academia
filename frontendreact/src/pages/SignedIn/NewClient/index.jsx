import React from 'react'
import Box from '@mui/material/Box';
import Divider from '@mui/material/Divider';
import MenuItem from '@mui/material/MenuItem';
import InputLabel from '@mui/material/InputLabel';
import Select from '@mui/material/Select';
import Grid from '@mui/material/Grid';
import TextField from '@mui/material/TextField';
import Typography  from '@mui/material/Typography';
import Button  from '@mui/material/Button';
import { useNavigate } from 'react-router-dom';
import { toast } from 'react-toastify';

const NewClient = () => {
  const navigate = useNavigate();

  const handleOnSave = () => {
    toast.success('Cliente cadastrado com sucesso')
    navigate('/client-list')
  }

  const handleBackPage = () => {
    navigate('/client-list');
  }  

  return (
      <Box sx={{width: '100%'}}>
        <Typography variant="h4" fontWeight="bold">
          Cadastrar novo cliente
        </Typography>
        <Box component="form" noValidate onSubmit={handleOnSave} sx={{ mt: 3, width: '100%' }}>
            <Grid container spacing={2}>
              <Grid item xs={12}>
                <Typography variant="h5" color="">
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
                <Grid item xs={12} sm={4}>
                  <TextField
                    required
                    variant="outlined"
                    fullWidth
                    id="cpf"
                    label="CPF"
                    name="cpf"
                  />
                </Grid>
                <Grid item xs={12} sm={4}>
                  <TextField
                    required
                    variant="outlined"
                    fullWidth
                    id="rg"
                    label="RG"
                    name="rg"
                  />
                </Grid>
                <Grid item xs={12} sm={4}>
                  <TextField
                    required
                    variant="outlined"
                    fullWidth
                    id="cnh"
                    label="CNH"
                    name="cnh"
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
              <Grid container spacing={2} mt={2}>
                <Grid item xs={12}>
                  <Typography variant="h5" color="">
                    Endereço
                  </Typography>
                  <Divider />
                </Grid>
                <Grid item xs={12} sm={3}>
                  <TextField
                    name="CEP"
                    variant="outlined"
                    required
                    fullWidth
                    id="cep"
                    label="Cep"
                  />
                </Grid>
                <Grid item xs={12} sm={8}>
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
                  <Typography variant="h5" color="">
                    Planos
                  </Typography>
                  <Divider />
                </Grid>
                <Grid item xs={12} sm={4}>
                  <InputLabel id="modalidade-label">Modalidade</InputLabel>
                  <Select
                    fullWidth
                    labelId="modalidade-label"
                    id="modalidade"
                    placeholder='Selecione a modalidade'
                    label="Modalidade"
                  >
                    <MenuItem selected value={20}>Musculação</MenuItem>
                    <MenuItem value={10}>Natação</MenuItem>
                    <MenuItem value={30}>Dança</MenuItem>
                    <MenuItem value={30}>Karatê</MenuItem>
                    <MenuItem value={30}>Jiu Jitsu</MenuItem>
                  </Select>
                </Grid>
                <Grid item xs={12} sm={4}>
                  <InputLabel id="plano-label">Plano</InputLabel>
                  <Select
                    fullWidth
                    labelId="plano-label"
                    id="plano"
                    placeholder='Selecione o plano'
                    label="Plano"
                  >
                    <MenuItem value={10}>Semanal</MenuItem>
                    <MenuItem selected value={20}>Mensal</MenuItem>
                    <MenuItem value={30}>Semestral</MenuItem>
                    <MenuItem value={30}>Anual</MenuItem>
                  </Select>
                </Grid>
                <Grid item xs={12} sm={4}>
                  <InputLabel id="pagamento-label">Forma de pagamento</InputLabel>
                  <Select
                    fullWidth
                    labelId="pagamento-label"
                    id="pagamento"
                    placeholder='Selecione a forma de pagamento'
                    label="Selecione a forma de pagamento"
                  >
                    <MenuItem value={10}>Dinheiro</MenuItem>
                    <MenuItem selected value={20}>Pix</MenuItem>
                    <MenuItem value={30}>Cartão</MenuItem>
                  </Select>
                </Grid>
              </Grid>
            <Grid display="flex" justifyContent="flex-end">
            <Button
                type="button"
                size='large'
                variant="outlined"
                onClick={handleBackPage}
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

export  { NewClient }