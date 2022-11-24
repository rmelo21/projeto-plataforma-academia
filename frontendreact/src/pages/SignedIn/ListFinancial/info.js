import Typography  from '@mui/material/Typography';

import { getColorByStatus, PGTO_STATUS } from './utils';

export const columns = [
  { field: 'id', headerName: 'Duplicata', flex: 1, },
  { field: 'venc', headerName: 'Nome',  flex: 1, },
  { field: 'pgto', headerName: 'Sobrenome',  flex: 1, },
  { field: 'status', headerName: 'Email', flex: 1, renderCell: (params) => (
    <strong>
      <Typography
       color={getColorByStatus(params.value)}
      >
        {params.value}
      </Typography>
    </strong>
  )}
];

export const rows = [
  { id: 99865, venc: '10/11/2022', pgto: '-', status: PGTO_STATUS.ABERTO },
  { id: 89546, venc: '10/10/2022', pgto: '-', status: PGTO_STATUS.VENCIDO },
  { id: 71536, venc: '10/09/2022', pgto: '-', status: PGTO_STATUS.VENCIDO },
  { id: 64859, venc: '10/08/2022', pgto: '08/01/2022', status: PGTO_STATUS.PAGO },
  { id: 58565, venc: '10/07/2022', pgto: '08/01/2022', status: PGTO_STATUS.PAGO },
  { id: 48566, venc: '10/06/2022', pgto: '08/01/2022', status: PGTO_STATUS.PAGO },
  { id: 38561, venc: '10/05/2022', pgto: '08/01/2022', status: PGTO_STATUS.PAGO },
  { id: 28562, venc: '10/04/2022', pgto: '08/01/2022', status: PGTO_STATUS.PAGO },
  { id: 18565, venc: '10/01/2022', pgto: '08/01/2022', status: PGTO_STATUS.PAGO },
];