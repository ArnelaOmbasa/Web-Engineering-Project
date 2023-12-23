// RecipeDetails.tsx
import React from 'react';
import { Typography, Box } from '@mui/material';


type Props = {
  recipe: {
    title: string;
    description: string;
  };
};

const RecipeDetails = ({ recipe }: Props) => (
    <Box sx={{ padding: 2 }}>
      <Typography variant="h4" gutterBottom>
        {recipe.title}
      </Typography>
      <Typography variant="body1">
        {recipe.description}
      </Typography>
    </Box>
  );
  
export default RecipeDetails;
