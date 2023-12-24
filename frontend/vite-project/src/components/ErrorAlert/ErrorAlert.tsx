import React from 'react';
import Alert from '@mui/material/Alert';

type ErrorAlertProps = {
  message: string;
};

const ErrorAlert = ({ message }: ErrorAlertProps) => {
  return <Alert severity="error">{message}</Alert>;
};

export default ErrorAlert;
