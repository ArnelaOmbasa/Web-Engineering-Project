// App.tsx
import React from 'react';
import CommentsList from './components/CommentsList';

const App = () => {
  // Example array of comments
  const comments = [
    { id: '1', text: 'Great recipe!' },
    { id: '2', text: 'Loved it!' },
    // ... more comments
  ];

  return (
    <div>
      <CommentsList comments={comments} />
    </div>
  );
};

export default App;
