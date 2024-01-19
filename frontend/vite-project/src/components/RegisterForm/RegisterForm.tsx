import React from 'react';
import { useForm, Controller  } from 'react-hook-form';
import { TextField, Button, Paper, Container, Box, FormControl, InputLabel, Select, MenuItem } from '@mui/material';
import { User, UserRole } from '../../utils/types'; // Adjust the import path as needed

const RegisterForm = () => {
  const { register, handleSubmit, control, formState: { errors } } = useForm<User>();
  

  const onSubmit = (data: User) => {
    console.log(data);
    // Typically, you would send a request to your server here
  };

  return (
    <Container maxWidth="sm">
      <Box display="flex" flexDirection="column" alignItems="center" justifyContent="center" minHeight="100vh">
        <Paper elevation={6} style={{ padding: 20, width: '100%', maxWidth: 400 }}>
          <form onSubmit={handleSubmit(onSubmit)} style={{ marginTop: 20 }}>
            <TextField
              label="Username"
              variant="outlined"
              fullWidth
              required
              margin="normal"
              {...register('username')}
            />
            <TextField
              label="Password"
              variant="outlined"
              type="password"
              fullWidth
              required
              margin="normal"
              {...register('password')}
            />
            <TextField
              label="Email"
              variant="outlined"
              type="email"
              fullWidth
              required
              margin="normal"
              {...register('email')}
            />
           <FormControl fullWidth margin="normal">
              <InputLabel>Role</InputLabel>
              <Controller
                name="role"
                control={control}
                defaultValue="USER"
                render={({ field }) => (
                  <Select
                    {...field}
                    label="Role"
                  >
                    {(['ADMIN', 'USER'] as UserRole[]).map((role) => (
                      <MenuItem key={role} value={role}>{role}</MenuItem>
                    ))}
                  </Select>
                )}
              />
            </FormControl>
            <Button type="submit" variant="contained" color="primary" fullWidth style={{ marginTop: 20 }}>
              Register
            </Button>
          </form>
        </Paper>
      </Box>
    </Container>
  );
};

export default RegisterForm;
