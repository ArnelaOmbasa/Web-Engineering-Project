// UserRecipeList.tsx
import React from 'react';
import { Grid } from '@mui/material';
import RecipeCard from '../../components/RecipeCard'; // Adjust the import path as needed
import { Recipe } from '../../utils/types'; // Adjust the import path for types
import spaghettiCarbonaraImg from '../../assets/spaghettiCarbonaraImg.jpg';
import vegetableStirFryImg from '../../assets/vegetableStirFryImg.jpg';
import chickenCurryImg from '../../assets/chickenCurryImg.jpg';
import cheeseburgerImg from '../../assets/cheeseburgerImg.jpg';

const dummyRecipes: Recipe[] = [
    {
      recipeId: '1',
      title: 'Spaghetti Carbonara',
      description: 'A classic Italian pasta dish...',
      ingredients: ['Pasta', 'Eggs', 'Cheese'],
      imageURL: spaghettiCarbonaraImg,
      author: 'user_id_1',
      comments: [
        {
          id: '1',
          text: 'So delicious :)'
        },
        {
          id: '2',
          text: 'Great recipe!'
        }
      ]
    },
    {
      recipeId: '2',
      title: 'Vegetable Stir Fry',
      description: 'A quick and healthy stir fry...',
      ingredients: ['Broccoli', 'Carrots', 'Peppers', 'Soy Sauce'],
      imageURL: vegetableStirFryImg,
      author: 'user_id_1',
      comments: [
        {
          id: '3',
          text: 'good :)'
        },
        {
          id: '4',
          text: 'Great '
        }
      ]
    },
    {
      recipeId: '3',
      title: 'Chicken Curry',
      description: 'A flavorful and spicy chicken curry...',
      ingredients: ['Chicken', 'Curry Powder', 'Coconut Milk', 'Rice'],
      imageURL: chickenCurryImg,
      author: 'user_id_1',
      comments: [
        {
          id: '5',
          text: 'So delicious :)'
        },
        {
          id: '6',
          text: 'Great recipe!'
        }
      ]
    },
    {
      recipeId: '4',
      title: 'Classic Cheeseburger',
      description: 'Juicy beef burger with cheese and lettuce...',
      ingredients: ['Beef Patty', 'Cheese', 'Lettuce', 'Buns'],
      imageURL: cheeseburgerImg,
      author: 'user_id_4',
      comments: [
        {
          id: '7',
          text: 'So delicious :)'
        },
        {
          id: '8',
          text: 'Great recipe!'
        }
      ]
    }
  
  ];

type UserRecipeListProps = {
  userId: string;
};

const UserRecipeList = ({ userId }: UserRecipeListProps) => {
  // Filter recipes to only include those created by the given user
  const userRecipes = dummyRecipes.filter(recipe => recipe.author === userId);

  return (
    <Grid container spacing={2}>
      {userRecipes.map((recipe) => (
        <Grid item key={recipe.recipeId} xs={12} sm={6} md={4} lg={3}>
          <RecipeCard recipe={recipe} />
        </Grid>
      ))}
    </Grid>
  );
};

export default UserRecipeList;
