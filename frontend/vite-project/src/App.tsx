import React from 'react';
import Home from './pages/Home';
import LoginForm from './components/LoginForm';
import LoginPage from './pages/LoginPage';
import './App.css';
// App.tsx
import RegisterForm from './components/RegisterForm';
import RegisterPage from './pages/RegisterPage';
import RecipeImage from './components/RecipeImage';
import spaghettiCarbonaraImg from './assets/spaghettiCarbonaraImg.jpg';


const App = () => {
  return (

    <div>
    <RecipeImage imageUrl={spaghettiCarbonaraImg} title="Spaghetti Carbonara" />
  </div>
  );
};

export default App;
