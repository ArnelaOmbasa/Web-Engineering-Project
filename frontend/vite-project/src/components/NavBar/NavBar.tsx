import React from 'react';
import { AppBar, Tabs, Tab, Toolbar, Typography, Button } from '@mui/material';
import { Link } from 'react-router-dom';

interface NavbarProps {
  isLoggedIn: boolean;
}

const Navbar = ({ isLoggedIn }: NavbarProps) => {
  return (
    <AppBar position="static" sx={{ width: '100%', maxWidth: '100%', position: 'absolute', top: 0, left: 0 }}>
      <Toolbar>
      <Typography variant="h6" sx={{ flexGrow: 0 }}>
      CookeryCommunity

        </Typography>
        <Typography sx={{ flexGrow: 1 }} />

        {isLoggedIn ? (
          <Tabs>
          <Tab label="Home" component={Link} to="/home" />
            <Tab label="My Profile" component={Link} to="/profile" />
            <Tab label="Upload Recipe" component={Link} to="/upload" />
            <Tab label="Logout" component={Link} to="/" />
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
