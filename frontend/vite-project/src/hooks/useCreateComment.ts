// hooks/useCreateComment.js

import { useMutation } from 'react-query';
import CommentService from '../services/comments';
import { CommentRequestDTO } from '../utils/types';

// because ts couldn't infer the type of the error
export interface ApiError {
    message: string;
}  
const useCreateComment = () => {
  return useMutation(
    (commentData: { recipeId: string; comment: CommentRequestDTO }) =>
      CommentService.createComment(commentData.recipeId, commentData.comment)
  );
};

export default useCreateComment;
