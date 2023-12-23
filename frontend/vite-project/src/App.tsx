// App.tsx
import React from 'react';
import UserInfo from './components/UserInfo'; // Adjust the import path as needed
import { User } from './utils/types'; // Adjust the import path for your types

const App = () => {
  // Example user data - replace with actual data from your application's state or API
  const user: User = {
    username: 'JohnDoe',
    email: 'johndoe@example.com',
    // Add other required fields from the User type
    // For example, if your User type has recipes, provide them here
    recipes: [
      // Example recipe data
      { recipeId: '1', title: 'Spaghetti Carbonara', description: '...', ingredients: ['Pasta', 'Eggs'], imageURL: 'image_url', author: 'JohnDoe', comments: [] },
      // More recipes...
    ]
  };

  return (
    <div>
      <UserInfo user={user} />
    </div>
  );
};

export default App;
