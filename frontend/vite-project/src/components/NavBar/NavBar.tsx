import React from 'react';
import { AppBar, Tabs, Tab, Toolbar, Typography, Button } from '@mui/material';
import { Link } from 'react-router-dom';
import { useSelector } from 'react-redux';
import { RootState } from '../../store'; // Adjust the import path as needed
import { useDispatch } from 'react-redux';
import { logout } from '../../store/authSlice'; // Adjust the import path as needed

const Navbar = () => {

  // useDispatch hook to dispatch an action
  const dispatch = useDispatch();
  
  // useSelector hook to access the Redux state
  const { userToken } = useSelector((state: RootState) => (state as RootState).auth);
  //const isAdmin = userInfo?.isAdmin; // Assuming isAdmin is a property of userInfo

  return (
    <AppBar position="fixed" className="AppBar-root">
      <Toolbar>
        <Typography variant="h6" sx={{ flexGrow: 0 }}>
          CookeryCommunity
        </Typography>
        <Typography sx={{ flexGrow: 1 }} />

        {userToken ? (
          <Tabs>
            <Tab label="Home" component={Link} to="/home" style={{ color: 'inherit' }}/>
            {/*isAdmin && <Tab label="Admin" component={Link} to="/admin" style={{ color: 'inherit' }}/>*/} 
            <Tab label="My Profile" component={Link} to="/profile" style={{ color: 'inherit' }}/>
            <Tab label="Upload Recipe" component={Link} to="/upload" style={{ color: 'inherit' }}/>
            {/* Adjust the Logout logic as needed, perhaps to call a logout function */}
            <Tab label="Logout" component={Link} to="/" style={{ color: 'inherit' }} onClick={() => dispatch(logout())}
/>
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
