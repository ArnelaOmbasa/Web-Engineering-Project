import React from 'react';
import Alert from '@mui/material/Alert';

type SuccessAlertProps = {
  message: string;
};

const SuccessAlert = ({ message }: SuccessAlertProps) => {
  return <Alert severity="success">{message}</Alert>;
};

export default SuccessAlert;
