// Home.tsx

import React from 'react';
import Navbar from '../components/NavBar';
import RecipeCardList from '../components/RecipeList';

const Home = () => {
  return (
    <div>
      <Navbar />
      <div className="root-content">
        <h1>Welcome to the Recipe Sharing Platform</h1>
        <RecipeCardList />
      </div>
    </div>
  );
};

export default Home;