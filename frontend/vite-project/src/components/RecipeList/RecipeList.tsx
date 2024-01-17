import React from 'react';
import { Grid } from '@mui/material';
import RecipeCard from "../../components/RecipeCard";
import useGetAllRecipes from "../../hooks/useGetAllRecipes"; // Import your custom hook

const RecipeCardList = () => {
  // Use the useGetAllRecipes hook
  const { data: recipes, isLoading, error } = useGetAllRecipes();

  // Display loading state
  if (isLoading) {
    return <div>Loading...</div>;
  }

  // Display error state
  if (error) {
    return <div>Error: {error.message}</div>;
  }

  return (
    <Grid container spacing={2}>
      {recipes && recipes.map((recipe, i) => (
        <Grid item key={i} xs={12} sm={6} md={4} lg={3}>
          <RecipeCard recipe={recipe} />
        </Grid>
      ))}
    </Grid>
  );
};

export default RecipeCardList;
