import React from 'react';
import RecipeList from './components/RecipeList'; 
import './App.css'; 

const App = () => {
  return (
    <div style={{ textAlign: 'center', marginTop: '20px' }}>
      <h1>Welcome to the Recipe Sharing Platform</h1>
      <RecipeList />
    </div>
  );
};

export default App;
