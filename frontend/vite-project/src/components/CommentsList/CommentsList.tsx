// CommentsList.tsx
import React from 'react';
import { List, ListItem, ListItemText } from '@mui/material';

type Comment = {
  id: string;
  text: string;
};

type Props = {
  comments: Comment[];
};

const CommentsList = ({ comments }: Props) => (
  <List>
    {comments.map(comment => (
      <ListItem key={comment.id}>
        <ListItemText primary={comment.text} />
      </ListItem>
    ))}
  </List>
);

export default CommentsList;
