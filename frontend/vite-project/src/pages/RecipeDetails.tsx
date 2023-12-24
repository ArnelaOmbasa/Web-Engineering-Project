import React from 'react';
import { Grid, Card, Box, Typography } from '@mui/material';
import RecipeImage from '../components/RecipeImage';
import RecipeDetails from '../components/RecipeDetails/RecipeDetails';
import IngredientsList from '../components/IngredientsList';
import CommentsList from '../components/CommentsList';
import NewCommentForm from '../components/AddCommentForm';
import { Recipe } from '../utils/types';
import spaghettiCarbonaraImg from '../assets/spaghettiCarbonaraImg.jpg';

const recipe: Recipe = {
  recipeId: '1',
  title: 'Spaghetti Carbonara',
  description: 'A classic Italian pasta dish made with eggs, cheese, bacon and black pepper.',
  ingredients: ['Pasta', 'Eggs', 'Cheese'],
  imageURL: spaghettiCarbonaraImg,
  author: 'Arnela Ombaša',
  comments: [
      { id: '1', text: 'So delicious :)' },
      { id: '2', text: 'Great recipe!' }
  ]
};

const handleNewComment = (commentText: string) => {
  console.log("New Comment:", commentText);
  // Add logic to handle the new comment submission
  // For example, updating state, sending to a server, etc.
};

const RecipeDetailPage = () => {
  // ... handleNewComment function

  return (
    <Box sx={{ flexGrow: 1, m: 4 }}>
      <Grid container spacing={3}>
        <Grid item xs={12} md={6}>
          <Card elevation={6}>
            <RecipeImage imageUrl={recipe.imageURL} title={recipe.title} />
          </Card>
        </Grid>
        <Grid item xs={12} md={6}>
          <Card elevation={6} sx={{ p: 2 }}>
            <Typography variant="h4" gutterBottom>{recipe.title}</Typography>
            <Typography variant="body1" gutterBottom>{recipe.description}</Typography>
            <IngredientsList ingredients={recipe.ingredients} />
            <CommentsList comments={recipe.comments} />
            <NewCommentForm onCommentSubmit={handleNewComment} />
          </Card>
        </Grid>
      </Grid>
    </Box>
  );
};

export default RecipeDetailPage;
