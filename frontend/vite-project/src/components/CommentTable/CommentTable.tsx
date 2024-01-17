import React from 'react';
import { Table, TableBody, TableCell, TableContainer, TableHead, TableRow, Paper, IconButton } from '@mui/material';
import DeleteIcon from '@mui/icons-material/Delete';
import { Comment } from '../../utils/types'; // Assuming this is the correct path to your type

interface CommentTableProps {
  comments: Comment[];
  onDelete: (commentId: string) => void;
}

function CommentTable(props: CommentTableProps) {
  const { comments, onDelete } = props;

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
          {comments.map((comment) => (
            <TableRow key={comment.commentId}>
              <TableCell component="th" scope="row">{comment.commentId}</TableCell>
              <TableCell>{comment.text}</TableCell>
              <TableCell>{comment.authorId}</TableCell>
              <TableCell>{comment.recipeId}</TableCell>
              <TableCell>
                <IconButton onClick={() => onDelete(comment.commentId)} color="error">
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
