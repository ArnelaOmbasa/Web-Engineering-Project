import React, { useState } from 'react';
import { AlertColor, Box, Drawer, List, ListItem, ListItemIcon, ListItemText, Toolbar, Typography } from '@mui/material';
import KitchenIcon from '@mui/icons-material/Kitchen';
import CommentIcon from '@mui/icons-material/Comment';
import PeopleIcon from '@mui/icons-material/People';
import RecipeTable from '../components/RecipeTable';
import CommentTable from '../components/CommentTable';
import UserTable from '../components/UsersTable';
import useGetAllRecipes from '../hooks/useGetAllRecipes';
import useGetAllComments from '../hooks/useGetAllComments'; // Import the hook for comments
import useGetAllUsers from '../hooks/useGetAllUsers'; // Make sure to import your hook
import useDeleteUser from '../hooks/useDeleteUser'; // Import the hook for deleting users
import { Snackbar, Alert } from '@mui/material';



const drawerWidth = 240;

function AdminPage() {

  const [snackbarOpen, setSnackbarOpen] = useState(false);
  const [snackbarMessage, setSnackbarMessage] = useState('');
  const [snackbarSeverity, setSnackbarSeverity] = useState<AlertColor>('success');
  const [selectedContent, setSelectedContent] = useState('');
  const { data: recipes, isLoading, isError, error } = useGetAllRecipes();
  const { data: comments, isLoading: isLoadingComments, isError: isErrorComments, error: errorComments } = useGetAllComments(); // Use the custom hook to fetch comments
  const { data: users, isLoading: isLoadingUsers, isError: isErrorUsers, error: errorUsers } = useGetAllUsers(); // Use the custom hook to fetch users
  
  const deleteMutation = useDeleteUser({
    onSuccess: () => {
      setSnackbarMessage('User deleted successfully');
      setSnackbarSeverity('success');
      setSnackbarOpen(true);
      // Optionally, refetch users or update local state here
    },
    onError: (error) => {
      setSnackbarMessage(error.message || 'Error deleting user');
      setSnackbarSeverity('error');
      setSnackbarOpen(true);
    },
  });

  const handleDeleteUser = (userId: string) => {
    deleteMutation.mutate(userId);
  };

  const handleListItemClick = (content: string) => {
    setSelectedContent(content);
  };

  const handleDeleteRecipe = (recipeId: string) => {
    console.log('Delete recipe with ID:', recipeId);
    // Implement the delete functionality here
  };

  const handleDeleteComment = (commentId: string) => {
    console.log('Delete comment with ID:', commentId);
    // Implement the delete functionality here
  };
  const handleCloseSnackbar = (
    event: React.SyntheticEvent | Event,
    reason?: string
  ) => {
    if (reason === 'clickaway') {
      return;
    }
    setSnackbarOpen(false);
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
              onClick={() => handleListItemClick(text)}
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
          <>
            {isLoading && <Typography>Loading recipes...</Typography>}
            {isError && <Typography>Error: {error?.message}</Typography>}
            {!isLoading && !isError && recipes && (
              <RecipeTable
                recipes={recipes}
                onDelete={handleDeleteRecipe}
              />
            )}
          </>
        )}
         {selectedContent === 'Comments' && (
          <>
            {isLoadingComments && <Typography>Loading comments...</Typography>}
            {isErrorComments && <Typography>Error: {errorComments?.message}</Typography>}
            {!isLoadingComments && !isErrorComments && comments && (
              <CommentTable
                comments={comments}
                onDelete={handleDeleteComment}
              />
            )}
            
          </>
        )}

{selectedContent === 'Users' && (
          <>
            {isLoadingUsers && <Typography>Loading users...</Typography>}
            {isErrorUsers && <Typography>Error: {errorUsers?.message}</Typography>}
            {!isLoadingUsers && !isErrorUsers && users && (
              <UserTable
                users={users}
                onDelete={handleDeleteUser}
              />
            )}
          </>
        )}

<Snackbar
  open={snackbarOpen}
  autoHideDuration={6000}
  onClose={handleCloseSnackbar}
>
  <Alert
    onClose={handleCloseSnackbar}
    severity={snackbarSeverity}
    sx={{ width: '100%' }}
  >
    {snackbarMessage}
  </Alert>
</Snackbar>
      </Box>
    </Box>
  );
}

export default AdminPage;
