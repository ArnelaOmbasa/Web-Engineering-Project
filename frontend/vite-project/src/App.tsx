// App.tsx
import React from 'react';
import IngredientsList from './components/IngredientsList';

const App = () => {
  // Example array of ingredients
  const ingredients = ['Pasta', 'Eggs', 'Cheese', 'Pancetta', 'Pepper'];

  return (
    <div>
      <IngredientsList ingredients={ingredients} />
    </div>
  );
};

export default App;
