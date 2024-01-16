// App.tsx
import './App.css';
import { useState } from 'react';
import { Routes, Route, Navigate } from 'react-router-dom'; // No need to import BrowserRouter here
import Navbar from './components/NavBar';
import LoginPage from './pages/LoginPage';
import RegisterPage from './pages/RegisterPage';
import HomePage from './pages/Home';
import UserProfilePage from './pages/UserProfile';
import UploadRecipePage from './pages/UploadRecipePage';
import RecipeDetailPage from './pages/RecipeDetails';

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(true);

  return (
   /* <>
    <Navbar isLoggedIn={isLoggedIn} />
    <div className="root-content">
      <Routes>
        <Route path="/" element={<Navigate to="/home" />} />
        <Route path="/login" element={<LoginPage />} />
        <Route path="/register" element={<RegisterPage />} />
        <Route path="/home" element={<HomePage />} />
        <Route path="/profile" element={<UserProfilePage />} />
        <Route path="/upload" element={<UploadRecipePage />} />
      </Routes>
    </div>
  </>*/
  <RecipeDetailPage/>
);
}

export default App;
