// UserInfo.tsx
import React from 'react';
import { User } from '../../utils/types';
import Container from '@mui/material/Container';
import Typography from '@mui/material/Typography';
import Button from '@mui/material/Button';
import UserAvatar from '../UserAvatar';
import { grey } from '@mui/material/colors';

type Props = {
  user: User;
};

const UserInfo = ({ user }: Props) => {
  return (
    <Container maxWidth="sm" sx={{ backgroundColor: 'primary.main', padding: '20px', borderRadius: '15px', textAlign: 'center', color: '#fff' }}>
      <UserAvatar username={user.username} size="80px" fontSize="30px" sx={{ margin: '15px auto', bgcolor: grey[500] }} />
      <Typography variant="h5" gutterBottom sx={{ color: '#fff' }}>
        {user.username}
      </Typography>
      <Typography variant="body2" gutterBottom sx={{ color: '#fff' }}> 
        {user.email} 
      </Typography>
      <Button 
        size="medium" 
        variant="contained"
        sx={{ 
          marginTop: '20px', 
          backgroundColor: '#fff', // White background
          color: grey[800], // Gray text
          '&:hover': {
            backgroundColor: grey[100], // Lighter gray on hover
          }
        }}
      >
        Edit personal information
      </Button>
    </Container>
  );
};

export default UserInfo;
