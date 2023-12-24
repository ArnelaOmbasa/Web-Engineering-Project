// NewCommentForm.tsx
import React, { useState } from 'react';
import { TextField, Button, Box } from '@mui/material';

type Props = {
  onCommentSubmit: (commentText: string) => void;
};

const NewCommentForm = ({ onCommentSubmit }: Props) => {
  const [commentText, setCommentText] = useState('');

  const handleSubmit = (event: React.FormEvent) => {
    event.preventDefault();
    onCommentSubmit(commentText);
    setCommentText('');
  };

  return (
    <Box component="form" onSubmit={handleSubmit} sx={{ mt: 2 }}>
      <TextField
        fullWidth
        multiline
        rows={4}
        variant="outlined"
        label="Add a comment"
        value={commentText}
        onChange={(e) => setCommentText(e.target.value)}
      />
      <Button type="submit" variant="contained" sx={{ mt: 2 }}>
        Post Comment
      </Button>
    </Box>
  );
};

export default NewCommentForm;
