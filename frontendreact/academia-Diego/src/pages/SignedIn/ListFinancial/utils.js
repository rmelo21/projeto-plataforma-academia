export const PGTO_STATUS = {
  PAGO: 'Pago',
  VENCIDO: 'Vencido',
  ABERTO: 'Em aberto',
};

export const getColorByStatus = status => {
  switch (status) {
    case PGTO_STATUS.PAGO:
      return '#50C878';
    case PGTO_STATUS.VENCIDO:
      return '#FF5733';
    case PGTO_STATUS.ABERTO:
      return '#FFC300';
    default:
      return '#023020';
  }
};
