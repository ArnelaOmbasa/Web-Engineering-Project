import { Recipe } from './utils/types';
import spaghettiCarbonaraImg from './assets/spaghettiCarbonaraImg.jpg';
import vegetableStirFryImg from './assets/vegetableStirFryImg.jpg';
import chickenCurryImg from './assets/chickenCurryImg.jpg';
import cheeseburgerImg from './assets/cheeseburgerImg.jpg';

export const dummyRecipes: Recipe[] = [
  {
    recipeId: '1',
    title: 'Spaghetti Carbonara',
    description: 'A classic Italian pasta dish...',
    ingredients: ['Pasta', 'Eggs', 'Cheese'],
    imageURL: spaghettiCarbonaraImg,
    author: 'user_id_1'
  },
  {
    recipeId: '2',
    title: 'Vegetable Stir Fry',
    description: 'A quick and healthy stir fry...',
    ingredients: ['Broccoli', 'Carrots', 'Peppers', 'Soy Sauce'],
    imageURL: vegetableStirFryImg,
    author: 'user_id_2'
  },
  {
    recipeId: '3',
    title: 'Chicken Curry',
    description: 'A flavorful and spicy chicken curry...',
    ingredients: ['Chicken', 'Curry Powder', 'Coconut Milk', 'Rice'],
    imageURL: chickenCurryImg,
    author: 'user_id_3'
  },
  {
    recipeId: '4',
    title: 'Classic Cheeseburger',
    description: 'Juicy beef burger with cheese and lettuce...',
    ingredients: ['Beef Patty', 'Cheese', 'Lettuce', 'Buns'],
    imageURL: cheeseburgerImg,
    author: 'user_id_4'
  }

];
