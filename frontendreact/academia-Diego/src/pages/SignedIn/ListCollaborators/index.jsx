import React from 'react'
import Box from '@mui/material/Box';
import Typography  from '@mui/material/Typography';
import Button  from '@mui/material/Button';
import AddOneIcon from '@mui/icons-material/Add';
import { DataGrid } from '@mui/x-data-grid';
import { useNavigate } from 'react-router-dom';

import { columns, rows } from './info'

const ListCollaborators = () => {

  const navigate = useNavigate();

  const handleNewCollaborator = () => {
    navigate('/collaborator-new');
  }

  return (
   
    <Box sx={{width: '100%'}}>
      <Typography variant="h5" color="">
        Lista de Colaboradores
      </Typography>
      <Box mt={4} display="flex" flex={1} alignItems="flex-end" justifyContent="flex-end">
        <Button variant="outlined" endIcon={<AddOneIcon />} onClick={handleNewCollaborator}>
          Novo Colaborador
        </Button>
      </Box>
      <Box sx={{width: '100%'}} mt={1}>
        <DataGrid
          rows={rows}
          columns={columns}
          pageSize={5}
          rowsPerPageOptions={[5]}
          autoHeight
          colu
        />
      </Box>
  </Box>
  )
}

export  {ListCollaborators}