// App.tsx
import React from 'react';
import NewCommentForm from './components/AddCommentForm';

const App = () => {
  const handleCommentSubmit = (commentText: string) => {
    console.log('New Comment:', commentText);
    // Here, you can also update the state or call an API to save the comment
  };

  return (
    <div>
      <NewCommentForm onCommentSubmit={handleCommentSubmit} />
    </div>
  );
};

export default App;
