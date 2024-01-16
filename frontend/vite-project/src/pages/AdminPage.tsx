import React, { useState } from 'react';
import { Box, Drawer, List, ListItem, ListItemIcon, ListItemText, Toolbar, Typography } from '@mui/material';
import KitchenIcon from '@mui/icons-material/Kitchen';
import CommentIcon from '@mui/icons-material/Comment';
import PeopleIcon from '@mui/icons-material/People';
import RecipeComponent from '../components/RecipeTable'; // Import your RecipeComponent here

const drawerWidth = 240;

function AdminPage() {

    const sampleRecipe = {
        recipeId: '1',
        title: 'Sample Recipe',
        description: 'This is a sample recipe',
        ingredients: ['Ingredient 1', 'Ingredient 2'],
        imageURL: 'https://example.com/sample-image.jpg',
        ownerId: 'user123',
      };


  const [selectedContent, setSelectedContent] = useState(''); // State to track selected content

  const handleListItemClick = (content: string) => {
    setSelectedContent(content);
  };
  

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
            <ListItem
              button
              key={text}
              onClick={() => handleListItemClick(text)} // Handle item click
              selected={selectedContent === text}
            >
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
        {selectedContent === 'Recipes' && (
  <RecipeComponent recipe={sampleRecipe} onDelete={() => { /* Handle onDelete */ }} />
)}

     
      </Box>
    </Box>
  );
}

export default AdminPage;
