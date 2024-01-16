import React from 'react';
import { Table, TableBody, TableCell, TableContainer, TableHead, TableRow, Paper, IconButton } from '@mui/material';
import DeleteIcon from '@mui/icons-material/Delete';

interface Comment {
  commentId: string;
  text: string;
  authorId: string;
  recipeId: string;
}

interface CommentProps {
  comment: Comment;
  onDelete: () => void;
}

function CommentComponent({ comment, onDelete }: CommentProps) {
  return (
    <TableContainer component={Paper} variant="outlined">
      <Table sx={{ minWidth: 650 }} aria-label="comment table">
        <TableHead>
          <TableRow>
            <TableCell>ID</TableCell>
            <TableCell>Text</TableCell>
            <TableCell>Author ID</TableCell>
            <TableCell>Recipe ID</TableCell>
            <TableCell>Actions</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          <TableRow
            sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
          >
            <TableCell component="th" scope="row">
              {comment.commentId}
            </TableCell>
            <TableCell>{comment.text}</TableCell>
            <TableCell>{comment.authorId}</TableCell>
            <TableCell>{comment.recipeId}</TableCell>
            <TableCell>
              <IconButton onClick={onDelete} color="error">
                <DeleteIcon />
              </IconButton>
            </TableCell>
          </TableRow>
        </TableBody>
      </Table>
    </TableContainer>
  );
}

export default CommentComponent;
