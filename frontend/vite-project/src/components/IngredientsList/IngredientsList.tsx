// IngredientsList.tsx
import React from 'react';
import { List, ListItem, ListItemText, Typography } from '@mui/material';

type Props = {
  ingredients: string[];
};

const IngredientsList = ({ ingredients }: Props) => (
  <List dense>
    <Typography variant="h6">Ingredients:</Typography>
    {ingredients.map((ingredient, index) => (
      <ListItem key={index}>
        <ListItemText primary={ingredient} />
      </ListItem>
    ))}
  </List>
);

export default IngredientsList;
