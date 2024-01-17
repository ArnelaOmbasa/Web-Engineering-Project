import { useQuery } from "react-query";
import { Comment } from "../utils/types";
import CommentService from "../services/comments";


// because ts couldn't infer the type of the error
interface ApiError {
    message: string;
}  

const useGetAllComments = () => {
   return useQuery<Comment[], ApiError>('comments',
       () => CommentService.getComments(),
       { refetchOnWindowFocus: false }
   );
}


export default useGetAllComments;