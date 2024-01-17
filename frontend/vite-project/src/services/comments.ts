import appAxios from "./appAxios";
import { Comment } from "../utils/types";


const getComments = async (): Promise<Comment[]> => {
    return appAxios.get(`/comments`).then(
        (response) => {
            const data = response.data;
            console.log(data);
 
            return data;
        });
 }

 const CommentService = {
    getComments
};

export default CommentService;