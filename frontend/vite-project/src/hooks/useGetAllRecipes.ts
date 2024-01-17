import { useQuery } from "react-query";
import { Recipe } from "../utils/types";
import RecipeService from "../services/recipes";


// because ts couldn't infer the type of the error
interface ApiError {
    message: string;
}  

const useGetAllRecipes = () => {
   return useQuery<Recipe[], ApiError>('recipes',
       () => RecipeService.getRecipes(),
       { refetchOnWindowFocus: false }
   );
}


export default useGetAllRecipes;