// RecipeDetailPage.tsx
import React from 'react';
import { Grid, Card, Box, Paper, Typography } from '@mui/material';
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

const RecipeDetailPage = () => {
  const handleNewComment = (commentText: string) => {
    console.log(commentText);
  };

  return (
    <Box sx={{ flexGrow: 1, m: 2 }}>
      <Grid container spacing={2}>
        <Grid item xs={12} md={6}>
          <Paper elevation={3} sx={{ maxWidth: 345, m: 'auto' }}>
            <RecipeImage imageUrl={recipe.imageURL} title={recipe.title} />
          </Paper>
        </Grid>
        <Grid item xs={12} md={6}>
          {/* Nested Grid for Details and Comments */}
          <Grid container spacing={2}>
            <Grid item xs={12} md={6}>
              <Card variant="outlined" sx={{ p: 2, height: '100%' }}>
                <RecipeDetails title={recipe.title} description={recipe.description} />
                <IngredientsList ingredients={recipe.ingredients} />
              </Card>
            </Grid>
            <Grid item xs={12} md={6}>
              <Card variant="outlined" sx={{ p: 2, height: '100%' }}>
                <CommentsList comments={recipe.comments} />
                <NewCommentForm onCommentSubmit={handleNewComment} />
              </Card>
            </Grid>
          </Grid>
        </Grid>
      </Grid>
    </Box>
  );
};



export default RecipeDetailPage;
