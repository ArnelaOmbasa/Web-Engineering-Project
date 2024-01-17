import appAxios from "./appAxios";
import { Recipe } from "../utils/types";


const getRecipes = async (): Promise<Recipe[]> => {
    return appAxios.get(`/recipes`).then(
        (response) => {
            const data = response.data;
            console.log(data);
 
            return data;
        });
 }


 const getRecipeById = async (id: string): Promise<Recipe> => {
    return appAxios.get(`/recipes/${id}`).then(
        (response) => {
            const data = response.data;
            console.log(data);
 
            return data;
        });
}

 const RecipeService = {
    getRecipes,
    getRecipeById
};

export default RecipeService;