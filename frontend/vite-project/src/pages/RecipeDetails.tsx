import React from 'react';
import { Grid, Card, Box, Typography } from '@mui/material';
import RecipeImage from '../components/RecipeImage';
import IngredientsList from '../components/IngredientsList';
import CommentsList from '../components/CommentsList';
import NewCommentForm from '../components/AddCommentForm';
import { useParams } from 'react-router-dom';
import useGetRecipeById from '../hooks/useGetRecipeById'; // Import your custom hook


type Comment = {
  text: string;
  // ...other properties
};

const RecipeDetailPage = () => {
  const { recipeId } = useParams<{ recipeId?: string }>(); // Note that recipeId is optional
  const {
    data: recipe,
    isLoading,
    isError,
    error,
  } = useGetRecipeById(recipeId!); // Using non-null assertion operator `!` since we are handling undefined case


  // Handle the loading state
  if (isLoading) {
    return <div>Loading...</div>;
  }

  // Handle the error state
  if (isError) {
    return <div>Error: {error?.message}</div>;
  }

  // Handle the case when there is no recipe data
  if (!recipe) {
    return <div>Recipe not found</div>;
  }

  // Function to handle new comment submission
  const handleNewComment = (commentText: string) => {
    // Logic to post a new comment
  };




  return (
    <Box sx={{ flexGrow: 1, m: 4 }}>
      <Grid container spacing={3}>
        <Grid item xs={12} md={6}>
          <Card
            elevation={6}
            sx={{
              display: 'flex',
              justifyContent: 'center',
              alignItems: 'center',
              height: '100%',
              img: { width: '100%', height: 'auto' },
            }}
          >
            <RecipeImage imageUrl={recipe.imageURL} title={recipe.title} />
          </Card>
        </Grid>
        <Grid item xs={12} md={6}>
          <Card
            elevation={6}
            sx={{
              p: 2,
              display: 'flex',
              flexDirection: 'column',
              justifyContent: 'space-between',
              height: '100%',
            }}
          >
            <Box sx={{ mb: 2 }}>
              <Typography variant="h4" gutterBottom sx={{ fontWeight: 'bold' }}>
                {recipe.title}
              </Typography>
              <Typography variant="body1" sx={{ mb: 3 }}>
                {recipe.description}
              </Typography>
            </Box>
            <Box sx={{ flexGrow: 1, mb: 2 }}>
              <IngredientsList ingredients={recipe.ingredients} />
            </Box>
            <Box>
            <CommentsList comments={recipe.comments} />
                    </Box>
            <Box sx={{ mt: 4 }}>
              <NewCommentForm onCommentSubmit={handleNewComment} />
            </Box>
          </Card>
        </Grid>
      </Grid>
    </Box>
  );
};

export default RecipeDetailPage;
