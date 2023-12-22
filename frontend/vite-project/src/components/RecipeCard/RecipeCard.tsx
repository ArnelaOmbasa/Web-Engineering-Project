import React from 'react';
import { Card, CardActions, CardContent, CardMedia, Button, Typography } from '@mui/material';
import { Recipe } from '../../utils/types';

type Props = {
  recipe: Recipe;
};

const RecipeCard = ({ recipe }: Props) => {
  return (
    <Card sx={{ maxWidth: 250 }}>
      <CardMedia
        sx={{ margin: 'auto', height: 180, width: 190, p: 2, borderBottom: 1, borderColor: 'text.secondary' }}
        image={recipe.imageURL}
        title={recipe.title}
      />
      <CardContent>
        <Typography gutterBottom variant="body1" component="div">
          {recipe.title}
        </Typography>
        <Typography 
            variant="body2" 
            color="text.secondary" 
            sx={{ overflow: 'hidden', whiteSpace: 'nowrap', textOverflow: 'ellipsis' 
        }}>
          {recipe.description}
        </Typography>
      </CardContent>
      <CardActions sx={{ display: 'flex', justifyContent: 'space-between'}}>
        <Button size="small">View Details</Button>
      </CardActions>
    </Card>
  );
}

export default RecipeCard;
