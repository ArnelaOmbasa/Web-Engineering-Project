import React, { useState } from 'react';
import { User } from '../../utils/types';
import { Container, TextField, Button } from '@mui/material';

type EditUserFormProps = {
  user: User;
  onUpdate: (user: User) => void;
  onClose: () => void;
};

const EditUserForm: React.FC<EditUserFormProps> = ({ user, onUpdate, onClose }) => {
  const [editedUser, setEditedUser] = useState<User>(user);

  const handleChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    setEditedUser({ ...editedUser, [event.target.name]: event.target.value });
  };

  const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    onUpdate(editedUser);
    onClose();
  };

  return (
    <Container maxWidth="sm" sx={{ padding: '20px', marginTop: '20px' }}>
      <form onSubmit={handleSubmit}>
        <TextField
          fullWidth
          margin="normal"
          label="Username"
          name="username"
          value={editedUser.username}
          onChange={handleChange}
        />
        <TextField
          fullWidth
          margin="normal"
          label="Email"
          name="email"
          value={editedUser.email}
          onChange={handleChange}
        />
        <TextField
          fullWidth
          margin="normal"
          label="Password"
          type="password"
          name="password"
          value={editedUser.password}
          onChange={handleChange}
        />
        <TextField
          fullWidth
          margin="normal"
          label="Role"
          name="role"
          value={editedUser.role}
          onChange={handleChange}
        />
        <Button type="submit" variant="contained" color="primary" sx={{ marginTop: '20px' }}>
          Done
        </Button>
      </form>
    </Container>
  );
};

export default EditUserForm;
