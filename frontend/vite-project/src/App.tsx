import React, { useState } from 'react';
import SuccessAlert from './components/SuccessAlert/SuccessAlert';
import ErrorAlert from './components/ErrorAlert/ErrorAlert';

const App = () => {
  const [alert, setAlert] = useState({ type: '', message: '' });

  // Function to show success alert
  const showSuccess = () => {
    setAlert({ type: 'success', message: 'Success message!' });
  };

  // Function to show error alert
  const showError = () => {
    setAlert({ type: 'error', message: 'Error message!' });
  };

  return (
    <div>
      <button onClick={showSuccess}>Show Success Alert</button>
      <button onClick={showError}>Show Error Alert</button>
      {alert.type === 'success' && <SuccessAlert message={alert.message} />}
      {alert.type === 'error' && <ErrorAlert message={alert.message} />}
    </div>
  );
};

export default App;
