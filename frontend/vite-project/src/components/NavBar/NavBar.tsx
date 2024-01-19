// Navbar.tsx

import React from 'react';
import { AppBar, Tabs, Tab, Toolbar, Typography, Button } from '@mui/material';
import { Link } from 'react-router-dom';

interface NavbarProps {
  isLoggedIn: boolean;
  isAdmin: boolean; // Add a prop to check if the user is an admin
}

const Navbar = ({ isLoggedIn, isAdmin }: NavbarProps) => {
  return (
    <AppBar position="fixed" className="AppBar-root">
      <Toolbar>
        <Typography variant="h6" sx={{ flexGrow: 0 }}>
          CookeryCommunity
        </Typography>
        <Typography sx={{ flexGrow: 1 }} />

        {isLoggedIn ? (
          <Tabs>
            <Tab label="Home" component={Link} to="/home" style={{ color: 'inherit' }}/>
            {isAdmin && <Tab label="Admin" component={Link} to="/admin" style={{ color: 'inherit' }}/>} 
            <Tab label="My Profile" component={Link} to="/profile" style={{ color: 'inherit' }}/>
            <Tab label="Upload Recipe" component={Link} to="/upload" style={{ color: 'inherit' }}/>
            <Tab label="Logout" component={Link} to="/" style={{ color: 'inherit' }} />
          </Tabs>
        ) : (
          <>
            <Button color="inherit" component={Link} to="/login">Login</Button>
            <Button color="inherit" component={Link} to="/register">Register</Button>
          </>
        )}
      </Toolbar>
    </AppBar>
  );
};

export default Navbar;
