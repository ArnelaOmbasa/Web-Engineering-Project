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
    height="140"
    image={imageUrl}
    alt={title}
  />
);

export default RecipeImage;
