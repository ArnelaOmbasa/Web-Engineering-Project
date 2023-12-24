import React from 'react';
import RegisterForm from '../components/RegisterForm'; // Ensure this path is correct
import { Container, CssBaseline, Box } from '@mui/material';

const RegisterPage = () => {
  return (
    <Container component="main" maxWidth="xs">
      <CssBaseline />
      <Box
        sx={{
          marginTop: 8,
          display: 'flex',
          flexDirection: 'column',
          alignItems: 'center'
        }}
      >
        <RegisterForm />
      </Box>
    </Container>
  );
};

export default RegisterPage;
