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
  




  export type User = {
    username: string;
    email: string;
    password: string;
    role: string;
    recipes?: Recipe[]; 
  };

 
  
  