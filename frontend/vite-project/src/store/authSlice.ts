import { createSlice } from '@reduxjs/toolkit'
import { createAsyncThunk } from '@reduxjs/toolkit'
import appAxios from '../services/appAxios'
import { RegisterFormData } from '../utils/types';

const initialState = {
    loading: false,
    userInfo: null, // for user the object
    userToken: null, // for storing the JWT
    error: null,
    success: false, // for monitoring the registration process.
}


const authSlice = createSlice({
   name: 'auth',
   initialState,
   reducers: {},
   extraReducers: (builder) => {
    builder.addCase(registerUser.pending, (state) => {
        state.loading = true
        state.error = null
    })
    builder.addCase(registerUser.fulfilled, (state) => {
        state.loading = false
        state.success = true
    })
    builder.addCase(registerUser.rejected, (state, action: any) => {
        state.loading = false
        state.error = action.payload
    })
}

})
// Define and export the createAsyncThunk
export const registerUser = createAsyncThunk(
    'auth/register',
    async (data: RegisterFormData, { rejectWithValue }) => {
      try {
        await appAxios.post('/auth/register', data);
      } catch (error: any) {
        if (error.response && error.response.data.message) {
          return rejectWithValue(error.response.data.message);
        } else {
          return rejectWithValue(error.message);
        }
      }
    }
  );
  

export default authSlice.reducer
