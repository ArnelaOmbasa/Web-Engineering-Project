// RecipeDetails.tsx
import React from 'react';
import { Typography, Box } from '@mui/material';

type Props = {
  title: string;
  description: string;
};

const RecipeDetails = ({ title, description }: Props) => (
  <Box sx={{ padding: 2 }}>
    <Typography variant="h4" gutterBottom>{title}</Typography>
    <Typography variant="body1">{description}</Typography>
  </Box>
);

export default RecipeDetails;
