import RecipeCard from "./components/RecipeCard";
import { dummyRecipes} from "./constants";


function App() {
  

    return (
      <div>
        <h1>Welcome to the Recipe Sharing Platform</h1>
        <RecipeCard recipe={dummyRecipes[0]} />
      </div>
    );
  
}

export default App;
