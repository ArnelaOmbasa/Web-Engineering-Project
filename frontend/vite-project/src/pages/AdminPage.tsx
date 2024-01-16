import React from 'react';
import { Box, Drawer, List, ListItem, ListItemIcon, ListItemText, Toolbar, Typography } from '@mui/material';
import KitchenIcon from '@mui/icons-material/Kitchen';
import CommentIcon from '@mui/icons-material/Comment';
import PeopleIcon from '@mui/icons-material/People';

const drawerWidth = 240;

function AdminPage() {
  return (
    <Box sx={{ display: 'flex' }}>
      <Drawer
        variant="permanent"
        sx={{
          width: drawerWidth,
          flexShrink: 0,
          [`& .MuiDrawer-paper`]: { width: drawerWidth, boxSizing: 'border-box' },
        }}
      >
        <Toolbar />
        <List>
          {['Recipes', 'Comments', 'Users'].map((text, index) => (
            <ListItem button key={text}>
              <ListItemIcon>
                {index === 0 ? <KitchenIcon /> : index === 1 ? <CommentIcon /> : <PeopleIcon />}
              </ListItemIcon>
              <ListItemText primary={text} />
            </ListItem>
          ))}
        </List>
      </Drawer>
      <Box
        component="main"
        sx={{ flexGrow: 1, bgcolor: 'background.default', p: 3 }}
      >
        <Toolbar />
        <Typography paragraph>
          Here goes the content based on the selection in the sidebar.
        </Typography>
      </Box>
    </Box>
  );
}

export default AdminPage;
