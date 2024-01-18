export type Recipe = {
    recipeId: string;
    title: string;
    description: string;
    ingredients: string[];
    imageURL: string;
    ownerId: string;
    comments: string[];
  }
  export type Comment = {
    commentId: string;
    text: string;
    authorId: string;
    recipeId: string;
  };
  




  export type UserRole = 'ADMIN' | 'USER';

  export type User = {
    userId: string;
    username: string;
    email: string;
    role: UserRole;
  };

  export type CommentRequestDTO = {
    text: string;
  };

 
  
  