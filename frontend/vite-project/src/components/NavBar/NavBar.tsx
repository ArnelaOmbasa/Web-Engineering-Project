// Navbar.tsx

import React from 'react';
import { AppBar, Toolbar, Typography, Button } from '@mui/material';

const Navbar = () => {
  return (
    <AppBar position="static" sx={{ width: '100%', maxWidth: '100%', position: 'absolute', top: 0, left: 0 }}>
      <Toolbar>
        <Typography variant="h6" style={{ flexGrow: 1 }}>
          Recipe Sharing Platform
        </Typography>
        <Button color="inherit">Login</Button>
        <Button color="inherit">Register</Button>
      </Toolbar>
    </AppBar>
  );
};

export default Navbar;
