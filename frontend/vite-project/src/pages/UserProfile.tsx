import React, { useState } from 'react';
import UserInfo from '../components/UserInfo';
import EditUserForm from '../components/EditUserForm/EditUserForm';
import { User } from '../utils/types';

const UserProfile: React.FC = () => {
  const [user, setUser] = useState<User>({
    // Dummy initial user data
    username: 'Arčibald',
    email: 'arnela.ombasa@ibu.edu.ba',
    password: 'password123',
    role: 'User'
  });
  const [isEditing, setIsEditing] = useState<boolean>(false);

  const handleUpdateUser = (updatedUser: User) => {
    setUser(updatedUser);
  };

  return (
    <div>
      <UserInfo user={user} onEditClick={() => setIsEditing(true)} />
      {isEditing && (
        <EditUserForm
          user={user}
          onUpdate={handleUpdateUser}
          onClose={() => setIsEditing(false)}
        />
      )}
    </div>
  );
};

export default UserProfile;
