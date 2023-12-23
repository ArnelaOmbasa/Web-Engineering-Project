// UploadRecipePage.tsx
import React, { useState } from 'react';
import RecipeUploadForm from '../components/RecipeUploadForm';
import RecipeList from '../components/RecipeList';
import { Button, Box } from '@mui/material';

const UploadRecipePage = () => {
  const [modalOpen, setModalOpen] = useState(false);

  const handleOpenModal = () => setModalOpen(true);
  const handleCloseModal = () => setModalOpen(false);

  // Add explicit types to the function parameters
  const handleUploadRecipe = (title: string, description: string, ingredients: string[], imageURL: string) => {
    console.log('Uploading recipe:', title, description, ingredients, imageURL);
    // Integrate with your backend to upload the recipe
    handleCloseModal(); // Close the form upon submission
  };

  return (
    <Box sx={{ padding: 2 }}>
      <Button variant="contained" color="primary" onClick={handleOpenModal} sx={{ marginBottom: 2 }}>
        Add New Recipe
      </Button>
      <RecipeUploadForm open={modalOpen} onClose={handleCloseModal} onUpload={handleUploadRecipe} />
      <Box sx={{ marginTop: 2 }}>
        <RecipeList /> {/* Displaying the list of user's recipes */}
      </Box>
    </Box>
  );
};

export default UploadRecipePage;
