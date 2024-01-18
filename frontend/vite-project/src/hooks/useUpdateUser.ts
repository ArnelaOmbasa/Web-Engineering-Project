import { useMutation, UseMutationOptions } from 'react-query';
import UserService from '../services/users';
import { User } from '../utils/types';

// Defining the input type for the updateUser function.
type UpdateUserParams = {
  userId: string;
  userData: User;
};
export interface ApiError {
    message: string;
}  

// This hook will return a mutation object that can be used to trigger the update operation.
const useUpdateUser = (options?: UseMutationOptions<User, Error, UpdateUserParams>) => {
  return useMutation<User, Error, UpdateUserParams>(
    ({ userId, userData }) => UserService.updateUser(userId, userData),
    options
  );
};

export default useUpdateUser;
