import React, { useState } from 'react';
import { Grid } from '@mui/material';
import RecipeCard from "../../components/RecipeCard";
import { Recipe } from '../../utils/types';
import { dummyRecipes} from "../../constants";

type Props = {};

const RecipeCardList = (props: Props) => {
  const [recipes, setRecipes] = useState<Recipe[]>(dummyRecipes);

  return (
    <Grid container spacing={2}>
      {recipes.map((recipe, i) => (
        <Grid item key={i} xs={12} sm={6} md={4} lg={3}>
          <RecipeCard recipe={recipe} />
        </Grid>
      ))}
    </Grid>
  );
};

export default RecipeCardList;
