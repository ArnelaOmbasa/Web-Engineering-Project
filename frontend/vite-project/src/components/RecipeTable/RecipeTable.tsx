import React from 'react';
import { Table, TableBody, TableCell, TableContainer, TableHead, TableRow, Paper, IconButton } from '@mui/material';
import DeleteIcon from '@mui/icons-material/Delete';

interface Recipe {
  recipeId: string;
  title: string;
  description: string;
  ingredients: string[];
  imageURL: string;
  ownerId: string;
}

interface RecipeProps {
  recipe: Recipe;
  onDelete: () => void;
}

function RecipeComponent({ recipe, onDelete }: RecipeProps) {
  return (
    <TableContainer component={Paper} variant="outlined">
      <Table sx={{ minWidth: 650 }} aria-label="simple table">
        <TableHead>
          <TableRow>
            <TableCell>ID</TableCell>
            <TableCell>Title</TableCell>
            <TableCell>Description</TableCell>
            <TableCell>Ingredients</TableCell>
            <TableCell>Image</TableCell>
            <TableCell>Owner</TableCell>
            <TableCell>Actions</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          <TableRow
            sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
          >
            <TableCell component="th" scope="row">
              {recipe.recipeId}
            </TableCell>
            <TableCell>{recipe.title}</TableCell>
            <TableCell>{recipe.description}</TableCell>
            <TableCell>{recipe.ingredients.join(', ')}</TableCell>
            <TableCell>
              <a href={recipe.imageURL} target="_blank" rel="noopener noreferrer">View Image</a>
            </TableCell>
            <TableCell>{recipe.ownerId}</TableCell>
            <TableCell>
            <IconButton onClick={onDelete} color="error">
<DeleteIcon />
</IconButton>
            </TableCell>
          </TableRow>
        </TableBody>
      </Table>
    </TableContainer>
  );
}

export default RecipeComponent;
