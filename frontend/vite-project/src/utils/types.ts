export type Recipe = {
    recipeId: string;
    title: string;
    description: string;
    ingredients: string[];
    imageURL: string;
    author: string;
    comments: Comment[];
  }

  export type Comment = {
    id: string;
    text: string;
   
  };
  