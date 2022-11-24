import React, { useState } from 'react'
import Box from '@mui/material/Box';
import Grid from '@mui/material/Grid';
import Typography  from '@mui/material/Typography';
import MenuItem from '@mui/material/MenuItem';
import InputLabel from '@mui/material/InputLabel';
import Select from '@mui/material/Select';
import { DataGrid } from '@mui/x-data-grid';

import { rows as clientRows } from '../ListClient/info';

import { columns, rows} from './info';


const ListFinancial = () => {

  const [clientSelected, setClientSelected] = useState(null)

  const onChangeClientSelected = (event) => {
      const clientId = event.target.value;

      console.log(clientId);
      setClientSelected(clientId)
  }

  return (
   
    <Box sx={{width: '100%'}}>
      <Typography variant="h5" color="">
        Movimentos financeiros
      </Typography>
      <Grid container mb={3} mt={4}>
      <Grid item xs={12} sm={4}>
          <InputLabel id="cliente-label">Selecione o cliente</InputLabel>
          <Select
            fullWidth
            labelId="cliente-label"
            id="cliente"
            onChange={onChangeClientSelected}
            placeholder='Selecione o cliente'
            label="Cliente"
          >
            {clientRows.map(client => (
              <MenuItem value={client.id}>{`${client.firstName} ${client.lastName} (${client.email})`}</MenuItem>
            ))}
          </Select>
        </Grid>
      </Grid>
      {clientSelected ? (
        <Box sx={{width: '100%'}} mt={1}>
          <DataGrid
            rows={rows}
            columns={columns}
            pageSize={35}
            rowsPerPageOptions={[5]}
            autoHeight
          />
        </Box>
      ) : null}
  </Box>
  )
}

export  {ListFinancial}