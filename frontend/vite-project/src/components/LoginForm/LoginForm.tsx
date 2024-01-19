import React from 'react';
import { useForm } from 'react-hook-form';
import { yupResolver } from '@hookform/resolvers/yup';
import * as yup from 'yup';
import { TextField, Button, Paper, Typography, Container } from '@mui/material';

// Define the form data type
type LoginFormData = {
  email: string;
  password: string;
};

// Yup schema
const schema = yup.object({
  email: yup.string().email('Invalid email format').required('Email is required'),
  password: yup.string().required('Password is required')
}).required();

const LoginForm = () => {
  const { register, handleSubmit, formState: { errors } } = useForm<LoginFormData>({
    resolver: yupResolver(schema)
  });

  const onSubmit = (data: LoginFormData) => {
    console.log(data);
    // Typically, you would send a request to your server here
  };

  return (
    <Container component="main" maxWidth="xs">
      <Paper style={{ padding: 20, marginTop: 50 }}>
        <Typography component="h1" variant="h5">
          Sign In
        </Typography>
        <form onSubmit={handleSubmit(onSubmit)} style={{ marginTop: 20 }}>
        <TextField
  variant="outlined"
  margin="normal"
  fullWidth
  label="Email Address"
  autoFocus
  error={Boolean(errors.email)}
  helperText={errors.email?.message}
  {...register('email')}
/>
<TextField
  variant="outlined"
  margin="normal"
  fullWidth
  label="Password"
  type="password"
  error={Boolean(errors.password)}
  helperText={errors.password?.message}
  {...register('password')}
/>
          <Button
            type="submit"
            fullWidth
            variant="contained"
            color="primary"
            sx={{ mt: 3, mb: 2 }}
          >
            Sign In
          </Button>
        </form>
      </Paper>
    </Container>
  );
};

export default LoginForm;
