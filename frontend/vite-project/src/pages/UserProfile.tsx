// UserProfile.js or UserProfile.tsx

import React, { useState } from 'react';
import UserInfo from '../components/UserInfo';
import EditUserForm from '../components/EditUserForm';
import useGetUserById from '../hooks/useGetUserById'; // Import your new hook
import { User } from '../utils/types'; // Assuming you have a User type
import { ApiError } from '../hooks/useGetUserById'; // Assuming you have an ApiError type

const UserProfile = () => {
  const userId = '6585ac7a7d1a9922c6feaea3'; // Replace with dynamic user ID as needed
  const [isEditing, setIsEditing] = useState(false);
  const { data: user, isLoading, isError, error } = useGetUserById(userId);

  const handleEditClick = () => {
    setIsEditing(true);
  };

  const handleUpdateUser = (updatedUser: User) => {
    // TODO: Implement the update logic here
    console.log('Updated user:', updatedUser);
    setIsEditing(false);
  };

  if (isLoading) {
    return <div>Loading...</div>;
  }

  if (isError) {
    const apiError = error as ApiError; // Type assertion
    return <div>Error: {apiError.message}</div>;
  }

  return (
    <div>
      {user && (
        <>
          <UserInfo user={user} onEditClick={handleEditClick} />
          {isEditing && (
            <EditUserForm
              user={user}
              onUpdate={handleUpdateUser}
              onClose={() => setIsEditing(false)}
            />
          )}
        </>
      )}
    </div>
  );
};

export default UserProfile;
