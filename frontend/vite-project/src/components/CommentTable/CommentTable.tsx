// CommentTable.tsx

import React from 'react';
import { Table, TableBody, TableCell, TableContainer, TableHead, TableRow, Paper, IconButton } from '@mui/material';
import DeleteIcon from '@mui/icons-material/Delete';
import { Comment } from '../../utils/types'; // Import the Comment type

interface CommentTableProps {
  comments: Comment[];
  onDelete: (recipeId: string, commentText: string) => void; // Updated to match new function signature
}

function CommentTable(props: CommentTableProps) {
  const { comments, onDelete } = props;

  return (
    <TableContainer component={Paper} variant="outlined">
      <Table sx={{ minWidth: 650 }} aria-label="comment table">
        <TableHead>
          <TableRow>
            <TableCell>Comment ID</TableCell>
            <TableCell>Comment Text</TableCell>
            <TableCell>Actions</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {comments.map((comment) => (
            <TableRow key={comment.commentId}>
              <TableCell component="th" scope="row">
                {comment.commentId}
              </TableCell>
              <TableCell>{comment.text}</TableCell>
              <TableCell>
                {/* Update the onClick to pass both recipeId and commentText */}
                <IconButton onClick={() => onDelete(comment.recipeId, comment.text)} color="error">
                  <DeleteIcon />
                </IconButton>
              </TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
  );
}

export default CommentTable;
