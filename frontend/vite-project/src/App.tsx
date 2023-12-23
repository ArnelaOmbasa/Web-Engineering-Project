// App.tsx
import React, { useState } from 'react';
import RecipeUploadForm from './components/RecipeUploadForm'; // Adjust the import path as needed

const App = () => {
  const [isFormOpen, setIsFormOpen] = useState(false);

  const handleOpenForm = () => setIsFormOpen(true);
  const handleCloseForm = () => setIsFormOpen(false);

  const handleUploadRecipe = (title: string, description: string, ingredients: string[], imageURL: string) => {
    console.log('Recipe Data:', title, description, ingredients, imageURL);
    // Integration with backend logic goes here
    handleCloseForm(); // Close the form upon submission
  };

  return (
    <div>
      <button onClick={handleOpenForm}>Add New Recipe</button>
      <RecipeUploadForm 
        open={isFormOpen} 
        onClose={handleCloseForm} 
        onUpload={handleUploadRecipe} 
      />
      {/* Other components can go here */}
    </div>
  );
};

export default App;
