// App.tsx
import React from 'react';
import './App.css';
import RecipeDetails from './components/RecipeDetails/RecipeDetails'; // Ensure this path is correct

const App = () => {
  const recipe = {
    title: 'Spaghetti Carbonara',
    description: 'A classic Italian pasta dish with eggs, cheese, pancetta, and pepper.'
  };

  return (
    <div>
      <RecipeDetails recipe={recipe} />
    </div>
  );
};


export default App;
