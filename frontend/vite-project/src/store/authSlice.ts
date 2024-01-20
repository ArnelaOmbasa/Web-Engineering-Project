import { createSlice } from '@reduxjs/toolkit'
import { createAsyncThunk } from '@reduxjs/toolkit'
import appAxios from '../services/appAxios'
import { RegisterFormData } from '../utils/types';
import { LoginFormData } from '../utils/types';

// initialize userToken from local storage
const userToken = localStorage.getItem('userToken')
    ? localStorage.getItem('userToken')
    : null

const initialState = {
    loading: false,
    userInfo: null, // for user the object
    userToken, // for storing the JWT
    error: null,
    success: false, // for monitoring the registration process.
}


const authSlice = createSlice({
   name: 'auth',
   initialState,
   reducers: {
    // Logout action
    logout: (state) => {
        state.loading = false;
        state.userInfo = null;
        state.userToken = null;
        state.error = null;
        state.success = false;
        localStorage.removeItem('userToken'); // Clear token from local storage
    },
},
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
    builder.addCase(login.fulfilled, (state, action) => {
      state.userToken = action.payload.jwt; 
      state.loading = false;
      state.userInfo = action.payload.user; 
    });
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

  export const login = createAsyncThunk(
    'auth/login',
    async (body: LoginFormData, { rejectWithValue }) => {
        try {
            const { data } = await appAxios.post(
                '/auth/login',
                body,
            )
            localStorage.setItem('userToken', data.jwt)
            return data
        } catch (error: any) {
            // return custom error message from backend if present
            if (error.response && error.response.data.message) {
                return rejectWithValue(error.response.data.message)
            } else {
                return rejectWithValue(error.message)
            }
        }
    }
 );
 
  
 export const { logout } = authSlice.actions;

export default authSlice.reducer
