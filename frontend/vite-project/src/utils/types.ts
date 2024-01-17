export type Recipe = {
    recipeId: string;
    title: string;
    description: string;
    ingredients: string[];
    imageURL: string;
    author: string;
    comments: string[];
  }

// Define your Comment type according to the actual structure of a comment object
export type Comment = {
  text: string;
  // ...other properties
};



  export type User = {
    username: string;
    email: string;
    password: string;
    role: string;
    recipes?: Recipe[]; 
  };

 
  
  