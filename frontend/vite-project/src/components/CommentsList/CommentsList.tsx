// CommentsList.tsx
import React from 'react';
import { List, ListItem, ListItemText, ListItemAvatar, Avatar, Divider, Paper } from '@mui/material';
import AccountCircleIcon from '@mui/icons-material/AccountCircle';

type Comment = {
  id: string;
  text: string;
};

type Props = {
  comments: Comment[];
};

const CommentsList = ({ comments }: Props) => (
  <List>
    {comments.map((comment, index) => (
      <React.Fragment key={comment.id}>
        {index > 0 && <Divider variant="inset" component="li" />}
        <Paper elevation={3} style={{ margin: '10px 0', padding: '10px' }}>
        <ListItem alignItems="center"> {/* Changed from 'flex-start' to 'center' */}
            <ListItemAvatar>
              <Avatar>
                <AccountCircleIcon style={{ fontSize: 40, color: 'blue' }} />
              </Avatar>
            </ListItemAvatar>
            <ListItemText primary={comment.text} />
          </ListItem>
        </Paper>
      </React.Fragment>
    ))}
  </List>
);

export default CommentsList;
