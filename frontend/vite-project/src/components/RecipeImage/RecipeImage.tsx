// RecipeImage.tsx
import React from 'react';
import { CardMedia } from '@mui/material';

type Props = {
  imageUrl: string;
  title: string;
};

const RecipeImage = ({ imageUrl, title }: Props) => (
  <CardMedia
    component="img"
    image={imageUrl}
    alt={title}
    sx={{ width: '100%', height: 'auto', objectFit: 'contain' }} // Adjust the style here
  />
);

export default RecipeImage;
