import { Grid, Card, Box, Typography } from '@mui/material';
import RecipeImage from '../components/RecipeImage';
import IngredientsList from '../components/IngredientsList';
import CommentsList from '../components/CommentsList';
import NewCommentForm from '../components/AddCommentForm';
import { Recipe } from '../utils/types';
import spaghettiCarbonaraImg from '../assets/spaghettiCarbonaraImg.jpg';

const recipe: Recipe = {
  recipeId: '1',
  title: 'Spaghetti Carbonara',
  description: 'A classic Italian pasta dish made with eggs, cheese, bacon and black paper.',
  ingredients: ['Pasta', 'Eggs', 'Cheese'],
  imageURL: spaghettiCarbonaraImg,
  author: 'Arnela Ombaša',
  comments: [
      { id: '1', text: 'So delicious :)' },
      { id: '2', text: 'Great recipe!' }
  ]
};

const handleNewComment = (commentText: string) => {
  // ...handleNewComment function
};

const RecipeDetailPage = () => {
 
  return (
    <Box sx={{ flexGrow: 1, m: 4 }}>
      <Grid container spacing={3}>
        <Grid item xs={12} md={6}>
<Card
elevation={6}
sx={{
display: 'flex',
justifyContent: 'center',
alignItems: 'center',
height: '100%',
// This will cause the image to adjust to the flex container
img: { width: '100%', height: 'auto' }
}}
>
<RecipeImage imageUrl={recipe.imageURL} title={recipe.title} />
</Card>
</Grid>
<Grid item xs={12} md={6}>
<Card
elevation={6}
sx={{
p: 2,
display: 'flex',
flexDirection: 'column',
justifyContent: 'space-between',
height: '100%'
}}
>
<Box sx={{ mb: 2 }}> {/* Increased space between title and description */}
<Typography variant="h4" gutterBottom sx={{ fontWeight: 'bold' }}>
{

recipe.title}
</Typography>
<Typography variant="body1" sx={{ mb: 3 }}> {/* Increased bottom margin for description */}
{recipe.description}
</Typography>
</Box>
<Box sx={{ flexGrow: 1, mb: 2 }}> {/*Added flexGrow to fill space and bottom margin */}
<IngredientsList ingredients={recipe.ingredients} />
{/*Removed gutterBottom from Typography if present in IngredientsList to reduce space*/}
</Box>
<Box>
<CommentsList comments={recipe.comments} />
{/*Adjustments inside CommentsList component may be necessary if there is too much space*/}
</Box>
<Box sx={{ mt: 4 }}> {/*Added top margin to comment form */}
<NewCommentForm onCommentSubmit={handleNewComment} />
</Box>
</Card>
</Grid>
</Grid>
</Box>
);
};

export default RecipeDetailPage;