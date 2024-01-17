import { useQuery } from "react-query";
import { Recipe } from "../utils/types";
import RecipeService from "../services/recipes";

// because ts couldn't infer the type of the error
interface ApiError {
    message: string;
}  

// get exercise details by id
const useGetRecipeById = (id: string) => {
    return useQuery<Recipe, ApiError>(['recipe', id],
        () => RecipeService.getRecipeById(id),
        { refetchOnWindowFocus: false }
    );
}

export default useGetRecipeById;
